# Measurements CLI

> **TASK OPENED:** 07. 03. 2022 HH:MM

> **TASK FINISHED:** 07. 03. 2022 HH:MM

## Backend Scope
- App stores **Products** (id / name / min allowed temperature / max allowed termperature) in DB;
  **CRUD** operations are available on Products via REST endpoint,
- It enables sending **Measurements** (product / temperature / measurement type) via REST endpoint,
- When recorded, **measurements are marked** as OK (inside allowed temperature range) or NOT OK,
- **Measurements history** for last 10 days is available via REST endpoint.

## Running Backend
- java -jar measurements-0.0.1-SNAPSHOT.jar *or*
- run_backenc.bat

Then check: http://127.0.0.1:8280/api/v1/swagger-ui.html

## Using *MeasCLI*

Try:
```
java si.um.feri.measurements.MeasCLI --help
Usage: MeasCLI [-hV] [COMMAND]
-h, --help      Show this help message and exit.
-V, --version   Print version information and exit.
Commands:
list        Lists Products or Measurements
addproduct  Adds a Products
```

### list command
*MeasCLI list <entities> [-n] [-s SERVER]* 

Example:
```
MeasCLI list products -n
Products:
ID    | PRODUCT NAME                             | TEMPERATURE RANGE
------+------------------------------------------+---------------------------
1     | Milka Classic                            | -5.0 .. 18.0
2     | Chicken Breasts                          | -25.0 .. -8.0
6     | IceCream                                 | -18.0 .. -5.5

Product count: 3
```

### addproduct command
*MeasCLI addproduct <name> <min-temp> <max-temp> [-s SERVER]*


Example:
```
MeasCLI addproduct IceCream -18 -5.5
```

## Your task
- Extends CLI with **Measurement support** (product/temperature/measurement type)
    - **Adding new measurement** and responding, it temperature is within allowed range,
    - Listing **all** measurements,
    - Listing all measurements **out of range**.

     
Examples:
```
MeasCLI measure 1 23.3 ManualMeasurement
Thank you. Measurement accepted. Inside allowed values.

MeasCLI list measurements -n
...(measurements table)


MeasCLI list measurements -n --bad-only
...(measurements that are outside of allowed range)

```
