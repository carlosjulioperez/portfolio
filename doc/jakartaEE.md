
- [Java EE \& Quarkus Fundamentals](#java-ee--quarkus-fundamentals)
  - [Diferencia de Jaharta EE con Spring Boot](#diferencia-de-jaharta-ee-con-spring-boot)
    - [1. **Enfoque de desarrollo:**](#1-enfoque-de-desarrollo)
    - [2. **Configuración:**](#2-configuración)
    - [3. **Dependencias y modularidad:**](#3-dependencias-y-modularidad)
    - [4. **Arquitectura y patrones:**](#4-arquitectura-y-patrones)
    - [5. **Desempeño y tamaño:**](#5-desempeño-y-tamaño)
    - [6. **Comunidad y ecosistema:**](#6-comunidad-y-ecosistema)
    - [7. **Soporte para Microservicios:**](#7-soporte-para-microservicios)
    - [Resumen:](#resumen)
  - [JPA/Hibernate ORM](#jpahibernate-orm)
    - [Ejemplo:](#ejemplo)
  - [@Path](#path)
    - [Ejemplo:](#ejemplo-1)
  - [@ApplicationScoped](#applicationscoped)
    - [Ejemplo:](#ejemplo-2)
  - [Panache en Quarkus](#panache-en-quarkus)
    - [Ejemplo básico](#ejemplo-básico)
    - [Operaciones con Panache](#operaciones-con-panache)
    - [Resumen](#resumen-1)
  - [Quarkus y GraalVM native image](#quarkus-y-graalvm-native-image)
  - [application.properties](#applicationproperties)
    - [Ejemplo:](#ejemplo-3)
  - [@Inject](#inject)
    - [Explicación detallada:](#explicación-detallada)
    - [Ventajas de `@Inject`:](#ventajas-de-inject)
  - [@Path / @GET](#path--get)
    - [Ejemplo:](#ejemplo-4)
  - [Quarkus DevMode](#quarkus-devmode)
  - [MicroProfile Config](#microprofile-config)
    - [Ejemplo:](#ejemplo-5)
  - [JPA @Entity](#jpa-entity)
    - [Ejemplo:](#ejemplo-6)
  - [Quarkus build-time bootstrapping](#quarkus-build-time-bootstrapping)
    - [Ejemplo:](#ejemplo-7)
  - [@PathParam](#pathparam)
    - [Ejemplo:](#ejemplo-8)
  - [@Produces](#produces)
  - [Undertow / Vert.x](#undertow--vertx)
    - [Ejemplo:](#ejemplo-9)
- [Cloud Native \& DevOps](#cloud-native--devops)
  - [Container registry](#container-registry)
    - [Ejemplo:](#ejemplo-10)
  - [Docker's ENTRYPOINT](#dockers-entrypoint)
  - [12-Factor App](#12-factor-app)
  - [IaC](#iac)
  - [Kubernetes readiness probe](#kubernetes-readiness-probe)
    - [Ejemplo:](#ejemplo-11)
  - [Idempotency in REST](#idempotency-in-rest)
    - [Ejemplo:](#ejemplo-12)
  - [docker ps](#docker-ps)
    - [Ejemplo:](#ejemplo-13)
    - [NodePort](#nodeport)
    - [Ejemplo:](#ejemplo-14)
  - [What is a pod in Kubernetes?](#what-is-a-pod-in-kubernetes)
    - [Ejemplo:](#ejemplo-15)
  - [Immutable infrastructure](#immutable-infrastructure)
  - [Horizontal Pod Autoscaler](#horizontal-pod-autoscaler)
  - [OpenAPI/Swagger](#openapiswagger)
  - [Service mesh](#service-mesh)
  - [What is a Secret in Kubernetes](#what-is-a-secret-in-kubernetes)
    - [Ejemplo:](#ejemplo-16)
  - [“Shift-left testing”](#shift-left-testing)
- [Security, Quality \& Monitoring](#security-quality--monitoring)
  - [SQL Injection](#sql-injection)
    - [Ejemplo:](#ejemplo-17)
    - [Sentencia preparada:](#sentencia-preparada)
  - [What is a JWT](#what-is-a-jwt)
    - [Ejemplo:](#ejemplo-18)
    - [Ejemplo de JWT:](#ejemplo-de-jwt)
  - [OAuth2](#oauth2)
  - [XSS](#xss)
    - [Solución:](#solución)
  - [CSRF](#csrf)
  - [SonarQube](#sonarqube)
    - [Ejemplo:](#ejemplo-19)
  - [WAF](#waf)
  - [Rate limiting](#rate-limiting)
  - [Structured Logs](#structured-logs)
    - [Ejemplo:](#ejemplo-20)
  - [SLF4J](#slf4j)
    - [Ejemplo:](#ejemplo-21)
  - [Circuit Breaker](#circuit-breaker)
    - [Ejemplo:](#ejemplo-22)
  - [Secret Manager](#secret-manager)
  - [Observability](#observability)
  - [SAST](#sast)
  - [CORS](#cors)
- [Frontend, Database \& Version Control](#frontend-database--version-control)
  - [Primary key](#primary-key)
  - [LEFT JOIN](#left-join)
  - [git rebase](#git-rebase)
    - [Ejemplo:](#ejemplo-23)
  - [git stash](#git-stash)
  - [ACID](#acid)
    - [Ejemplo:](#ejemplo-24)
  - [Index in SQL](#index-in-sql)
    - [Ejemplo:](#ejemplo-25)
    - [En resumen:](#en-resumen)
  - [ORM](#orm)
    - [Ejemplo:](#ejemplo-26)
  - [git cherry-pick](#git-cherry-pick)
    - [Ejemplo:](#ejemplo-27)
  - [Migration tool](#migration-tool)
  - [PWA](#pwa)
  - [Redis](#redis)
    - [Ejemplo:](#ejemplo-28)
    - [Resultado:](#resultado)
  - [Optimistic locking](#optimistic-locking)
    - [Ejemplo:](#ejemplo-29)
  - [GraphQL](#graphql)
  - [Data normalization](#data-normalization)
    - [Ejemplo:](#ejemplo-30)
  - [git merge](#git-merge)

# Java EE & Quarkus Fundamentals

## Diferencia de Jaharta EE con Spring Boot
La diferencia entre una aplicación **Jakarta EE** (anteriormente conocida como **Java EE**) y una aplicación basada en **Spring Boot** radica principalmente en el enfoque, las herramientas y las filosofías de desarrollo que utilizan. Aquí te dejo algunas diferencias clave:

### 1. **Enfoque de desarrollo:**

* **Jakarta EE:**

  * **Especificación estándar** de Java para el desarrollo de aplicaciones empresariales.
  * Utiliza tecnologías como **EJB (Enterprise Java Beans)**, **JPA (Java Persistence API)**, **JAX-RS (Java API for RESTful Web Services)**, **JSF (JavaServer Faces)**, **JMS (Java Message Service)**, entre otras.
  * Más **estricto** en cuanto a configuración y arquitectura.
  * El desarrollo suele centrarse en cumplir con los estándares definidos por la especificación, lo que garantiza la portabilidad entre diferentes servidores de aplicaciones (como **WildFly**, **Payara**, **GlassFish**).

* **Spring Boot:**

  * Parte del ecosistema **Spring**, que tiene un enfoque más moderno y flexible.
  * **Configuración automática** (auto-configuration) y **convención sobre configuración**, lo que permite que los desarrolladores puedan iniciar proyectos rápidamente con una mínima configuración.
  * Más **simplificado** y **moderno**. Ideal para microservicios, aplicaciones web, y backend en general.
  * **Spring Boot** proporciona una gran variedad de bibliotecas integradas que permiten crear rápidamente aplicaciones con bases de datos, servicios web, seguridad, etc.

### 2. **Configuración:**

* **Jakarta EE:**

  * Requiere una configuración más detallada, sobre todo cuando se utiliza un servidor de aplicaciones como WildFly o Payara.
  * Los desarrolladores deben encargarse de **configurar** muchas partes del ciclo de vida de la aplicación.
  * Para simplificar, algunos servidores de Jakarta EE incluyen configuraciones por defecto, pero es común tener que lidiar con descripciones de despliegue, como archivos XML (`web.xml`, `ejb-jar.xml`, etc.).

* **Spring Boot:**

  * **Configuración automática**, donde Spring se encarga de hacer gran parte del trabajo por ti. El desarrollo es mucho más fluido y rápido.
  * Uso de **propiedades** y **anotaciones** para configurar automáticamente la infraestructura (bases de datos, servidores web, seguridad, etc.), evitando la necesidad de archivos XML complejos.
  * No requiere un servidor de aplicaciones independiente, ya que **Spring Boot** incluye un servidor embebido (como **Tomcat**, **Jetty** o **Undertow**).

### 3. **Dependencias y modularidad:**

* **Jakarta EE:**

  * Dependencias muy estructuradas, ya que está basado en un conjunto de APIs estándar.
  * Exige que los componentes sean modulares y que se utilicen en un contenedor de aplicaciones (por ejemplo, WildFly, Payara).
  * Los desarrolladores deben seleccionar y configurar las APIs que necesitan manualmente.

* **Spring Boot:**

  * Gran **flexibilidad** en cuanto a dependencias, ya que Spring Boot se integra con una gran cantidad de bibliotecas de terceros (Spring Security, Spring Data, Spring Cloud, etc.).
  * **Spring Boot Starter POMs** proporcionan una manera fácil de añadir dependencias preconfiguradas para servicios comunes.
  * No es necesario un contenedor de aplicaciones, ya que Spring Boot empaqueta todo como un **JAR** ejecutable con un servidor embebido.

### 4. **Arquitectura y patrones:**

* **Jakarta EE:**

  * Tradicionalmente más **monolítica** y centrada en la arquitectura **en capas** (por ejemplo, presentación, lógica de negocio y persistencia).
  * Es común usar **EJBs** y otros patrones empresariales tradicionales.
* **Spring Boot:**

  * Tiende a enfocarse más en una arquitectura **desacoplada**, usando patrones como **microservicios** y **servicios independientes**.
  * Su integración con **Spring Cloud** facilita la creación de sistemas distribuidos y escalables.

### 5. **Desempeño y tamaño:**

* **Jakarta EE:**

  * Las aplicaciones Jakarta EE suelen ser más **pesadas**, ya que requieren un servidor de aplicaciones completo para ejecutarse, que incluye muchos servicios internos.
  * Esto puede hacer que el arranque y la ejecución de la aplicación sean más lentos.

* **Spring Boot:**

  * Spring Boot tiende a ser más **ligero** en cuanto a la ejecución, ya que incluye un servidor embebido y no depende de un servidor de aplicaciones externo.
  * El tiempo de arranque es más rápido, y las aplicaciones pueden ejecutarse de manera más eficiente.

### 6. **Comunidad y ecosistema:**

* **Jakarta EE:**

  * Al ser una **especificación estándar**, tiene una comunidad más grande en entornos empresariales tradicionales.
  * Aunque Jakarta EE tiene un fuerte soporte en la industria, especialmente en empresas grandes, su adopción ha sido más lenta para arquitecturas modernas como microservicios.

* **Spring Boot:**

  * **Spring** tiene una comunidad muy activa y está muy de moda en startups, empresas tecnológicas y en general en aplicaciones de microservicios.
  * Existen muchas más herramientas y bibliotecas integradas en Spring, y su soporte para **cloud-native** y **microservicios** es una gran ventaja.

### 7. **Soporte para Microservicios:**

* **Jakarta EE:**

  * Aunque se puede usar Jakarta EE para construir microservicios, su arquitectura tradicional está más orientada a aplicaciones monolíticas. No tiene tantas herramientas nativas para microservicios como Spring Boot.
* **Spring Boot:**

  * **Spring Boot** se ha optimizado para trabajar con **microservicios**, proporcionando fácil integración con **Spring Cloud**, que ofrece soluciones para configuración distribuida, descubrimiento de servicios, balanceo de carga, etc.

### Resumen:

* **Jakarta EE** es una opción más **tradicional y estándar**, que funciona bien en aplicaciones empresariales grandes y monolíticas, o donde se requiere una alta conformidad con estándares.
* **Spring Boot** es más **moderno, ágil y flexible**, adecuado para aplicaciones que requieren rapidez en el desarrollo, facilidad en la configuración, y un enfoque basado en microservicios o aplicaciones distribuidas.

Ambos enfoques son poderosos, pero **Spring Boot** tiende a ser más popular hoy en día por su facilidad de uso y la forma en que aborda aplicaciones modernas.

## JPA/Hibernate ORM
```
Q1. Which Quarkus extension enables JPA/Hibernate ORM?
Answer: quarkus-hibernate-orm
Explanation: This extension provides ORM capabilities and integrates Hibernate.
```

La extensión **quarkus-hibernate-orm** habilita las capacidades de JPA/Hibernate ORM en Quarkus. Hibernate ORM es una herramienta que permite mapear las clases de Java a tablas de bases de datos y manejar la persistencia de datos.

### Ejemplo:

Supongamos que tienes una entidad llamada **Producto** que quieres persistir en una base de datos. Primero, necesitarías agregar la extensión en tu proyecto Quarkus:

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm</artifactId>
</dependency>
```

Luego, defines la clase de entidad utilizando JPA y Hibernate:

```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {

    @Id
    private Long id;
    private String nombre;
    private double precio;

    // Getters y setters
}
```

Con la extensión **quarkus-hibernate-orm** en el proyecto, Quarkus automáticamente gestiona la conexión a la base de datos y la persistencia de objetos **Producto** mediante Hibernate. Esto te permite realizar operaciones como **guardar**, **actualizar** o **consultar** los objetos de manera sencilla.

## @Path
```
Q2. What annotation exposes a REST endpoint in JAX-RS?
Answer: @Path
Explanation: Marks the base URI of the REST resource.
```
La anotación que expone un endpoint REST en JAX-RS es **`@Path`**. Esta anotación se utiliza para definir la ruta de un recurso dentro de la API REST. Se coloca en una clase o método para especificar la URL base donde el servicio estará disponible.

### Ejemplo:

```java
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/productos")  // Define la ruta base para este recurso
public class ProductoResource {

    @GET
    public String obtenerProductos() {
        return "Lista de productos";
    }
}
```

En este ejemplo:

* La anotación `@Path("/productos")` indica que el recurso `ProductoResource` estará disponible en la URL base `/productos`.
* El método `obtenerProductos()` es un endpoint que responde a solicitudes HTTP GET.

## @ApplicationScoped 
```
Q3. What does @ApplicationScoped mean in CDI?
Answer: One shared instance for the entire application lifecycle.
Explanation: Similar to Singleton but follows CDI lifecycle rules.
```

En Contexts and Dependency Injection (CDI), la anotación `@ApplicationScoped` se utiliza para declarar un bean cuya instancia será compartida a lo largo de todo el ciclo de vida de la aplicación. Esto significa que solo existirá una instancia de ese bean en toda la aplicación, similar a `@Singleton`, pero siguiendo las reglas de CDI para el ciclo de vida.

### Ejemplo:

```java
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConfigService {
    private String configValue;

    public ConfigService() {
        this.configValue = "Valor de configuración global";
    }

    public String getConfigValue() {
        return configValue;
    }
}
```

En este ejemplo, `ConfigService` es un bean marcado con `@ApplicationScoped`. Esto significa que **solo habrá una única instancia de `ConfigService` en toda la aplicación**, y esa misma instancia será compartida por cualquier componente que lo inyecte a lo largo del ciclo de vida de la aplicación.

Por ejemplo, si tienes varios componentes que inyectan `ConfigService`, todos compartirán la misma instancia y, por lo tanto, cualquier cambio en su estado afectará a todos esos componentes.


## Panache en Quarkus
```
Q4. What is the purpose of Panache in Quarkus?
Answer: Simplifies JPA by offering an active-record style API.
Explanation: Panache reduces boilerplate (CRUD, queries).
```

**Panache** es una biblioteca de Quarkus que simplifica el trabajo con bases de datos en aplicaciones Java, eliminando la necesidad de escribir mucho código repetitivo. Te permite trabajar de forma más sencilla con entidades (tablas de la base de datos) y realizar operaciones como consultar, insertar, actualizar y borrar registros sin tener que usar directamente las clases de JPA (Java Persistence API).

En lugar de escribir código detallado para manejar las consultas SQL y las operaciones sobre la base de datos, Panache proporciona una API más concisa y fácil de usar. Esto hace que el desarrollo sea más rápido y menos propenso a errores.

### Ejemplo básico

Supón que tienes una base de datos con una tabla `Libro` que contiene información sobre libros. La clase entidad podría verse así:

```java
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Libro extends PanacheEntity {
    public String titulo;
    public String autor;
    public int anioPublicacion;
}
```

En este caso, `PanacheEntity` extiende `javax.persistence.Entity`, lo que significa que `Libro` es una entidad de JPA (correspondiente a una tabla en la base de datos).

### Operaciones con Panache

Con Panache, puedes realizar operaciones comunes de base de datos de manera mucho más sencilla. Por ejemplo:

* **Guardar un libro**:

```java
Libro libro = new Libro();
libro.titulo = "El Quijote";
libro.autor = "Miguel de Cervantes";
libro.anioPublicacion = 1605;
libro.persist();
```

* **Buscar un libro por título**:

```java
Libro libro = Libro.find("titulo", "El Quijote").firstResult();
```

* **Listar todos los libros**:

```java
List<Libro> libros = Libro.listAll();
```

* **Actualizar un libro**:

```java
Libro libro = Libro.find("titulo", "El Quijote").firstResult();
libro.anioPublicacion = 1615;
libro.persist();
```

* **Eliminar un libro**:

```java
Libro libro = Libro.find("titulo", "El Quijote").firstResult();
libro.delete();
```

### Resumen

* **Panache** elimina la necesidad de escribir muchas consultas SQL o código repetitivo.
* Se utiliza con **JPA**, pero con una API mucho más fácil de usar.
* Puedes realizar operaciones de base de datos de manera rápida, como insertar, actualizar, borrar y consultar entidades.

Esencialmente, Panache simplifica el trabajo con la base de datos, manteniendo el código más limpio y fácil de entender.

## Quarkus y GraalVM native image
```
Q5. Quarkus is optimized primarily for which runtime?
Answer: GraalVM native image.
Explanation: Build-time processing makes it extremely fast with low memory.
```
La respuesta se refiere a la optimización de **Quarkus**, un framework de desarrollo para aplicaciones Java. Quarkus está diseñado principalmente para funcionar de manera más eficiente con **GraalVM native image**. Vamos a desglosarlo:

1. **GraalVM native image**:

   * **GraalVM** es una máquina virtual de alto rendimiento que soporta múltiples lenguajes de programación. Permite compilar aplicaciones Java, Kotlin, Scala y otros lenguajes directamente en código nativo (binarios ejecutables).
   * Un **native image** es una versión precompilada de una aplicación Java. Esto significa que la aplicación ya no se ejecuta sobre la JVM (Java Virtual Machine) tradicional, sino directamente sobre el sistema operativo, lo cual ofrece ventajas significativas en cuanto a rendimiento y uso de memoria.

2. **Optimización de Quarkus para GraalVM**:

   * **Quarkus** es un framework diseñado para ser extremadamente rápido y eficiente, especialmente en entornos como **microservicios** o **funciones serverless**. Una de sus características destacadas es que está optimizado para aprovechar las capacidades de **GraalVM native image**, lo cual le permite generar aplicaciones que inician más rápido y consumen menos memoria.
   * Esto se debe a que **Quarkus** usa un enfoque de **procesamiento en tiempo de construcción** (build-time). En lugar de hacer la mayor parte del trabajo durante la ejecución (que es lo que hace una JVM tradicional), Quarkus realiza muchas optimizaciones mientras construye la aplicación, lo que reduce el tamaño de la aplicación y mejora la velocidad de inicio y el consumo de memoria.

3. **Ventajas**:

   * **Velocidad**: Las aplicaciones compiladas como imágenes nativas con GraalVM arrancan mucho más rápido que las aplicaciones Java tradicionales, que requieren iniciar la JVM.
   * **Uso eficiente de memoria**: Al ser precompilada, la aplicación nativa tiene un menor tamaño en memoria y un consumo más eficiente de recursos en comparación con la ejecución bajo la JVM.

En resumen, Quarkus está diseñado para aprovechar GraalVM native image y sus características de compilación anticipada, lo que mejora el rendimiento y la eficiencia, especialmente en entornos donde la rapidez en el inicio y el bajo consumo de memoria son cruciales.

## application.properties
```
Q6. What file defines configuration in Quarkus?
Answer: application.properties
Explanation: Core config file for Quarkus runtime.
```
En Quarkus, el archivo que define la configuración es **`application.properties`**.

### Ejemplo:

Supongamos que quieres configurar el puerto en el que se ejecuta tu aplicación. En el archivo **`application.properties`** puedes agregar la siguiente línea:

```properties
quarkus.http.port=8081
```

Esto cambiaría el puerto por defecto (que es el 8080) a 8081. Quarkus lee este archivo durante el arranque de la aplicación y ajusta la configuración en función de las propiedades definidas allí.

Este archivo es clave porque centraliza y simplifica la configuración de la aplicación, permitiendo personalizar comportamientos como puertos, bases de datos, o incluso el perfil de ejecución (desarrollo, producción, etc.).

## @Inject
```
Q7. What does @Inject do?
Answer: Performs dependency injection using CDI.
Explanation: Replaces manual object creation.
```

El símbolo `@Inject` se utiliza en el contexto de *Dependency Injection* (DI) dentro de la especificación de **Contextos y Dependencias Inyectadas** (CDI, por sus siglas en inglés) en Java. Lo que hace es *automáticamente* inyectar dependencias en los objetos, en lugar de que tú tengas que crear esas dependencias manualmente.

### Explicación detallada:

1. **Dependency Injection (DI)**: Es un patrón de diseño que permite que un objeto reciba (o sea "inyectado") sus dependencias de manera externa, en lugar de crearlas dentro de su propio código. Esto facilita la prueba, mantenimiento y reutilización del código.

2. **¿Cómo funciona `@Inject`?**

   * Si tienes una clase que depende de otra (por ejemplo, un servicio que usa otro servicio), puedes usar `@Inject` para marcar las dependencias en lugar de crear instancias de esos objetos manualmente.
   * CDI se encarga de instanciar y gestionar las dependencias automáticamente en el momento adecuado.

3. **Ejemplo básico:**

   Imagina que tienes dos clases:

   ```java
   public class ServicioA {
       // Algunas funcionalidades
   }

   public class ServicioB {
       @Inject
       private ServicioA servicioA;
       
       public void hacerAlgo() {
           servicioA.algunaFuncion();
       }
   }
   ```

   En este caso, `ServicioB` depende de `ServicioA`. Al usar `@Inject`, el contenedor CDI se encarga de crear una instancia de `ServicioA` y asignarla a la variable `servicioA` dentro de `ServicioB` automáticamente, cuando se cree una instancia de `ServicioB`.

### Ventajas de `@Inject`:

* **Simplicidad**: No tienes que preocuparte por la creación de las dependencias de forma manual.
* **Flexibilidad**: El contenedor CDI puede cambiar la implementación de las dependencias sin que tú tengas que modificar el código de las clases que las usan.
* **Pruebas**: Facilita la creación de pruebas unitarias, ya que puedes inyectar mocks u objetos simulados.

En resumen, `@Inject` reemplaza la creación manual de objetos, permitiendo que el contenedor CDI se encargue de la gestión de dependencias.

## @Path / @GET
```
Q8. Which annotation maps HTTP GET in JAX-RS?
Answer: @GET
Explanation: Used inside a @Path class.
```

En JAX-RS (Java API for RESTful Web Services), la anotación `@GET` se utiliza para mapear las solicitudes HTTP de tipo GET a un método en una clase que está anotada con `@Path`, que indica la URL base del recurso.

### Ejemplo:

```java
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/saludo")
public class SaludoResource {

    @GET
    public String obtenerSaludo() {
        return "¡Hola, Mundo!";
    }
}
```

En este ejemplo:

* `@Path("/saludo")` define que la clase `SaludoResource` responderá a las solicitudes que vayan a la URL `/saludo`.
* `@GET` en el método `obtenerSaludo` indica que este método debe ser invocado cuando se realice una solicitud HTTP GET a la URL `/saludo`.

Así que, si se hace una solicitud GET a `http://localhost:8080/saludo`, el servidor responderá con "¡Hola, Mundo!".

## Quarkus DevMode
```
Q9. What does Quarkus DevMode provide?
Answer: Live reload and fast feedback during development.
Explanation: mvn quarkus:dev enables hot reload.
```

Quarkus DevMode proporciona **recarga en vivo** y **retroalimentación rápida** durante el desarrollo de aplicaciones. Esto significa que puedes realizar cambios en el código y ver los resultados de inmediato sin tener que reiniciar manualmente la aplicación.

**Ejemplo:**

Supongamos que estás desarrollando una aplicación RESTful con Quarkus. Si usas el comando `mvn quarkus:dev` para iniciar la aplicación en modo de desarrollo, cualquier cambio que realices en el código (como modificar una clase o un endpoint) se reflejará automáticamente en la aplicación sin tener que detenerla y reiniciarla. Así puedes probar rápidamente los cambios y ajustar tu código de forma ágil.

Por ejemplo, si modificas un endpoint para cambiar el mensaje de respuesta, solo necesitas guardar el archivo y la aplicación lo actualizará automáticamente sin tener que reiniciar el servidor. Esto acelera mucho el proceso de desarrollo.

## MicroProfile Config
```
Q10. What is MicroProfile Config used for?
Answer: Reading typed configuration values at runtime.
Explanation: Quarkus builds on this specification.
```

**MicroProfile Config** es una especificación de MicroProfile que permite leer valores de configuración tipados en tiempo de ejecución. En otras palabras, te permite acceder a valores de configuración (como parámetros de bases de datos, URLs, claves API, etc.) desde tu aplicación sin tener que codificarlos directamente.

### Ejemplo:

Supón que tienes una aplicación Quarkus que necesita conectarse a una base de datos. En lugar de poner la URL de la base de datos directamente en el código, puedes almacenarla en un archivo de configuración, como `application.properties`, y acceder a ella dinámicamente en tu código.

**application.properties:**

```properties
db.url=jdbc:mysql://localhost:3306/mydb
```

**Clase Java usando MicroProfile Config:**

```java
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

public class DatabaseService {

    public void connect() {
        Config config = ConfigProvider.getConfig();
        String dbUrl = config.getValue("db.url", String.class);
        
        // Usar dbUrl para conectar a la base de datos
        System.out.println("Conectando a la base de datos en: " + dbUrl);
    }
}
```

Aquí, `ConfigProvider.getConfig()` obtiene la configuración y `config.getValue("db.url", String.class)` lee el valor de la URL de la base de datos de manera tipada. Esto permite cambiar el valor de la configuración sin modificar el código fuente, y se puede cargar dinámicamente en tiempo de ejecución.

## JPA @Entity
```
Q11. What annotation marks a JPA entity?
Answer: @Entity
Explanation: Indicates a persistent domain class.
```

La anotación `@Entity` en JPA (Java Persistence API) se usa para marcar una clase como una entidad persistente, lo que significa que sus instancias se almacenarán en una base de datos.

### Ejemplo:

```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
    
    @Id
    private Long id;
    private String nombre;
    private int edad;

    // Constructor, getters y setters
}
```

En este ejemplo, la clase `Persona` está marcada con la anotación `@Entity`, indicando que se corresponde con una tabla en la base de datos. Además, el atributo `id` está marcado con `@Id`, lo que indica que es la clave primaria de la tabla.

## Quarkus build-time bootstrapping
```
Q12. What is the primary benefit of Quarkus build-time bootstrapping?
Answer: Faster startup and lower memory usage.
Explanation: Reflection and metadata processed at build time.
```

El principal beneficio de la **compilación en tiempo de construcción** (build-time bootstrapping) de **Quarkus** es la **inicialización más rápida** y un **menor uso de memoria** en comparación con otros marcos de desarrollo. Esto se debe a que la reflexión y el procesamiento de metadatos se realizan durante la construcción de la aplicación (es decir, antes de que se ejecute), en lugar de hacerlo en tiempo de ejecución.

### Ejemplo:

Supongamos que estamos construyendo una API REST con Quarkus. En lugar de que la aplicación tenga que analizar y generar los metadatos necesarios sobre las clases y objetos en el momento de la ejecución (lo que podría llevar tiempo y consumir memoria), Quarkus lo hace durante la **fase de construcción**.

* **En tiempo de construcción**, Quarkus procesa los metadatos de las clases y genera los recursos necesarios.
* **En tiempo de ejecución**, cuando se inicia la aplicación, ya no es necesario hacer este procesamiento, lo que reduce el tiempo de inicio y la carga de la memoria.

Esto resulta en un **arranque más rápido** y en **menos consumo de recursos**, especialmente en aplicaciones basadas en microservicios que requieren un rendimiento eficiente.

## @PathParam
```
Q13. What annotation maps path parameters?
Answer: @PathParam
Explanation: Extracts variables from URI.
```

La anotación `@PathParam` se utiliza en aplicaciones basadas en Java (por ejemplo, con JAX-RS) para extraer valores de parámetros directamente desde la URL de la solicitud HTTP.

### Ejemplo:

Supón que tienes un servicio web que obtiene la información de un usuario a partir de su ID, y la URL para acceder a la información del usuario es algo como:

```
GET /usuarios/{id}
```

En este caso, `{id}` es un parámetro en la ruta (path parameter). Para acceder a este parámetro dentro de tu método, usarías la anotación `@PathParam`.

```java
@Path("/usuarios")
public class UsuarioResource {

    @GET
    @Path("/{id}")
    public String obtenerUsuario(@PathParam("id") String id) {
        // Aquí se extrae el valor de {id} de la URL
        return "Usuario con ID: " + id;
    }
}
```

Si la solicitud HTTP es `GET /usuarios/123`, el valor `123` se extrae de la URL y se pasa al parámetro `id` del método `obtenerUsuario`. El resultado sería:

```
Usuario con ID: 123
```

En resumen, `@PathParam` mapea el valor del parámetro en la ruta a una variable del método.

## @Produces
```
Q14. What is the correct annotation for creating a producer in CDI?
Answer: @Produces
Explanation: Used to provide objects not directly instantiated by CDI.
```
En CDI (Contexts and Dependency Injection), la anotación `@Produces` se utiliza para indicar que un método o campo es responsable de crear un objeto que será gestionado por el contenedor CDI y podrá ser inyectado en otras partes de la aplicación.

**Ejemplo:**

Supongamos que tenemos una clase `DatabaseConnection` que queremos inyectar en varios lugares de nuestra aplicación, pero no queremos que CDI la cree directamente (por ejemplo, porque la creamos de forma personalizada). Usamos `@Produces` para indicarle a CDI cómo crear ese objeto.

```java
import javax.enterprise.inject.Produces;

public class ConnectionProducer {

    @Produces
    public DatabaseConnection createDatabaseConnection() {
        return new DatabaseConnection("url_de_conexion", "usuario", "clave");
    }
}
```

En este caso, el método `createDatabaseConnection` es anotado con `@Produces`, lo que significa que el objeto `DatabaseConnection` que retorna estará disponible para ser inyectado en cualquier otra clase que lo necesite.

**Inyección en otra clase:**

```java
import javax.inject.Inject;

public class Service {

    @Inject
    private DatabaseConnection dbConnection;

    public void connect() {
        dbConnection.connect();
    }
}
```

Aquí, CDI se encarga de inyectar la instancia de `DatabaseConnection` creada por el método `createDatabaseConnection` sin necesidad de que lo hagamos manualmente.

## Undertow / Vert.x 
```
Q15. What is the default HTTP server used by Quarkus?
Answer: Undertow (or Vert.x depending on version)
Explanation: Quarkus supports fast, reactive HTTP servers.
```
Por defecto, Quarkus utiliza **Undertow** como servidor HTTP. En versiones más recientes, también puede utilizar **Vert.x**, dependiendo de la configuración y la versión de Quarkus. Ambos son servidores reactivos, lo que significa que están optimizados para manejar un gran número de conexiones simultáneas de manera eficiente.

### Ejemplo:

Imagina que estás desarrollando una aplicación web con Quarkus y la ejecutas en tu máquina local. Al hacer un `mvn quarkus:dev` para iniciar la aplicación, el servidor HTTP Undertow se encargará de gestionar las solicitudes y respuestas HTTP.

Si tu aplicación tiene un endpoint como este:

```java
@Path("/hello")
public class HelloResource {
    
    @GET
    public String hello() {
        return "Hola desde Quarkus";
    }
}
```

Al visitar `http://localhost:8080/hello` en tu navegador, Undertow se encargará de recibir la solicitud y devolver la respuesta "Hola desde Quarkus".

Este servidor es ligero y está optimizado para aplicaciones que necesitan un alto rendimiento en entornos de alta concurrencia.

# Cloud Native & DevOps

## Container registry
```
Q16. What is a container registry?
Answer: A repository for storing and pulling container images.
Explanation: e.g., Docker Hub, ECR, GCR.
```
Un *container registry* es un repositorio donde se almacenan y gestionan imágenes de contenedores, que son archivos que contienen todo lo necesario para ejecutar una aplicación en un contenedor, como el código, las bibliotecas y las dependencias.

### Ejemplo:

Imagina que has creado una aplicación utilizando Docker. Para poder ejecutarla en diferentes servidores, necesitas almacenar la imagen del contenedor en un repositorio accesible. Puedes usar Docker Hub (público) o Amazon ECR (privado) para almacenar esa imagen y luego "extraerla" (pull) a otros servidores donde se ejecute la aplicación.

En resumen, un container registry facilita el almacenamiento y distribución de imágenes de contenedores. Ejemplos comunes son:

* **Docker Hub** (público)
* **Amazon ECR** (privado)
* **Google Container Registry (GCR)**.

## Docker's ENTRYPOINT
```
Q17. What does Docker’s ENTRYPOINT define?
Answer: The main executable of the container.
Explanation: Always runs regardless of CMD values.
```
Docker's `ENTRYPOINT` define el ejecutable principal que se ejecutará cuando el contenedor se inicie. Es la instrucción que le dice a Docker qué programa o comando debe ejecutarse por defecto.

Por ejemplo:

```Dockerfile
FROM ubuntu:latest
ENTRYPOINT ["echo", "Hello, world!"]
```

En este caso, cuando se construya y ejecute el contenedor, siempre se ejecutará el comando `echo "Hello, world!"`, independientemente de cualquier otro valor que se pase con `CMD`.

Si usas el `CMD` junto con el `ENTRYPOINT`, el valor de `CMD` se usará como argumento para el `ENTRYPOINT`, pero el `ENTRYPOINT` siempre será el principal.

Por ejemplo:

```Dockerfile
FROM ubuntu:latest
ENTRYPOINT ["echo"]
CMD ["Hello, world!"]
```

Aquí, el contenedor imprimirá `Hello, world!`, porque `CMD` pasa el argumento `Hello, world!` al `ENTRYPOINT`. Sin embargo, podrías reemplazar "Hello, world!" con otro argumento al ejecutar el contenedor.

## 12-Factor App
```
Q18. What is “12-Factor App” primarily about?
Answer: Best practices for building scalable cloud apps.
Explanation: Emphasizes config, statelessness, CI/CD.
```
El **"12-Factor App"** es un conjunto de principios y mejores prácticas para construir aplicaciones modernas que sean escalables, fáciles de mantener y desplieguen sin problemas en la nube. Aquí están los 12 factores con un ejemplo sencillo de cada uno:

1. **Codebase**: La aplicación debe tener una sola base de código gestionada en un sistema de control de versiones, como Git.

   * *Ejemplo*: Un proyecto de Python donde todo el código está en un solo repositorio de GitHub.

2. **Dependencies**: Declarar todas las dependencias explícitamente, no confiar en que el entorno las instale automáticamente.

   * *Ejemplo*: Usar un archivo `requirements.txt` en Python para listar todas las librerías necesarias.

3. **Config**: La configuración de la aplicación debe almacenarse en variables de entorno, no en el código.

   * *Ejemplo*: Definir la URL de la base de datos en una variable de entorno `DATABASE_URL` en lugar de escribirla en el código.

4. **Backing Services**: Tratar los servicios externos (como bases de datos, colas de mensajes, etc.) como recursos adjuntos a la aplicación.

   * *Ejemplo*: Usar una base de datos como servicio (DBaaS) en lugar de instalar una base de datos localmente.

5. **Build, Release, Run**: Separar claramente los tres fases del ciclo de vida de la aplicación: compilación, liberación y ejecución.

   * *Ejemplo*: En una aplicación Node.js, usar comandos diferentes para `npm install` (build), `npm run deploy` (release) y `npm start` (run).

6. **Processes**: La aplicación debe ejecutarse en procesos sin estado, que no dependan de la memoria del servidor.

   * *Ejemplo*: Un servidor web que maneja las solicitudes de manera independiente sin mantener el estado entre ellas.

7. **Port Binding**: La aplicación debe ser auto-contenida y exponer servicios a través de un puerto.

   * *Ejemplo*: Una API REST que corre en el puerto 8080 y se puede acceder directamente a través de la URL `http://localhost:8080`.

8. **Concurrency**: Escalar la aplicación mediante la ejecución de múltiples instancias de procesos, según sea necesario.

   * *Ejemplo*: Una aplicación de chat que puede aumentar el número de instancias de procesos para manejar más usuarios concurrentes.

9. **Disposability**: Los procesos deben ser rápidos en iniciar y cerrar para facilitar el despliegue y escalado.

   * *Ejemplo*: Una función de procesamiento de imágenes que debe iniciarse rápidamente para recibir solicitudes y finalizar al terminar.

10. **Dev/Prod Parity**: Mantener la mayor similitud posible entre los entornos de desarrollo, prueba y producción.

* *Ejemplo*: Usar Docker para asegurar que la aplicación funcione igual en las máquinas locales de los desarrolladores que en producción.

11. **Logs**: Tratar los logs como un flujo de eventos, no como archivos, y gestionarlos a través de herramientas especializadas.

* *Ejemplo*: Usar un sistema de agregación de logs como ELK Stack (Elasticsearch, Logstash, Kibana) para visualizar los logs de la aplicación.

12. **Admin Processes**: Los procesos administrativos (como migraciones de base de datos) deben ejecutarse en el mismo entorno que la aplicación.

* *Ejemplo*: Ejecutar comandos de migración de base de datos como `python manage.py migrate` en el mismo entorno de producción donde corre la aplicación.

Cada uno de estos factores ayuda a crear aplicaciones que sean fáciles de desplegar, escalar y mantener en un entorno de nube.

## IaC
```
Q19. What is IaC?
Answer: Managing infrastructure using declarative code.
Explanation: Terraform, CloudFormation, Pulumi.
```
**IaC (Infrastructure as Code)** es un enfoque que permite gestionar la infraestructura de TI a través de código declarativo en lugar de hacerlo manualmente a través de interfaces gráficas o comandos. Esto facilita la automatización y escalabilidad en la provisión y administración de servidores, redes, bases de datos, etc.

**Ejemplo:**
Imagina que necesitas crear un servidor virtual en la nube (por ejemplo, AWS). Con IaC, puedes escribir un archivo de código que describa cómo debe ser ese servidor, qué características debe tener (como su tamaño, sistema operativo, etc.), y luego el código se ejecuta para provisionarlo automáticamente. Así, en lugar de hacer clic en una consola web para crear el servidor, simplemente ejecutas un archivo de configuración.

**Herramientas populares:**

* **Terraform**: Permite definir la infraestructura en un lenguaje declarativo y luego aplicarla a diferentes plataformas en la nube.
* **CloudFormation**: Específico de AWS, permite crear y gestionar recursos de AWS mediante plantillas declarativas en JSON o YAML.
* **Pulumi**: Similar a Terraform, pero permite usar lenguajes de programación como JavaScript o Python para definir la infraestructura.

## Kubernetes readiness probe
```
Q20. Kubernetes readiness probe checks what?
Answer: If the app is ready to receive traffic.
Explanation: Unlike liveness which checks if it should restar
```
La **readiness probe** en Kubernetes se utiliza para verificar si una aplicación está lista para recibir tráfico. Esto es útil para asegurarse de que un contenedor no reciba peticiones antes de que esté completamente preparado.

### Ejemplo:

Imagina que tienes una aplicación web que realiza una conexión a una base de datos al iniciar. El contenedor de la aplicación puede empezar antes de que la base de datos esté lista, por lo que no debería recibir tráfico inmediatamente.

En este caso, puedes configurar una **readiness probe** para hacer un chequeo a una URL de la aplicación (por ejemplo, `/healthz`). Si la aplicación responde correctamente, significa que está lista para recibir tráfico. Si no responde (porque la base de datos aún no está disponible), Kubernetes no enviará tráfico a ese contenedor hasta que la probe indique que está listo.

* **Liveness Probe**: Verifica si la aplicación está viva y funcionando correctamente. Si no responde, se reinicia.
* **Readiness Probe**: Verifica si la aplicación está lista para recibir tráfico.

Esto asegura que las solicitudes no lleguen antes de tiempo, evitando errores o caídas en el servicio.

## Idempotency in REST
```
Q21. What is idempotency in REST?
Answer: Multiple identical requests produce the same result.
Explanation: PUT and DELETE must be idempotent.
```
**Idempotencia en REST** significa que realizar la misma operación varias veces dará siempre el mismo resultado, sin importar cuántas veces se repita la solicitud. Esto es importante para garantizar que no haya efectos secundarios inesperados si una solicitud se envía más de una vez, por ejemplo, debido a un fallo en la red o un reintento.

### Ejemplo:

Imagina que tienes un API para actualizar la información de un usuario:

* **Solicitud PUT:** `PUT /usuarios/123 { "nombre": "Juan" }`

Si envías esta solicitud varias veces, el resultado siempre será el mismo: el nombre del usuario con ID 123 será "Juan". No importa cuántas veces se repita la solicitud, el estado final es el mismo. Esto es **idempotente**.

En contraste, una solicitud **POST** (para crear recursos) no sería idempotente, porque enviar la misma solicitud varias veces puede crear múltiples recursos (por ejemplo, varios usuarios).

Por eso, **PUT** y **DELETE** son operaciones idempotentes:

* **PUT:** Si actualizas un recurso con el mismo valor varias veces, el estado del recurso no cambia después de la primera vez.
* **DELETE:** Si eliminas un recurso y luego lo intentas eliminar de nuevo, el resultado será el mismo (el recurso ya no existe).

## docker ps
```
Q22. What command shows running containers?
Answer: docker ps
Explanation: Lists active containers.
```
El comando `docker ps` se utiliza para mostrar los contenedores que están en ejecución en el sistema.

### Ejemplo:

Supongamos que tienes un contenedor de una aplicación web corriendo. Si ejecutas el siguiente comando:

```bash
docker ps
```

El resultado podría ser algo así:

```
CONTAINER ID   IMAGE         COMMAND                  CREATED          STATUS          PORTS     NAMES
a1b2c3d4e5f6   nginx         "/docker-entrypoint.…"   2 hours ago      Up 2 hours      80/tcp    happy_docker
```

Este comando muestra la información del contenedor activo, como su ID, la imagen que está usando (`nginx` en este caso), el tiempo que lleva en ejecución y los puertos expuestos (en este caso el puerto 80).

### NodePort
```
Q23. What is a NodePort?
Answer: Exposes a service on a port of every Kubernetes node.
Explanation: Basic type of external K8s service.
```
Un **NodePort** es un tipo de servicio en Kubernetes que expone una aplicación o servicio en un puerto específico en cada nodo del clúster. Esto permite acceder al servicio desde fuera del clúster, utilizando la dirección IP de cualquier nodo y el puerto asignado.

### Ejemplo:

Supón que tienes un servicio llamado **"mi-app"** que se ejecuta en un contenedor dentro de Kubernetes, y quieres que sea accesible desde fuera del clúster. Puedes crear un servicio de tipo **NodePort** para exponerlo en todos los nodos del clúster.

1. Creas el servicio **NodePort** con un puerto asignado, por ejemplo, el puerto 30000:

   ```yaml
   apiVersion: v1
   kind: Service
   metadata:
     name: mi-app
   spec:
     selector:
       app: mi-app
     ports:
       - protocol: TCP
         port: 80        # Puerto del servicio dentro del clúster
         targetPort: 8080 # Puerto del contenedor
         nodePort: 30000  # Puerto en el nodo
     type: NodePort
   ```

2. Después de aplicar este manifiesto, el servicio estará accesible en el puerto **30000** de **cualquier nodo** del clúster. Puedes acceder a la aplicación desde fuera usando la IP de cualquier nodo, por ejemplo: `http://<IP-del-nodo>:30000`.

Este tipo de servicio es útil cuando quieres exponer un servicio internamente, pero aún permitir el acceso externo al clúster sin usar un balanceador de carga.

## What is a pod in Kubernetes?
```
Q24. What is a pod in Kubernetes?
Answer: The smallest deployable unit containing containers.
Explanation: One or more tightly coupled containers.
```
Un **Pod** en Kubernetes es la unidad más pequeña y básica que se puede desplegar y administrar en un clúster de Kubernetes. Un Pod puede contener uno o más contenedores que comparten el mismo contexto de red, almacenamiento y otros recursos.

### Ejemplo:

Supongamos que tienes una aplicación web que consta de dos contenedores: uno para el servidor web y otro para una base de datos en memoria. Ambos contenedores necesitan estar en el mismo entorno para poder comunicarse rápidamente y compartir datos.

En este caso, crearías un **Pod** que contenga esos dos contenedores. Aunque son contenedores separados, están "empaquetados" dentro de un único Pod, lo que les permite compartir recursos como la red local y el volumen de almacenamiento.

Este **Pod** luego se puede desplegar y gestionar en el clúster de Kubernetes.

## Immutable infrastructure
```
Q25. What is immutable infrastructure?
Answer: Servers are replaced instead of modified.
Explanation: Supports reliability and reproducible environments.
```

La **infraestructura inmutable** es un enfoque en el que los servidores y otros componentes de la infraestructura no se modifican una vez que están en funcionamiento. En lugar de hacer cambios o actualizaciones a los servidores existentes, se reemplazan por completo. Esto asegura un entorno consistente, predecible y fácil de reproducir.

**Ejemplo:** Supongamos que tienes una aplicación web que está corriendo en varios servidores. Si uno de esos servidores necesita actualizarse, en lugar de conectarse a él y modificar su configuración o instalar nuevas dependencias, simplemente se crea una nueva versión del servidor con todos los cambios necesarios y se despliega. El servidor antiguo es eliminado y reemplazado por completo, garantizando que todo se mantenga en el mismo estado conocido y estable. Esto facilita la gestión y mejora la confiabilidad del sistema.

## Horizontal Pod Autoscaler
```
Q26. What is a Horizontal Pod Autoscaler?
Answer: Automatically scales pods based on metrics like CPU.
Explanation: Adjusts replicas depending on workload.
```
El **Horizontal Pod Autoscaler (HPA)** es una característica de Kubernetes que ajusta automáticamente el número de réplicas de un pod en función de métricas como el uso de CPU o la memoria.

**Ejemplo:**

Imagina que tienes una aplicación desplegada en Kubernetes y configuras un HPA para que ajuste el número de réplicas de tus pods en función del uso de CPU. Si en un momento dado, el uso de CPU de tus pods supera un umbral establecido (por ejemplo, el 80%), el HPA puede aumentar el número de réplicas para manejar la carga adicional. Por otro lado, si el uso de CPU disminuye, el HPA puede reducir las réplicas para ahorrar recursos.

Esto permite que la aplicación escale de manera eficiente en función de la demanda real.

## OpenAPI/Swagger
```
Q27. What does OpenAPI/Swagger provide?
Answer: API documentation and client generation.
Explanation: Standard for REST API schemas.
```
OpenAPI (anteriormente conocido como Swagger) es un estándar para describir la estructura de una API REST. Proporciona una especificación que permite generar documentación interactiva y también generar clientes automáticamente en varios lenguajes de programación.

**Ejemplo:**

Imagina que tienes una API para gestionar un sistema de tareas. Usando OpenAPI, puedes definir cómo se debe realizar una solicitud para obtener todas las tareas o para crear una nueva tarea, y qué parámetros se necesitan. Con esta descripción, herramientas como Swagger UI pueden generar una interfaz gráfica donde los desarrolladores pueden ver la documentación y probar los endpoints directamente desde el navegador.

**Beneficios:**

* **Documentación interactiva:** Los desarrolladores pueden ver cómo interactuar con la API y probarla en tiempo real.
* **Generación automática de clientes:** A partir de la descripción de la API, puedes generar automáticamente un cliente en lenguajes como Java, Python, o JavaScript, lo que facilita la integración con tu API.

En resumen, OpenAPI/Swagger facilita la creación, documentación y prueba de APIs de manera estandarizada y automatizada.

## Service mesh
```
Q28. What is a service mesh?
Answer: Layer handling service-to-service communication.
Explanation: Observability, mTLS, routing (Istio, Linkerd).
```
Un **service mesh** es una capa de infraestructura que gestiona la comunicación entre servicios dentro de una aplicación distribuida. Facilita tareas como la seguridad, el enrutamiento y la observabilidad de los servicios que se comunican entre sí.

**Ejemplo:**

Imagina una aplicación de e-commerce que tiene varios microservicios: uno para el carrito de compras, otro para el pago, y otro para el inventario. Estos servicios necesitan comunicarse entre sí para realizar acciones como procesar el pago y actualizar el inventario.

Sin un service mesh, tendrías que gestionar manualmente aspectos como la autenticación entre servicios, el enrutamiento de las peticiones o el monitoreo de las interacciones. Aquí es donde entra un **service mesh** como **Istio** o **Linkerd**, que automáticamente maneja:

1. **mTLS** (Mutual TLS): encripta y autentica la comunicación entre los servicios para garantizar que solo servicios autorizados se comuniquen entre sí.

2. **Enrutamiento**: gestiona cómo y a qué instancias se dirigen las solicitudes entre microservicios (por ejemplo, enviando peticiones a una nueva versión de un servicio sin interrumpir el sistema).

3. **Observabilidad**: proporciona métricas y trazabilidad de las solicitudes, lo que ayuda a ver cómo los servicios interactúan y detectar posibles problemas.

En resumen, un service mesh simplifica la gestión de la comunicación entre microservicios, mejorando la seguridad, el control y la visibilidad en un entorno distribuido.

## What is a Secret in Kubernetes
```
Q29. What is a Secret in Kubernetes?
Answer: Object that stores sensitive data (tokens, passwords).
Explanation: Base64‐encoded, not encrypted by default.
```

En Kubernetes, un **Secret** es un objeto que almacena información sensible, como contraseñas, tokens de acceso, claves de API, entre otros. Su principal objetivo es mantener estos datos de manera segura, aunque cabe destacar que, por defecto, los Secrets no están cifrados, solo están codificados en Base64.

### Ejemplo:

Supón que tienes una aplicación que necesita conectarse a una base de datos y para ello, requiere un nombre de usuario y una contraseña. En lugar de incluir estos datos directamente en el archivo de configuración del Pod (lo cual sería riesgoso), puedes almacenarlos como un Secret.

```yaml
apiVersion: v1
kind: Secret
metadata:
  name: db-credentials
type: Opaque
data:
  username: dXNlcjE=  # "user1" codificado en base64
  password: cGFzc3dvcmQ=  # "password" codificado en base64
```

En este ejemplo:

* `username` y `password` están codificados en Base64.
* Kubernetes guarda el Secret, pero no lo cifra por defecto, por lo que es importante que utilices mecanismos adicionales (como cifrado en reposo) para proteger esta información.

Luego, el Secret se puede montar dentro de un Pod para que la aplicación lo use sin exponer los valores directamente en el código.

## “Shift-left testing”
```
Q30. What is “shift-left testing”?
Answer: Running tests earlier in the development cycle.
Explanation: Detects defects sooner and reduces cost.
```
**Shift-left testing** es una práctica en desarrollo de software donde las pruebas se realizan lo antes posible en el ciclo de vida del proyecto, es decir, se "desplazan hacia la izquierda" en el cronograma, antes de que el software esté completamente desarrollado.

**Ejemplo**: Imagina que estás desarrollando una aplicación y, en lugar de esperar hasta el final para realizar pruebas (como se hacía tradicionalmente), empiezas a probar desde las primeras fases del desarrollo, incluso cuando sólo hay partes pequeñas del código. Esto permite detectar errores antes, lo que reduce los costos de corregir fallos y mejora la calidad del software.

**Beneficio**: Detectar defectos más temprano, lo que ahorra tiempo y dinero al evitar que los problemas se acumulen y se conviertan en costosos de solucionar más tarde.

# Security, Quality & Monitoring

## SQL Injection
```
Q31. Prepared statements prevent which attack?
Answer: SQL Injection
Explanation: They avoid query concatenation.
```
Las **sentencias preparadas** (prepared statements) previenen el ataque de **inyección SQL** (SQL Injection).

### Ejemplo:

Imagina que un atacante intenta inyectar código malicioso a través de un formulario de login:

* **Consulta vulnerable sin sentencia preparada**:

  ```sql
  SELECT * FROM usuarios WHERE username = 'usuario' AND password = '1234';
  ```

Si el atacante ingresa como nombre de usuario: `usuario' OR '1' = '1` y como contraseña: `cualquiercosa`, la consulta resultante sería:

```sql
SELECT * FROM usuarios WHERE username = 'usuario' OR '1' = '1' AND password = 'cualquiercosa';
```

Esto podría devolver todos los registros de la tabla, permitiendo al atacante acceder al sistema sin tener credenciales válidas.

### Sentencia preparada:

Al usar una sentencia preparada, la consulta se separa de los datos que el usuario introduce, y el código no puede ser manipulado. La consulta podría verse así:

```sql
SELECT * FROM usuarios WHERE username = ? AND password = ?;
```

Los valores de `username` y `password` se insertan de manera segura en la consulta, sin que el código SQL pueda ser alterado por el usuario, evitando el ataque de inyección.

De este modo, **las sentencias preparadas** evitan que los datos del usuario alteren la estructura de la consulta SQL, protegiendo la base de datos de ataques de inyección.

## What is a JWT
```
Q32. What is a JWT?
Answer: A signed token representing claims for authentication.
Explanation: Often includes subject, roles, expiration.
```
Un **JWT** (JSON Web Token) es un token firmado que se utiliza para representar claims o afirmaciones sobre una entidad, como la identidad de un usuario, y se usa comúnmente en autenticación y autorización.

### Ejemplo:

Imagina que un usuario inicia sesión en una aplicación. La aplicación genera un JWT que contiene información como el ID del usuario y su rol (por ejemplo, "admin"). Este token es firmado con una clave secreta para garantizar su integridad. Cada vez que el usuario hace una solicitud a un servidor, el JWT se incluye en la cabecera de la solicitud para que el servidor lo verifique y sepa quién es el usuario y si tiene permiso para realizar la acción solicitada.

**Estructura de un JWT:**

1. **Header (Cabecera):** Tipo de token (JWT) y el algoritmo de firma (por ejemplo, HMAC SHA256).
2. **Payload (Cuerpo):** Contiene los claims, como el ID de usuario, roles, fecha de expiración, etc.
3. **Signature (Firma):** Se utiliza para verificar que el token no ha sido alterado.

### Ejemplo de JWT:

```text
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

* La primera parte es la cabecera codificada en base64.
* La segunda parte es el cuerpo del token, que contiene los claims.
* La tercera parte es la firma, que garantiza que el token no ha sido modificado.

En resumen, un JWT es una manera de asegurar que el servidor pueda confiar en las solicitudes de un cliente sin tener que revisar constantemente una base de datos o estado de sesión.

## OAuth2
```
Q33. What is OAuth2 primarily used for?
Answer: Delegated authorization.
Explanation: Allows apps to act on behalf of users.
```

OAuth2 es un protocolo de autorización que permite a las aplicaciones obtener acceso a recursos de un usuario sin necesidad de compartir sus credenciales. En lugar de pedirle al usuario su nombre de usuario y contraseña, OAuth2 permite que una aplicación actúe en nombre del usuario de manera segura.

**Ejemplo:**

Imagina que usas una aplicación llamada *"FotoApp"* que te permite compartir fotos desde tu cuenta de Google Fotos en redes sociales. En lugar de pedirte tu usuario y contraseña de Google, *FotoApp* te redirige a la página de inicio de sesión de Google, donde le otorgas permisos para acceder a tus fotos. Una vez que autorizas, *FotoApp* recibe un "token" que le permite acceder a tus fotos, pero sin conocer tu contraseña.

Así, OAuth2 le permite a *FotoApp* realizar acciones en tu nombre (delegated authorization) sin que tú tengas que compartir tu información sensible directamente.

## XSS
```
Q34. What is XSS?
Answer: Cross-Site Scripting (injecting malicious scripts).
Explanation: Happens when apps don’t sanitize input.
```
**XSS (Cross-Site Scripting)** es una vulnerabilidad de seguridad en aplicaciones web que permite a un atacante inyectar scripts maliciosos (generalmente en JavaScript) en páginas web que otros usuarios visualizarán. Esto sucede cuando una aplicación no valida ni "limpia" adecuadamente los datos que el usuario ingresa, permitiendo que el script se ejecute en el navegador de otro usuario.

**Ejemplo:**
Imagina una página de comentarios en un blog. Si un atacante ingresa un comentario con un código JavaScript malicioso, como:

```html
<script>alert('¡Tu sesión ha sido secuestrada!');</script>
```

Si la aplicación no limpia este código y lo muestra tal cual en la página, cualquier persona que vea ese comentario verá el mensaje de alerta. Si el script fuera más sofisticado, podría robar cookies de sesión, redirigir a usuarios a páginas falsas, o realizar otras acciones maliciosas.

### Solución:

Para prevenir XSS, las aplicaciones deben "sanitizar" o "escapar" el contenido ingresado por los usuarios, asegurándose de que cualquier código malicioso sea neutralizado.

## CSRF
```
Q35. What does CSRF protect against?
Answer: Unwanted actions executed by authenticated users.
Explanation: Anti-CSRF tokens mitigate.
```
El CSRF (Cross-Site Request Forgery) es un tipo de ataque en el que un atacante induce a un usuario autenticado a ejecutar una acción no deseada en una aplicación web en la que está autenticado. Esto puede ocurrir sin que el usuario lo sepa, aprovechando su sesión activa.

**Ejemplo:**

Imagina que estás autenticado en tu cuenta bancaria en un navegador. Si un atacante crea una página maliciosa y te hace visitar esa página mientras estás logueado en tu banco, la página podría hacer una solicitud para transferir dinero de tu cuenta sin tu consentimiento.

**Protección contra CSRF:**

Para prevenir esto, se utilizan **tokens anti-CSRF**. Estos tokens son valores únicos generados por el servidor y enviados en cada solicitud. Cuando el servidor recibe una solicitud, verifica que el token enviado coincida con el que se esperaba. Si no coinciden, se rechaza la solicitud, evitando que se ejecute una acción no autorizada.

## SonarQube
```
Q36. What is SonarQube used for?
Answer: Static code analysis for quality and security.
Explanation: Measures bugs, vulnerabilities, code smells.
```
**SonarQube** es una herramienta de análisis estático de código que se utiliza para evaluar la calidad del código y detectar posibles vulnerabilidades o "fallos" en el mismo. Realiza un análisis profundo para identificar errores de programación, problemas de seguridad y malos hábitos en el código, conocidos como "code smells".

### Ejemplo:

Imagina que tienes un proyecto en Java y estás desarrollando una aplicación. Cuando usas **SonarQube**, la herramienta escanea tu código en busca de errores, como variables no utilizadas, funciones demasiado complejas o vulnerabilidades de seguridad (como posibles inyecciones SQL). Después de hacer el análisis, SonarQube te muestra un informe detallado que incluye:

* **Bugs**: Errores que pueden generar fallos en la ejecución.
* **Vulnerabilidades**: Riesgos de seguridad que podrían ser explotados.
* **Code Smells**: Partes del código que, aunque no son errores, podrían mejorar para facilitar su mantenimiento.

Este informe te permite corregir esos problemas antes de que el código llegue a producción, mejorando la calidad general del software.

## WAF
```
Q37. What does a WAF do?
Answer: Filters and protects HTTP traffic from attacks.
Explanation: Blocks SQLi, XSS, etc.
```
Un WAF (Web Application Firewall) es un sistema de seguridad que se utiliza para proteger las aplicaciones web de ataques maliciosos, como la inyección de SQL (SQLi), los ataques de secuencias de comandos en sitios cruzados (XSS) y otros tipos de vulnerabilidades comunes en las aplicaciones web.

**Ejemplo:**

Imagina que tienes un sitio web de comercio electrónico donde los usuarios pueden hacer compras. Un atacante intenta inyectar código malicioso a través de un formulario de búsqueda en el sitio, lo que podría comprometer la base de datos del sistema y robar información sensible. Un WAF filtraría ese tráfico malicioso, bloqueando la inyección SQL antes de que llegue al servidor de la aplicación, protegiendo así el sitio web y los datos de los usuarios.

En resumen, un WAF actúa como un guardia de seguridad que monitorea y filtra las solicitudes HTTP que llegan a tu aplicación web para evitar ataques.

## Rate limiting
```
Q38. What is rate limiting?
Answer: Restricting number of requests per client.
Explanation: Prevents abuse, DoS attacks.
```
**Rate limiting** es una técnica utilizada para restringir el número de solicitudes que un cliente (como un usuario o un sistema) puede hacer a un servidor en un período de tiempo determinado. Su propósito es evitar abusos, como ataques de denegación de servicio (DoS) o la sobrecarga de un servidor.

**Ejemplo:**
Imagina que tienes una API que permite a los usuarios consultar información sobre el clima. Para evitar que un único usuario haga miles de solicitudes en un segundo (lo que podría colapsar el servidor), puedes implementar rate limiting. Por ejemplo, podrías permitir que cada usuario haga hasta 100 solicitudes por minuto. Si un usuario supera ese límite, el servidor les enviará un mensaje de error, como "Demasiadas solicitudes, por favor espere".

Esto ayuda a proteger el sistema y asegura que todos los usuarios tengan acceso sin que un solo cliente monopolice el servicio.

## Structured Logs
```
Q39. What is the purpose of logs being “structured”?
Answer: Machine-readable data (JSON) for analysis.
Explanation: Works well with ELK, Loki, etc.
```
Los **logs estructurados** son registros de eventos o actividades en un formato organizado y consistente, como **JSON**, que facilita su análisis automático. A diferencia de los logs no estructurados (que pueden ser texto libre), los logs estructurados tienen campos claramente definidos que las máquinas pueden procesar fácilmente.

### Ejemplo:

Supón que tienes una aplicación web y deseas registrar información sobre cada solicitud HTTP. Un log estructurado podría verse así en formato JSON:

```json
{
  "timestamp": "2025-12-02T14:45:00Z",
  "user_id": "12345",
  "request_method": "GET",
  "request_url": "/home",
  "status_code": 200,
  "response_time_ms": 120
}
```

Este formato es fácil de leer y analizar automáticamente mediante herramientas como **ELK** (Elasticsearch, Logstash y Kibana) o **Loki**, porque cada campo tiene un significado claro y puede ser filtrado o consultado con precisión.

Por ejemplo, si quisieras ver todas las solicitudes con errores (status_code = 500), podrías hacerlo rápidamente usando consultas específicas en la herramienta sin tener que interpretar texto libre o patrones irregulares. Esto ahorra tiempo y mejora la eficiencia en el análisis de grandes volúmenes de datos.

## SLF4J
```
Q40. What does SLF4J provide?
Answer: Logging API abstraction.
Explanation: Decouples code from logging implementation.
```
SLF4J (Simple Logging Facade for Java) proporciona una **abstracción de API para el registro (logging)**. Esto significa que permite que las aplicaciones Java usen un conjunto estándar de interfaces para registrar mensajes (como errores, advertencias o información), sin estar atadas a una implementación específica de logging.

### Ejemplo:

Imagina que tienes una aplicación Java y deseas agregar logging. Sin SLF4J, tendrías que depender directamente de una librería de logging específica como Log4j o java.util.logging. Esto haría que tu código dependa de esa librería, lo que puede ser problemático si deseas cambiarla más adelante.

Con SLF4J, puedes escribir tu código usando su API, y luego elegir qué implementación de logging deseas usar (Log4j, Logback, etc.). Si en el futuro decides cambiar de implementación, solo necesitas cambiar la configuración, no el código de la aplicación.

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApp {
    private static final Logger logger = LoggerFactory.getLogger(MyApp.class);

    public static void main(String[] args) {
        logger.info("Inicio de la aplicación");
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("Ocurrió un error", e);
        }
    }
}
```

En este caso, `logger` está usando SLF4J. El sistema de logging real (por ejemplo, Logback o Log4j) se define en tiempo de ejecución sin necesidad de cambiar el código fuente.

Esto permite que el código esté desacoplado de la implementación de logging específica, lo que mejora la flexibilidad y facilita el mantenimiento.

## Circuit Breaker
```
Q41. What is the role of a circuit breaker?
Answer: Prevents cascading failures by stopping calls to failing services.
Explanation: OPEN → fallback.
```
Un **circuit breaker** es un patrón de diseño utilizado en sistemas distribuidos para evitar que una falla en un servicio se propague y cause fallos en cadena en otros servicios. Su función principal es "interrumpir" las solicitudes a un servicio que está fallando, permitiendo que el sistema recupere estabilidad.

### Ejemplo:

Imagina que tienes un sistema de microservicios donde el **Servicio A** realiza llamadas al **Servicio B**. Si **Servicio B** comienza a fallar debido a un error o una sobrecarga, **Servicio A** podría seguir intentando llamar a **Servicio B**, lo que empeoraría la situación. Aquí es donde entra el **circuit breaker**.

1. **Estado "CLOSED"**: Cuando todo está funcionando bien, el circuit breaker permite que las solicitudes pasen normalmente de **A a B**.
2. **Estado "OPEN"**: Si el número de fallos de **Servicio B** alcanza un umbral, el circuit breaker se abre y bloquea las solicitudes a **B**, evitando más intentos fallidos.
3. **Estado "HALF-OPEN"**: Después de un tiempo, el circuit breaker prueba de nuevo si **Servicio B** está operativo. Si las pruebas son exitosas, el circuito se cierra nuevamente, permitiendo el tráfico.

Con esto, el sistema evita que una sobrecarga o falla en **Servicio B** afecte a otros servicios y da tiempo para que **B** se recupere sin generar más errores. Además, se puede usar un **fallback** (un comportamiento alternativo) cuando el circuit breaker está abierto, para manejar la falla de forma segura.

## Secret Manager
```
Q42. What is a Secret Manager?
Answer: Secure storage for credentials and secrets.
Explanation: AWS, GCP, HashiCorp Vault.
```
**Un Secret Manager** es un servicio que permite **guardar de forma segura credenciales y secretos** —por ejemplo: contraseñas, claves API o cadenas de conexión— y acceder a ellos de manera controlada.

**Ejemplo breve:**
Imagina que tu aplicación necesita una **clave API** para conectarse a un servicio externo. En vez de escribir la clave directamente en el código, la guardas en un **Secret Manager** (como AWS Secrets Manager, Google Secret Manager o HashiCorp Vault). Luego, la aplicación la obtiene desde allí cuando la necesita, reduciendo riesgos de seguridad.

## Observability
```
Q43. What is observability?
Answer: Ability to understand internal state from logs, metrics, traces.
Explanation: Broader than monitoring.
```
**Observabilidad (observability)** es la capacidad de entender lo que está ocurriendo dentro de un sistema a partir de la información que éste emite, como **logs**, **métricas** y **trazas**.
Es un concepto **más amplio que el monitoreo**, porque no solo detecta fallos, sino que permite **investigar y comprender** su causa.

**Ejemplo:**
Imagina una aplicación web que empieza a responder lentamente.

* Las **métricas** muestran que el uso de CPU aumentó.
* Los **logs** revelan que ciertas consultas a la base de datos tardan demasiado.
* Las **trazas** permiten seguir una petición completa y muestran exactamente dónde se produce la demora.

Con esa información, puedes identificar el problema sin necesidad de acceder directamente al servidor.

## SAST
```
Q44. What does SAST mean?
Answer: Static Application Security Testing.
Explanation: Scans code without executing it.
```
**SAST** (Static Application Security Testing) es un tipo de prueba de seguridad que se realiza sobre el código fuente de una aplicación sin ejecutarla. Su objetivo es identificar vulnerabilidades potenciales en el código antes de que se despliegue o ejecute.

**Ejemplo:**
Imagina que un desarrollador está escribiendo una aplicación de comercio electrónico. Antes de lanzar el código al servidor, usa una herramienta SAST para revisar el código fuente. La herramienta escanea el código y encuentra una vulnerabilidad, como una posible inyección de SQL, que podría ser explotada si un atacante interactuara con la base de datos. Gracias al SAST, el desarrollador puede corregir este error en el código antes de que el sistema entre en producción, evitando así posibles problemas de seguridad.

## CORS
```
Q45. What is CORS?
Answer: Mechanism for cross-domain resource sharing.
Explanation: Configured via HTTP response headers.
```
CORS (Cross-Origin Resource Sharing) es un mecanismo de seguridad que permite que los recursos de un servidor sean accesibles desde otro dominio diferente al del servidor original. Esto se configura mediante los encabezados de respuesta HTTP.

**Ejemplo:**

Imagina que tienes una página web alojada en `https://mi-sitio.com`, y esta página intenta hacer una solicitud para obtener datos desde una API en `https://api-externa.com`. Si `https://api-externa.com` no permite explícitamente que su contenido sea accesible desde `mi-sitio.com`, el navegador bloqueará la solicitud por razones de seguridad.

Sin embargo, si `https://api-externa.com` incluye en la respuesta un encabezado HTTP como este:

```
Access-Control-Allow-Origin: https://mi-sitio.com
```

Esto indica que el servidor de la API permite solicitudes desde `https://mi-sitio.com`, y el navegador permitirá la transferencia de datos entre ambos dominios.

En resumen, CORS permite compartir recursos entre dominios de manera controlada.

# Frontend, Database & Version Control

## Primary key
```
Q46. What is a primary key?
Answer: Unique identifier of a table row.
Explanation: Not null + unique.
```
Una **primary key** (clave primaria) es un campo o conjunto de campos en una tabla de base de datos que se utiliza para identificar de manera única cada fila de la tabla. Tiene dos características principales:

1. **No puede ser nula** (not null).
2. **Debe ser única** para cada fila.

**Ejemplo:**

Imagina una tabla llamada **Estudiantes**:

| ID_Estudiante | Nombre | Edad |
| ------------- | ------ | ---- |
| 1             | Ana    | 20   |
| 2             | Juan   | 22   |
| 3             | María  | 19   |

En este caso, el campo **ID_Estudiante** es la **primary key** porque:

* Cada estudiante tiene un **ID_Estudiante único**.
* No hay ningún valor nulo en esa columna, lo que asegura que cada estudiante tiene un identificador único y obligatorio.

Por lo tanto, el **ID_Estudiante** sirve como la clave primaria de la tabla.

## LEFT JOIN
```
Q47. What does a LEFT JOIN return?
Answer: All rows from left table plus matching right table rows.
Explanation: Non-matches = NULLs.
```
Un **LEFT JOIN** (o **LEFT OUTER JOIN**) devuelve **todas las filas** de la tabla de la **izquierda** y las filas correspondientes de la tabla de la **derecha**. Si no hay coincidencia en la tabla de la derecha, se rellenan esos campos con **NULL**.

**Ejemplo:**

Imagina dos tablas:

1. **Empleados**:

   | ID | Nombre |
   | -- | ------ |
   | 1  | Juan   |
   | 2  | Ana    |
   | 3  | Carlos |

2. **Ventas**:

   | ID_Empleado | Monto |
   | ----------- | ----- |
   | 1           | 1000  |
   | 3           | 1500  |

Si hacemos un **LEFT JOIN** de la tabla **Empleados** con la tabla **Ventas** usando el campo **ID** de **Empleados** y el campo **ID_Empleado** de **Ventas**, el resultado será:

```sql
SELECT Empleados.ID, Empleados.Nombre, Ventas.Monto
FROM Empleados
LEFT JOIN Ventas ON Empleados.ID = Ventas.ID_Empleado;
```

**Resultado:**

| ID | Nombre | Monto |
| -- | ------ | ----- |
| 1  | Juan   | 1000  |
| 2  | Ana    | NULL  |
| 3  | Carlos | 1500  |

* **Juan** tiene una venta, por lo que muestra el monto.
* **Ana** no tiene una venta registrada, por lo que el campo **Monto** es **NULL**.
* **Carlos** tiene una venta, por lo que muestra el monto.

En resumen, el **LEFT JOIN** incluye todas las filas de la tabla izquierda y las filas correspondientes de la tabla derecha, con **NULL** en caso de no haber coincidencia.

## git rebase
```
Q48. What does git rebase do?
Answer: Reapplies commits on top of another branch.
Explanation: Creates linear history.
```
**`git rebase`** es un comando que permite mover o combinar una secuencia de commits de una rama a la punta de otra rama, creando un historial más limpio y lineal.

### Ejemplo:

Imagina que tienes las siguientes ramas y commits:

1. **Rama `main`**:

   ```
   A---B---C
   ```

2. **Rama `feature`**:

   ```
   A---B---C---D---E
   ```

Aquí, la rama `feature` se ramificó de `main` después del commit C y tiene los commits D y E.

Si ejecutas `git rebase main` mientras estás en la rama `feature`, Git tomará los commits D y E y los "reaplicará" sobre la punta de la rama `main`. El resultado será:

```
A---B---C---D'---E'
```

Lo que hace `rebase` es **mover** los commits D y E a la punta de la rama `main`, como si esos cambios se hubieran hecho después de C en vez de sobre C. Esto crea un historial lineal, sin la "ramificación" visible que se generaría con un `merge`.

## git stash
```
Q49. What does git stash do?
Answer: Saves uncommitted changes temporarily.
Explanation: Useful before switching branches.
```
El comando `git stash` se utiliza para guardar temporalmente los cambios no confirmados (modificaciones en archivos o nuevos archivos) sin tener que hacer un commit. Esto es útil cuando necesitas cambiar de rama, pero no quieres perder esos cambios.

**Ejemplo:**

1. Estás trabajando en la rama `feature` y realizas algunos cambios en el código.
2. Decides cambiar a la rama `develop` para revisar algo, pero no quieres hacer un commit de los cambios actuales.

En lugar de hacer un commit temporal o perder tus cambios, usas:

```bash
git stash
```

Esto guarda los cambios y limpia tu área de trabajo. Ahora puedes cambiar a la rama `develop` sin problemas. Luego, cuando regreses a la rama `feature`, puedes recuperar tus cambios con:

```bash
git stash apply
```

Así, `git stash` te permite "aparcar" los cambios y volver a ellos más tarde, sin comprometerlos aún.

## ACID
```
Q50. What is ACID?
Answer: Atomicity, Consistency, Isolation, Durability.
Explanation: Guarantees transactions.
```
**ACID** es un conjunto de propiedades que garantizan que las transacciones en una base de datos sean procesadas de manera fiable. Estas propiedades son:

1. **Atomicidad**: La transacción es "todo o nada". Si una parte falla, toda la transacción se deshace.
2. **Consistencia**: La base de datos pasa de un estado válido a otro estado válido.
3. **Aislamiento**: Las transacciones se ejecutan de manera independiente, sin que una interfiera con otra.
4. **Durabilidad**: Una vez que una transacción se ha completado, sus cambios son permanentes, incluso si hay un fallo del sistema.

### Ejemplo:

Imagina que un usuario transfiere dinero de una cuenta a otra en una base de datos.

* **Atomicidad**: Si el dinero se debita de una cuenta pero no se acredita en la otra, la transacción se revierte completamente.
* **Consistencia**: Después de la transacción, el total de dinero en ambas cuentas sigue siendo correcto, según las reglas del sistema.
* **Aislamiento**: Si dos usuarios intentan transferir dinero a la misma cuenta al mismo tiempo, cada transacción se procesa como si fuera la única.
* **Durabilidad**: Una vez que la transferencia se completa, el cambio en las cuentas es definitivo y no se pierde, incluso si el sistema falla después.

En resumen, ACID garantiza que las transacciones sean seguras, confiables y consistentes.

## Index in SQL
```
Q51. What is an index in SQL used for?
Answer: Speeding up data lookup.
Explanation: Works like a tree structure (B-Tree).
```
Un **índice en SQL** se utiliza para **acelerar la búsqueda de datos** en una tabla. Funciona como un índice en un libro, que permite encontrar rápidamente la página donde está la información que buscas.

### Ejemplo:

Imagina que tienes una tabla llamada `Empleados` con millones de registros y necesitas buscar el nombre de un empleado específico.

* **Sin índice:** Si realizas una consulta como `SELECT * FROM Empleados WHERE nombre = 'Juan'`, el sistema tiene que revisar cada fila en la tabla, lo cual puede ser muy lento si la tabla tiene muchos datos.

* **Con índice:** Si creas un índice sobre la columna `nombre`, SQL puede buscar el valor de "Juan" de manera mucho más rápida, como si estuviera buscando en una lista ordenada.

El índice en este caso es como un árbol (estructurado con un B-Tree, que es una estructura de datos balanceada) que ayuda a saltar directamente a las ubicaciones de los datos sin tener que revisar todo.

### En resumen:

Un **índice** en SQL mejora la velocidad de las búsquedas, especialmente cuando se tienen tablas grandes.

## ORM
```
Q52. What is an ORM?
Answer: Maps objects to relational tables.
Explanation: Hibernate, JPA, etc.
```
Un **ORM (Object-Relational Mapping)** es una técnica que permite convertir los datos de una base de datos relacional en objetos de programación orientada a objetos. En lugar de trabajar directamente con las tablas de la base de datos, se utilizan clases y objetos en el código, y el ORM se encarga de realizar las conversiones entre ambos.

### Ejemplo:

Supongamos que tenemos una base de datos con una tabla de **Usuarios**:

| id | nombre | edad |
| -- | ------ | ---- |
| 1  | Juan   | 30   |
| 2  | María  | 25   |

Con un ORM como **Hibernate** en Java, puedes definir una clase de Java llamada `Usuario` que se mapea a esta tabla. Algo así:

```java
@Entity
public class Usuario {
    @Id
    private int id;
    private String nombre;
    private int edad;
    
    // Getters y setters
}
```

Entonces, puedes trabajar con objetos `Usuario` directamente en tu código, y el ORM se encargará de realizar las operaciones de lectura y escritura en la base de datos, sin que tengas que escribir consultas SQL manualmente.

Por ejemplo, para guardar un usuario en la base de datos:

```java
Usuario usuario = new Usuario();
usuario.setNombre("Juan");
usuario.setEdad(30);
session.save(usuario);
```

Aquí, `session.save(usuario)` es una operación gestionada por el ORM, que traduce este objeto a una fila en la tabla **Usuarios** de la base de datos.

## git cherry-pick 
```
Q53. What does git cherry-pick do?
Answer: Applies a specific commit from another branch.
Explanation: Useful for selective merging.
```
`git cherry-pick` es un comando que permite aplicar un **commit específico** de otra rama en la rama actual, sin necesidad de fusionar toda la rama. Es útil cuando quieres llevar un cambio específico, pero no todo el historial de una rama.

### Ejemplo:

Imagina que tienes dos ramas: `main` y `feature`. Supón que en `feature` se hizo un commit que soluciona un error importante, pero no quieres fusionar toda la rama `feature` con `main`, solo ese commit en particular.

1. Estás en la rama `main`.
2. Usas `git log` en la rama `feature` para encontrar el hash del commit que quieres aplicar.
3. Ejecutas el siguiente comando en la rama `main`:

```bash
git cherry-pick <hash-del-commit>
```

Esto traerá ese commit específico de `feature` y lo aplicará a la rama `main` como un nuevo commit.

##  Migration tool
```
Q54. What is a migration tool?
Answer: Manages schema changes over time.
Explanation: Flyway, Liquibase.
```
Un **migración de herramientas** es un software que ayuda a gestionar y aplicar cambios en la estructura de una base de datos a lo largo del tiempo, garantizando que las actualizaciones y modificaciones se realicen de manera controlada y coherente.

**Ejemplo:**

Imagina que tienes una base de datos para una tienda en línea. Inicialmente, la base de datos solo tiene tablas para productos y clientes. Después decides agregar una nueva funcionalidad para almacenar los pedidos. Utilizando una herramienta de migración como **Flyway** o **Liquibase**, puedes crear un archivo de migración que describa cómo agregar la nueva tabla de pedidos y las relaciones necesarias.

Cada vez que actualices la base de datos (por ejemplo, añadiendo más tablas o columnas en el futuro), estas herramientas se encargan de aplicar las migraciones en orden, asegurando que las versiones anteriores de la base de datos no se rompan y manteniendo un registro de todos los cambios realizados.

De esta forma, puedes gestionar el esquema de la base de datos de forma controlada y predecible, sin perder datos o causar inconsistencias.

## PWA
```
Q55. What is a PWA?
Answer: Progressive Web App.
Explanation: Offline cache, installable, service workers.
```
Una **PWA** (Progressive Web App) es una aplicación web que combina lo mejor de las aplicaciones móviles y las páginas web. Se comporta como una aplicación nativa en dispositivos móviles, pero se ejecuta desde el navegador.

**Características clave:**

1. **Offline cache:** Puede funcionar sin conexión a Internet, ya que almacena recursos en caché.
2. **Instalable:** Los usuarios pueden instalarla en su dispositivo, como una app nativa, sin necesidad de pasar por una tienda de aplicaciones.
3. **Service workers:** Son scripts que gestionan el caching y las notificaciones push, lo que permite que la aplicación funcione de manera más eficiente.

**Ejemplo:**
Una aplicación de noticias como **Twitter** o **Pinterest** puede ser una PWA. Puedes acceder a ella a través del navegador, navegar por contenido, y si pierdes la conexión a Internet, aún puedes leer artículos almacenados en caché. Además, puedes "instalarla" en tu pantalla de inicio sin necesidad de pasar por una tienda de apps.

## Redis
```
Q56. Redis is commonly used as what?
Answer: In-memory cache.
Explanation: Dramatically speeds up read operations.
```
**Redis** es comúnmente utilizado como **memoria caché en memoria**.

### Ejemplo:

Supón que tienes un sitio web de comercio electrónico con miles de productos. Cada vez que un usuario consulta un producto, el sistema debe buscar esa información en una base de datos. Si la base de datos está alojada en un disco duro, esto podría ser lento, especialmente con un gran volumen de usuarios.

Para mejorar la velocidad, usas Redis como caché. Almacenas los detalles más consultados de los productos en **memoria RAM** a través de Redis. Así, cuando un usuario busca un producto que ya está en la caché, Redis lo recupera extremadamente rápido, sin necesidad de acceder a la base de datos.

### Resultado:

La **caché en memoria** mejora enormemente la velocidad de las consultas, ya que las operaciones en memoria son mucho más rápidas que las en disco.

## Optimistic locking
```
Q57. What is optimistic locking?
Answer: Prevents conflicts with version numbers instead of DB locks.
Explanation: Used in high-concurrency systems.
```
El *optimistic locking* (bloqueo optimista) es una técnica utilizada en sistemas con alta concurrencia para evitar conflictos cuando varios usuarios intentan modificar los mismos datos simultáneamente, pero sin bloquear completamente los recursos.

### Ejemplo:

Imagina que dos personas están editando el mismo documento en un sistema en línea. El sistema no las bloquea mientras lo hacen (lo que sería un *bloqueo pesimista*), pero cada vez que alguien guarda los cambios, el sistema verifica si los datos han cambiado desde la última vez que el usuario los cargó.

1. Usuario A carga el documento. La versión es 1.
2. Usuario B también carga el mismo documento. La versión es 1.
3. Usuario A edita y guarda el documento. Ahora, la versión es 2.
4. Usuario B edita el documento y al intentar guardar, el sistema verifica que la versión del documento es 2 (no la 1 que cargó originalmente). Entonces, el sistema le informa a Usuario B que debe actualizar su versión antes de guardar.

De esta forma, se previene la sobrescritura de cambios sin necesidad de bloquear el documento para ambos usuarios. El "optimismo" radica en que el sistema asume que no habrá conflictos y solo verifica al final.

## GraphQL
```
Q58. What is GraphQL?
Answer: Query language where clients request exactly what they need.
Explanation: Alternative to REST.
```
**GraphQL** es un lenguaje de consulta para APIs que permite a los clientes pedir exactamente los datos que necesitan, ni más ni menos, a diferencia de REST, donde el servidor decide qué datos enviar.

**Ejemplo:**
Imagina que tienes una API de usuarios y cada usuario tiene un nombre, correo electrónico y dirección. Con REST, si pides información de un usuario, puedes obtener todos los datos del usuario (nombre, correo y dirección), incluso si solo necesitas el nombre. En cambio, con **GraphQL**, puedes pedir específicamente solo el **nombre** del usuario, lo que reduce la cantidad de datos innecesarios.

**Consulta GraphQL:**

```graphql
{
  usuario(id: 1) {
    nombre
  }
}
```

Con esta consulta, solo recibirás el nombre del usuario con id 1, sin datos adicionales.

## Data normalization
```
Q59. What is data normalization?
Answer: Organizing data to reduce redundancy.
Explanation: 1NF, 2NF, 3NF.
```
La **normalización de datos** es el proceso de organizar una base de datos para reducir la redundancia y mejorar la eficiencia, asegurando que los datos estén distribuidos de manera lógica en varias tablas.

### Ejemplo:

Imagina que tienes una tabla con información de estudiantes y los cursos que cursan:

| Estudiante_ID | Nombre      | Curso       | Profesor     |
| ------------- | ----------- | ----------- | ------------ |
| 1             | Juan Pérez  | Matemáticas | Dr. Gómez    |
| 2             | Ana López   | Física      | Dr. Martínez |
| 1             | Juan Pérez  | Física      | Dr. Martínez |
| 3             | Carlos Díaz | Matemáticas | Dr. Gómez    |

Aquí, los datos están repetidos, lo que crea redundancia. Para normalizar estos datos:

1. **1NF (Primera Forma Normal)**: Aseguramos que cada columna tenga valores atómicos (no repetidos). La tabla ya cumple con esto.

2. **2NF (Segunda Forma Normal)**: Eliminamos la dependencia parcial. En lugar de tener la información del estudiante y el curso juntos, separamos los datos en diferentes tablas:

   **Tabla Estudiantes**:

   | Estudiante_ID | Nombre      |
   | ------------- | ----------- |
   | 1             | Juan Pérez  |
   | 2             | Ana López   |
   | 3             | Carlos Díaz |

   **Tabla Cursos**:

   | Curso       | Profesor     |
   | ----------- | ------------ |
   | Matemáticas | Dr. Gómez    |
   | Física      | Dr. Martínez |

   **Tabla Inscripciones**:

   | Estudiante_ID | Curso       |
   | ------------- | ----------- |
   | 1             | Matemáticas |
   | 2             | Física      |
   | 1             | Física      |
   | 3             | Matemáticas |

3. **3NF (Tercera Forma Normal)**: Eliminamos dependencias transitivas, como si un dato depende de otro a través de un tercer dato. Ya con las tres tablas (Estudiantes, Cursos, Inscripciones), hemos eliminado redundancias y dependencias innecesarias.

La normalización hace que la base de datos sea más eficiente y fácil de mantener.

## git merge
```
Q60. What is git merge used for?
Answer: Combining commits from one branch into another.
Explanation: Produces a merge commit unless fast-forward.
```
El comando `git merge` se utiliza para combinar los cambios de una rama (branch) en otra. Es comúnmente usado cuando has trabajado en una rama de características y quieres incorporar esos cambios a la rama principal (por ejemplo, `main` o `master`).

**Ejemplo:**

1. Tienes una rama `feature` donde hiciste algunos cambios.
2. Ahora quieres traer esos cambios a la rama `main`.

Primero, cambias a la rama `main`:

```bash
git checkout main
```

Luego, ejecutas el comando `git merge` para fusionar los cambios de `feature`:

```bash
git merge feature
```

Este comando traerá los commits de `feature` a `main`. Si no hay conflictos, Git crea un "merge commit" que indica que las ramas se han combinado.

Si no hay ningún cambio nuevo en `main` desde que creaste `feature`, se podría hacer un "fast-forward", es decir, Git simplemente avanzará la referencia de la rama `main` para apuntar a la misma posición de `feature` sin crear un commit extra.
