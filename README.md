# Videojuegos API (Spring Boot) - Previa

Proyecto ejemplo para la entrega del curso: CRUD de Videojuegos usando Spring Boot y almacenamiento en memoria.

## Estructura
- `src/main/java/com/proyecto/videojuegos` - código fuente Java
- `src/main/resources/application.properties` - propiedades
- `frontend/index.html` - UI estática (abrir en el navegador)
- `pom.xml` - Maven

## Requisitos
- Java 17+
- Maven

## Ejecutar
1. Compilar y ejecutar:
   ```
   mvn spring-boot:run
   ```
2. Abrir la UI:
   - Opción A: abrir `frontend/index.html` con doble clic (archivo local)
   - Opción B (recomendado para evitar restricciones): servir con `python -m http.server 5500` desde la carpeta `frontend` y abrir `http://localhost:5500`

La API corre en `http://localhost:9000/api/games`

## Ramas Git (crear sin comillas)
```
git checkout -b develop
git checkout -b test
git checkout -b production
```

## Notas
- El proyecto usa colecciones en memoria (no hay base de datos).
- CORS está habilitado en el controlador para desarrollo (`@CrossOrigin("*")`).
