ATM Web Service

A secure and modern **ATM (Automated Teller Machine)** web service built with **Spring Boot**, featuring **JWT authentication**, **RESTful APIs**, and **MySQL** integration. This project simulates essential ATM operations including user registration, authentication, balance inquiries, cash withdrawals, deposits, and account-to-account transfers.

Project Overview:

This application provides a backend REST API that simulates core ATM functionalities. The service is protected using **JWT (JSON Web Tokens)** for secure user authentication and authorization.

The system allows users to register and perform a variety of operations on their bank accounts after successful login, while ensuring proper validation, error handling, and transaction consistency.

Authentication and Security:

User **registration** and **login**
Secure API access via **JWT tokens**
Stateless session management
- Role-based access control (optional/extendable)

Core Features:

**User Registration** – Create a new user account with personal and account details
**Login** – Authenticate using email/username and password to receive a JWT token
**Deposit Funds** – Add money to a user’s account
**Withdraw Funds** – Withdraw money from the user's account
**Transfer Funds** – Transfer money from one user account to another
**Balance Inquiry** – Get the current account balance
**Transaction History** – View list of all past transactions for the logged-in user 

Tech Stack:

| Layer         | Technology                  |
|---------------|-----------------------------|
| Language      | Java                        |
| Framework     | Spring Boot                 |
| Security      | Spring Security + JWT       |
| Database      | MySQL                       |
| ORM           | Spring Data JPA (Hibernate) |
| API Design    | RESTful API (JSON)          |
| Build Tool    | Maven                       |
