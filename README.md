# TPE - Programación Orientada a Objetos 2026

## Juego de la Vida - Ulises Ivan Seguel

Trabajo Práctico Especial para finales de la materia Programación Orientada a Objetos.
El proyecto implementa una versión extensible del Juego de la Vida, incorporando nuevas reglas y distintos tipos de celdas.

### Requisitos

* Maven
* JavaFX

### Compilar el proyecto

Desde la carpeta raíz del proyecto ejecutar: mvn clean instal

Esto compila todas las clases y genera el proyecto listo para ejecutar

---

### Ejecutar la versión gráfica

Ejecutar la clase principal:

org.example.Juego_De_La_Vida.JuegoDeLaVida

Esto abrirá la interfaz gráfica del juego. 

---

### Ejecutar la versión por consola

Ejecutar la clase:

org.example.Juego_De_La_Vida.JuegoDeLaVidaConsola

La versión de consola permite:

* Seleccionar reglas especiales
* Elegir archivo de tablero inicial
* Generar tableros aleatorios
* Simular generaciones

---

## Estructura del proyecto

El proyecto está dividido en paquetes según responsabilidad:

* Celdas
* Reglas
* Tableros
* org.example.Juego_De_La_Vida

---

## Diseño del sistema

El diseño sigue principios de Programación Orientada a Objetos,
separando responsabilidades entre clases y permitiendo extender 
el comportamiento mediante nuevas reglas o tipos de celda.

---

## Celdas

Representan el estado de cada posición del tablero.

### Celda (abstracta)

Define el comportamiento básico de cualquier celda.
Declara el método:

estaViva()

que permite determinar si la celda se considera viva o muerta.

### CeldaViva

Representa una celda viva.

### CeldaMuerta

Representa una celda muerta.

### CeldaEnferma

Extiende CeldaViva.
Representa una celda viva que se encuentra enferma y puede verse afectada por reglas especiales.

### CeldaLatente

Extiende CeldaMuerta.
Representa una celda muerta con la capacidad de activarse bajo ciertas condiciones.

### Nuevas Celdas

Si se desea generar un nuevo tipo de Celda esta debe extender la Celda abstracta o 
extender una de las ya existentes. Asi como implementarlas en las Reglas.

---

## Reglas

Definen cómo evoluciona el tablero en cada generación.

### Regla

Interfaz que define el comportamiento que debe implementar cualquier regla del juego.

### ReglaBasica

Implementa las reglas clásicas del Juego de la Vida.

### ReglaEnfermedad

Introduce un comportamiento para las celdas enfermas.

### ReglaLatente

Permite que las celdas latentes se activen bajo ciertas condiciones.

### ReglaCombinacion

Permite combinar múltiples reglas y aplicarlas en orden.
Esto permite extender el juego agregando nuevas reglas sin modificar el resto del sistema.
Para el caso en que se utilice la versión gráfica, las reglas deben ser agregadas o removidas a partir 
del codigo. Aun no se implemento un menú para interactuar

### Extension a más reglas

Si se deseara implementar una nueva regla debe extenderse de la interfaz y generar cada condición.

---

## Tablero

Representa la estructura bidimensional donde se almacenan las celdas.

### Tablero

Mantiene una matriz de celdas y permite:

* acceder a cada celda
* calcular vecinos
* generar la siguiente generación
* detectar estados estables

### TableroCarga

Clase auxiliar encargada de:

* cargar tableros desde archivos
* generar tableros aleatorios

---

## Interfaz gráfica

La interfaz gráfica fue implementada utilizando **JavaFX**.

### JuegoDeLaVida

Clase principal que inicia la aplicación JavaFX.

### JuegoDeLaVidaController

Controlador de la interfaz que gestiona:

* visualización del tablero
* avance de generaciones
* simulación automática
* control de velocidad
* detección de estabilidad

---

## Características implementadas

* Implementación del Juego de la Vida
* Extensión mediante nuevas reglas
* Celdas especiales (enfermas y latentes)
* Simulación por consola
* Interfaz gráfica con JavaFX
* Carga de tableros desde archivo
* Generación de tableros aleatorios
* Detección de estados estables

---

### Documentos, Archivos y Bibliografia utilizada

* https://docs.oracle.com/javase/8/javafx/api/overview-summary.html
* https://www.ra-ma.es/media/rama/files/book-attachment-9912.pdf
* Material otorgado por la cátedra e Programación Orientada a Objetos
* https://playgameoflife.com/ para la corroboración de la implementación de los metodos de simulación y las reglas.

#### Información Adicional: 
* Se utilizó Inteligencia Artificial para la creación el archivo CSS dark-theme asi 
como para la explicación de la documentación de Oracle JavaFX.
* Se utilizo la aplicación Screen Builder para el diseño base de la interfaz gráfica