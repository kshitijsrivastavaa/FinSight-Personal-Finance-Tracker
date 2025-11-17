> ⚠️ **Important:** When signing up or logging in for the first time, please wait a few seconds — the backend server wakes from sleep mode. Once active, the app runs smoothly. 🚀

<p align="center">
  <img src="https://img.shields.io/badge/FinSight-Personal%20Finance%20Tracker-4c8bd6?style=for-the-badge&logo=react&logoColor=white" />
</p>

<h1 align="center">💰 FinSight — Personal Finance & Expense Intelligence Platform</h1>

<p align="center">
  A fully production-style finance management system built with 
  <b>Spring Boot</b>, <b>React + Vite</b>, <b>TypeScript</b>, <b>JWT Authentication</b>, and a smooth analytics dashboard.
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

## ✨ Overview

FinSight is a **secure, modern personal finance platform** designed to help users:

- Track income & expenses  
- Visualize financial activity with charts & insights  
- Maintain user-specific transaction history
- Monitor savings & spending trends  
- Access data securely with JWT authentication  

It feels like a **real SaaS dashboard** — responsive, clean, and portfolio-grade.

---

## 🖼 Preview Screenshots

| Authentication | Dashboard |
|---------------|-----------|
| ![Auth](assets/finsight-auth.png) | ![Dashboard](assets/finsight-dashboard-summary.png) |

| Transactions | Analytics |
|-------------|-----------|
| ![Table](assets/finsight-transactions-table.png) | ![Chart](assets/finsight-analytics-chart.png) |

---

## 🛠 Tech Stack Breakdown

### **Frontend**
- ⚛ React (Vite)
- 📘 TypeScript  
- 🎨 Custom UI Styling (dark dashboard look)
- 📊 Recharts for analytics visualization  

### **Backend**
- ☕ Spring Boot 3  
- 🔐 Spring Security + JWT  
- 🧰 Maven  

### **Database & Deployment**
- 🗄 H2 (local development)
- 🐘 PostgreSQL (production-ready)
- 🐳 Docker support
- ☁ Deployments using **Render** + **Vercel**
- 📜 Swagger/OpenAPI documentation available

---

## 💡 Core Features

### 🔐 Authentication & Security
- Account creation + login  
- Secure password hashing  
- JWT-based protected API access  
- LocalStorage token handling on frontend  

### 📊 Dashboard Analytics
- Total income summary
- Total expenses summary
- Net savings indicator
- Automatic live updates on changes  
- Spending categorization & visualization via pie chart  

### 💸 Transaction Handling
- Add income/expense entries  
- Filterable and responsive transaction table  
- Category, date, amount, and type-based structure  
- Delete transaction option  

### 👥 Multi-User Isolation
- Users see **only their data**
- Backend filters by authenticated user ID from JWT

---

## 🧱 System Architecture
 ------------------------------
|            Frontend          |
| React + Vite + TypeScript    |
| - Auth UI                    |
| - Dashboard                  |
| - Charts & Table             |
 ------------------------------
              |
              v
 ------------------------------
|            Backend           |
| Spring Boot + JWT           |
| - Auth APIs                 |
| - Transaction APIs          |
| - Analytics APIs            |
 ------------------------------
              |
              v
 ------------------------------
|            Database          |
| PostgreSQL (Prod) / H2 Dev  |
| - Users                     |
| - Transactions              |
| - Auth Mapping              |
 ------------------------------


