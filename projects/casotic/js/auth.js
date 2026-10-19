const Auth = {
    login: function(email, password) {
        const users = DB.getTable('users');
        const user = users.find(u => u.email === email && u.password === password);
        if (user) {
            // No guardar la contraseña en la sesión
            const { password, ...sessionUser } = user;
            localStorage.setItem('casotic_session', JSON.stringify(sessionUser));
            return true;
        }
        return false;
    },
    register: function(userData) {
        const users = DB.getTable('users');
        if (users.find(u => u.email === userData.email)) {
            return { success: false, message: 'El email ya está registrado' };
        }
        
        // Basic DNI/CIF validation
        if (!userData.dni || userData.dni.length < 5) {
            return { success: false, message: 'Formato de Documento inválido.' };
        }

        let companyId = null;
        if (userData.role === 'company') {
            const newCompany = DB.insert('companies', {
                name: userData.companyName,
                cif: userData.dni, // Use DNI field for CIF
                description: userData.description || '',
                category: userData.category || 'Tech',
                location: userData.location || '',
                phone: userData.phone || '',
                website: userData.website || '',
                founded: new Date().getFullYear().toString(),
                stage: 'Seed',
                logo: '',
                videoUrl: '',
                validated: false // Requiere validación del admin
            });
            companyId = newCompany.id;
        }

        const newUser = DB.insert('users', {
            name: userData.name,
            email: userData.email,
            password: userData.password,
            dni: userData.dni,
            role: userData.role,
            companyId: companyId,
            verified: false // Requiere validación del admin
        });

        const { password, ...sessionUser } = newUser;
        localStorage.setItem('casotic_session', JSON.stringify(sessionUser));
        return { success: true };
    },
    logout: function() {
        localStorage.removeItem('casotic_session');
        window.location.href = 'login.html';
    },
    getUser: function() {
        return JSON.parse(localStorage.getItem('casotic_session'));
    },
    isAuthenticated: function() {
        return !!this.getUser();
    },
    requireAuth: function() {
        if (!this.isAuthenticated()) {
            window.location.href = 'login.html';
            return false;
        }
        return true;
    },
    requireAdmin: function() {
        if (!this.requireAuth()) return;
        const user = this.getUser();
        if (user.role !== 'admin') {
            alert('Acceso denegado. Se requiere rol de administrador.');
            window.location.href = 'index.html';
        }
    }
};

// Auto-update UI based on auth state (Header changes)
document.addEventListener('DOMContentLoaded', () => {
    const user = Auth.getUser();
    const loginBtnContainer = document.getElementById('auth-buttons');
    if (loginBtnContainer) {
        if (user) {
            loginBtnContainer.innerHTML = `
                <div class="flex items-center gap-4">
                    <span class="text-sm font-bold text-primary" data-i18n="greeting">Hola, </span> <span class="text-sm font-bold">${user.name}</span>
                    <a href="${user.role === 'admin' ? 'panel_administrativo.html' : 'perfil_empresa.html'}" class="bg-slate-200 dark:bg-slate-800 rounded-full size-10 flex items-center justify-center overflow-hidden cursor-pointer">
                        <span class="material-symbols-outlined text-slate-500">account_circle</span>
                    </a>
                    <button onclick="Auth.logout()" class="text-xs text-red-500 hover:underline" data-i18n="logout">Cerrar Sesión</button>
                </div>
            `;
        } else {
            loginBtnContainer.innerHTML = `
                <button onclick="window.location.href='login.html'" class="flex min-w-[84px] cursor-pointer items-center justify-center rounded-lg h-10 px-5 bg-primary text-white text-sm font-bold transition-opacity hover:opacity-90" data-i18n="login">Iniciar Sesión</button>
            `;
        }
    }
});
