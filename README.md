# Ticket Raising REST API (Spring Boot)

A simple backend for railway ticket raising and tracking.

## Tech stack
- Java 17
- Spring Boot
- Spring Web, Spring Data JPA
- H2 (or MySQL) database
- Maven

## How to run
1. Clone the repo  
   `git clone https://github.com/samathachiruthani-dotcom/spring_project-Demo-ticket-Raising.git`
2. Go into folder  
   `cd spring_project-Demo-ticket-Raising`
3. Run  
   `mvn spring-boot:run`
4. API base URL: `http://localhost:8080/api/tickets`

## Endpoints
- GET `/api/tickets` – list all tickets  
- GET `/api/tickets/{id}` – get one ticket  
- POST `/api/tickets` – create ticket  
- PUT `/api/tickets/{id}` – update ticket  
- DELETE `/api/tickets/{id}` – delete ticket
