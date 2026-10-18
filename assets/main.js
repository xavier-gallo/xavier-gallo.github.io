/* =====================================================================
   EDITA SOLO ESTE BLOQUE (PROFILE y PROJECTS). No inventes datos.
   Lo que dejes vacío ("") se oculta solo: enlaces, universidad, etc.
   ===================================================================== */
const PROFILE = {
  name: "Xavier Alejandro Gallo Rodas",   // tu nombre real, como aparece en tu CV
  github: "xavier-gallo",          // solo tu usuario de GitHub, p. ej. "janedoe"
  linkedin: "https://www.linkedin.com/in/xavier-alejandro-gallo-rodas-868b672a0/",        // URL completa de tu perfil de LinkedIn
  email: "xavigallo04@gmail.com",           // correo profesional (puede ser público: es una web pública)
  cv: "Xavier_Gallo_Rodas_Resume_EN",              // p. ej. "assets/cv.pdf" (sin DNI/NIE, dirección ni teléfono)
  university: "Universidad Católica San Antonio",      // p. ej. "Universidad X" (confírmalo antes de rellenarlo)
};

/* repo: nombre del repositorio en tu GitHub (null = sin enlace).
   demo: true solo cuando hayas activado GitHub Pages en ese repositorio.
   role: añade aquí TU contribución concreta (muy valorado por reclutadores). */
const PROJECTS = [
  {
    name: "Casotic: technology innovation marketplace",
    context: "Academic project for the IT Project Management course.",
    summary: "Web prototype of a marketplace where technology companies, startups and investors publish innovation offers, demands and job posts.",
    highlights: [
      "Role-based access with admin, company and user accounts",
      "Admin panel to validate companies and approve posts",
      "Company directory with live search and a simulated B2B chat",
      "Spanish and English interface switch"
    ],
    note: "Front-end only. Data is stored in the browser’s LocalStorage and login is simulated, so it is not secure and not meant for real users.",
    stack: ["HTML", "Tailwind CSS", "JavaScript", "LocalStorage"],
    repo: "casotic",
    demo: false
  },
  {
    name: "University management: Servlets/JSP and REST API",
    context: "Academic project for the Distributed Applications course, done in a pair.",
    summary: "Two practicals on the same domain (degrees, subjects, professors and users): first a Servlet/JSP web application, then REST controllers built with Jersey (JAX-RS).",
    highlights: [
      "Part 1: front controller servlet that dispatches action classes (Command pattern), login and admin filters, a context listener and a custom JSP tag",
      "Part 2: controllers, beans and data classes split into packages, JSON parsing and a custom API exception"
    ],
    note: "Not packaged with Maven or Gradle yet; the required libraries are listed in the repository instead of being committed.",
    stack: ["Java", "Servlets", "JSP", "Jersey (JAX-RS)", "JSON-B", "Eclipse"],
    repo: "java-university-web",
    demo: false
  },
  {
    name: "PC component configurator",
    context: "Academic project for the Advanced Visual Programming course, done in a team of three.",
    summary: "Windows desktop application to choose PC components (processors, motherboards, graphics cards, memory and power supplies) from a SQL Server database, with separate user and admin screens.",
    highlights: [
      "User registration and login",
      "Predefined PC builds stored in the database",
      "Database scripts included (tables and sample data)"
    ],
    note: "Windows only. It needs a local SQL Server database created from the included scripts.",
    stack: ["C#", ".NET Framework 4.7.2", "Windows Forms", "SQL Server", "T-SQL"],
    repo: "pc-component-configurator",
    demo: false
  },
  {
    name: "Colon tumor classification model",
    context: "Academic project for the Intelligent Systems course, done in a pair.",
    summary: "Neural-network model that classifies colon tumors, built in a Jupyter notebook on Google Colab and documented in a written report and a demo video.",
    highlights: [
      "Keras model with regularization",
      "Class weights for imbalanced classes, early stopping and learning-rate reduction",
      "Evaluation with a confusion matrix"
    ],
    note: "The notebook reads its dataset from Google Drive, so it cannot be re-run without that data.",
    stack: ["Python", "TensorFlow/Keras", "scikit-learn", "NumPy", "Matplotlib"],
    repo: "colon-tumor-classifier",
    demo: false
  },
  {
    name: "Algorithms in C: hashing, backtracking, sorting and searching",
    context: "Academic lab assignments for the Algorithmics course, done in a pair.",
    summary: "Three assignments implementing core algorithms and data structures in C, each with a written report.",
    highlights: [
      "Assignment 1: hash table implementation",
      "Assignment 2: backtracking and a maximization problem",
      "Assignment 3: sorting and searching, tested on input files of 50,000, 100,000 and 200,000 numbers"
    ],
    stack: ["C", "Code::Blocks"],
    repo: "algorithms-c",
    demo: false
  }
];
/* ================== FIN DEL BLOQUE EDITABLE ================== */

const $ = (selector) => document.querySelector(selector);
const hasUser = PROFILE.github.trim() !== "";
const ghUrl = (path = "") => `https://github.com/${PROFILE.github.trim()}${path}`;

/* Builds DOM nodes without innerHTML, so text is never interpreted as HTML. */
function el(tag, props = {}, ...children) {
  const node = document.createElement(tag);
  Object.entries(props).forEach(([key, value]) => node.setAttribute(key, value));
  children.flat().forEach((child) => node.append(child));
  return node;
}

function fillProfile() {
  document.querySelectorAll("[data-p]").forEach((node) => {
    node.textContent = PROFILE[node.dataset.p] || "";
  });
  document.querySelectorAll("[data-show]").forEach((node) => {
    node.hidden = !PROFILE[node.dataset.show];
  });
  const links = {
    github: hasUser ? ghUrl() : "",
    linkedin: PROFILE.linkedin,
    email: PROFILE.email ? `mailto:${PROFILE.email}` : "",
    cv: PROFILE.cv
  };
  document.querySelectorAll("[data-link]").forEach((anchor) => {
    const href = links[anchor.dataset.link];
    if (href) anchor.setAttribute("href", href);
    else anchor.hidden = true;
  });
  document.title = `${PROFILE.name} | Computer Engineering student`;
}

function renderProjects() {
  const list = $("#project-list");
  PROJECTS.forEach((p) => {
    const links = [];
    if (p.repo && hasUser) {
      links.push(el("a", { href: ghUrl(`/${p.repo}`), "aria-label": `Source code for ${p.name}` }, "Source code"));
      if (p.demo) {
        links.push(el("a", { href: `https://${PROFILE.github.trim()}.github.io/${p.repo}/`, "aria-label": `Live demo of ${p.name}` }, "Live demo"));
      }
    }
    list.append(
      el("li", {},
        el("h3", {}, p.name),
        el("p", { class: "context" }, p.context),
        el("p", {}, p.summary),
        el("ul", { class: "bullets" }, p.highlights.map((text) => el("li", {}, text))),
        p.role ? el("p", {}, el("strong", {}, "My contribution: "), p.role) : "",
        p.note ? el("p", { class: "note" }, el("strong", {}, "Limitations: "), p.note) : "",
        el("p", { class: "stack" }, el("strong", {}, "Built with: "), p.stack.join(", ")),
        links.length ? el("p", { class: "links" }, links) : ""
      )
    );
  });
}

function initTheme() {
  const button = $("#theme-toggle");
  const root = document.documentElement;
  const current = () =>
    root.dataset.theme || (matchMedia("(prefers-color-scheme: dark)").matches ? "dark" : "light");
  const sync = () => button.setAttribute("aria-pressed", String(current() === "dark"));
  sync();
  button.addEventListener("click", () => {
    const next = current() === "dark" ? "light" : "dark";
    root.dataset.theme = next;
    try { localStorage.setItem("theme", next); } catch (error) { /* storage blocked: keep it for this visit */ }
    sync();
  });
}

fillProfile();
renderProjects();
initTheme();
$("#year").textContent = new Date().getFullYear();
