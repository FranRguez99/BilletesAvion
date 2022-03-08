import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PuntoVentaBillete {


    public  void interfaz() {
        JFrame ventanaPrincipal = new JFrame("Adivina el resultado de la suma");
        ///ventanaPrincipal.setSize(700, 250);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(new BorderLayout());

        //Crea los paneles
        JPanel pPuntoDeVenta=new JPanel();
        pPuntoDeVenta.setAlignmentX(0);
        JPanel pDetalles=new JPanel();
        JPanel pTrayecto=new JPanel();



        //Seccion Detalles
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
        pModalidad.setSize(15,15);




        //Seccion Trayecto


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