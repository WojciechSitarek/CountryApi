# Country API

## Description

Country API is a simple RESTful service that allows fetching information about countries based on their ISO 3166-1 alpha-3 code. The API integrates with the external **RestCountries** service, which provides detailed data about countries, such as name, capital, languages, currencies, timezones, population, borders, region, subregion, and more.

The API saves the retrieved data in a local H2 database, and then provides it to users, ensuring faster access to information if the data has been previously fetched and stored.

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
