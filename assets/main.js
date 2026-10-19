/* =====================================================================
   EDITA SOLO ESTE BLOQUE (PROFILE, PROJECTS y MORE). No inventes datos.
   Lo que dejes vacío ("") se oculta solo: enlaces, fecha de graduación...
   ===================================================================== */
const PROFILE = {
  name: "Xavier Alejandro Gallo Rodas", // como aparece en tu CV
  github: "xavier-gallo",               // solo tu usuario de GitHub
  linkedin: "https://www.linkedin.com/in/xavier-alejandro-gallo-rodas-868b672a0",
  email: "xavigallo04@gmail.com",       // visible para cualquiera, también para bots de spam
  cv: "",                               // p. ej. "assets/cv.pdf". Tu CV lleva teléfono: sube una copia SIN teléfono
  university: "Universidad Católica San Antonio de Murcia (UCAM)",
  graduation: ""                        // tu CV no la indica; rellénala solo si es una fecha real
};

/* repo: nombre del repositorio en tu GitHub. Déjalo en null hasta que exista (null = sin enlace).
   demo: true solo cuando hayas activado GitHub Pages en ese repositorio.
   role: añade aquí TU contribución concreta (muy valorado por reclutadores). */
const PROJECTS = [
  {
    name: "Distributed applications: socket server and Java RMI",
    context: "Academic project for the Distributed Applications I course, done in a pair.",
    summary: "Client-server system for academic management (degrees, subjects and enrolments), first built on Java sockets with a custom FTP-like protocol and then reimplemented with Java RMI.",
    highlights: [
      "Multithreaded server that handles several clients at once",
      "Two channels: one for text commands and a separate dynamic data channel for serialized objects",
      "State machine for user authentication",
      "Same domain reimplemented with Java RMI (separate server and client projects)"
    ],
    note: "The socket version keeps its data in memory only; there is no database.",
    stack: ["Java", "Sockets", "Threads", "Object serialization", "Java RMI", "Eclipse"],
    path: "projects/distributed-apps-java",
    demo: false
  },
  {
    name: "University management: Servlets/JSP and REST API",
    context: "Academic project for the Distributed Applications II course, done in a pair.",
    summary: "Two practicals on the same domain (degrees, subjects, professors and users): first a Servlet/JSP web application, then REST controllers built with Jersey (JAX-RS).",
    highlights: [
      "Part 1: control servlet that dispatches action classes (Command pattern), login and admin filters for access control, a context listener, a custom JSP tag and CRUD for degrees, subjects, professors and users",
      "Part 2: controllers, beans and data classes split into packages, JSON parsing and a custom API exception"
    ],
    note: "Not packaged with Maven or Gradle yet; the required libraries are listed in the repository instead of being committed.",
    stack: ["Java", "Servlets", "JSP", "Jersey (JAX-RS)", "JSON-B", "Eclipse"],
    path: "projects/java-university-web",
    demo: false
  },
  {
    name: "F1 merchandise store",
    context: "Academic project for the Web Programming course.",
    summary: "Online store for Formula 1 merchandise on a five-table MySQL schema, with registration and login, a product catalog, a shopping cart, orders and an admin area to manage products.",
    highlights: [
      "Catalog pages for teams, drivers and accessories, plus product search",
      "Shopping cart, checkout and invoice page",
      "Admin area to add, edit and delete products"
    ],
    note: "Learning project, not safe to deploy as it is: passwords are stored as plain text, database credentials and the admin login are hard-coded, and some SQL queries concatenate request parameters (SQL injection risk).",
    stack: ["PHP", "MySQL", "HTML", "CSS", "JavaScript"],
    path: "projects/f1-merch-store",
    demo: false
  },
  {
    name: "Colon tissue classifier",
    context: "Academic project for the Intelligent Systems course, done in a pair.",
    summary: "Image classifier for colon histopathology images using EfficientNetV2B1 transfer learning, built in a Jupyter notebook on Google Colab and documented in a written report and a demo video.",
    highlights: [
      "96.7% accuracy on the course test split, compared with about 30% for a basic CNN trained from scratch",
      "Class weights for imbalanced classes, regularization, early stopping and learning-rate reduction",
      "Evaluation with a confusion matrix"
    ],
    note: "The notebook reads its dataset from Google Drive, so it cannot be re-run without that data.",
    stack: ["Python", "TensorFlow/Keras", "EfficientNetV2B1", "scikit-learn", "NumPy", "Matplotlib"],
    path: "projects/colon-tissue-classifier",
    demo: false
  }
];

/* Proyectos secundarios: se muestran en una lista compacta. */
const MORE = [
  {
    name: "Casotic marketplace prototype",
    summary: "Marketplace prototype for technology companies, startups and investors, with role-based access, an admin panel and a Spanish/English switch, for the IT Project Management course. Front-end only: data lives in LocalStorage and login is simulated.",
    role: "Project leader: I led the team and coordinated the work from planning through delivery of the final prototype.",
    stack: ["HTML", "Tailwind CSS", "JavaScript"],
    path: "projects/casotic",
    demo: false
  },
  {
    name: "PC component configurator",
    summary: "Windows Forms application to choose PC components from a SQL Server database, with separate user and admin screens, for the Advanced Visual Programming course (team of three).",
    stack: ["C#", ".NET Framework 4.7.2", "Windows Forms", "SQL Server"],
    path: "projects/pc-component-configurator",
    demo: false
  },
  {
    name: "Algorithms in C",
    summary: "Hash table, backtracking, sorting and searching assignments, each with a written report, for the Algorithmics course.",
    stack: ["C"],
    path: "projects/algorithms-c",
    demo: false
  },
  {
    name: "Database management coursework",
    summary: "SQL schema and database export scripts for an academic database management project.",
    stack: ["Oracle SQL", "Oracle APEX"],
    path: "projects/sgi-database-project",
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

/* Source and demo links appear only when the repository really exists (repo is not null). */
function repoLinks(p) {
  const links = [];
  if (p.path && hasUser) {
    links.push(el("a", { href: ghUrl(`/xavier-gallo.github.io/tree/main/${p.path}`), "aria-label": `Source code for ${p.name}` }, "Source code"));
    if (p.demo) {
      links.push(el("a", { href: `https://${PROFILE.github.trim()}.github.io/${p.repo}/`, "aria-label": `Live demo of ${p.name}` }, "Live demo"));
    }
  }
  return links;
}

function renderProjects() {
  const list = $("#project-list");
  PROJECTS.forEach((p) => {
    const links = repoLinks(p);
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

function renderMore() {
  const list = $("#more-list");
  MORE.forEach((p) => {
    list.append(el("li", {}, el("strong", {}, p.name), `. ${p.summary} `,
      p.role ? `My contribution: ${p.role} ` : "",
      `Built with ${p.stack.join(", ")}. `, repoLinks(p)));
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
renderMore();
initTheme();
$("#year").textContent = new Date().getFullYear();
