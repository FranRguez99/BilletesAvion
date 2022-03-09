package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PuntoVentaBilletes {


    public  void interfaz() {
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

        //Seccion Trayecto
        // Crea los paneles este
        JPanel pTrayecto=new JPanel();

        // Contenido de los paneles

        //Seccion Punto de venta de billetes
        JLabel etiVentaBilletes=new JLabel("PUNTO DE VENTA DE BILLETES");
        pPuntoDeVenta.add(etiVentaBilletes);


        //Añade elementos a la ventana principal
        ventanaPrincipal.add(pPuntoDeVenta,BorderLayout.NORTH);
        ventanaPrincipal.add(pDetalles,BorderLayout.WEST);
        ventanaPrincipal.add(pTrayecto,BorderLayout.EAST);
        ventanaPrincipal.pack();
        ventanaPrincipal.setVisible(true);
    }
}
