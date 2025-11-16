# FinSight – Personal Finance & Expense Analytics

**Author:** Kshitij Srivastava

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
