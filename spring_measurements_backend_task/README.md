# Measurements backend

> **TASK OPENED:** 07. 03. 2022 HH:MM

> **TASK FINISHED:** 07. 03. 2022 HH:MM

## Scope
- App stores **Products** (id / name / min allowed temperature / max allowed termperature) in DB;
  **CRUD** operations are available on Products via REST endpoint,
- It enables sending **Measurements** (product / temperature / measurement type) via REST endpoint,
- When recorded, **measurements are marked** as OK (inside allowed temperature range) or NOT OK,
- **Measurements history** for last 10 days is available via REST endpoint. 
	
## Running
- build & run *or*
- docker-compose build & docker-compose up

## Usage
- http://127.0.0.1:8280/api/v1/swagger-ui.html
- http://127.0.0.1:8280/api/v1/v3/api-docs


- http://127.0.0.1:8280/api/v1/products
- http://127.0.0.1:8280/api/v1/products/1
- http://127.0.0.1:8280/api/v1/history
- http://127.0.0.1:8280/api/v1/product_measurement

## Your task
- Extends backed with **Locations** (id / location name / location type - STORE;OPEN_SPACE;WAREHOUSE)
  - Link **Products with Locations** (Location as an attribute in Product)
  - Enable **Locations support** in Products REST endpoint (when creating/retreiving Products)
  - Enable **Locations Post and Get** (all/by id) operations in REST endpoint,
- Create new get-only endpoint: **/bad_locations** that will output locations with percentages of "not ok" measurements
e.g.:
```
[
    {
        "id":1,
        "name":"Local warehouse",
        "badMeasurements":0.82
    },
    {
        "id":5,
        "name":"Supermarket",
        "badMeasurements":0.01
    }
]
```