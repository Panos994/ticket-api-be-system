# Ticket API

A lightweight Spring Boot backend for a ticketing system.

## Features
- User registration and role assignment
- JWT-based authentication
- Event management
- Reservation creation and cancellation
- PostgreSQL persistence

## Tech Stack
- Java 17
- Spring Boot 4.1.1
- Spring Web / Security / Data JPA
- PostgreSQL
- Maven

## Run locally
1. Start PostgreSQL and create the database `ticket_mg_db`.
2. Update database credentials in `src/main/resources/application.properties` if needed.
3. Run:

```bash
./mvnw spring-boot:run
```

The app starts on:
- `http://localhost:9794`

## Main endpoints
- `POST /api/auth/login`
- `POST /api/users`
- `GET /api/users`
- `PATCH /api/users`
- `GET /api/events`
- `POST /api/events`
- `POST /api/reservations`
- `DELETE /api/reservations/{reservationId}`

## Notes
This project is a backend API for managing tickets, users, and event bookings with JWT authentication and secure access control.
