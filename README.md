# Personal portfolio

Static portfolio site (plain HTML, CSS and JavaScript, no build step) published with GitHub Pages.

## Run locally

Open the folder in VS Code and start the Live Server extension, or run:

```bash
python -m http.server 8000
```

Then visit http://localhost:8000.

## Customize

All personal content lives in the editable block at the top of `assets/main.js`:
`PROFILE` (name and links) and `PROJECTS` (one entry per project). Empty fields are hidden automatically.

## Deploy

Repository named `USERNAME.github.io`, then Settings > Pages > Source: **Deploy from a branch** > `main` / `(root)`.

## Structure

```text
index.html        page structure
assets/style.css  styles (light/dark themes, responsive, reduced motion)
assets/main.js    profile data, project list, theme toggle
.nojekyll         tells GitHub Pages to serve the files as they are
```
