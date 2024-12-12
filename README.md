# Country API

## Description

Country API is a simple RESTful service that allows fetching information about countries based on their ISO 3166-1 alpha-3 code. The API integrates with the external **RestCountries** service, which provides detailed data about countries, such as name, capital, languages, currencies, timezones, population, borders, region, subregion, and more.

The API saves the retrieved data in a local H2 database, and then provides it to users, ensuring faster access to information if the data has been previously fetched and stored.

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
