# FinSight – Personal Finance & Expense Analytics

**Author:** Kshitij Srivastava
# FinSight 💰 Personal Finance & Expense Analytics

![Build](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)
![Java](https://img.shields.io/badge/Backend-SpringBoot_3-orange)
![React](https://img.shields.io/badge/Frontend-React_Vite-blue)
![Database](https://img.shields.io/badge/Database-H2%20(in-memory)-lightgrey)
![Status](https://img.shields.io/badge/version-1.0.0-success)
![Maintained](https://img.shields.io/badge/Maintained-Yes-success)

This repository contains a full-stack personal finance tracker:

- `backend/` – Java Spring Boot API with JWT auth, analytics & Swagger docs  
- `frontend/` – React + Vite dashboard with charts and transaction management  

To run locally:

```bash
# Backend
cd backend
mvn clean package
mvn spring-boot:run

# Frontend
cd ../frontend
npm install
npm run dev
```

Or using Docker:

```bash
docker-compose up --build
```
