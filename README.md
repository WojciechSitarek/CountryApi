# Country API

## Description

Country API is a simple RESTful service that allows fetching information about countries based on their ISO 3166-1 alpha-3 code. The API integrates with the external **RestCountries** service, which provides detailed data about countries, such as name, capital, languages, currencies, timezones, population, borders, region, subregion, and more.

The API saves the retrieved data in a local H2 database, and then provides it to users, ensuring faster access to information if the data has been previously fetched and stored.

## Technologies Used

This project utilizes the following technologies:

1. **Java 21**  
   The application is built using Java 21, which is the primary programming language for backend development. Java 21 provides advanced language features and improved performance, making it ideal for modern application development.

2. **Spring Boot**  
   Spring Boot is used to simplify the setup and configuration of the application. It allows rapid development of production-grade applications with minimal configuration.

3. **Lombok**  
   Lombok is used to reduce boilerplate code in Java, such as getters, setters, constructors, and more. It uses annotations to generate these elements during compile-time, making the code more concise and readable.

4. **Maven**  
   Maven is the build automation tool used in this project to manage dependencies, build the project, and run the application. It simplifies the process of dependency management and project configuration.

5. **H2 Database**  
   H2 is an in-memory database used to store country data. It provides fast and lightweight storage for the project, enabling quick storage and retrieval of country information fetched from external APIs.

6. **Spring Data JPA**  
   Spring Data JPA is used for data persistence. It provides a simple way to interact with databases using Java Persistence API (JPA), eliminating the need for boilerplate code to access and manage relational databases.

7. **Spring Web**  
   Spring Web is used to build RESTful web services. It enables the creation of the API endpoints that handle HTTP requests and responses, providing the necessary infrastructure for building scalable web applications.

## Setting up the Project

To run the project locally, make sure that your environment is set up correctly. Follow the steps below:

### IntelliJ IDEA Configuration

1. **Install Lombok Plugin**  
   Ensure that the Lombok plugin is installed in your IDE. You can install it by going to:
   - `File` → `Settings` → `Plugins`
   - Search for "Lombok" and click "Install".

2. **Enable Annotation Processing**  
   Lombok requires annotation processing to generate code during compile time. To enable annotation processing in IntelliJ IDEA:
   - Navigate to: `Preferences` → `Build, Execution, Deployment` → `Compiler` → `Annotation Processors`.
   - Make sure the option **Enable annotation processing** is checked.

3. **Rebuild the Project**  
   After enabling annotation processing, rebuild your project to ensure Lombok annotations are processed correctly. You can rebuild the project using:
   - `Build` → `Rebuild Project`.

4. **Add Lombok Dependency**  
   Make sure you add Lombok as a dependency in your project. Add the following to your `pom.xml` (Maven) or `build.gradle` (Gradle):

   - **For Maven (`pom.xml`)**:
     ```xml
     <dependencies>
         <dependency>
             <groupId>org.projectlombok</groupId>
             <artifactId>lombok</artifactId>
             <version>1.18.24</version> <!-- or the latest version -->
             <scope>provided</scope>
         </dependency>
     </dependencies>
     ```

   - **For Gradle (`build.gradle`)**:
     ```gradle
     dependencies {
         compileOnly 'org.projectlombok:lombok:1.18.24'  // or the latest version
         annotationProcessor 'org.projectlombok:lombok:1.18.24'  // or the latest version
     }
     ```

   Make sure to sync your dependencies with your build tool (`mvn clean install` for Maven or `gradle build` for Gradle).

5. **Add Lombok Plugin to Build Configuration**  
   To ensure proper annotation processing, add the following configuration to the `<build>` section of your `pom.xml` file for Maven(or newer version):
 ```xml
<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<annotationProcessorPaths>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</path>
					</annotationProcessorPaths>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>
```

## Features

- Retrieve country data based on its ISO code.
- Store data in a local H2 database.
- Ability to scale and add new features in the future.

## Endpoints

### GET `/country/{code}`

Fetches information about a country based on its ISO 3166-1 alpha-3 code.

#### Example:

- **URL:** `/country/PL`
- **Method:** GET
- **Response:**

```json
{
  "commonName": "Poland",
  "officialName": "Republic of Poland",
  "currencies": ["PLN"],
  "capital": ["Warsaw"],
  "region": "Europe",
  "subregion": "Eastern Europe",
  "languages": ["pl"],
  "population": 38386000,
  "borders": ["DEU", "CZE", "SVK", "UKR", "BLR", "LTU", "RUS"],
  "timezones": ["CET", "CEST"]
}
