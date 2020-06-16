# Test Backend Java EE (Type - 01)

##### Descripcion

> Crear una aplicación Java web basada en los estándares Servlet Spec.
La aplicación web debe proveer una API REST para la búsqueda de cajeros automáticos
ubicados en Alemania y retornarlos en formato JSON.
---
Consulta propuesta para la solucion:

> **GET /api/atms** 

### Request Params
| Param Name | Variable Name | Description                              |
|------------|---------------|------------------------------------------|
| street     | street        | Used for filter addresses by street      |
| hnumber    | houseNumber   | Used for filter addresses by house number |
| zipcode    | zipcode       | Used for filter addresses by zipcode/postalcode |
| city       | city          | Used for filter addresses by city name   |
| type       | type          | Used for filter the ATMs by Type         |

| Http Status Code | Meaning        |
|------------------|----------------|
| 200              | OK             |
| 400              | Page Not Found |


## Test/JUnit

A Unit Test was developed for test the same way of the endpoint /GET/api/atms

# Test Angular

> Se ha utilizado Angular en su ultima version (8)


