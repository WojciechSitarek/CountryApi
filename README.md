# Country API

## Opis

Country API to prosty serwis RESTful, który umożliwia pobieranie informacji o krajach na podstawie ich kodu (ISO 3166-1 alpha-3). API integruje się z zewnętrznym serwisem **RestCountries**, który dostarcza szczegółowe dane o krajach, takie jak nazwa, stolica, języki, waluty, strefy czasowe, populacja, granice, region, subregion oraz inne.

API zapisuje pobrane dane w lokalnej bazie danych H2, a następnie udostępnia je użytkownikom, zapewniając szybszy dostęp do informacji, jeżeli dane zostały wcześniej pobrane i zapisane.

## Funkcjonalności

- Pobieranie danych o kraju na podstawie jego kodu ISO.
- Zapis danych do lokalnej bazy danych H2.
- Obsługa błędów i wyjątków.
- Możliwość skalowania i dodawania nowych funkcji w przyszłości.

## Endpoints

### GET `/country/{code}`

Pobiera informacje o kraju na podstawie jego kodu (ISO 3166-1 alpha-3).

#### Przykład:

- **URL:** `/country/PL`
- **Metoda:** GET
- **Odpowiedź:**

```json
{
  "commonName": "Polska",
  "officialName": "Rzeczpospolita Polska",
  "currencies": ["PLN"],
  "capital": ["Warszawa"],
  "region": "Europe",
  "subregion": "Eastern Europe",
  "languages": ["pl"],
  "population": 38386000,
  "borders": ["DEU", "CZE", "SVK", "UKR", "BLR", "LTU", "RUS"],
  "timezones": ["CET", "CEST"]
}
