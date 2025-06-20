# 🧩 User Service – Microservicio con Spring Boot 2.7 y Java 11

Este es un microservicio de ejemplo para la gestión de usuarios, creado con **Java 11** y **Spring Boot 2.7.18**. Utiliza una base de datos H2 en memoria, expone endpoints RESTful y soporta monitoreo con **Prometheus** y documentación con **Swagger**.

---

## 📐 Arquitectura del Proyecto

- **Lenguaje:** Java 11
- **Framework principal:** Spring Boot 2.7
- **Persistencia:** Spring Data JPA + H2
- **Documentación:** Springfox Swagger
- **Monitoreo:** Spring Boot Actuator + Micrometer + Prometheus
- **Testing:** JUnit, Mockito, Spring Boot Test
- **Build Tool:** Maven

---

## 📁 Estructura de paquetes

```
backend-user-service/
├─ src/
│ ├─ main/
│ │ ├─ java/com/ditech/backend/
│ │ │ ├─ model/
│ │ │ │ └─ User.java
│ │ │ ├─ repository/
│ │ │ │ └─ UserRepository.java
│ │ │ ├─ service/
│ │ │ │ └─ UserService.java
│ │ │ └─ controller/
│ │ │ └─ UserController.java
│ │ └─ resources/
│ │ ├─ application.properties
│ │ └─ data.sql
│ └─ test/
│ └─ java/com/ditech/backend/
│ ├─ service/
│ │ └─ UserServiceTest.java
│ └─ controller/
│ └─ UserControllerTest.java
├─ pom.xml
└─ README.md
```

---

## 🚀 Cómo ejecutar el proyecto

### 🔧 Requisitos

- Java 11 instalado
- Maven instalado 3.9.9

### ▶️ Instrucciones

1. Clona o descarga este repositorio.
2. Asegúrate de tener Java 11 como path en las variables de entorno
3. Ejecuta el siguiente comando desde la terminal del proyecto:

```bash
./mvnw spring-boot:run
# o si tienes Maven global:
mvn spring-boot:run
```

## Detener la aplicación
Desde la terminal de windows ctrl + c y luego S para aceptar detener la aplicacion

- - -
4. El servidor arrancará en el puerto `8080`.

---

## 📡 Endpoints REST

- `POST /users` – Crea un nuevo usuario
- `GET /users` – Lista todos los usuarios
- `GET /users/{id}` – Obtiene un usuario por ID
- `DELETE /users/{id}` – Elimina un usuario por ID

Ejemplo JSON para crear un usuario:

```json
{
  "username": "johndoe",
  "email": "john@example.com",
  "active": true
}
```

---

## 📊 Consolas y herramientas disponibles

| Herramienta        | URL                                                |
|--------------------|-----------------------------------------------------|
| SpringDoc Open-API | [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) |
| H2 Console         | [http://localhost:8080/h2-console](http://localhost:8080/h2-console) |
| Prometheus Metrics | [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus) |

---

## 🧪 Ejecutar pruebas

```bash
mvn test
```

Incluye pruebas unitarias de servicio (`UserService`) y pruebas de integración para el controlador (`UserController`).

---

---

## 🧑‍💻 Autor
Robert Carvajal Franco
