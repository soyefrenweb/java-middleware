# Java Spring Boot Middleware API

Middleware construido con **Spring Boot 3** que actúa como capa intermedia para consulta e integración de datos, utilizando **MongoDB Atlas** para persistencia y **Spring Cache** para optimización de respuestas.

## 🛠️ Stack Tecnológico

- **Java 17** / **Spring Boot 3**
- **Spring Data MongoDB** (Persistencia NoSQL en la nube)
- **Spring Cache** (`ConcurrentMapCacheManager`)
- **Maven**

## 🚀 Configuración y Ejecución

### 1. Variable de entorno
El proyecto requiere la cadena de conexión a MongoDB Atlas configurada en la variable `SPRING_DATA_MONGODB_URI`.

En **PowerShell**:
```powershell
$env:SPRING_DATA_MONGODB_URI="mongodb+srv://<usuario>:<password>@cluster0.ytffuyi.mongodb.net/middleware_db?retryWrites=true&w=majority"