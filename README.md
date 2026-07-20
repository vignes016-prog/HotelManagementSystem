<img width="100%" src="https://capsule-render.vercel.app/api?type=waving&color=0:2C3E50,50:4CA1AF,100:2C3E50&height=280&section=header&text=Hotel%20Management%20System&fontSize=48&fontColor=ffffff&animation=fadeIn&fontAlignY=32&desc=Full%20Stack%20Booking%20Platform&descAlignY=52&descSize=18"/>

<p align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=22&pause=1000&color=4CA1AF&center=true&vCenter=true&width=600&lines=Java+%2B+Spring+Boot+Backend;PostgreSQL+%2B+Docker+Deployment;Live+on+Render+%F0%9F%9A%80" alt="Typing SVG" />
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
<img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white"/>
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/>
<img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"/>
</p>

<p align="center">
<a href="https://hotelmanagementsystem-3.onrender.com"><img src="https://img.shields.io/badge/🚀_Live_Demo-Click_Here-success?style=for-the-badge"/></a>
</p>
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
