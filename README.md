# Employee Management API

The Employee Management API is a RESTful web service built with Spring Boot for managing employee data. It provides endpoints to list, retrieve, create, update, and delete employee records.

## Endpoints

### List Employees

- **GET /api/employees**

  Returns a list of all employees in the database.

```json
[
    {
        "employee_id": 100,
        "first_name": "Steven",
        "last_name": "King",
        "email": "steven.king@sqltutorial.org",
        "phone_number": "515.123.4567",
        "hire_date": "1987-06-17T06:00:00.000+00:00",
        "job_id": 4,
        "salary": 24000.0,
        "manager_id": null,
        "department_id": 9
    },
    {
        "employee_id": 101,
        "first_name": "Neena",
        "last_name": "Kochhar",
        "email": "neena.kochhar@sqltutorial.org",
        "phone_number": "515.123.4568",
        "hire_date": "1989-09-21T06:00:00.000+00:00",
        "job_id": 5,
        "salary": 17000.0,
        "manager_id": 100,
        "department_id": 9
    },
    "..."
]
```

### Get Employee by ID

- **GET /api/employees/{id}**

  Returns details of a specific employee identified by their ID.
  
- For example: GET /api/employees/207:

```json
{
    "employee_id": 207,
    "first_name": "Carlos",
    "last_name": "Hernandez",
    "email": "carlos.hernandez@sqltutorial.org",
    "phone_number": "756.123.4567",
    "hire_date": "1999-06-17T06:00:00.000+00:00",
    "job_id": 4,
    "salary": 30000.0,
    "manager_id": null,
    "department_id": 9
}
```

### Create Employee

- **POST /api/employees**

  Creates a new employee record.
- For example as argument:
  Body in raw JSON:

```json
{
    "first_name": "Carlos",
    "last_name": "Hernandez",
    "email": "carlos.hernandez@sqltutorial.org",
    "phone_number": "756.123.4567",
    "hire_date": "1999-06-17T06:00:00.000+00:00",
    "job_id": 4,
    "salary": 30000.0,
    "manager_id": null,
    "department_id": 9
}
```

### Update Employee

- **PUT /api/employees/{id}**

  Updates the details of an existing employee identified by their ID.


### Delete Employee

- **DELETE /api/employees/{id}**

  Deletes an employee record by their ID.

## Usage

To use this API, you can make HTTP requests to the provided endpoints using tools like curl, Postman, or any programming language that supports HTTP requests.

## Prerequisites

Before running the API, ensure you have the following:

- Java Development Kit (JDK)
- Spring Boot installed
- Database configured (MySQL or another supported database)
- Dependencies specified in the `pom.xml` file

## Running the API

1. Clone this repository to your local machine.

2. Configure your database connection by modifying the `application.properties` file on `src/main/resources/`.

3. Build and run the API using the following command:

   ```bash
   mvn spring-boot:run
