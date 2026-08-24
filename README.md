# Employee Payroll Management System

A **Core Java** console application that manages employees, attendance, payroll calculations, and payslips without using a database.

The project demonstrates **Object-Oriented Programming, Java Collections, Enums, Java Date & Time API, BigDecimal, Streams, Optional, Lambda Expressions, layered architecture, Repository Pattern, Service Layer, exception handling, and automated testing with JUnit 5**.

---

# ✨ Features

## 👨‍💼 Employee Management

- Add Employee
- Search Employee
- View All Employees
- Update Employee
- Delete Employee

---

## 📅 Attendance Management

- Mark Attendance
- View Employee Attendance
- View Monthly Attendance
- Track Attendance Status

---

## 💰 Payroll Management

- Calculate Salary
- Calculate Bonus
- Calculate Tax
- Calculate Net Salary

---

## 🧾 Payslip Management

- Generate Payslip
- View Payslip
- Store Payslip Information
- Support Monthly Pay Periods

---

## 📊 Employee Reports

- Employees by Department
- Employees by Salary
- Highest Paid Employee
- Average Salary by Department
- Employee Count by Department

---

## 🧪 Automated Testing

The project includes unit tests for:

- Model Classes
- Repository Classes
- Service Classes
- Employee Operations
- Attendance Operations
- Payroll Operations

Testing is implemented using **JUnit 5**.

---

# 🛠 Technologies Used

- Java 25
- Gradle
- Gradle Kotlin DSL
- Object-Oriented Programming
- Java Collections Framework
- LinkedHashMap
- ArrayList
- Streams
- Lambda Expressions
- Optional
- Functional Programming
- BigDecimal
- Java Date & Time API
- Exception Handling
- JUnit 5

---

# 📁 Project Structure

```text
Employee-Payroll-Management-System/
│
├── src/
│   │
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── dheeraj/
│   │               └── payroll/
│   │
│   │                   ├── Main.java
│   │                   │
│   │                   ├── model/
│   │                   │   ├── Employee.java
│   │                   │   ├── Attendance.java
│   │                   │   └── Payslip.java
│   │                   │
│   │                   ├── repository/
│   │                   │   ├── EmployeeRepository.java
│   │                   │   ├── AttendanceRepository.java
│   │                   │   └── PayslipRepository.java
│   │                   │
│   │                   ├── services/
│   │                   │   ├── EmployeeService.java
│   │                   │   ├── AttendanceService.java
│   │                   │   └── PayslipService.java
│   │                   │
│   │                   ├── ui/
│   │                   │   ├── EmployeeUI.java
│   │                   │   ├── AttendanceUI.java
│   │                   │   ├── PayslipUI.java
│   │                   │   └── ReportsUI.java
│   │                   │
│   │                   ├── enums/
│   │                   │   ├── Department.java
│   │                   │   ├── EmployeeType.java
│   │                   │   └── AttendanceStatus.java
│   │                   │
│   │                   ├── exception/
│   │                   │   └── EmployeeNotFoundException.java
│   │                   │
│   │                   └── util/
│   │                       └── Generator.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── dheeraj/
│                   └── payroll/
│
│                       ├── model/
│                       │   ├── EmployeeTest.java
│                       │   ├── AttendanceTest.java
│                       │   └── PayslipTest.java
│                       │
│                       ├── repository/
│                       │   ├── EmployeeRepositoryTest.java
│                       │   ├── AttendanceRepositoryTest.java
│                       │   └── PayslipRepositoryTest.java
│                       │
│                       └── services/
│                           ├── EmployeeServiceTest.java
│                           ├── AttendanceServiceTest.java
│                           └── PayslipServiceTest.java
│
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── gradle.properties
├── README.md
└── LICENSE
