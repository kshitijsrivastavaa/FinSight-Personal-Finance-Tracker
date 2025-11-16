<p align="center">
  <img src="https://img.shields.io/badge/FinSight-Personal%20Finance%20Tracker-4c8bd6?style=for-the-badge" />
</p>

<h1 align="center">💰 FinSight — Personal Finance & Expense Analytics</h1>

<p align="center">
A modern full-stack finance management application built with 
<strong>Spring Boot</strong>, <strong>React + Vite + TypeScript</strong>, 
<strong>JWT Authentication</strong>, and a clean <strong>Analytics Dashboard</strong>.
</p>

<p align="center">
  <img src="https://img.shields.io/github/languages/top/kshitijsrivastavaa/FinSight-Personal-Finance-Tracker?style=flat-square" />
  <img src="https://img.shields.io/github/last-commit/kshitijsrivastavaa/FinSight-Personal-Finance-Tracker?style=flat-square" />
  <img src="https://img.shields.io/badge/status-active-success?style=flat-square" />
</p>

---

## 🚀 Live Demo

🔗 **Frontend App:**  
https://finsight-frontend-2xkuf043o.vercel.app  

⚙ **Backend API Base:**  
https://finsight-backend-qiwc.onrender.com  

📄 **Swagger API Docs:**  
https://finsight-backend-qiwc.onrender.com/swagger-ui/index.html  

---

## 🔥 Features

- 🔐 **JWT-based Authentication** – Secure login & registration.
- 👤 **Multi-User Support** – Each user sees only their own data.
- 💰 **Track Income & Expenses** – Add, view, and delete transactions.
- 🗂 **Spending Categories** – Food, Rent, Travel, Shopping, Bills, Others.
- 📊 **Analytics Dashboard** – Visualize spending with interactive charts (Recharts).
- 🧮 **Financial Summary** – Total income, total expense, net savings.
- 🧾 **Transaction History** – Full table view with delete actions.
- 💾 **Persistent Session** – JWT token stored in localStorage.
- 🌐 **Fully Deployed** – Backend on Render, Frontend on Vercel.
- 🛠 **RESTful APIs** – Well-structured backend with Swagger documentation.
- 🐳 **Docker Ready** – Backend containerized with Dockerfile.

---

## 🏗 Tech Stack

| Layer      | Technology                                  |
|-----------|----------------------------------------------|
| Frontend  | React, Vite, TypeScript, Recharts           |
| Styling   | CSS (custom styles, dashboard layout)       |
| Backend   | Spring Boot 3, Java 17, Maven               |
| Auth      | JWT, Spring Security                        |
| Database  | H2 (in-memory for dev)                      |
| API Docs  | Swagger / OpenAPI                          |
| Deployment| Render (Backend), Vercel (Frontend), Docker |

---

## 🧱 Architecture Overview

**Frontend (Vercel)**  
- Built with React + Vite + TypeScript.  
- Talks to backend via `fetch` using `API_BASE = https://finsight-backend-qiwc.onrender.com/api`.  
- Handles:
  - Authentication (register, login)
  - State management using React hooks
  - Dashboard UI, charts, and tables

**Backend (Render)**  
- Spring Boot application exposing `/api/...` routes.
- Handles:
  - User registration & login (JWT)
  - Transactions CRUD
  - Analytics: summary & spending by category
- Swagger UI for testing and documentation.

---

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
