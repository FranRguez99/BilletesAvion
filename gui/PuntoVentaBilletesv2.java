import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;


public class PuntoVentaBilletesv2 {

    LocalDate fecha_ida;
    LocalDate fecha_vuelta;
    ArrayList<String> mesesEsp;
    final HashMap<String, String> codigosIATA = new HashMap<>(); // todo añadir los valores al diccionario

    public void interfaz() {
        JFrame ventanaPrincipal = new JFrame("Air Carmela");
        ventanaPrincipal.setSize(500, 300);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(new BorderLayout());

        //Crea los paneles
        JPanel pGeneral = new JPanel();
        Border bGeneral = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        pGeneral.setBorder(bGeneral);
        pGeneral.setLayout(new BorderLayout());
        JPanel pPrincipal1 = new JPanel();
        pPrincipal1.setLayout(new BorderLayout());
        JPanel pPrincipal2 = new JPanel();
        pPrincipal2.setLayout(new BorderLayout());

        // PANEL PRINCIPAL 1
        pPrincipal1.setSize(pGeneral.getPreferredSize());
        pPrincipal1.setBorder(new BevelBorder(BevelBorder.LOWERED));

        // Sección Titulo
        JPanel pTitulo = new JPanel();
        pTitulo.setBorder(new BevelBorder(BevelBorder.RAISED));
        pTitulo.setAlignmentX(0);
        JLabel lTitulo = new JLabel("PUNTO DE VENTA DE BILLETES");
        lTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
        pTitulo.add(lTitulo);

        // Sección Detalles
        // Crea los paneles
        JPanel pFecha = new JPanel(); // Panel Fecha
        pFecha.setLayout(new GridLayout(0, 1));
        JPanel pModalidad = new JPanel(); // Panel Modalidad
        Border bModalidadInterior = BorderFactory.createEmptyBorder(0, 80, 0, 80);
        Border bModalidadExterior = BorderFactory.createTitledBorder(null, "Modalidad", TitledBorder.CENTER, TitledBorder.TOP);
        Border bModalidad = BorderFactory.createCompoundBorder(bModalidadExterior, bModalidadInterior);
        pModalidad.setBorder(bModalidad);
        JPanel pFechaIda = new JPanel(); // Panel Fecha Ida
        JPanel pFechaVuelta = new JPanel(); // Panel Ida Vuelta

        // Contenido de los paneles
        // Panel Modalidad
        JRadioButton rbIda = new JRadioButton("Ida sólo");
        JRadioButton rbIdaVuelta = new JRadioButton("Ida/Vuelta");
        ButtonGroup grpIdaVuelta = new ButtonGroup();
        grpIdaVuelta.add(rbIda);
        grpIdaVuelta.add(rbIdaVuelta);
        pModalidad.add(rbIda);
        pModalidad.add(rbIdaVuelta);


        // Panel Ida
        fecha_ida = LocalDate.now();
        mesesEsp = listaMeses();
        JSpinner sDiaIda = new JSpinner();
        JSpinner sMesIda = new JSpinner();
        JSpinner sAnioIda = new JSpinner();
        spinnerFecha(pFechaIda, sDiaIda, sMesIda, sAnioIda);
        TitledBorder bordeMIda = BorderFactory.createTitledBorder("Fecha ida");
        pFechaIda.setBorder(bordeMIda);

        // Panel Vuelta
        fecha_vuelta = LocalDate.now();
        JSpinner sDiaVuelta = new JSpinner();
        JSpinner sMesVuelta = new JSpinner();
        JSpinner sAnioVuelta = new JSpinner();
        spinnerFecha(pFechaVuelta, sDiaVuelta, sMesVuelta, sAnioVuelta);
        TitledBorder bordeVuelta = BorderFactory.createTitledBorder("Fecha vuelta");
        pFechaVuelta.setBorder(bordeVuelta);

        // Panel Fecha
        pFecha.add(pModalidad);
        pFecha.add(pFechaIda);
        pFecha.add(pFechaVuelta);

        // Sección Trayecto
        // Crea los paneles
        JPanel pTrayecto = new JPanel(); // Panel Trayecto
        Border trayectoInterior = BorderFactory.createEmptyBorder(0, 50, 0, 50);
        Border trayectoExterior = BorderFactory.createTitledBorder(null, "Trayecto", TitledBorder.CENTER, TitledBorder.TOP);
        Border bTrayecto = BorderFactory.createCompoundBorder(trayectoExterior, trayectoInterior);
        pTrayecto.setBorder(bTrayecto);
        pTrayecto.setLayout(new BorderLayout());
        JPanel pOrigen = new JPanel(); // Panel Origen
        pOrigen.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel pDestino = new JPanel(); // Panel Destino
        pDestino.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel pPersonas = new JPanel(); // Panel Personas
        pPersonas.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Contenido de los paneles
        // Panel Origen
        JLabel lOrigen = new JLabel("Origen: ");
        JComboBox<String> cbOrigen = crearCaja();
        cbOrigen.setSize(300, 300);
        pOrigen.add(lOrigen);
        pOrigen.add(cbOrigen);

        // Panel Destino
        JLabel lDestino = new JLabel("Destino: ");
        JComboBox<String> cbDestino = crearCaja();
        pDestino.add(lDestino);
        pDestino.add(cbDestino);

        // Panel Personas
        JLabel lPersonas = new JLabel("Nº Personas:");
        JSpinner sPersonas = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        JButton bPersonas = new JButton("Buscar");
        pPersonas.add(lPersonas);
        pPersonas.add(sPersonas);
        pPersonas.add(bPersonas);

        // Panel Trayecto
        pTrayecto.add(pOrigen, BorderLayout.NORTH);
        pTrayecto.add(pDestino, BorderLayout.CENTER);
        pTrayecto.add(pPersonas, BorderLayout.SOUTH);

        // Añadir elementos al panel principal
        pPrincipal1.add(pTitulo, BorderLayout.NORTH);
        pPrincipal1.add(pFecha, BorderLayout.WEST);
        pPrincipal1.add(pTrayecto, BorderLayout.EAST);
        pPrincipal1.setVisible(true);

        // PANEL PRINCIPAL 2
        pPrincipal2.setSize(pGeneral.getPreferredSize());
        pPrincipal2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pPrincipal2.setLayout(new BorderLayout());

        // Sección título
        JPanel pTitulo2=new JPanel();
        JLabel lTitulo2=new JLabel("LOS VUELOS DISPONIBLES SON:");
        pTitulo2.add(lTitulo2);

        // Sección vuelos ida
        JPanel pIdaDisponible=new JPanel();
        pIdaDisponible.setBorder(creaBorde("Ida"));
        JRadioButton rbIda1= new JRadioButton();
        JRadioButton rbIda2 = new JRadioButton();
        ButtonGroup grpVuelosIda = new ButtonGroup();
        grpVuelosIda.add(rbIda1);
        grpVuelosIda.add(rbIda2);
        Box boxIda = Box.createVerticalBox();
        boxIda.add(rbIda1,BorderLayout.NORTH);
        boxIda.add(rbIda2,BorderLayout.SOUTH);
        pIdaDisponible.setLayout(new BorderLayout());
        pIdaDisponible.add(boxIda);

        // Sección vuelos vuelta
        JPanel pVueltaDisponible=new JPanel();
        pVueltaDisponible.setBorder(creaBorde("Vuelta"));
        JRadioButton rbVuelta1 = new JRadioButton();
        JRadioButton rbVuelta2 = new JRadioButton();
        ButtonGroup grpVuelosVuelta = new ButtonGroup();
        grpVuelosVuelta.add(rbVuelta1);
        grpVuelosVuelta.add(rbVuelta2);
        Box boxVuelta = Box.createVerticalBox();
        boxVuelta.add(rbVuelta1,BorderLayout.NORTH);
        boxVuelta.add(rbVuelta2,BorderLayout.SOUTH);
        pVueltaDisponible.setLayout(new BorderLayout());
        pVueltaDisponible.add(boxVuelta);

        //tamaños
        pVueltaDisponible.setPreferredSize(new Dimension(365,100));
        pIdaDisponible.setPreferredSize(new Dimension(365,100));

        // Sección confirmar
        JPanel pConfirmar=new JPanel();
        JButton bConfirmar=new JButton("Confirmar Elecciones");
        bConfirmar.setPreferredSize(new Dimension(180,30));
        pConfirmar.add(bConfirmar);

        // Añadir elementos al panel principal
        pPrincipal2.add(pTitulo2,BorderLayout.NORTH);
        pPrincipal2.add(pIdaDisponible,BorderLayout.WEST);
        pPrincipal2.add(pConfirmar,BorderLayout.SOUTH);

        // PANEL PRINCIPAL 3
        JPanel pPrincipal3 = new JPanel();
        pPrincipal3.setSize(new Dimension(700,300));
        pPrincipal3.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pPrincipal3.setLayout(new BorderLayout());
        pPrincipal3.setSize(pGeneral.getPreferredSize());

        // Sección detalles
        // Panel asiento
        JPanel pAsiento = new JPanel();
        JPanel pValorAsiento = new JPanel();
        JSlider sAsientos = new JSlider(JSlider.HORIZONTAL, 1, 26, 5);
        sAsientos.setPaintTrack(true);
        sAsientos.setPaintTicks(true);
        sAsientos.setPaintLabels(true);
        sAsientos.setMinorTickSpacing(1);
        sAsientos.setMajorTickSpacing(5);
        JLabel lFilas = new JLabel("Filas:");
        JLabel lValorSlider = new JLabel(String.valueOf(sAsientos.getValue()));
        Border asientoExterior = BorderFactory.createTitledBorder(null, "Asientos", TitledBorder.LEFT, TitledBorder.TOP);
        pAsiento.setBorder(asientoExterior);
        pValorAsiento.add(lFilas);
        pValorAsiento.add(lValorSlider);
        pAsiento.setLayout(new BorderLayout());
        pAsiento.add(pValorAsiento, BorderLayout.NORTH);
        pAsiento.add(sAsientos, BorderLayout.CENTER);
        sAsientos.setPreferredSize(new Dimension(152,80));

        // Panel posición
        JPanel pPosicion = new JPanel();
        Border posicionExterior = BorderFactory.createTitledBorder(null, "Posición", TitledBorder.LEFT, TitledBorder.TOP);
        pPosicion.setBorder(posicionExterior);
        JRadioButton rPasillo = new JRadioButton("Pasillo");
        JRadioButton rCentro = new JRadioButton("Centro");
        JRadioButton rVentana = new JRadioButton("Ventana");
        ButtonGroup grpPosicion = new ButtonGroup();
        grpPosicion.add(rPasillo);
        grpPosicion.add(rCentro);
        grpPosicion.add(rVentana);
        pPosicion.add(rPasillo);
        pPosicion.add(rCentro);
        pPosicion.add(rVentana);


        // Panel Extras
        JPanel pExtras = new JPanel();
        pExtras.setBorder(creaBorde("Extras"));
        JCheckBox chEmbarque = new JCheckBox("Embarque Prior. ");
        JCheckBox chEquipaje = new JCheckBox("Equipaje");
        pExtras.add(chEmbarque);
        pExtras.add(chEquipaje);

        // Panel detalles
        JPanel pDetalles = new JPanel();
        Border exInterior = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        Border exExterior = BorderFactory.createTitledBorder(null, "Detalles", TitledBorder.CENTER, TitledBorder.TOP);
        Border bExtras = BorderFactory.createCompoundBorder(exExterior, exInterior);
        pDetalles.setBorder(bExtras);
        pDetalles.setLayout(new BorderLayout());
        pDetalles.setSize(new Dimension(300,60));
        pAsiento.setPreferredSize(new Dimension(240,90));
        pPosicion.setPreferredSize(new Dimension(240,60));
        pExtras.setPreferredSize(new Dimension(240,60));



        pDetalles.add(pAsiento, BorderLayout.NORTH);
        pDetalles.add(pPosicion, BorderLayout.CENTER);
        pDetalles.add(pExtras, BorderLayout.SOUTH);



        // Sección Precio Billete
        // Panel importes
        JPanel pImportes = new JPanel();
        pImportes.setLayout(new BorderLayout());
        pImportes.setBorder(creaBorde("Importes"));
        pImportes.setSize(new Dimension(400,90));

        // Precios superiores
        //Asiento
        JLabel lAsiento = new JLabel("Asiento:");
        JTextField tfAsiento = new JTextField(6);
        tfAsiento.setHorizontalAlignment(JTextField.LEFT);
        lAsiento.add(tfAsiento);
        // Embarque
        JLabel lEmbarque = new JLabel("Embarque: ");
        JTextField tfEmbarque = new JTextField(6);
        tfEmbarque.setHorizontalAlignment(JTextField.LEFT);
        lEmbarque.add(tfEmbarque);
        // Equipaje
        JLabel lEquipaje = new JLabel("Equipaje: ");
        JTextField tfEquipaje = new JTextField(6);
        tfEquipaje.setHorizontalAlignment(JTextField.LEFT);
        lEquipaje.add(tfEquipaje);

        // Precio Final
        JPanel pPrecioFinal = new JPanel();
        JLabel lPrecioFinal = new JLabel("Precio Final:");
        JTextField tfPrecioFinal = new JTextField(8);
        lPrecioFinal.setFont(new Font("Verdana",Font.BOLD,18));
        pPrecioFinal.add(lPrecioFinal);
        pPrecioFinal.add(tfPrecioFinal);

        //Panel precios
        JPanel pPrecios = new JPanel();
        pPrecios.add(lAsiento);
        pPrecios.add(tfAsiento);
        pPrecios.add(lEmbarque);
        pPrecios.add(tfEmbarque);
        pPrecios.add(lEquipaje);
        pPrecios.add(tfEquipaje);
        JPanel pPreciosCompleto = new JPanel();
        pPreciosCompleto.setLayout(new BorderLayout());
        pPreciosCompleto.setPreferredSize(new Dimension(400, 120));
        pPreciosCompleto.add(pPrecios, BorderLayout.NORTH);
        pPreciosCompleto.add(pPrecioFinal, BorderLayout.SOUTH);

        // Panel botones
        JPanel pBotones = new JPanel();
        pBotones.setLayout(new GridLayout(2,1));
        Border modalidadInterior3 =new EtchedBorder(EtchedBorder.LOWERED);
        Border modalidadInterior2 = BorderFactory.createEmptyBorder(8, 8, 8, 8);
        Border bPosicion2 = BorderFactory.createCompoundBorder(modalidadInterior2,modalidadInterior3);
        pBotones.setBorder(bPosicion2);
        // Aceptar
        Icon aceptar = new ImageIcon("C:\\Users\\usuario\\IdeaProjects\\TrabajoGrupal2T\\src\\img\\valBot.png");
        JButton bAceptar = new JButton(aceptar);
        pBotones.add(bAceptar);
        // Cancelar
        Icon cancelar = new ImageIcon("C:\\Users\\usuario\\IdeaProjects\\TrabajoGrupal2T\\src\\img\\canBot.png");
        JButton bCancelar = new JButton(cancelar);
        pBotones.add(bCancelar);


        pBotones.setPreferredSize(new Dimension(70, 3));

        // Añadimos componentes a los paneles
        pImportes.setPreferredSize(new Dimension(500, 100));
        pImportes.add(pPreciosCompleto, BorderLayout.WEST);
        pImportes.add(pBotones, BorderLayout.EAST);

        // Panel Billete
        JPanel pBillete = new JPanel();
        pBillete.setBorder(creaBorde("Billete"));
        ImageIcon iBillete=new ImageIcon("C:\\Users\\aj_ic\\OneDrive\\Escritorio\\BilletesAvion-main (1)\\BilletesAvion-main\\consola\\ico_bill_av_iv (1).png");
        JLabel lImagen=new JLabel(iBillete);
        lImagen.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pBillete.add(lImagen);

        // Añadimos los componentes al panel final
        JPanel pPrecioBillete = new JPanel();
        pPrecioBillete.setLayout(new BorderLayout());
        pPrecioBillete.add(pImportes, BorderLayout.NORTH);
        pPrecioBillete.add(pBillete, BorderLayout.SOUTH);

        // Añadir elementos al panel principal
        pPrincipal3.add(pDetalles,BorderLayout.WEST);
        pPrincipal3.add(pPrecioBillete,BorderLayout.EAST);

        // Funciones
        // PANEL PRINCIPAL 1
        // Fechas
        /* todo Completar cambio de fecha automático
        sDiaIda.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    fecha_ida = fecha_ida.withDayOfMonth((Integer) sDiaIda.getValue()).withMonth(numeroMes((String) sMesIda.getValue()))
                            .withYear((Integer) sAnioIda.getValue());
                } catch (Exception exc){

                }

            }
        }); */
        sDiaIda.addChangeListener(e -> sDiaVuelta.setValue(sDiaIda.getValue()));
        sMesIda.addChangeListener(e -> sMesVuelta.setValue(sMesIda.getValue()));
        sAnioIda.addChangeListener(e -> sAnioVuelta.setValue(sAnioIda.getValue()));
        // Comprobación
        bPersonas.addActionListener(e -> {
            if ((rbIda.isSelected() || rbIdaVuelta.isSelected()) && // Comprobamos que estén todos los datos introducidos
                    (!Objects.equals(cbOrigen.getSelectedItem(), "---------") && !Objects.equals(cbDestino.getSelectedItem(), "---------"))) {
                String mensaje = "Ida: " + cadenaVuelo(cbOrigen.getSelectedItem(), cbDestino.getSelectedItem(),
                        sDiaIda.getValue(), sMesIda.getValue(), sAnioIda.getValue());
                if (rbIdaVuelta.isSelected()) {
                    mensaje = mensaje + "\nVuelta: " + cadenaVuelo(cbDestino.getSelectedItem(), cbOrigen.getSelectedItem(),
                            sDiaIda.getValue(), sMesIda.getValue(), sAnioIda.getValue());
                }
                mensaje = mensaje + "\n(" + sPersonas.getValue() + " personas)";
                int confirmado = JOptionPane.showConfirmDialog(pPrincipal1, mensaje, "Seleccionar ona Opción", JOptionPane.YES_NO_CANCEL_OPTION);

                if (confirmado == 0) {
                    ArrayList<String> vuelosIda = infoVuelos((String) cbOrigen.getSelectedItem(), (String) cbDestino.getSelectedItem());
                    rbIda1.setText(vuelosIda.get(0));
                    rbIda2.setText(vuelosIda.get(1));
                    if (rbIdaVuelta.isSelected()){
                        ArrayList<String> vuelosVuelta = infoVuelos((String) cbDestino.getSelectedItem(), (String) cbOrigen.getSelectedItem());
                        rbVuelta1.setText(vuelosVuelta.get(0));
                        rbVuelta2.setText(vuelosVuelta.get(1));
                        pPrincipal2.add(pVueltaDisponible,BorderLayout.EAST);
                    }
                    pGeneral.add(pPrincipal2, BorderLayout.CENTER);
                    ventanaPrincipal.pack();
                }
            }
        });

        // PANEL PRINCIPAL 2
        bConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pGeneral.add(pPrincipal3, BorderLayout.SOUTH);
                ventanaPrincipal.pack();
            }
        });
        // PANEL PRINCIPAL 3
        sAsientos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sAsientos.getValueIsAdjusting()) {
                    lValorSlider.setText(String.valueOf(sAsientos.getValue()));
                }
            }
        });

        // Añadir paneles al marco
        pGeneral.add(pPrincipal1, BorderLayout.NORTH);
        ventanaPrincipal.add(pGeneral);
        ventanaPrincipal.pack();
        ventanaPrincipal.setVisible(true);
    }

    // Métodos de la clase

    /**
     * Toma un panel y le añade spinners con la fecha
     *
     * @param panel panel que va a ser cambiado
     */
    private void spinnerFecha(JPanel panel, JSpinner dia, JSpinner mes, JSpinner anio) {
        panel.setLayout(new FlowLayout());
        // Creamos el contenido del panel
        JLabel lDia = new JLabel("Día");
        dia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        dia.setValue(fecha_ida.getDayOfMonth());
        JLabel lMes = new JLabel("Mes");
        mes.setModel(new SpinnerListModel(mesesEsp));
        mes.setValue(fecha_ida.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"))
                .toUpperCase(Locale.ROOT).charAt(0) + fecha_ida.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"))
                .substring(1));
        mes.setPreferredSize(new Dimension(88, 20));
        JLabel lAnio = new JLabel("Año");
        anio.setModel(new SpinnerNumberModel(2022, 1980, 2024, 1));
        anio.setValue(fecha_ida.getYear());
        // Añadimos el contenido al panel
        panel.add(lDia);
        panel.add(dia);
        panel.add(lMes);
        panel.add(mes);
        panel.add(lAnio);
        panel.add(anio);
    }

    /**
     * Crea una JComboBox con los aeropuertos disponibles
     *
     * @return la JComboBox con los datos introducidos
     */
    private JComboBox<String> crearCaja() {
        JComboBox<String> res = new JComboBox<>();
        res.addItem("---------");
        res.addItem("Sevilla");
        res.addItem("Madrid");
        res.addItem("Barcelona");
        res.addItem("Valencia");
        res.addItem("Bilbao");
        res.addItem("Málaga");
        res.addItem("A Coruña");
        res.addItem("Santander");
        res.addItem("Asturias");
        return res;
    }

    /**
     * Creación de una lista con los meses en español
     *
     * @return la lista de meses
     */
    public ArrayList<String> listaMeses() {
        Month[] meses = Month.values();
        ArrayList<String> res = new ArrayList<>();
        Arrays.stream(meses).forEach(m -> res.add(m.getDisplayName(TextStyle.FULL, new Locale("es", "ES"))
                .toUpperCase(Locale.ROOT).charAt(0) + m.getDisplayName(TextStyle.FULL, new Locale("es", "ES"))
                .substring(1)));
        return res;
    }

    /**
     * Crea un borde para un panel
     * @param title título del borde
     * @return el borde resultante
     */
    public Border creaBorde(String title){
        Border ImporteInterior = BorderFactory.createEmptyBorder(0, 5, 0, 0);
        Border ImporteExterior = BorderFactory.createTitledBorder(null, title, TitledBorder.LEFT, TitledBorder.TOP);
        return BorderFactory.createCompoundBorder(ImporteExterior, ImporteInterior);
    }

    /**
     * Devuelve el valor numérico de un mes introducido
     * como cadena de texto
     *
     * @param mes el mes introducido
     * @return número del mes
     */
    public int numeroMes(String mes) {
        return Month.of(mesesEsp.indexOf(mes) + 1).getValue();
    }

    /**
     * Genera cadena con la información del vuelo
     *
     * @param origen  lugar de origen
     * @param destino lugar de destino
     * @param dia     dia del vuelo
     * @param mes     mes del vuelo
     * @param anio    año del vuelo
     * @return cadena con el formato deseado
     */
    public String cadenaVuelo(Object origen, Object destino, Object dia, Object mes, Object anio) {
        return String.format("%s/%s %s-%s-%s", origen, destino, dia, mes, anio);
    }

    /**
     * Recibe 2 ciudades y devuelve los vuelos disponibles
     * entre ella, sus horarios y sus precios
     *
     * @param origen  ciudad de origen
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
        ArrayList<String>[] vuelosSVQ = new ArrayList[6];
        vuelosSVQ[0] = new ArrayList<String>(Arrays.asList("MAD", "08:25", "21:00", "60"));
        vuelosSVQ[1] = new ArrayList<String>(Arrays.asList("BCN", "07:45", "18:55", "90"));
        vuelosSVQ[2] = new ArrayList<String>(Arrays.asList("VLC", "07:45", "15:15", "70"));
        vuelosSVQ[3] = new ArrayList<String>(Arrays.asList("BIO", "08:55", "20:15", "85"));
        vuelosSVQ[4] = new ArrayList<String>(Arrays.asList("AGP", "10:10", "15:30", "55"));
        vuelosSVQ[5] = new ArrayList<String>(Arrays.asList("BIO", "8:55", "20:15", "75"));

        ArrayList<String>[] vuelosMAD = new ArrayList[3];
        vuelosMAD[0] = new ArrayList<String>(Arrays.asList("BCN", "10:25", "17:00", "70"));
        vuelosMAD[1] = new ArrayList<String>(Arrays.asList("VLC", "12:00", "16:15", "45"));
        vuelosMAD[2] = new ArrayList<String>(Arrays.asList("SVQ", "10:45", "18:30", "60"));

        ArrayList<String>[] vuelosBCN = new ArrayList[3];
        vuelosBCN[0] = new ArrayList<String>(Arrays.asList("MAD", "12:30", "19:00", "70"));
        vuelosBCN[1] = new ArrayList<String>(Arrays.asList("VLC", "10:30", "17:25", "60"));
        vuelosBCN[2] = new ArrayList<String>(Arrays.asList("SVQ", "08:45", "20:15", "90"));

        // Diccionario con los aeropuertos y sus vuelos disponibles
        HashMap<String, ArrayList[]> aeropuertos = new HashMap<>();
        aeropuertos.put("SVQ", vuelosSVQ);
        aeropuertos.put("MAD", vuelosMAD);
        aeropuertos.put("BCN", vuelosBCN);

        //Generación de las cadenas a devolver
        String oIATA = codigosIATA.get(origen);
        String dIATA = codigosIATA.get(destino);
        ArrayList<String>[] vuelos = aeropuertos.get(oIATA);

        // Recorremos la lista de ArrayList<String> hasta encontrar el destino
        ArrayList<String> vuelosDestino = Arrays.stream(vuelos).filter(lista -> lista.get(0).equals(dIATA))
                .collect(Collectors.toCollection(ArrayList::new)).iterator().next();

        // Sublista solo con las horas de los vuelos
        ArrayList<String> horas = vuelosDestino.subList(1, vuelosDestino.size() - 1).stream()
                .collect((Collectors.toCollection(ArrayList::new)));

        // Generación de las cadenas a imprimir
        Random r = new Random();
        horas.forEach(h -> res.add(oIATA + "-" + dIATA + " " + h + " " + LocalTime.parse(h)
                .plusMinutes(Long.parseLong(vuelosDestino.get(vuelosDestino.size() - 1)))
                .toString() + " " + String.format("%.2f", r.nextDouble(35.00, 60.00)) +
                Currency.getInstance("EUR").getSymbol()));

        return res;
    }

}