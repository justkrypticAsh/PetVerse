<!-- PROJECT LOGO -->
<p align="center">
  <img src="https://img.icons8.com/?size=128&id=O6PBD5U9PStV&format=png" width="110"/>
</p>

<h1 align="center">🐾 PetVerse — Pet Adoption Platform</h1>

<p align="center"><b>Java Servlets • JSP • JDBC • Maven • Tomcat</b></p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk"/>
  <img src="https://img.shields.io/badge/Maven-Build Success-brightgreen?style=for-the-badge&logo=apachemaven"/>
  <img src="https://img.shields.io/badge/Tomcat-11.0-blue?style=for-the-badge&logo=apachetomcat"/>
  <img src="https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql"/>
</p>

---

## 📌 Overview

**PetVerse** is a complete web-based **Pet Adoption System** built using **Core Java**, focusing on clean MVC design, seamless integration, and strong data validation.

This project is created for **Review-2 (Final Submission)** and includes:

✔ Fully functional adoption flow  
✔ User Authentication (Login/Register)  
✔ Pet CRUD (Add, Edit, Delete)  
✔ SweetAlert2-based UI  
✔ Responsive Bootstrap design  
✔ Session-based access control  
✔ Database-driven dynamic pet listing  

---

## 🧰 Tech Stack

| Layer | Technology |
|------|------------|
| **Frontend** | JSP, HTML5, CSS, Bootstrap 5, SweetAlert2 |
| **Backend** | Java 17, Jakarta Servlets |
| **Database** | MySQL 8.0 |
| **Connection** | JDBC |
| **Server** | Apache Tomcat 11 |
| **Build Tool** | Maven |
| **Version Control** | Git + GitHub |

---

## ✨ Core Features

### 👤 User Features
- Create account (Register)
- Login securely
- View all pets dynamically
- Adopt pets (SweetAlert confirmation)
- Adoption saved in DB (non-blocking)

### 👨‍💼 Admin Features
- Add new pets
- Edit existing pets
- Delete pets
- View/manage adoption requests

### 🎨 UI / UX Highlights
- Glassmorphism cards  
- Gradient animated borders  
- Modern button animations  
- Fade-in transitions  
- Emoji + UTF-8 Support  

---

## 📁 Project Structure

```
PetVerse/
 ├── pom.xml
 ├── README.md
 ├── src/
 │   ├── main/
 │   │   ├── java/com/project/petverse/
 │   │   │   ├── model/
 │   │   │   ├── dao/
 │   │   │   ├── servlet/
 │   │   │   └── util/
 │   │   └── webapp/
 │   │        ├── home.jsp
 │   │        ├── login.jsp
 │   │        ├── register.jsp
 │   │        ├── addPet.jsp
 │   │        ├── listPets.jsp
 │   │        ├── editPet.jsp
 │   │        ├── petDetails.jsp
 │   │        ├── navbar.jsp
 │   │        └── WEB-INF/web.xml
 └── target/petverse.war
```

---

## 🗄️ MySQL Database Schema

### **users**
```
id (PK)
name
email
password
```

### **pets**
```
id (PK)
name
type
breed
age
description
image_url
status
```

### **adoption_requests**
```
id (PK)
pet_id (FK)
user_id (FK)
adopter_name
adopter_email
message
status
request_date
adopted_at
```

---

## ⚙️ Database Configuration

File:

```
src/main/java/com/project/petverse/util/DBConnection.java
```

Set:

```java
private static final String URL = "jdbc:mysql://localhost:3306/petverse_db";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";
```

---

## 🔧 Build Instructions

### 1️⃣ Build project (WAR)
```bash
mvn clean package
```

### 2️⃣ Deploy WAR to Tomcat
```bash
cp target/petverse.war /opt/homebrew/Cellar/tomcat/11.0.14/libexec/webapps/
```

### 3️⃣ Start Tomcat
```bash
catalina start
```

### 4️⃣ Access App
```
http://localhost:8080/petverse
```

---

## 🧪 Testing Checklist

✔ Register / Login  
✔ Add Pet  
✔ Edit Pet  
✔ Delete Pet  
✔ Adopt Pet (popup)  
✔ Adoption saved in DB  
✔ Dynamic pet listings  
✔ UTF-8 Emoji working  
✔ Smooth animations  

---

## 📝 Review-2 Requirements (Status)

| Requirement | Status |
|------------|--------|
| Core Features | ✅ Completed |
| Error Handling | ✅ Completed |
| Data Validation | ✅ Completed |
| Integration | ✅ Completed |
| UI & Design | ✅ Completed |
| Robustness | ✅ Completed |
| GitHub README | ✅ Completed |

---

## 👨‍💻 Author
**Ashish Kumar Sharma**  
🔗 GitHub: https://github.com/justkrypticAsh

---

<p align="center"><b>⭐ Please consider giving the repo a star!</b></p>
