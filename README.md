# Task Management System

The **Task Management System** is a project management application built using **Spring Boot** and **Hibernate**. It allows users to create, update, and delete projects and tasks, allocate resources, and track task statuses.

## Features

- **Project Management**: Create, update, and delete projects.
- **Task Management**: Add tasks to projects with status options (Pending, In Progress, Completed).
- **Resource Allocation**: Assign resources (developers) to tasks within projects.
- **Resource Constraints**: Prevents over-allocation of resources; each resource can be assigned to a maximum of 2 tasks within the same project.
- **Validation Logic**: Ensures only available resources are assigned to new tasks.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- Spring Data JPA
- MySQL (or any relational database)
- REST API

## Project Structure


## API Endpoints

The following endpoints are exposed:

### Project Endpoints

| Method   | Endpoint                | Description                    |
|----------|--------------------------|--------------------------------|
| `POST`   | `/projects/add`          | Add a new project              |
| `GET`    | `/projects/{id}`         | Get a project by its ID        |
| `GET`    | `/projects/all`          | Get all projects               |
| `DELETE` | `/projects/{id}`         | Delete a project by its ID     |

### Task Endpoints

| Method   | Endpoint                   | Description                       |
|----------|-----------------------------|-----------------------------------|
| `POST`   | `/tasks/add`               | Add a new task to a project       |
| `PUT`    | `/tasks/{id}`              | Update a task status              |
| `DELETE` | `/tasks/{id}`              | Delete a task by its ID           |
| `GET`    | `/tasks/{projectId}/all`   | Get all tasks for a specific project |

### Resource Endpoints

| Method   | Endpoint                     | Description                            |
|----------|-------------------------------|----------------------------------------|
| `POST`   | `/resources/add`              | Add a new resource                     |
| `PUT`    | `/resources/{id}/assign`      | Assign a resource to a task            |
| `GET`    | `/resources/available`        | Get all available resources            |

## Resource Constraints

- Each resource can be allocated to a maximum of **2 tasks** within the same project.
- Only resources marked as "Available" can be assigned to tasks.

## How to Run

1. Clone the project repository:

   ```bash
   git clone https://github.com/your-username/task-management-system.git
cd task-management-system
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

mvn spring-boot:run
POST /tasks/add
Content-Type: application/json

{
  "projectId": 1,
  "name": "Develop User Interface",
  "status": "Pending",
  "assignedResourceId": 2
}


This `README.md` provides an overview of the project, its structure, API endpoints, and setup instructions, which can be adjusted based on the exact structure and dependencies of your project.


