# 🏨 Hotel Management System

A full-stack hotel management web application built with Spring Boot, featuring room management, booking, and cancellation — deployed live with Docker on Render.

🔗 **Live Demo:** [hotelmanagementsystem-3.onrender.com](https://hotelmanagementsystem-3.onrender.com)

> ⏳ Free tier hosting — first load may take 30-50 seconds if the app has been inactive.

## ✨ Features

- 🛏️ Room listing with real-time availability
- 📅 Room booking with check-in/check-out dates
- ❌ Booking cancellation
- 🔒 Secured REST APIs with Spring Security
- 📊 PostgreSQL database integration
- 🐳 Dockerized for consistent deployment

## 🛠️ Tech Stack

**Backend:** Java 21, Spring Boot, Spring Data JPA, Spring Security, Maven
**Database:** PostgreSQL
**Frontend:** HTML, CSS, JavaScript, Bootstrap
**Deployment:** Docker, Render

## 🏗️ Architecture
HotelManagementSystem/
├── src/main/java/com/ty/HotelManagementSystem/
│ ├── controller/
│ ├── entity/
│ ├── repository/
│ ├── service/
│ └── config/
├── src/main/resources/
│ ├── static/ (frontend HTML/CSS/JS)
│ └── application.properties
├── Dockerfile
└── pom.xml

## 🚀 Running Locally

```bash
git clone https://github.com/vignes016-prog/HotelManagementSystem.git
cd HotelManagementSystem
mvn clean package
java -jar target/*.jar
```

Configure your PostgreSQL credentials in `application.properties` before running.

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/rooms` | Get all rooms |
| POST | `/api/bookings` | Create a booking |
| PUT | `/api/bookings/{id}/cancel` | Cancel a booking |
| GET | `/api/bookings` | Get all bookings |

## 👤 Author

**Vignesh A**
[GitHub](https://github.com/vignes016-prog) · [LinkedIn](https://www.linkedin.com/in/vignesh016/)
