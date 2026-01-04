# Bank-Account-System-Java-JDBC-

# Bank Account System (Java + JDBC)

## Overview
This is a simple Java console application that connects to a MySQL database using JDBC.  
It allows users to **create a new bank account** and **check the balance** of an existing account by entering the account number. The project demonstrates JDBC basics such as driver loading, database connection, parameterized queries, and reading results with `ResultSet`.

---

## Objectives
- Create new accounts with account number, holder name, and initial balance.
- Fetch and display account balance securely using JDBC.
- Show how to use `PreparedStatement` for safe queries.
- Demonstrate `ResultSet` navigation for reading data.

---

## Tech Stack
- Java (JDK 8 or higher)
- JDBC (Java Database Connectivity)
- MySQL
- MySQL Connector/J (JDBC driver)

---

## Project Structure
BankAccountSystem/ │ ├── src/com/bank/account/ │   ├── Account.java          # Model class │   ├── AccountDAO.java       # Handles INSERT + SELECT queries │   ├── DBConnection.java     # Utility for DB connection │   └── Main.java             # Console menu (Create + Check Balance) │ ├── sql/accounts_table.sql    # SQL script to create DB & table └── README.md                 # Documentation


---

## Database Setup
Run this SQL script before starting the program:

```sql
CREATE DATABASE bankdb;

USE bankdb;

CREATE TABLE accounts (
    acc_no INT PRIMARY KEY,
    holder_name VARCHAR(50),
    balance DOUBLE
);
