# Demo API — Spring Boot + MySQL + Docker

API REST minimalista con 2 endpoints para registrar y consultar productos. Desplegable en AWS EC2 con Docker Compose.

## Tecnologias

- Java 21 (Amazon Corretto)
- Spring Boot 4.0.5
- Spring Data JPA
- MySQL 8.0
- Docker + Docker Compose

## Estructura del Proyecto

```
demo-api/
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── src/main/java/cl/duoc/demo/
    ├── DemoApiApplication.java
    ├── model/
    │   └── Producto.java
    ├── repository/
    │   └── ProductoRepository.java
    └── controller/
        └── ProductoController.java
```

## Endpoints

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| `POST` | `/api/productos` | Registrar un producto |
| `GET` | `/api/productos` | Listar todos los productos |

### Body del POST (JSON)

```json
{
  "nombre": "Laptop",
  "precio": 599990
}
```

## Despliegue con Docker Compose

### Requisitos en el servidor

- Docker Engine
- Docker Compose v2
- Docker Buildx >= 0.17

### Pasos

```bash
# Clonar el repositorio
git clone https://github.com/Fr4nk13d3vs/demo-api.git
cd demo-api

# Levantar los contenedores
docker compose up -d --build

# Verificar que esten corriendo
docker compose ps
```

Esto levanta 2 contenedores:

| Contenedor | Puerto | Servicio |
|------------|--------|----------|
| demo-mysql | 3306 | MySQL 8.0 |
| demo-api | 8080 | API REST |

## Probar la API

```bash
# Registrar un producto
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Laptop","precio":599990}'

# Listar productos
curl http://localhost:8080/api/productos
```

Desde el navegador: `http://IP_SERVIDOR:8080/api/productos`

## Comandos utiles

```bash
docker compose logs api --tail 50    # Ver logs
docker compose restart               # Reiniciar
docker compose down                  # Detener
docker compose up -d --build         # Reconstruir
```
