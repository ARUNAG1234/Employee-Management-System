Employee Management System
A web-based Employee Management System built with Java, Spring Boot, Spring MVC, Spring Security, Hibernate/JPA, MySQL and Thymeleaf.

Features
Authentication
User registration
Login and logout
Database-backed authentication
Password hashing using BCrypt
USER and ADMIN roles
Employee Management
Add employee
View employees
Search employees
View employee details
Update employee
Delete employee
Employee department and designation
Salary management
Joining date
Active/inactive status
Role-Based Access
ADMIN

View employees
Add employees
Edit employees
Delete employees
Search employees
USER

View employees
Search employees
View employee details
Technologies
Java 17
Spring Boot 3
Spring MVC
Spring Security
Spring Data JPA
Hibernate
MySQL
Thymeleaf
Maven
HTML5
CSS3
Architecture
Controller → Service → Repository → Hibernate/JPA → MySQL

Database Setup
Create the database:

CREATE DATABASE employee_management_db;
Update:

src/main/resources/application.properties

with your MySQL credentials.

Run
mvn clean install
mvn spring-boot:run
Open:

http://localhost:8080

Create an Admin
Register normally. New accounts receive the USER role.

For a local/demo installation, promote your account:

UPDATE users
SET role = 'ADMIN'
WHERE username = 'your_username';
Log out and log in again.

Main URLs
/login
/register
/employees
/employees/view/{id}
/employees/new (ADMIN)
/employees/edit/{id} (ADMIN)
/employees/delete/{id} (ADMIN)
Security
Passwords are stored using BCrypt hashing. Do not commit real database passwords or production secrets to GitHub.

Author
Aruna G.
