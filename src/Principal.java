import com.isosadev.conversordemoneda.consultas.ConsultaDivisas;
import com.isosadev.conversordemoneda.consultas.Divisa;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String fechaHoraFormateada = fechaHoraActual.format(formatter);
        Scanner scanner = new Scanner(System.in);
        String base_code = "";
        String target_code = "";
        //com.isosadev.conversordemoneda.consultas.ConsultaDivisas consulta = new com.isosadev.conversordemoneda.consultas.ConsultaDivisas();

        try (FileWriter escritura = new FileWriter("consultas.txt", true)){

            while (true) {
                // Menú interactivo
                System.out.println("\n******** Bienvenido al Conversor de Divisas **********\n");
                System.out.println("1. Convertir Dólar a Peso Argentino");
                System.out.println("2. Convertir Peso Argentino a Dólar");
                System.out.println("3. Convertir Dólar a Real Brasileño");
                System.out.println("4. Convertir Real Brasileño a Dólar");
                System.out.println("5. Convertir Dólar a Peso Colombiano");
                System.out.println("6. Convertir Peso Colombiano a Dólar");
                System.out.println("7. Salir");
                System.out.print("""
                    Seleccione una opción válida:
                     *********************************************
                    """);

                int opcion = 0;

                while (opcion < 1 || opcion > 7) {
                    if (scanner.hasNextInt()) {
                        opcion = scanner.nextInt();
                        if (opcion < 1 || opcion > 7) {
                            System.out.println("Opción inválida. Por favor ingrese un número " +
                                    "de las opciones del menu.");
                        }
                    } else {
                        System.out.println("Opción inválida. Por favor ingrese un número " +
                                "de las opciones del menu.");
                        scanner.next();
                    }
                }

                if (opcion == 7) {
                    System.out.println("""
                        ******* Gracias por utilizar nuestro conversor. ******
                        ******* Esperamos que vuelva pronto.   ****************
                        ******* Programa finalizado con éxito  *************
                        """);
                    break;
                }

                // Solicitar el valor a convertir
                System.out.print("Ingrese la cantidad a convertir:\n" +
                        " ");
                double cantidadDeCambio = scanner.nextDouble();


                // Asignar los pares de monedas según la opción seleccionada
                switch (opcion) {
                    case 1 -> {
                        base_code = "USD";
                        target_code = "ARS";
                    }
                    case 2 -> {
                        base_code = "ARS";
                        target_code = "USD";
                    }
                    case 3 -> {
                        base_code = "USD";
                        target_code = "BRL";
                    }
                    case 4 -> {
                        base_code = "BRL";
                        target_code = "USD";

                    }
                    case 5 -> {
                        base_code = "USD";
                        target_code = "COP";

                    }
                    case 6 -> {
                        base_code = "COP";
                        target_code = "USD";

                    }
                    default -> {
                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                        continue;
                    }
                }

                ConsultaDivisas consulta  = new ConsultaDivisas();
                Divisa divisa = consulta.busquedaDivisa(base_code, target_code, cantidadDeCambio);

                // Formatear la salida de la consulta
                String resultadoConsulta = "\nEl valor ingresado: " + cantidadDeCambio + " " + divisa +
                        "\nConsulta realizada el día: " + fechaHoraActual.format(formatter) +
                        "\n*****************************************************\n"+
                        "                                                         ";

                // Mostrar resultado en consola
                System.out.println(resultadoConsulta);

                // Escribir la consulta en el archivo
                escritura.write(resultadoConsulta);


            }


        } catch (RuntimeException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }


    }
}
