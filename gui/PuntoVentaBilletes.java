package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PuntoVentaBilletes {

    public void interfaz() {
        JFrame ventanaPrincipal = new JFrame("Air Carmela");
        ventanaPrincipal.setSize(700, 250);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(new BorderLayout());

        //Crea los paneles
        JPanel pPuntoDeVenta = new JPanel();
        pPuntoDeVenta.setAlignmentX(0);
        JPanel pDetalles = new JPanel();
        JPanel pTrayecto = new JPanel();

        GridLayout experimentLayout = new GridLayout(0, 1);
        pDetalles.setLayout(experimentLayout);

        //Seccion Detalles
        JPanel pModalidad = new JPanel();
        JPanel pFechaIda = new JPanel();
        JPanel pFechaVuelta = new JPanel();
        pDetalles.add(pModalidad);
        pDetalles.add(pFechaIda);
        pDetalles.add(pFechaVuelta);

        //Seccion Ida y Vuelta

        JRadioButton opcion1 = new JRadioButton("Ida Solo");
        JRadioButton opcion2 = new JRadioButton("Ida/Vuelta");
        pModalidad.add(opcion1);
        pModalidad.add(opcion2);
        TitledBorder bordeModalidad = BorderFactory.createTitledBorder("Modalidad");
        bordeModalidad.setTitleJustification(TitledBorder.CENTER);
        pModalidad.setBorder(bordeModalidad);
        pModalidad.setSize(15, 15);

        //Fecha ida
        TitledBorder bordeMIda = BorderFactory.createTitledBorder("Fecha ida");
        pFechaIda.setBorder(bordeMIda);
        pFechaIda.setSize(15, 15);
        //Fecha vuelta
        TitledBorder bordeVuelta = BorderFactory.createTitledBorder("Fecha vuelta");
        bordeMIda.setTitleJustification(TitledBorder.CENTER);
        pFechaVuelta.setBorder(bordeVuelta);
        pFechaVuelta.setSize(15, 15);


        JLabel DiaIda = new JLabel("Día");
        JSpinner diasIda = new JSpinner();
        JLabel mesIda = new JLabel("Mes");
        JSpinner mesesIda = new JSpinner();
        JLabel anioIda = new JLabel("Año");
        JSpinner aniosIda = new JSpinner();

        //añade elementos al panel Ida
        pFechaIda.add(DiaIda);
        pFechaIda.add(diasIda);
        pFechaIda.add(mesIda);
        pFechaIda.add(mesesIda);
        pFechaIda.add(anioIda);
        pFechaIda.add(aniosIda);

        //** añade elementos al panel vuelta

        JLabel DiaV = new JLabel("Día");
        JSpinner diasV = new JSpinner();
        JLabel mesV = new JLabel("Mes");
        JSpinner mesesV = new JSpinner();
        JLabel anioV = new JLabel("Año");
        JSpinner aniosV = new JSpinner();

        pFechaVuelta.add(DiaV);
        pFechaVuelta.add(diasV);
        pFechaVuelta.add(mesV);
        pFechaVuelta.add(mesesV);
        pFechaVuelta.add(anioV);
        pFechaVuelta.add(aniosV);

        // Sección Trayecto
        // Crea los paneles este
        JPanel pTrayecto=new JPanel();
        JPanel pOrigen = new JPanel();
        pOrigen.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel pDestino = new JPanel();
        pDestino.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel pPersonas = new JPanel();
        pPersonas.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Contenido de los paneles
        // Panel origen
        JLabel lOrigen = new JLabel("Origen: ");
        JComboBox<String> cbOrigen = crearCaja();
        cbOrigen.setSize(300, 300);
        pOrigen.add(lOrigen);
        pOrigen.add(cbOrigen);

        // Panel destino
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

        // Panel trayecto
        Border trayectoInterior = BorderFactory.createEmptyBorder(0, 35, 0, 35);
        Border trayectoExterior = BorderFactory.createTitledBorder(null, "Trayecto", TitledBorder.CENTER, TitledBorder.TOP);
        Border bTrayecto = BorderFactory.createCompoundBorder(trayectoExterior, trayectoInterior);
        pTrayecto.setBorder(bTrayecto);
        pTrayecto.setLayout(new BorderLayout());
        pTrayecto.add(pOrigen, BorderLayout.NORTH);
        pTrayecto.add(pDestino, BorderLayout.CENTER);
        pTrayecto.add(pPersonas, BorderLayout.SOUTH);


        // Sección Punto de venta de billetes
        JLabel etiVentaBilletes=new JLabel("PUNTO DE VENTA DE BILLETES");
        pPuntoDeVenta.add(etiVentaBilletes);


        //Añade elementos a la ventana principal
        ventanaPrincipal.add(pPuntoDeVenta, BorderLayout.NORTH);
        ventanaPrincipal.add(pDetalles, BorderLayout.WEST);
        ventanaPrincipal.add(pTrayecto, BorderLayout.EAST);
        ventanaPrincipal.setVisible(true);
    }

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
