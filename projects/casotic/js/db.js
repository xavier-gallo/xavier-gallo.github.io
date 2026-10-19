const INITIAL_DATA = {
    users: [
        { id: 1, name: 'Administrador Principal', email: 'admin@casotic.com', password: 'admin123', role: 'admin', dni: '[REDACTED]', verified: true },
        { id: 2, name: 'Cuenta Empresa Demo', email: 'empresa@casotic.com', password: 'empresa123', role: 'company', dni: '[REDACTED]', companyId: 1, verified: true },
        { id: 3, name: 'Alex Rivera', email: 'alex@usuario.com', password: 'password123', role: 'user', dni: '[REDACTED]', verified: true }
    ],
    companies: [
        { 
            id: 1, 
            name: 'EcoGrid Solutions', 
            cif: 'B12345678',
            description: 'Smart Infrastructure & IoT for renewable energy microgrids. Developing autonomous load balancing systems.', 
            category: 'CleanTech',
            location: 'Madrid, Spain',
            phone: '+34 600 000 000',
            website: 'www.ecogrid.com',
            founded: '2020', 
            stage: 'Series A', 
            logo: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBjw6YSI_hH_XhdgmZB1sGTJ2ejFa8tUbeHqz3nkhQ7uR5CNCNQiwCnWbwSnuJ_-8EGRtcm-djYDmGBEdeubgYyt0d6RFxY7uspE0QTCjavPUmnzFm3GoKZvmLSOWOBrOlDSoK-WoL0RAdqqokPmiUo_FcLRX2-w2IAVDs2iajqCKhv6LYaVdWZ1caJAGDYXRtRLPgCaNpwIGF5kdBjk-62bPop21sAioqUBYhFuB6BIYZ7l2hA8M0kMxURV_Ntn1fFNmBIors9ctg',
            videoUrl: 'https://www.youtube.com/embed/dQw4w9WgXcQ',
            validated: true
        },
        { 
            id: 2, 
            name: 'TechVanguard Ltd.', 
            cif: 'B87654321',
            description: 'AI-Driven Supply Chain Predictor. Next generation models for logistics optimization.', 
            category: 'Artificial Intelligence',
            location: 'Barcelona, Spain',
            phone: '+34 600 111 111',
            website: 'www.techvanguard.io',
            founded: '2021', 
            stage: 'Seed', 
            logo: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDtCXSMBQ6W3jH5hfe3nirXpkYMGoNA0OyrmmL1IekivbAXPiD-tZypgafnuk6JL5MhYwZS7PADvAcA4vshESmeppXlqV30Eg0jDifdJbqde4Fz0TjnvSNAS2i27x6GgiS42FUEoymVRRaDwAl04NLc_mNzGMChqYHZjLeQJ09GllBa-pOi9EUqOCgya99uV1_AsUBDxO4gwMRJWv9AYEm5tcw_P7bee3VYBreV4vxHOe0sLwbJueM1mdI720bz33Ac2zdTj2aAJag',
            videoUrl: '',
            validated: true
        },
        { 
            id: 3, 
            name: 'Stellar Dynamics', 
            cif: 'B99999999',
            description: 'Aerospace engineering focused on low orbit nano-satellites.', 
            category: 'Aerospace',
            location: 'Seville, Spain',
            phone: '+34 600 222 222',
            website: 'www.stellardynamics.space',
            founded: '2019', 
            stage: 'Series B', 
            logo: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBKgZXUwTcnMM6wVcKQgZp2uXX9rW5LcAQDEOUhluaBIwj5kqnKU9tKgeDRVwe4UMd_dSD57YTT5mD_48op37JhyrszlNdyvhIPBm9kr0uJlajk34cBVrn2UaNPj1ds70XST9ps6_sG0XJ4w9UCYOSArfGv38cib1yR8cF3oM9gyKj3gdEdMfFWhR_hj4P8-jHHyeLYf86TgG7f0EVDlXjLrdmfW2WU97qcFWFoQk7q2FldfVDBZFAorUD1Td40EKgd_FynHIXrTWY',
            videoUrl: '',
            validated: true
        },
        { 
            id: 4, 
            name: 'BioGene Health', 
            cif: 'B44444444',
            description: 'CRISPR-based Rapid Pathogen Kits and genetic diagnostics.', 
            category: 'Biotech',
            location: 'Valencia, Spain',
            phone: '+34 600 333 333',
            website: 'www.biogene.health',
            founded: '2022', 
            stage: 'Seed', 
            logo: 'https://lh3.googleusercontent.com/aida-public/AB6AXuC3C3kJcdIBQoCE_65-BCC8BNc8wvtCM6bJLLevj6BEjn-VWEoAfOd_n2ojeVKoWr9ASRj7LpogrXTGxar5UTMy3mYcgmVAqiEt57gq69fa7tkaOyryx0OYl7IwIGna706Oxksq37f7UZNFOXfTmHbIigh4Ol-VpEw-0u4S_VMr2kal3QJNzav6nVHfv_PJyWGNipI0S4cu6wsQUsySejwr3fWAz2y7kT3dmN-nC5kVBJeXk7-VYtJnprxRN3pomBwgEMtXiNJP6Bs',
            videoUrl: '',
            validated: true
        },
        { 
            id: 5, 
            name: 'CyberDefend Security', 
            cif: 'B55555555',
            description: 'Enterprise level penetration testing and zero-trust network solutions.', 
            category: 'Cybersecurity',
            location: 'Bilbao, Spain',
            phone: '+34 600 444 444',
            website: 'www.cyberdefend.com',
            founded: '2018', 
            stage: 'Series A', 
            logo: 'https://lh3.googleusercontent.com/aida-public/AB6AXuAn9MGLgrSAdbM-gAPORZyJtMNI9AZOzrDf1wHGrFu5TXjNLYB6wV9vB1FsMGtgtmq7WMvKZmU0DCoDowmWW6leotDnX49qFznSR4T-Qc0_u8eDok0xAsJ_YPieA2ciehzXoN4plrvXRnuOaOdlmbasiI_xLaHJhqtQVealr_qnMrpFSjXSPI0LFwOZH-V0e2yWEF1GM-WJjlsQdnTgoPLaEvJTLXKOEIujKsxr2avQFF-7RvKCef97C4A5P_P8FuBlpC9h-SleJCs',
            videoUrl: '',
            validated: false // Ejemplo de empresa pendiente
        }
    ],
    publications: [
        { id: 1, type: 'offer', companyId: 1, title: 'EcoGrid Controller', description: 'Autonomous load balancing for renewable energy microgrids. TRL 8.', tags: ['Energy', 'Hardware'], date: '2023-10-24', validated: true },
        { id: 2, type: 'demand', companyId: 2, title: 'Zero-Emission Cargo Propulsion', description: 'Seeking scalable hydrogen or ammonia-based propulsion systems for large-scale container vessel retrofitting.', tags: ['Deep Tech'], date: '2023-10-25', validated: true },
        { id: 3, type: 'offer', companyId: 4, title: 'Rapid Pathogen Kit', description: 'CRISPR based detection under 15 mins.', tags: ['Biotech'], date: '2023-10-26', validated: false } // Pendiente
    ],
    jobs: [
        { id: 1, companyId: 1, title: 'Senior IoT Engineer', description: 'Looking for a Senior IoT engineer to develop our next gen edge controllers.', location: 'Remote', type: 'Full-time', validated: true },
        { id: 2, companyId: 2, title: 'Machine Learning Architect', description: 'Lead our AI supply chain prediction models.', location: 'Madrid, Spain', type: 'Full-time', validated: true }
    ],
    messages: [
        { id: 1, userId: 2, text: 'Hola, estamos interesados en su oferta.', timestamp: Date.now() - 3600000 }
    ],
    noticias: [
        { id: 1, title: 'La IA revoluciona el sector logístico', date: '2023-11-01', summary: 'TechVanguard ha lanzado un nuevo modelo de predicción.', image: 'https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&q=80&w=800' },
        { id: 2, title: 'Nueva ronda de inversión para EcoGrid', date: '2023-11-05', summary: 'La startup española levanta 5 millones para expandir sus microgrids.', image: 'https://images.unsplash.com/photo-1497435334941-8c899ee9e8e9?auto=format&fit=crop&q=80&w=800' }
    ]
};

const DB = {
    init: function() {
        if (!localStorage.getItem('casotic_db_initialized_v2')) {
            localStorage.clear(); // Limpiamos para asegurarnos de que cargue la versión 2 fresca
            localStorage.setItem('casotic_users', JSON.stringify(INITIAL_DATA.users));
            localStorage.setItem('casotic_companies', JSON.stringify(INITIAL_DATA.companies));
            localStorage.setItem('casotic_publications', JSON.stringify(INITIAL_DATA.publications));
            localStorage.setItem('casotic_jobs', JSON.stringify(INITIAL_DATA.jobs));
            localStorage.setItem('casotic_messages', JSON.stringify(INITIAL_DATA.messages));
            localStorage.setItem('casotic_noticias', JSON.stringify(INITIAL_DATA.noticias));
            localStorage.setItem('casotic_db_initialized_v2', 'true');
        }
    },
    getTable: function(table) {
        return JSON.parse(localStorage.getItem(`casotic_${table}`)) || [];
    },
    saveTable: function(table, data) {
        localStorage.setItem(`casotic_${table}`, JSON.stringify(data));
    },
    insert: function(table, record) {
        const data = this.getTable(table);
        record.id = Date.now(); // Simple ID generation
        data.push(record);
        this.saveTable(table, data);
        return record;
    },
    update: function(table, id, recordUpdates) {
        const data = this.getTable(table);
        const index = data.findIndex(r => r.id === id);
        if(index > -1) {
            data[index] = { ...data[index], ...recordUpdates };
            this.saveTable(table, data);
            return data[index];
        }
        return null;
    },
    remove: function(table, id) {
        const data = this.getTable(table);
        const filtered = data.filter(r => r.id !== id);
        this.saveTable(table, filtered);
    }
};

// Initialize DB on script load
DB.init();
