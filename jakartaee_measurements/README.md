# Measurements Jakarta EE Web App

## Scope
- App stores **Products** (id / name / min allowed temperature / max allowed termperature) in DB;
  **CRUD** operations are available on Products via REST endpoint,
- It enables inserting **Measurements** (product / temperature / measurement type),
- When recorded, **measurements are marked** as OK (inside allowed temperature range) or NOT OK,
- **Measurements history** for last 10 days is available on the **Web user interface**.

## Running
- build & run *or*
- docker-compose build & docker-compose up

## Usage
- http://127.0.0.1:8080/Measurements/faces/products.xhtml

