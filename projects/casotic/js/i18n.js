const DICTIONARY = {
    es: {
        "nav_news": "Noticias",
        "nav_companies": "Empresas",
        "nav_offers": "Marketplace",
        "nav_dashboard": "Panel Admin",
        "login": "Iniciar Sesión",
        "logout": "Cerrar Sesión",
        "greeting": "Hola, ",
        "search_placeholder": "Buscar...",
        "hero_title": "Navegando el Futuro de las Tendencias Tecnológicas",
        "hero_subtitle": "Datos en tiempo real sobre tecnologías emergentes, cambios de mercado e innovadores.",
        "explore_trends": "Explorar Tendencias",
        "view_dashboard": "Ver Panel",
        "featured_companies": "Empresas Destacadas",
        "view_all": "Ver todas",
        "recent_offers": "Ofertas y Demandas Recientes",
        "market_offers": "Ofertas del Mercado",
        "industry_demands": "Demandas de la Industria",
        "lang_es": "ES",
        "lang_en": "EN",
        "register": "Registrarse",
        "email": "Correo Electrónico",
        "password": "Contraseña",
        "name": "Nombre Completo",
        "dni": "DNI (8 números y 1 letra)"
    },
    en: {
        "nav_news": "News",
        "nav_companies": "Companies",
        "nav_offers": "Marketplace",
        "nav_dashboard": "Dashboard",
        "login": "Login",
        "logout": "Logout",
        "greeting": "Hello, ",
        "search_placeholder": "Search...",
        "hero_title": "Navigating the Future of Technology Trends",
        "hero_subtitle": "Real-time data on emerging technologies, market shifts, and innovative disruptors shaping the global landscape.",
        "explore_trends": "Explore Trends",
        "view_dashboard": "View Dashboard",
        "featured_companies": "Featured Companies",
        "view_all": "View all",
        "recent_offers": "Recent Offers & Demands",
        "market_offers": "Market Offers",
        "industry_demands": "Industry Demands",
        "lang_es": "ES",
        "lang_en": "EN",
        "register": "Sign Up",
        "email": "Email Address",
        "password": "Password",
        "name": "Full Name",
        "dni": "ID Document"
    }
};

const I18n = {
    currentLang: localStorage.getItem('casotic_lang') || 'es',
    
    setLanguage: function(lang) {
        if (DICTIONARY[lang]) {
            this.currentLang = lang;
            localStorage.setItem('casotic_lang', lang);
            this.translatePage();
            this.updateLangToggle();
        }
    },
    
    translatePage: function() {
        const elements = document.querySelectorAll('[data-i18n]');
        elements.forEach(el => {
            const key = el.getAttribute('data-i18n');
            if (DICTIONARY[this.currentLang][key]) {
                if (el.tagName === 'INPUT' && el.hasAttribute('placeholder')) {
                    el.placeholder = DICTIONARY[this.currentLang][key];
                } else {
                    el.innerText = DICTIONARY[this.currentLang][key];
                }
            }
        });
    },

    updateLangToggle: function() {
        const toggleBtn = document.getElementById('lang-toggle');
        if (toggleBtn) {
            toggleBtn.innerText = this.currentLang.toUpperCase();
        }
    }
};

document.addEventListener('DOMContentLoaded', () => {
    // Inject lang toggle in header if not exists
    const headers = document.querySelectorAll('header .flex.items-center.gap-4, header .flex.flex-1.justify-end.gap-6.items-center');
    if (headers.length > 0) {
        const targetHeader = headers[headers.length - 1]; // Insert in the last matching group
        const langDiv = document.createElement('div');
        langDiv.innerHTML = `
            <button id="lang-toggle" onclick="I18n.setLanguage(I18n.currentLang === 'es' ? 'en' : 'es')" 
                class="ml-4 text-xs font-bold text-primary bg-primary/10 px-2 py-1 rounded cursor-pointer hover:bg-primary/20 transition-colors">
                ${I18n.currentLang.toUpperCase()}
            </button>
        `;
        targetHeader.appendChild(langDiv);
    }

    I18n.translatePage();
});
