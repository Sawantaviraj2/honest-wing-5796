## honest-wing-5796 
<a name="start"></a> 
# COVID-19 VACCINATION
![Screenshot 2023-08-27 142441](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/3106fed9-f8f8-4487-864b-5cda02f917fb)

This endeavor presents a COVID-19 Vaccination portal developed using Spring Boot. It offers users the ability to schedule vaccinations at nearby centers. Administrators can add members, manage vaccine availability, and oversee dosages. JPA ensures data persistence, while MySQL serves as the database. The project prioritizes validation and web functions, aided by Lombok to minimize redundant code. Swagger enhances API development for administrators and vaccination teams.

## Tech Stack

#### Java | Hibernate | Spring Boot | Spring Framework | Spring Data JPA | Spring Boot Validation | Spring Boot Web | Spring Boot DevTools| Postman | MySQL Database | Maven | Swagger UI | Lombok | HTML | CSS | JavaScript | Swagger

## Modules 
- Vaccine Registration Module
- Booking Appointment Module.
- Vaccination Center Module.
- Vaccine Module.
- Vaccine Inventory Module.
- Search Module.

## Prerequisites

- Java 8 or higher
- Maven
- MySQL Server

## Our Application 🪄

This application aims to make it easier and more convenient for citizens to get vaccinated against Covid-19. It provides an online platform to register and schedule vaccination appointments. People have the flexibility to choose the vaccination center they prefer and can easily pick a suitable appointment time. The self-registration feature ensures that only eligible individuals sign up, which helps make the whole process smoother. The application also guides users through every stage, starting from registration all the way to getting the vaccine, with the goal of making the vaccination experience efficient and trouble-free for everyone.
<a name="back1"></a> 

## ER Diagram 
![ERR](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/f7d573db-9acf-47da-ac8c-02c4b51c2d06)

 <p align="right">( <a href="#start">Back 🔙</a> )( <a href="#start">Restart 🔝</a> )</p>
 
## Screenshots From SWAGGER 📸

![UserController1](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/e6ab2e6a-c655-4460-bb57-f83d30af88d9)


![memberController2](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/e2a34e4f-a819-476c-af4e-a8398c699c36)


![vaccinationCenterController3](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/0f60d18b-1055-4853-adec-5e8516a8f837)


![vaccineInventoryController4](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/ec29c5e7-d48d-4b63-86e8-eb715ebb97c9)


![vaccineController5](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/a777e2ee-65cd-4c9d-b2d7-6c21ed5d5773)


![appointmentController6](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/134c1fe3-4d2d-4a17-80ba-d451c7aa6878)

<a name="back2"></a> 
 <p align="right">( <a href="#back1">Back 🔙</a> )( <a href="#start">Restart 🔝</a> )</p>
 
## Schemas 📌

### User Schema
![UserSchemas1](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/7901ee16-8d70-4b35-9362-139467fdc8ba)

### Member Schema
![Screenshot 2023-08-27 143953](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/ac08ec87-aece-4244-9633-51c16ccbbea7)


### Vaccination Center Schema
![Screenshot 2023-08-27 144056](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/ce8b0ede-6668-4b89-af20-c6d7aba2e5ab)


### Vaccination Inventory Schema
![Screenshot 2023-08-27 144145](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/404dc9ee-a484-4596-a58f-180e2f596c11)


### Vaccine Schema
![vaccineSchemas5](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/b8141781-bbed-491b-81da-ea0176e4c125)

### Appointment Schema
![Screenshot 2023-08-27 144342](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/85ca15e7-2da6-4202-b296-66d7e7c6f5e5)

### Vaccine Count Schema
![Screenshot 2023-08-27 144301](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/299934d6-d69e-4160-a9f7-cbbc0bcae4df)
<a name="back3"></a> 
 <p align="right">( <a href="#back2">Back 🔙</a> )( <a href="#start">Restart 🔝</a> )</p>
 
## Installation and Execution Instructions ⚙️

Follow these steps to set up and run the project locally:

1. Open the `application.properties` file located in the `src/main/resources` directory.

2. Configure your MySQL database credentials by replacing the placeholders with your actual information:
   
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

3. Build the project using Maven by executing the following command:
   
   ```
   mvn clean install
   ```

4. Once the build is successful, navigate to the `target` directory and execute the JAR file using the command:
   
   ```
   java -jar target/decisive-iron-5903-0.0.1-SNAPSHOT.jar
   ```

5. The application will be up and running locally at `http://localhost:8088`.

## API Endpoint Information 

Root Endpoint:
- HTTPS: `https://localhost:8088/`

Swagger API Documentation:
- Access the API documentation using the following URL in your web browser:
  - http://localhost:8088/swagger-ui/index.html

These instructions will guide you through the process of setting up and launching the project locally. If you encounter any issues, please refer to the provided steps or seek assistance from your technical team.

## Collaborators 👨‍💻

- [Aviraj Sawant](https://github.com/Sawantaviraj2) (Team Lead)
- [Shaswat Singh Raghuvansi](https://github.com/ShaswatSRaghuvansi)
- [Kishan Jalan](https://github.com/kishanjalan11) 
- [Sudhist Kumar](https://github.com/ersudhist) 
- [Shivendra Kumar](https://github.com/shivendra-somr)

![Screenshot 2023-08-27 145829](https://github.com/Sawantaviraj2/honest-wing-5796/assets/115460278/7478246f-6aa3-43a0-b15a-d6edeb68d25d)
 <p align="right">( <a href="#back3">Back 🔙</a> )( <a href="#start">Restart 🔝</a> )</p>

