import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class ApoyoPuntoVenta {

    /**
     * Obtiene una fecha como parámetros y cambia el formato de la
     * misma para imprimirla por pantalla
     *
     * @param  args  argumentos del programa
     * @return una cadena con la fecha en el formato deseado
     */
    public static String fecha(String[] args) {
        int dia = Integer.parseInt(args[0]); // Lo guardamos como int para eliminar el '0' delante de los días de un solo dígito
        // Usamos la clase month para obtener el nombre del mes
        String mes = Month.of(Integer.parseInt(args[1])).getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        return String.format("%d-%s-%s", dia, mes.substring(0, 1).toUpperCase() + mes.substring(1), args[2]);
    }

    /**
     * Obtiene un despegue y una duración y devuelve la hora de llegada
     *
     * @param despegue hora de despegue del vuelo
     * @param duracion duración del vuelo
     * @return hora de aterrizaje
     */
    public static LocalTime calcularhora(String despegue, long duracion) {
        LocalTime hora = LocalTime.parse(despegue);
        return hora.plusMinutes(duracion);
    }

    /**
     * Método en el cual el usuario introduce un mes en formato
     * numérico y devuelve una lista de meses empezando por
     * el indicado
     *
     * @param mesIntroducido mes por el cual empieza la tabla
     * @return tabla con los meses en el orden deseado
     */
    public static ArrayList<String> meses(int mesIntroducido) {
        int mesActual = mesIntroducido;
        ArrayList<String> res = new ArrayList<String>();
        for (int contador = 1; contador <= 12; contador++) {
            String mes = Month.of(mesActual).getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            mesActual++; // Usamos la clase month para obtener el nombre del mes
            if (mesActual > 12) {
                mesActual = 1;
            }
            String letrasMayusculas = mes.toUpperCase(Locale.ROOT).substring(0, 1);
            String letrasMinusculas = mes.substring(1);
            String total = letrasMayusculas + letrasMinusculas;
            res.add(total);
        }
        return res;
    }

    /**
     * Método que devuelve los días de un mes
     * introducido como cadena
     * @param mes cadena con el nombre del mes
     * @return número de dias del mes
     */
    public static int dias_del_mes(String mes) {
        ArrayList<String> listaMeses = new ArrayList<String>(
                Arrays.asList("enero", "febrero", "marzo", "abril", "mayo", "junio",
                        "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"));
        return Month.of(listaMeses.indexOf(mes.toLowerCase()) + 1).length(bisiesto());
    }

    /**
     * Comprueba si un año es bisiesto
     * @return true o false según si el año es o no bisiesto
     */
    public static boolean bisiesto() {
        return LocalDate.now().getYear() % 4 == 0 || LocalDate.now().getYear() % 400 == 0;
    }

    /**
     * Recibe 2 ciudades y devuelve los vuelos disponibles
     * entre ella, sus horarios y sus precios
     *
     * @param origen ciudad de origen
     * @param destino ciudad de destino
     * @return lista con ambas cadenas de los vuelos
     */
    public static ArrayList<String> infoVuelos(String origen, String destino) {
        // Inicialización de la tabla resultado que devolveremos al final del método
        ArrayList<String> res = new ArrayList<>();

        // Diccionario con las ciudades y sus diferentes códigos IATA
        HashMap<String, String> codigosIATA = new HashMap<>();
        codigosIATA.put("Sevilla", "SVQ");
        codigosIATA.put("Madrid", "MAD");
        codigosIATA.put("Barcelona", "BCN");
        codigosIATA.put("Valencia", " VLC");
        codigosIATA.put("Bilbao", "BIO");
        codigosIATA.put("Málaga", "AGP");
        codigosIATA.put("A Coruña", "LCG");
        codigosIATA.put("Santander", "SDR");
        codigosIATA.put("Asturias", "OVD");

        // Vuelos disponibles en cada aeropuerto
        ArrayList<String>[] vuelosSVQ = new ArrayList[8];
        vuelosSVQ[0] = new ArrayList<String>(Arrays.asList("MAD", "08:25", "21:00", "60"));
        vuelosSVQ[1] = new ArrayList<String>(Arrays.asList("BCN", "07:45", "18:55", "90"));
        vuelosSVQ[2] = new ArrayList<String>(Arrays.asList("VLC", "7:45", "15:15", "70"));
        vuelosSVQ[3] = new ArrayList<String>(Arrays.asList("BIO", "08:55", "20:15", "85"));
        vuelosSVQ[4] = new ArrayList<String>(Arrays.asList("AGP", "10:10", "15:30", "85"));
        vuelosSVQ[5] = new ArrayList<String>(Arrays.asList("BIO", "08:55", "20:15", "85"));

        // Diccionario con los aeropuertos y sus vuelos disponibles
        HashMap<String, ArrayList[]> aeropuertos = new HashMap<>();
        aeropuertos.put("SVQ", vuelosSVQ);

        //Generación de las cadenas a devolver
        String oIATA = codigosIATA.get(origen);
        String dIATA = codigosIATA.get(destino);
        ArrayList<String>[] vuelos = aeropuertos.get(oIATA);

        // Recorremos la lista de ArrayList<String> hasta encontrar el destino
        ArrayList<String> vuelosDestino = Arrays.stream(vuelos).filter(lista -> lista.get(0).equals(dIATA))
                .collect(Collectors.toCollection(ArrayList::new)).iterator().next();

        // Sublista solo con las horas de los vuelos
        ArrayList<String> horas = vuelosDestino.subList(1, vuelosDestino.size() - 1).stream().collect((Collectors.toCollection(ArrayList::new)));

        // Generación de las cadenas a imprimir
        Random r = new Random();
        horas.forEach(h -> res.add(origen + "(" + oIATA + ") → " + destino + "(" + dIATA + ")\t" + h.toString() + "  " +
                LocalTime.parse(h).plusMinutes(Long.parseLong(vuelosDestino.get(vuelosDestino.size() - 1))).toString() + "\t" +
                String.format("%.2f", r.nextDouble(35.00, 60.00)) + "€"));

        return res;
    }

}
