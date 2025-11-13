# Quarkus 3 Liquibase Native REST API

Este proyecto es una API REST con Quarkus 3, Java 17, Liquibase y H2 Database.

## Características

- Java 17
- Quarkus 3.11.1
- Liquibase para migraciones de base de datos
- H2 Database en memoria
- API REST completa para gestión de personas (JAX-RS)
- Hibernate ORM con Panache
- Datos de prueba cargados automáticamente
- Soporte para compilación nativa con GraalVM

## Cómo ejecutar

### Requisitos
- Java 17 o superior
- Gradle
- Para compilación nativa: GraalVM 17+ o usar Docker

### Ejecutar la aplicación en modo desarrollo
```bash
./gradlew quarkusDev
```

### Ejecutar la aplicación en modo producción (JVM)
```bash
./gradlew quarkusBuild
java -jar build/quarkus-app/quarkus-run.jar
```

### Compilar ejecutable nativo

**Opción 1: Con GraalVM instalado localmente**
```bash
./gradlew build -Dquarkus.package.type=native
```

O usando el task específico:
```bash
./gradlew buildNative
```

**Opción 2: Usando Docker (recomendado si no tienes GraalVM)**
```bash
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

**Ejecutar el binario nativo:**
```bash
./build/quarkus-native-liquibase-gradle-0.0.1-SNAPSHOT-runner
```

O usando el script:
```bash
./run-native.sh
```

**Nota:** La compilación nativa puede tardar varios minutos y requiere bastante memoria RAM (se recomienda al menos 4GB disponibles).

La aplicación se ejecutará en `http://localhost:8080`

## Endpoints de la API

### Obtener todas las personas
```
GET /api/persons
```

### Obtener una persona por ID
```
GET /api/persons/{id}
```

### Crear una nueva persona
```
POST /api/persons
Content-Type: application/json

{
  "name": "Nuevo Usuario"
}
```

### Actualizar una persona
```
PUT /api/persons/{id}
Content-Type: application/json

{
  "name": "Usuario Actualizado"
}
```

### Eliminar una persona
```
DELETE /api/persons/{id}
```

### Health check
```
GET /api/persons/health
```

## Base de datos

- **H2 Console**: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuario**: `sa`
- **Contraseña**: (vacía)

## Datos de prueba

La aplicación carga automáticamente 10 personas de prueba desde `src/main/resources/import.sql`.

## Ejemplos de uso con curl

### Obtener todas las personas
```bash
curl http://localhost:8080/api/persons
```

### Crear una nueva persona
```bash
curl -X POST http://localhost:8080/api/persons \
  -H "Content-Type: application/json" \
  -d '{"name": "Nuevo Usuario"}'
```

### Obtener una persona específica
```bash
curl http://localhost:8080/api/persons/1
```

### Actualizar una persona
```bash
curl -X PUT http://localhost:8080/api/persons/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "Usuario Modificado"}'
```

### Eliminar una persona
```bash
curl -X DELETE http://localhost:8080/api/persons/1
``` 