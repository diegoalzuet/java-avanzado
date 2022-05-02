# Repositorio Curso Java Avanzado CoderHouse


## Proyecto Final Java Avanzado

API de atención médica.
Se uso para su desarrollo:
- Eclipse
- MySQL
- JDK1.8
- Spring Security
- Swagger UI
- Sonarqube

## Links
- [Proyecto Final](https://github.com/diegoalzuet/java-avanzado/tree/main/Proyecto%20Final%20-%20Api%20Atencion%20Medica)
- [Swagger](http://localhost:8080/swagger-ui/index.html#/). (con la app corriendo)
- [Colecciones de Postman](https://github.com/diegoalzuet/java-avanzado/tree/main/Proyecto%20Final%20-%20Api%20Atencion%20Medica/Collection-Postman)
- [Capturas Sonarqube](https://github.com/diegoalzuet/java-avanzado/tree/main/Proyecto%20Final%20-%20Api%20Atencion%20Medica/Sonarqube)

## Detalle
La API cuenta con 3 niveles de autorización (de mayor a menor):  
- **ROLE_DOCTOR**
- **ROLE_NURSE**
- **ROLE_USER**

Para autenticarse las credenciales son:
- user: **doctor** pass: **1234**
- user: **nurse** pass: **1234**
- user. **user** pass:**1234**

Cada usuario cuenta con el nivel de autorización de su rol homónimo. 
