# Pet Adoption Platform — Java (Servlets + JDBC + JSP)

## Overview
This repository contains a Java-based implementation of the Pet Adoption Platform using Servlets, JDBC, MySQL and JSP (Bootstrap UI).

## What is included (for Review 1)
- `schema.sql` — MySQL database schema and sample data.
- `pom.xml` — Maven build file.
- `src/` — project source structure (placeholders; real code in next commit).
- `presentation.pdf` — Presentation slides for Review 1.
- `README.md` — (this file).

## How to run (for reviewers)
1. Create DB: `mysql -u root -p < schema.sql`
2. Update DB credentials in `src/main/resources/db.properties` (file present as placeholder).
3. Build with Maven: `mvn clean package`
4. Deploy `target/pet-adoption.war` to Tomcat (or run via IDE).
5. Open `http://localhost:8080/pet-adoption/`

## Notes
- This repo is the Java-based project for GUVI Review 1.
- For full source files (Servlets, DAO, JSP), see subsequent commits.
