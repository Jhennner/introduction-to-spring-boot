# Aplicación inicial Spring Boot

Aplicación básica usando Spring Boot y plantillas Thymeleaf.

## Requisitos

Necesitas tener instalado en tu sistema:

- Java 8

## Ejecución

Puedes ejecutar la aplicación usando el _goal_ `run` del _plugin_ Maven 
de Spring Boot:

```
$ ./mvnw spring-boot:run 
```   

También puedes generar un `jar` y ejecutarlo:

```
$ ./mvnw package
$ java -jar target/demoapp-0.0.1-SNAPSHOT.jar 
```

Una vez lanzada la aplicación puedes abrir un navegador y probar los distintos _controllers_:

- [http://localhost:8080](http://localhost:8080)
- [http://localhost:8080/saludo/Pepito](http://localhost:8080/saludo/Pepito)
- [http://localhost:8080/saludoplantilla/Pepito](http://localhost:8080/saludoplantilla/Pepito)
- [http://localhost:8080/saludoform](http://localhost:8080/saludoform)

## Introduction

DemoAPP es una aplicación web creada con 
Spring Boot y Thymeleaf que muestra funciones básicas como la validación 
de números, la comprobación de cuadrados y los cálculos aritméticos. 
Sigue una arquitectura MVC estándar usando controladores Spring, clases de 
servicio y plantillas Thymeleaf.
---

## Functionalities & Endpoints

### 1. Even Number Check (`/numeropar`)

| Method | URL | Description                                |
|--------|-----|--------------------------------------------|
| GET | `/numeropar` | Despliega el formulario                    |
| POST | `/numeropar` | Envia un número y verifica si es par o no. |

**Cómo funciona:**
El usuario introduce un único número entero positivo. El método de servicio `isPar(int numero)` comprueba si el número es divisible por 2 y devuelve un mensaje indicando si es par (*par*) o impar (*impar*).

---

### 2. Square Check (`/numerocuadrado`)

| Method | URL | Description                                                                  |
|--------|-----|------------------------------------------------------------------------------|
| GET | `/numerocuadrado` | Despliega un formulario                                                      |
| POST | `/numerocuadrado` | Envia 2 numero y comprueba que el segundo número es el cuadrado del primero. |

**Cómo funciona:**
El usuario introduce dos números enteros positivos. El método de servicio `isCuadrado(int num1, int num2)` comprueba si `num2 == num1 * num1`.

---

### 3. Calculator (`/calculadora`)

| Method | URL | Description                                                        |
|--------|-----|--------------------------------------------------------------------|
| GET | `/calculadora` | Despliega un formulario                                            |
| POST | `/calculadora` | Envia 2 número y un operador para dar el resultado de la operación |

**Cómo funciona:**
El usuario introduce dos números (con decimales) y selecciona una operación (`+`, `-`, `*`, `/`) en un menú desplegable. El método de servicio `calcular()` realiza la operación y devuelve el resultado como una cadena. La división por cero se gestiona de forma explícita, devolviendo un mensaje de error en lugar de lanzar una excepción.
---

### 4. Palindrome Check (`/palindromo`)

| Method | URL | Description                                    |
|--------|-----|------------------------------------------------|
| GET | `/palindromo` | Despliega un formulario                        |
| POST | `/palindromo` | Envia una palabra y comprueba si es palindroma |

**Cómo funciona:**
El usuario introduce una palabra. El método de servicio `isPalindromo(String palabra)` comprueba si la palabra se lee igual hacia delante y hacia atrás, y devuelve un mensaje descriptivo en forma de cadena con el resultado.

---

## Validation

All models use **Jakarta Bean Validation** annotations:

| Annotation | Used in | Purpose |
|---|---|---|
| `@Positive` | `NumeroData`, `CuadradoData` | Asegura que los números sean mayores que 0. |
| `@NotNull` | `CuadradoData`, `CalculadoraData` | Asegura que los campos no estén vacíos. |
| `@Pattern` | `CalculadoraData` | Restringe al operador a `+`, `-`, `*`, `/` |
| `@NotEmpty` | `PalabraData` | Asegura que el campo de texto no esté vacío. |

Los errores de validación se muestran en línea en las plantillas Thymeleaf utilizando `th:errors`.

---

## Repositories

| Resource | URL |
|---|---|
| GitHub | https://github.com/Jhennner/introduction-to-spring-boot/tree/main|
| Docker Hub | https://hub.docker.com/r/jheneralbarado/spring-boot-demoapp |

---

## Cómo ejecutar

```bash
# Clone the repository
git clone https://hub.docker.com/r/jheneralbarado/spring-boot-demoapp

# Navigate to the project folder
cd demo

# Run with Maven
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

---

## Author

Jhener Albarado Mamani

