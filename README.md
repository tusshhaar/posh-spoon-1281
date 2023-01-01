# Online Plant Nursery Application


//<p>
       // <img
      //  align="center"
      //  src="https://github.com/parimalbiswas/tropical-jellyfish-2222/blob/main/Team.jpeg"
      //  alt="Coding"
      //  width="700"
       // style="display: block"/>
   // </p>
   // <br>

This project is developed by a team of 5 members with the help of the Spring-Boot framework. The main objective of this Web services application is to cater needs of front-end developers to call different types of API as per the requirement.


## Tech Stack and Tools
- Java
- Spring Boot Framework
- Spring Data JPA
- Hibernate
- MySQL
- Postman
- Lombok

//## ER- Diagram
//<p>
     //   <img
    //    align="center"
  //      src="https://github.com/parimalbiswas/tropical-jellyfish-2222/blob/main/ER%20-DIA.jpg?raw=true"
   //     alt="Coding"
   //     width="700"
    //    style="display: block"/>
  //  </p>
   // <br>


## Modules
- Admin Module
- Customer Module
- Login/Logout Module
- Order Module
- Items Module
- Cart Module

## Features
- Admin Features:
 - Admin can perform CRUD operation like add, update and delete by using generated session key.
 - Admin can delete customer also.
 - Admin can view the list of item and customer.
 
- Customer Features:
 - Customer can register themseleves to use this application.
 - Customer can login to get the valid session token(id).
 - View list of available items.
 - Add items to cart, and view that cart.
  
## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.
server.port=8008
spring.datasource.url=jdbc:mysql://localhost:3306/sb201db;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=enter_username
spring.datasource.password=enter_password
```
## API Root Endpoint
```
https://localhost:8888/
```
