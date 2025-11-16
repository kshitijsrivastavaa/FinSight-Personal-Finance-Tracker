<p align="center">
  <img src="https://img.shields.io/badge/FinSight-Personal%20Finance%20Tracker-4c8bd6?style=for-the-badge&logo=react&logoColor=white" />
</p>

<h1 align="center">💰 FinSight — Personal Finance & Expense Analytics</h1>

<p align="center">
  A modern full-stack personal finance manager built with 
  <b>Spring Boot</b>, <b>React + Vite</b>, <b>TypeScript</b>, <b>JWT Auth</b>, and a clean analytics dashboard.
</p>

<p align="center">
  <a href="https://fin-sight-personal-finance-tracker.vercel.app" target="_blank">
    <img src="https://img.shields.io/badge/🚀 LIVE DEMO-00CC99?style=for-the-badge" />
  </a>
</p>

<p align="center">
  <a href="https://fin-sight-personal-finance-tracker.vercel.app">🌐 Frontend</a> •
  <a href="https://finsight-backend-qiwc.onrender.com">🖥 Backend API</a> •
  <a href="https://finsight-backend-qiwc.onrender.com/swagger-ui/index.html">📘 Swagger Docs</a>
</p>

---

## ✨ What is FinSight?

FinSight is a **personal finance & expense analytics web app** where users can:

- Create an account, log in securely, and manage their own data.
- Add income and expenses across categories like Food, Bills, Shopping, Travel, etc.
- See **instant updates** to total income, total expenses, and net savings.
- Visualize spending using a **category-wise pie chart**.
- Browse, filter, and delete transactions in a clean, responsive table.

It’s designed to look and feel like a **production-ready SaaS dashboard** you can proudly show in your portfolio.

---

## 🖼 UI Preview

> Replace image paths with your actual filenames inside `assets/` (or wherever you store them).

| Auth Screen | Dashboard Summary |
|------------|-------------------|
| ![Auth Screen](assets/finsight-auth.png) | ![Dashboard Summary](assets/finsight-dashboard-summary.png) |

| Transactions Table | Analytics Pie Chart |
|--------------------|---------------------|
| ![Transactions Table](assets/finsight-transactions-table.png) | ![Analytics Chart](assets/finsight-analytics-chart.png) |

---

## 🚀 Live Deployment

| Part           | Status | URL |
|----------------|--------|-----|
| Frontend (Vercel) | ✅ Live | https://fin-sight-personal-finance-tracker.vercel.app |
| Backend (Render)  | ✅ Live | https://finsight-backend-qiwc.onrender.com |
| Swagger Docs      | ✅ Live | https://finsight-backend-qiwc.onrender.com/swagger-ui/index.html |

---

## 🛠 Tech Stack

### Frontend
- ⚛ **React** (with **Vite**)
- 📘 **TypeScript**
- 🎨 Custom CSS (dark dashboard UI)
- 📊 **Recharts** for analytics (pie chart)

### Backend
- ☕ **Java 17**
- 🌱 **Spring Boot 3**
- 🔐 **Spring Security + JWT**
- 🧮 **Maven** for build & dependencies

### Data & Infra
- 🗄 **H2** (dev) / **PostgreSQL** (prod-ready)
- 🐳 Dockerized backend
- ☁ **Render** (backend hosting)
- ☁ **Vercel** (frontend hosting)
- 📜 **Swagger/OpenAPI** for API documentation

---

## 💡 Core Features

### 👤 Authentication & Security
- Register and login with email & password.
- Passwords stored securely (using hashing on the backend).
- JWT token returned on login/registration and stored in `localStorage`.
- All protected endpoints require a valid `Authorization: Bearer <token>` header.

### 💸 Transaction Management
- Add **INCOME** or **EXPENSE** with:
  - Amount
  - Type
  - Category (Food, Rent, Travel, Shopping, Bills, Others)
  - Date
  - Description (optional)
- View all transactions in a responsive table.
- Delete individual transactions.

### 📈 Analytics Dashboard
- Summary cards:
  - **Total Income**
  - **Total Expense**
  - **Net Savings**
- **Spending by Category** pie chart (powered by Recharts).
- Real-time UI updates after every transaction add/delete.

### 👥 Multi-User Support
- Every user’s data is isolated:
  - Transactions, summary, and analytics are **user-specific**.
- Backend APIs filter data using the authenticated user’s ID from the JWT.

---

## 🧱 High-Level Architecture

```text
┌───────────────────────────┐        ┌──────────────────────────┐
│         Frontend          │        │         Backend          │
│  React + Vite + TS        │  HTTP  │  Spring Boot + JWT      │
│                           ├────────▶  /api/auth/**            │
│  Auth Forms               │        │  /api/transactions/**   │
│  Dashboard (cards, chart) │        │  /api/analytics/**      │
└───────────────────────────┘        └─────────────┬────────────┘
                                                   │
                                                   ▼
                                         ┌──────────────────┐
                                         │  Database (H2 /  │
                                         │   PostgreSQL)    │
                                         └──────────────────┘
