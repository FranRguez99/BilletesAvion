package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PuntoVentaBilletes {

    public void interfaz() {
        JFrame ventanaPrincipal = new JFrame("Air Carmela");
        ventanaPrincipal.setSize(700, 250);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(new BorderLayout());

        //Crea los paneles
        JPanel pGeneral = new JPanel();
        Border bGeneral = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        pGeneral.setBorder(bGeneral);
        JPanel pPrincipal1 = new JPanel();
        pPrincipal1.setLayout(new BorderLayout());

        // PANEL PRINCIPAL 1

        // Sección Titulo
        JPanel pTitulo = new JPanel();
        pTitulo.setAlignmentX(0);
        JLabel etiVentaBilletes = new JLabel("PUNTO DE VENTA DE BILLETES");
        pTitulo.add(etiVentaBilletes);

        // Sección Detalles
        // Crea los paneles
        JPanel pDetalles = new JPanel(); // Panel Detalles
        GridLayout experimentLayout = new GridLayout(0, 1);
        pDetalles.setLayout(experimentLayout);
        JPanel pModalidad = new JPanel(); // Panel Modalidad
        Border modalidadInterior = BorderFactory.createEmptyBorder(0, 80, 0, 80);
        Border modalidadExterior = BorderFactory.createTitledBorder(null, "Modalidad", TitledBorder.CENTER, TitledBorder.TOP);
        Border bModalidad = BorderFactory.createCompoundBorder(modalidadExterior, modalidadInterior);
        pModalidad.setBorder(bModalidad);
        JPanel pFechaIda = new JPanel(); // Panel Fecha Ida
        JPanel pFechaVuelta = new JPanel(); // Panel Ida Vuelta

        // Contenido de los paneles
        // Panel Modalidad
        JRadioButton rbIda = new JRadioButton("Ida sólo");
        JRadioButton rbIdaVuelta = new JRadioButton("Ida/Vuelta");
        pModalidad.add(rbIda);
        pModalidad.add(rbIdaVuelta);

        // Panel Ida

        spinnerFecha(pFechaIda);
        TitledBorder bordeMIda = BorderFactory.createTitledBorder("Fecha ida");
        pFechaIda.setBorder(bordeMIda);

        // Panel Vuelta
        spinnerFecha(pFechaVuelta);
        TitledBorder bordeVuelta = BorderFactory.createTitledBorder("Fecha vuelta");
        pFechaVuelta.setBorder(bordeVuelta);

        // Panel Detalles
        pDetalles.add(pModalidad);
        pDetalles.add(pFechaIda);
        pDetalles.add(pFechaVuelta);

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

        // Añade elementos a los paneles principales
        pPrincipal1.add(pTitulo, BorderLayout.NORTH);
        pPrincipal1.add(pDetalles, BorderLayout.WEST);
        pPrincipal1.add(pTrayecto, BorderLayout.EAST);
        pPrincipal1.setVisible(true);

        // Funciones del PANEL PRINCIPAL 1
        ActionListener confirmaFecha = e -> {
            /* boolean confirmado = JOptionPane.showConfirmDialog(); */
        };

        // Añadir paneles al marco
        pGeneral.add(pPrincipal1);
        ventanaPrincipal.add(pGeneral);
        ventanaPrincipal.setVisible(true);
    }

    // Métodos de la clase

    /**
     * Toma un panel y le añade spinners con la fecha
     *
     * @param panel panel que va a ser cambiado
     */
    private void spinnerFecha(JPanel panel) {
        panel.setLayout(new FlowLayout());
        // Creamos el contenido del panel
        JLabel lDia = new JLabel("Día");
        JSpinner sDia = new JSpinner();
        JLabel lMes = new JLabel("Mes");
        JSpinner sMes = new JSpinner();
        JLabel lAnio = new JLabel("Año");
        JSpinner sAnio = new JSpinner();
        // Añadimos el contenido al panel
        panel.add(lDia);
        panel.add(sDia);
        panel.add(lMes);
        panel.add(sMes);
        panel.add(lAnio);
        panel.add(sAnio);
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
}