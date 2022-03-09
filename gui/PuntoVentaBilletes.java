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

        //Seccion Detalles
        //Crea los paneles oeste
        JPanel pPuntoDeVenta=new JPanel();
        pPuntoDeVenta.setAlignmentX(0);
        JPanel pDetalles=new JPanel();
        JPanel pModalidad=new JPanel();
        JPanel pFechaIDa=new JPanel();
        JPanel pFechaVuelta=new JPanel();
        pDetalles.add(pModalidad);

        JRadioButton opcion1=new JRadioButton("Ida Solo");
        JRadioButton opcion2=new JRadioButton("Ida/Vuelta");
        pModalidad.add(opcion1);
        pModalidad.add(opcion2);
        Border borde=BorderFactory.createTitledBorder("Modalidad");
        pModalidad.setBorder(borde);
        pModalidad.setSize(700,500);

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
        ventanaPrincipal.add(pPuntoDeVenta,BorderLayout.NORTH);
        ventanaPrincipal.add(pDetalles,BorderLayout.WEST);
        ventanaPrincipal.add(pTrayecto,BorderLayout.EAST);
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
