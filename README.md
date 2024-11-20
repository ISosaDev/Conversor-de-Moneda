# Conversor-de-Moneda

Este proyecto es una aplicación Java que permite convertir diferentes monedas utilizando tasas de cambio obtenidas desde la API ExchangeRate-API. Los usuarios pueden seleccionar entre varias opciones de conversión y los resultados se registran en un archivo de texto para futuras referencias.

Características:

Interfaz interactiva: Proporciona un menú para seleccionar el tipo de conversión de moneda.
Monedas soportadas:
Dólar estadounidense (USD)
Peso argentino (ARS)
Real brasileño (BRL)
Peso colombiano (COP)
Consulta en tiempo real: Las tasas de cambio se obtienen en tiempo real desde la API ExchangeRate-API.
Registro persistente: Las consultas realizadas se guardan en un archivo consultas.txt.
Manejo de errores: Validación de entradas del usuario y manejo de excepciones para garantizar la estabilidad del programa.

Requisitos:

Java Development Kit (JDK) 17 o superior.
Conexión a Internet para consultar las tasas de cambio en la API.
Dependencias externas:
Gson: Biblioteca para manejar datos en formato JSON.

Uso del Programa:

Al iniciar, el programa muestra un menú con las opciones de conversión disponibles.
Selecciona una opción válida (1 a 7).
Ingresa la cantidad a convertir.
Observa el resultado en la consola. Este también se registrará en el archivo consultas.txt.
Para finalizar, selecciona la opción 7 (Salir).

Autor
ISosaDev
