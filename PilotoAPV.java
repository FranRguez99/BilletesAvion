import java.util.Scanner;

/**
 * Piloto ApoyoPuntoVentas
 *
 * @author Francisco Rodríguez, Antonio Jesús Oliva
 * @version 1.1
 * @since 03-03-2022
 */

public class PilotoAPV {

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t\tPROGRAMA BILLETE AVIÓN");

        Scanner sc = new Scanner(System.in); // Introducción de datos por teclado
        int opcion; // Variable que guarda la opción seleccionada por el usuario
        boolean salir = false;

        while (!salir) {
            // Salida del menú por pantalla
            System.out.println("\n\t\t\tMENÚ");
            System.out.println("\n1.-Transformación fecha suministrada como parámetro");
            System.out.println("2.-Generación de la hora de llegada");
            System.out.println("3.-Generación automatizada de tabla de meses");
            System.out.println("4.-Obtención de los días correspondientes de un mes");
            System.out.println("5.-Recopilación información de un vuelo");
            System.out.println("6.-Salir");
            System.out.print("\nOpción: ");

            // try & catch para controlar la opción introducida por el usuario
            try {
                opcion = Integer.parseInt(sc.next());
                System.out.println();

                switch (opcion) { // Contiene la ejecución de todos los métodos

                    case 1 -> {
                        System.out.println("Se ha recibido como parámetro de ejecucción\n");
                        System.out.println("\nDía: " + args[0] + "\nMes: " + args[1] + "\nAño: " + args[2]);
                        System.out.println("\nEl resultado solicitado de la misma es: " + ApoyoPuntoVenta.fecha(args));
                    }
                    case 2 -> {
                        System.out.print("Hora de despegue (hh:mm): ");
                        String hora = sc.next();
                        System.out.print("Duración (en minutos): ");
                        long minutos = Long.parseLong(sc.next());
                        System.out.println("\nEl resultado solicitado de la misma es: " + ApoyoPuntoVenta.calcularhora(hora, minutos));
                    }
                    case 3 -> {
                        System.out.print("Introduzca el mes en formato numérico: ");
                        int mes = Integer.parseInt(sc.next());
                        System.out.println("\nLa tabla se está genrando...");
                        System.out.println("\nEl resultado solicitado es:");
                        System.out.println(ApoyoPuntoVenta.meses(mes).toString().replace("[", "").replace("]", ""));
                    }
                    case 4 -> {
                        System.out.print("Introduzca el mes en formato cadena: ");
                        String mesCadena = sc.next();
                        System.out.println("\nEl resultado solicitado es: " + ApoyoPuntoVenta.dias_del_mes(mesCadena));
                    }
                    case 5 -> {
                        System.out.print("Origen: ");
                        String origen = sc.next();
                        System.out.print("Destino: ");
                        String destino = sc.next();
                        System.out.println("\nEl resultado solicitado es:");
                        ApoyoPuntoVenta.infoVuelos(origen, destino).forEach(System.out::println);
                    }
                    case 6 -> salir = true;
                }
            } catch (Exception e) {
                System.out.println("\tDebes teclear un número entero");
            }

        }


    }

}
