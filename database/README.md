# MySQL Docker Container Setup

This document provides instructions for setting up a MySQL Docker container for the "bd_company" database. Follow the steps below to build and run the container.

## Build Docker Image

Use the following command to build a Docker image for MySQL with your desired settings. Replace `mysql-company-image` with your preferred image name.

```bash
docker build -t mysql-company-image .
```

## Run MySQL Container
Run the MySQL container using the following command. Adjust the environment variables for the root password, MySQL user, and MySQL password as needed.

```bash
docker run -d -p 3306:3306 --name mysql-company-container -e MYSQL_ROOT_PASSWORD=root_password -e MYSQL_USER=company_user -e MYSQL_PASSWORD=company_password mysql-company-image
```

```yaml
-d: Run the container in detached mode.
-p 3306:3306: Map host port 3306 to container port 3306 for MySQL access.
--name mysql-company-container: Assign a name to the container for easy reference.
-e MYSQL_ROOT_PASSWORD=root_password: Set the root password for MySQL.
-e MYSQL_USER=company_user: Create a MySQL user with the specified username.
-e MYSQL_PASSWORD=company_password: Set the password for the MySQL user.
```

## Access MySQL Container
To access the MySQL container, use the following command to start a Bash shell within the container:

```bash
docker exec -ti mysql-company-container bash
```

Once inside the container, you can access the MySQL command-line client:

```bash
mysql -u company_user -p
```

After entering the password, you'll have access to the MySQL shell. You can then interact with the bd_company database.

## Execute SQL Query

To run the SQL query that selects data from the employees table, use the MySQL shell:

```bash
use bd_company;
select
    e1_0.employee_id,
    e1_0.department_id,
    e1_0.email,
    e1_0.first_name,
    e1_0.hire_date,
    e1_0.job_id,
    e1_0.last_name,
    e1_0.manager_id,
    e1_0.phone_number,
    e1_0.salary 
from
    employees e1_0;
```

That's it! You now have a MySQL Docker container running with the "bd_company" database and can execute SQL queries for your API.