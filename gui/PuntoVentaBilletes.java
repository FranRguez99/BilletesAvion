package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PuntoVentaBilletes {
    public void interfaz() {
        JFrame ventanaPrincipal = new JFrame("Adivina el resultado de la suma");
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


        //Seccion Trayecto


        //Seccion Punto de venta de billetes
        JLabel etiVentaBilletes = new JLabel("PUNTO DE VENTA DE BILLETES");
        pPuntoDeVenta.add(etiVentaBilletes);


        //Añade elementos a la ventana principal
        ventanaPrincipal.add(pPuntoDeVenta, BorderLayout.NORTH);
        ventanaPrincipal.add(pDetalles, BorderLayout.WEST);
        ventanaPrincipal.add(pTrayecto, BorderLayout.EAST);
        ventanaPrincipal.setVisible(true);
    }
}
