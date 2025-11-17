> ⚠️ **Important:** When signing up or logging in for the first time, please wait a few seconds — the backend server wakes from sleep mode. Once active, the app runs smoothly. 🚀

<div align="center">

<img src="https://img.shields.io/badge/FinSight-Next%20Gen%20Finance%20Tracker-2ECC71?style=for-the-badge&logo=react&logoColor=white"/>

# 💰 FinSight — Smart Personal Finance & Expense Intelligence

**Track. Analyze. Grow.**

FinSight is not just an expense tracker — it's your **financial command center**, built with enterprise-grade architecture, modern UI, and real-time analytics.

</div>

---

## 🚀 Quick Links

<div align="center">

🔗 **Live App:** https://fin-sight-personal-finance-tracker.vercel.app  
🧪 **Backend API:** https://finsight-backend-qiwc.onrender.com  
📘 **Swagger Docs:** https://finsight-backend-qiwc.onrender.com/swagger-ui/index.html  

</div>

---

## 🧩 Overview

FinSight turns raw financial activity into a **clean and actionable dashboard**.  
From authentication to analytics — everything is built with modern stack, scalability in mind, and a premium SaaS experience.

---

### 🏆 Key Highlights

| Feature | Status |
|--------|--------|
| 🔐 JWT Auth + Secure Login | ✔️ |
| 📊 Real-time Expense Analytics (Pie charts, cards) | ✔️ |
| 💸 Income + Expense CRUD | ✔️ |
| 🧾 Search/Filter Transactions | ✔️ |
| 🌍 Multi-User Isolated Data | ✔️ |
| 🛠 Swagger + Docker support | ✔️ |
| 🏗 Production Deployments | ✔️ |

---

## 🖼 Product Showcase

| Login & Signup | Dashboard |
|---------------|-----------|
| ![](assets/finsight-auth.png) | ![](assets/finsight-dashboard-summary.png) |

| Analytics & Charts | Transaction Management |
|---------------|-----------|
| ![](assets/finsight-analytics-chart.png) | ![](assets/finsight-transactions-table.png) |

---

## 🛠 Tech Stack

🔥 Built to be **fast, secure, scalable & pretty.**

| Layer | Technologies |
|-------|-------------|
| **Frontend** | React ⚛ • Vite ⚡ • TypeScript 🧠 • Recharts 📊 • Custom CSS 🎨 |
| **Backend** | Java 17 • Spring Boot • Spring Security • JWT Auth |
| **Database** | H2 (Dev) • PostgreSQL (Production Ready) |
| **Infrastructure** | Docker 🐳 • Render ☁ • Vercel 🚀 |
| **Docs** | Swagger / OpenAPI 📘 |

---

## 🧠 System Architecture

```
 ┌─────────────────────────────┐         ┌──────────────────────────────┐
 │        Frontend UI          │         │            Backend            │
 │ React + TypeScript + Vite   │  HTTPS  │ Spring Boot + JWT Security   │
 │                             ├────────▶│ /auth | /transactions | ...   │
 │ Auth Pages | Dashboard      │         │                                │
 └─────────────────────────────┘         └───────────────┬──────────────┘
                                                         │
                                                         ▼
                                              ┌────────────────────────┐
                                              │       Database         │
                                              │  PostgreSQL / H2 DB    │
                                              └────────────────────────┘
```

---

## ⚙️ Features Breakdown

### 🔐 Secure Authentication
- Token-based secure login  
- Password hashing  
- Authorization headers enforced  

### 💸 Finance Management
- Add income/expense entries  
- Categorizing: Food, Bills, Rent, Travel, Shopping etc.  
- Delete and manage transactions  

### 📈 Smart Analytics
- Pie chart breakdown  
- Summary cards with:
  - Total Income
  - Total Expense
  - Net Balance  
- Automatic UI refresh after actions  

### 👤 Multi-User Support
- Every user sees only their data  
- Backend filters using JWT subject  

---

## 📦 Project Commands

### ▶ Frontend

```sh
npm install
npm run dev
```

### ▶ Backend

```sh
mvn clean install
mvn spring-boot:run
```

### ▶ Docker

```sh
docker-compose up --build
```

---

## 📜 API Documentation

📘 Available via Swagger:

```
/swagger-ui/index.html
```

Includes:
- Auth APIs  
- Transaction APIs  
- Analytics endpoints  

---

## 🌟 Roadmap

| Feature | Status |
|--------|--------|
| Dark/Light Theme | ⏳ Planned |
| Export CSV/PDF | ⏳ Planned |
| AI-based Spending Suggestions | 🚧 In Progress |
| Budget Goals & Alerts | ⏳ Planned |
| Mobile App (React Native) | 🚀 Future |

---

## 🏅 Why FinSight?

> Because finance apps shouldn’t feel boring.  
This project is built to feel modern, smooth, and production-ready — perfect for your **portfolio, resume, or as a real-world daily-use app**.

---

<div align="center">

### ⭐ If you like this project, consider giving the repo a star!

Made with ❤️ by **Kshitij Srivastava**

</div>
