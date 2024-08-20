# Student API with microservices implemented

This Student API project with microservices implemented provides a scalable and modular approach to student data management by utilizing a microservice architecture. The project is divided into two distinct microservices, each serving a specific role in the overall system.

The first microservice, `student-adp`, is responsible for CRUD operations for student records by connecting directly to a PostgreSQL database.

The second microservice, `student-ms`, acts as an intermediary layer that takes the data from the API provided by `student-adp`. And it works on only needed part of the taken data. 

## Table of Contents
* [Features](#features)
* [Getting Started](#getting-started)
* [Usage](#usage)
* [Contributing](#contributing)

## Features 
- ### student-adp
    - Create, Read, Update, and Delete (CRUD) operations for student data
    - Integration with PostgreSQL
    - RESTful API design
    - UNIT Testing 
- ### student-ms 
    - Create, Read, Update, and Delete (CRUD) operations for reduced student data. 
    - Integration wit `student-adp`
    - RESTful API design    
    - UNIT and Integration testing

## Getting Started
Let's see how you can get started with our application. You should go through these steps : 

#### Step 1 : Clone the repository 
Firstly, you need to clone the repository by using the following commands : 
```sh
git clone https://github.com/Javid-Sadigli/Student-API-With-Microservices-Implemented.git
cd Student-API-With-Microservices-Implemented
```

#### Step 2 : Run the services 
After cloning the repository, you can run the services. In the main project directory you can see `docker-compose.yaml` file. Using this file, you can access all dockerfiles and run all services including : 
1. Spring Boot applications,
2. PostgreSQL database, 
3. Pgadmin tool (for viewing the database)

by typing the following command : 
```sh
docker-compose up --build -d 
``` 
This command will download the images from the corresponding resources, and will run container for each of the services (applications, database, pgadmin tool).

## Usage 

#### 1. Usage of `student-adp` 
You can use `student-adp` service to manage students by doing CRUD operations on them. For that, you will need to send a request to following endpoints (the base URL for all endpoints is `http://localhost:8080/api/student`) : 

- `GET /{id}` - To retrieve a student by ID
- `POST /` - To create a new student
- `PUT /{id}` - To update an existing student
- `DELETE /{id}` - To delete a student

In `student-adp` service, you can work on these informations of students : 
* Student id, 
* Student name, 
* Student gender, 
* Student email, 
* Student password

#### 2. Usage of `student-ms`
You can use `student-ms` service to manage students by doing CRUD operations on reduced part of them. For that, you will need to send a request to following endpoints (the base URL for all endpoints is `http://localhost:8080/api/student`) : 

- `GET /{id}` - To retrieve a student by ID
- `POST /` - To create a new student
- `PUT /{id}` - To update an existing student
- `DELETE /{id}` - To delete a student

In `student-ms` service, you can only work on these informations of students : 
* Student id, 
* Student name, 
* Student gender

This makes, `student-ms` service more secure. Because, this service doesn't provide any information about students' email and password. If you don't need to work on these fields, you can use `student-ms` service for security. But if you need to work on these fields, you can choose `student-adp` service. 

#### 3. Usage of pgAdmin
You may want to see the database itself also. For that, you can use pgAdmin tool to connect to the database directly. For that, go to `localhost:2000` in your browser. Then, authenticate yourself in pgAdmin. After that, you should click the `Add New Server` button. In the opened window, you should enter the following parameters : 

- Name : name of the server (whatever you want)
- Hostname/address : `postgres`
- Port : `5432`
- Maintenance database : `studentapi`
- Username : `testuser`
- Password : `testpassword`

By this parameters, you can connect to the database of our student API, write queries to see or change datasets manually.

## Contributing 
Contributions are welcome! Follow these steps to contribute:
* Fork the project.
* Create a new branch: `git checkout -b feature/your-feature`.
* Make your changes.
* Submit a pull request.

## Thanks for your attention! 