<!-- PROJECT LOGO -->
<p align="center">
  <img src="https://share.google/images/1vFwXgbATUNwcOLZs" width="120"/>
</p>

<h1 align="center">🐾 PetVerse — Pet Adoption Platform</h1>

<p align="center">
  <b>Java Servlets • JSP • JDBC • Maven • Tomcat</b>
</p>

<p align="center">
  <!-- Shields.io Badges -->
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java"/>
  <img src="https://www.google.com/imgres?q=maven%20logo&imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F5%2F52%2FApache_Maven_logo.svg%2F1280px-Apache_Maven_logo.svg.png&imgrefurl=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3AApache_Maven_logo.svg&docid=7sX6XkybIyx6LM&tbnid=P85lqIq29_4mLM&vet=12ahUKEwj6ssKct42RAxVcTmwGHaN9GvkQM3oECCEQAA..i&w=1280&h=324&hcb=2&ved=2ahUKEwj6ssKct42RAxVcTmwGHaN9GvkQM3oECCEQAA"/>
  <img src="https://img.shields.io/badge/Tomcat-11.0-blue?style=for-the-badge&logo=apachetomcat"/>
  <img src="https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql"/>
</p>

---

## 📌 Overview

**PetVerse** is a web-based Pet Adoption System built entirely using **Core Java technologies**.  
This project follows MVC architecture using:

- Java Servlets  
- JSP (View Layer)  
- JDBC + HikariCP (Database Layer)  
- Maven (Build)  
- Apache Tomcat (Deployment)

The project is built as part of **GUVI Full Stack Java Developer (Review-1)**.

---

## 🧰 Tech Stack

| Layer | Technologies Used |
|------|-------------------|
| **Frontend** | JSP, HTML5, CSS, Bootstrap |
| **Backend** | Java 17, Servlets, JDBC |
| **Database** | MySQL 8.0, HikariCP Connection Pool |
| **Server** | Apache Tomcat 11 |
| **Build Tool** | Maven |
| **Version Control** | Git + GitHub |

---

## 📁 Folder Structure

```
PetVerse/
 ├── pom.xml
 ├── schema.sql
 ├── README.md
 ├── presentation.pdf
 ├── src/
 │   ├── main/
 │   │   ├── java/com/project/petverse/
 │   │   │   ├── controller/ (Servlets)
 │   │   │   ├── dao/        (DB Layer)
 │   │   │   ├── model/      (JavaBeans)
 │   │   │   └── util/       (DB Connection)
 │   │   ├── resources/
 │   │   │    └── db.properties
 │   │   └── webapp/
 │   │        ├── index.jsp
 │   │        ├── pages/*.jsp
 │   │        └── WEB-INF/web.xml
 └── target/petverse.war
```

---

## 🗄️ Database Schema (MySQL)

Execute:

```bash
mysql -u root -p < schema.sql
```

### Tables included:
- `users`
- `pets`
- `adoption_requests`

---

## 🔌 Configure Database Connection

Edit:

```
src/main/resources/db.properties
```

Add:

```
jdbc.url=jdbc:mysql://localhost:3306/petverse
jdbc.username=root
jdbc.password=YOUR_PASSWORD
jdbc.maximumPoolSize=10
```

---

## 🛠️ Build Project (WAR File)

```
mvn -U clean package
```

Generates:

```
target/petverse.war
```

---

## 🚀 Deploy on Apache Tomcat (macOS)

### 1. Install Tomcat
```bash
brew install tomcat
```

### 2. Copy WAR file
```bash
cp target/petverse.war /opt/homebrew/opt/tomcat/libexec/webapps/
```

### 3. Start server
```bash
brew services start tomcat
```

### 4. Open in browser
```
http://localhost:8080/petverse/
```

---

## 🔍 Test Endpoints

| Endpoint | Description |
|----------|-------------|
| `/petverse/` | Home page |
| `/petverse/hello` | HelloServlet test |
| `/petverse/test-db` | Database connection test |

---

## 🧩 Architecture Diagram (MVC)

```
        +-------------+
        |   Client    |
        +------+------+
               |
               v
      +--------+---------+
      |    Servlet       |  <-- Controller
      +--------+---------+
               |
               v
      +--------+---------+
      |     Service      |
      +--------+---------+
               |
               v
      +--------+---------+
      |       DAO        | <-- JDBC + HikariCP
      +--------+---------+
               |
               v
          +----+----+
          |  MySQL  |
          +---------+
```

---

## 🖼️ Screenshots (Coming in Review-2)

<p align="center">
  <i>Screenshots will be added after completing UI pages.</i>
</p>

---

## 📌 Review-1 Deliverables (Status)

| Task | Status |
|------|--------|
| GitHub Repo Setup | ✅ Completed |
| Maven Project | ✅ Completed |
| Database Schema | ✅ Completed |
| WAR Build Success | ✅ Completed |
| Tomcat Deployment | ✅ Completed |
| Test Servlet Working | ✅ Completed |
| README + Presentation | ✅ Completed |
| Full MVC Implementation | ⏳ Review-2 |
| JSP Pages + UI | ⏳ Review-2 |
| CRUD + Adoption Flow | ⏳ Review-2 |

---

## 👨‍💻 Author

**Ashish Kumar Sharma**  
GitHub: https://github.com/justkrypticAsh

---

<p align="center">
  ⭐ If you like this project, consider giving it a star on GitHub!
</p>

