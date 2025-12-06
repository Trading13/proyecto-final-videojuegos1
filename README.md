# 🎮 Videojuegos API - CRUD REST (Spring Boot)

API REST para la gestión de videojuegos, desarrollada como práctica académica de **Servicios Web** utilizando **Java 17** y **Spring Boot 3**. El proyecto sigue buenas prácticas de desarrollo empresarial, arquitectura REST y control de calidad mediante pruebas unitarias.

---

## 👨‍💻 Autores

**Juan David Cartagena**
**Scarleth julieth covos**
Proyecto desarrollado con fines educativos y de aprendizaje.

---

## 🚀 Tecnologías Utilizadas

| Tecnología         | Uso                        |
| ------------------ | -------------------------- |
| Java 17            | Lenguaje principal         |
| Spring Boot 3      | Framework backend          |
| Spring Web         | Construcción de API REST   |
| Jakarta Validation | Validaciones de DTO        |
| Maven              | Gestión de dependencias    |
| JUnit 5            | Pruebas unitarias          |
| Mockito            | Simulación de dependencias |
| MockMvc            | Pruebas de controladores   |
| Git                | Control de versiones       |

---

## 📦 Instalación y Ejecución

### 📌 Requisitos previos

* Java 17 instalado
* Maven 3 instalado
* Git instalado

### ▶️ Ejecutar el proyecto

```bash
mvn spring-boot:run
```

El servidor se iniciará en:

```
http://localhost:8080/
```

---

## 🧠 Endpoints de la API

| Método | Endpoint        | Descripción              |
| ------ | --------------- | ------------------------ |
| POST   | /api/games      | Crear videojuego         |
| GET    | /api/games      | Listar videojuegos       |
| GET    | /api/games/{id} | Buscar videojuego por ID |
| PUT    | /api/games/{id} | Actualizar videojuego    |
| DELETE | /api/games/{id} | Eliminar videojuego      |

---

## 📌 Ejemplo de solicitud (POST)

```json
{
  "title": "Minecraft",
  "genre": "Sandbox",
  "platform": "PC",
  "releaseDate": "2011-11-18",
  "price": 29.99,
  "developer": "Mojang"
}
```

---

## 🔐 Validaciones Implementadas

| Campo                             | Validación            |
| --------------------------------- | --------------------- |
| title, genre, platform, developer | No vacío (@NotBlank)  |
| price                             | Mayor a 0 (@Positive) |
| releaseDate                       | No nulo (@NotNull)    |

### ❌ Respuesta ante datos inválidos

```json
{
  "title": "Title cannot be empty",
  "price": "Price must be greater than 0"
}
```

---

## ⚠️ Manejo Global de Errores

La API implementa un manejador global de excepciones para responder de forma clara y controlada ante errores.

### ❌ Ejemplo: ID inexistente

```json
{
  "error": "Game with ID 99 not found"
}
```

---

## 🧪 Pruebas Unitarias

El proyecto incluye pruebas para:

* Servicios (**GameServiceImplTest**)
* Controladores con **MockMvc** (**GameControllerTest**)
* Validaciones y excepciones

### ▶️ Ejecutar pruebas

```bash
mvn test
```

---

## 🌿 Flujo de Ramas (Git)

Se utiliza un flujo profesional de **tres ramas**:

```
development → test → production
```

| Rama        | Descripción                   |
| ----------- | ----------------------------- |
| development | Desarrollo de funcionalidades |
| test        | Pruebas y validaciones        |
| production  | Versión final del proyecto    |

---

## 🎉 Estado del Proyecto

✅ **Finalizado y completamente funcional**

---

## 🌐 Interfaz de Usuario (HTML)

Además del backend en Spring Boot, el proyecto incluye una **interfaz web sencilla en HTML** que permite interactuar con la API REST directamente desde el navegador.

### 📂 Ubicación

El archivo principal se encuentra en:

```
/index.html
```

### ▶️ Ejecutar la interfaz

Puedes abrirla usando **Live Server** o con Python:

```bash
python -m http.server 5500
```

Luego abre en el navegador:

```
http://localhost:5500/
```

### 🔗 Nota importante

La interfaz utiliza **fetch()** para comunicarse con la API REST. Asegúrate de que el backend esté ejecutándose en:

```
http://localhost:9000/
```
