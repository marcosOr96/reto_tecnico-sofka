# Título del proyecto: Concurso de preguntas y respuestas

#### Concurso de preguntas y respuestas
***

## Índice
1. [Características](#Características)
2. [Contenido del proyecto](#contenido-del-proyecto)
3. [Tecnologías](#tecnologías)
4. [IDE](#ide)
5. [Demo](#demo)
6. [Autor(es)](#autores)
7. [UML](#UML)
***

#### Características:

- Creación de nueva partida de juego.
- Ingreso de datos de jugador.
- Visualización de formulario de ingreso de preguntas y opciones de respuesta.
- Ingreso de preguntas y opciones de respuesta.
- registro en memoria de datos ingresados.
- Visualizacción de formulario de respuesta.
- Administración de campos dinamicos.
- Registro de respuesta dada.
- Visualización de nueva ronda de preguntas.
- Solicitud de confirmación de contuidad de partida.
- Visualización de formulario de ranking de puntajes historicos.
- Visualización de listado de puntajes historicos.
- Solicitud de confirmación de nueva partida de juego.


***
#### Contenido del PROYECTO

1. [clases](): En esta sección se describen las clases del proyecto
    - [Jugador](): Clase representativa de usuario jugador.
    - [Ronda](): Clase representativa de rondas de partida.
    - [Categoria](): Clase representativa de las categorias de dificultad de preguntas.
    - [Pregunta](): Clase representativa de las preguntas de la partida.
    - [Opcion](): Clase representativa de opciones de respuesta.
    - [Premio](): Clase representativa de premios.
    - [Juego](): Clase principal que representa la fachada del proyecto. En por donde se conectara el controlador con las demas clases del negocio.
    - [JuegoController](): Clase controladora de javaFx que me permite conectar los elecmentos de la GUI(VISTA) con la funcional de negocio.
***

#### Tecnologías

- JavaFx
- Maven
- Java 17
***

#### IDE

- Intellij IDEA

***


### Demo

Para probar la aplicacion deben seguir los siguientes pasos:
1. Clonar el repositorio con:  git clone https://github.com/marcosOr96/reto_tecnico-sofka.git
2. Tener descargado java 17
3. Buscar la clase de configuracion de JavaFX JuegoApplication.claas y ejecutar el metodo main
***

### Autor(es)
Proyecto desarrollado por:

1. Marcos Josue Ortega Lagos (<markosortega15@gmail.com>).
***
### UML

![alt text](https://github.com/marcosOr96/reto_tecnico-sofka-/raw/master//UML.png)
***
