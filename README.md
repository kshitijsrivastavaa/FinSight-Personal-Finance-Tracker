<p align="center">
  <img src="https://img.shields.io/badge/FinSight-Personal%20Finance%20Tracker-4c8bd6?style=for-the-badge&logo=react&logoColor=white" />
</p>

<h1 align="center">💰 FinSight — Personal Finance & Expense Analytics</h1>

<p align="center">A modern, smart personal finance manager built using Spring Boot, React + Vite, PostgreSQL, and JWT Authentication — designed to help users track spending, manage budgets, and understand financial habits with beautiful analytics.</p>

---

<p align="center">
  <a href="https://finsight-frontend-2xkuf043o.vercel.app" target="_blank">
    <img src="https://img.shields.io/badge/🚀 LAUNCH APP-00CC99?style=for-the-badge" />
  </a>
</p>

<p align="center">
  <a href="https://finsight-frontend-2xkuf043o.vercel.app">🔗 Frontend</a> |
  <a href="https://finsight-backend-qiwc.onrender.com">🖥️ Backend</a> |
  <a href="https://finsight-backend-qiwc.onrender.com/swagger-ui/index.html">📘 Swagger Docs</a>
</p>

---

## 🛠️ Tech Stack

| Component | Technology |
|----------|------------|
| Frontend | React + Vite + TypeScript + TailwindCSS |
| Backend | Java 17 + Spring Boot 3 + Spring Security |
| Database | H2 (Dev), PostgreSQL / Render (Prod) |
| Authentication | JWT Token-Based Auth |
| Deployment | Vercel (Frontend) & Render (Backend) |
| Dev Tools | Maven, Swagger UI, Postman |

---

## ✨ Features

- 🔐 JWT Authentication & Session Management  
- 👤 Multi-user secure accounts  
- 🧾 Add, view, edit, and delete expenses & income  
- 🗂 Categorization with visual reports  
- 📊 Analytics Dashboard (Pie charts + breakdowns)  
- 🧮 Budget summary with net savings calculation  
- 📁 Persistent database storage  
- ☁ Deploy-ready Docker & CI/CD support  

---

## 📷 UI Preview

| Login Page | Dashboard | Analytics |
|------------|-----------|-----------|
| *(Coming Soon)* | *(Coming Soon)* | *(Coming Soon)* |

> Screenshots will be added in future updates.

---

## 🚀 Deployment Links

| Component | Status | Link |
|----------|--------|------|
| Frontend | ✔ Live | https://finsight-frontend-2xkuf043o.vercel.app |
| Backend API | ✔ Live | https://finsight-backend-qiwc.onrender.com |
| Swagger API Docs | ✔ Live | https://finsight-backend-qiwc.onrender.com/swagger-ui/index.html |

---

## 🧪 Local Setup

### Backend

```sh
cd backend
mvn spring-boot:run

## 📁 Project Structure

```bash
FinSight-Personal-Finance-Tracker/
│
├── backend/
│   ├── src/main/java/...        # Spring Boot source code
│   ├── src/main/resources/      # application.properties, schema, etc.
│   ├── pom.xml                  # Maven dependencies
│   └── Dockerfile               # Docker config for backend
│
└── frontend/
    ├── src/
    │   ├── App.tsx             # Main dashboard + auth UI + API calls
    │   ├── main.tsx            # React entrypoint
    │   └── styles.css          # UI styles
    ├── index.html
    ├── package.json
    └── vite.config.ts / js
