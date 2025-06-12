# 🩺 FirstAPI - Patient Management System

This is a simple RESTful API built with **Spring Boot** for managing patients in a healthcare context. The project includes basic CRUD operations and is documented using **Swagger UI** and tested with **Postman**.

---

## 🚀 Features

- ✅ Create new patients
- 📋 Get a list of all patients
- ✏️ Update patient information
- ❌ Delete a patient by ID
- 📖 Swagger UI documentation
- 📦 Postman Collection included

---

## 🧰 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database (or external DB)**
- **Swagger (Springdoc OpenAPI)**
- **Postman**

---

## 📂 Project Structure

```
src
 └── main
     ├── java/com/example/demo
     │   ├── controller/PatientController.java
     │   ├── service/PatientService.java
     │   ├── repository/PatientRepository.java
     │   └── model/Patient.java
     └── resources
         ├── application.properties
         └── static/
```

---

## 🔧 How to Run the Project

### Using Maven

```bash
git clone https://github.com/bassam207/FirstAPI.git
cd FirstAPI
mvn spring-boot:run
```

### Swagger UI

After running, open:

```
http://localhost:8080/swagger-ui.html
```

### H2 Database Console (Optional)

```
http://localhost:8080/h2-console
```

(Default credentials set in `application.properties`)

---

## 📬 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/v1/patients` | Get all patients |
| GET    | `/api/v1/patients/{id}` | Get a patient by ID |
| POST   | `/api/v1/patients` | Add a new patient |
| PUT    | `/api/v1/patients/{id}` | Update patient |
| DELETE | `/api/v1/patients/{id}` | Delete patient |

---

## 📁 Postman Collection

You can import the file `Patient API.postman_collection.json` into Postman to test all endpoints.

---

## 👨‍💻 Author

**Bassam207**  
[GitHub Profile](https://github.com/bassam207)

---

## 📌 Notes

- You can extend the project by adding:
  - Authentication (Spring Security / JWT)
  - Input Validation
  - Exception Handling
  - DTO Mapping using MapStruct or ModelMapper
  - Unit Tests with JUnit/Mockito

---

> Feel free to fork or improve this project. PRs are welcome!