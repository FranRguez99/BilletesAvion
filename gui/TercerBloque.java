package Parteprincipal3;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import javax.swing.JFrame;


public class TercerBloque {
    public void interfaz2() {
        JFrame ventanaPrincipal3 = new JFrame("rf");
        ventanaPrincipal3.setSize(875, 325);
        ventanaPrincipal3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal3.setLayout(new BorderLayout());

        //Crea los paneles
        JPanel pGeneralParte3 = new JPanel();
        Border bGeneral = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        pGeneralParte3.setBorder(bGeneral);
        JPanel pDetalles = new JPanel();
        Border exInterior = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        Border exExterior = BorderFactory.createTitledBorder(null, "Detalles", TitledBorder.CENTER, TitledBorder.TOP);
        Border bExtras = BorderFactory.createCompoundBorder(exExterior, exInterior);
        pDetalles.setBorder(bExtras);
        pDetalles.setLayout(new BorderLayout());
        //pDetalles.setSize(pDetalles.getPreferredSize());

        // PANEL PRINCIPAL 3
        JPanel panelPrincipal3 = new JPanel();

        panelPrincipal3.setBorder(new BevelBorder(BevelBorder.LOWERED));



        // Crea los paneles
        JPanel pDetallesVuelo = new JPanel(); // Panel Detalles
        GridLayout experimentLayout = new GridLayout(0, 1);
        pDetallesVuelo.setLayout(experimentLayout);
        JPanel pPosicion = new JPanel(); // Panel Posición
        Border modalidadInterior = BorderFactory.createEmptyBorder(0, 80, 0, 80);
        Border posicionExterior = BorderFactory.createTitledBorder(null, "Posición", TitledBorder.LEFT, TitledBorder.TOP);
        Border bPosicion = BorderFactory.createCompoundBorder(posicionExterior, modalidadInterior);
        pPosicion.setBorder(bPosicion);



        // Contenido de los paneles
        // Panel Modalidad
        JRadioButton rPasillo = new JRadioButton("Ida sólo");
        JRadioButton rCentro = new JRadioButton("Centro");
        JRadioButton rVentana = new JRadioButton("Ventana");
        JPanel nee=new JPanel();
        ButtonGroup grpIdaVuelta = new ButtonGroup();
        grpIdaVuelta.add(rPasillo);
        grpIdaVuelta.add(rCentro);
        grpIdaVuelta.add(rVentana);
        nee.add(rPasillo);
        nee.add(rCentro);
        nee.add(rVentana);
        pPosicion.add(nee);

        //Panel Asiento
        JPanel pAsiento = new JPanel();
        JPanel jValorAsiento = new JPanel();
        JSlider sAsientos = new JSlider(JSlider.HORIZONTAL, 1, 26, 5);
        Border asientoInterior = BorderFactory.createEmptyBorder(0, 80, 0, 80);
        Border asientoExterior = BorderFactory.createTitledBorder(null, "Asientos", TitledBorder.LEFT, TitledBorder.TOP);
        Border bAsiento = BorderFactory.createCompoundBorder(asientoExterior, asientoInterior);
        pAsiento.setBorder(bAsiento);


        JLabel lFilas = new JLabel("Filas:");
        JLabel lValorSlider = new JLabel("0");

        //
        //**Muestra los valores del slider
        sAsientos.setPaintTrack(true);
        sAsientos.setPaintTicks(true);
        sAsientos.setPaintLabels(true);

        sAsientos.setMinorTickSpacing(1);
        sAsientos.setMajorTickSpacing(5);


        // Cambia el valor del numero del filas al deslizar la barra
        sAsientos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sAsientos.getValueIsAdjusting()) {
                    lValorSlider.setText(String.valueOf(sAsientos.getValue()));
                }
            }
        });

        jValorAsiento.add(lFilas);
        jValorAsiento.add(lValorSlider);

        pAsiento.setLayout(new BorderLayout());

        pAsiento.add(jValorAsiento, BorderLayout.NORTH);
        pAsiento.add(sAsientos, BorderLayout.CENTER);

        // Panel Extras
        JPanel pExtras = new JPanel();
        pExtras.setBorder(creabordes("Extras"));


        JCheckBox chEmbarque = new JCheckBox("Embarque Prior. ");
        JCheckBox chEquipaje = new JCheckBox("Equipaje");

        pExtras.add(chEmbarque);
        pExtras.add(chEquipaje);

        //Panel Importes
        JPanel pImportes = new JPanel();
        pImportes.setBorder(creabordes("Importes"));
        //
        JPanel precios = new JPanel();

        // **Asiento
        JLabel lpAsiento = new JLabel("Asiento:");
        JTextField txAsiento = new JTextField(4);
        txAsiento.setHorizontalAlignment(JTextField.LEFT);
        txAsiento.setBorder(new BevelBorder(BevelBorder.RAISED));
        lpAsiento.add(txAsiento);
        //
        // **importe
        JLabel lpEmbarque = new JLabel("Embarque: ");
        JTextField txEmbbarqie = new JTextField(4);
        txEmbbarqie.setBorder(new BevelBorder(BevelBorder.RAISED));
        lpEmbarque.add(txEmbbarqie);
        //
        // **equipaje
        JLabel lpEquipaje = new JLabel("Equipaje");
        JTextField txEquipaje = new JTextField(4);
        lpEquipaje.add(txEquipaje);
        txEquipaje.setBorder(new BevelBorder(BevelBorder.RAISED));
        pImportes.add(lpEquipaje);
        //
        //**Precio Final
        JPanel pPrecioFinal = new JPanel();
        JLabel lpPrecioFinal = new JLabel("Precio Final:");
        JTextField txPrecioFinal = new JTextField(6);
        txPrecioFinal.setFont(new Font("Verdana",Font.BOLD,20));
        txPrecioFinal.setBorder(new BevelBorder(BevelBorder.RAISED));
        pPrecioFinal.add(lpPrecioFinal);
        pPrecioFinal.add(txPrecioFinal);

        JPanel PanelPrecios = new JPanel();
        PanelPrecios.setLayout(new BorderLayout());
        PanelPrecios.add(precios, BorderLayout.NORTH);
        PanelPrecios.add(pPrecioFinal, BorderLayout.SOUTH);

        precios.add(lpAsiento);
        precios.add(txAsiento);
        precios.add(lpEmbarque);
        precios.add(txEmbbarqie);
        precios.add(lpEquipaje);
        precios.add(txEquipaje);




        //Botones
        JPanel Botones = new JPanel();
        Border modalidadInterior3 =new BevelBorder(BevelBorder.LOWERED);
        Border modalidadInterior2 = BorderFactory.createEmptyBorder(0, 2, 0, 2);
        Border bPosicion2 = BorderFactory.createCompoundBorder(modalidadInterior2,modalidadInterior3);
        Botones.setBorder(bPosicion2);



        //
        //**Boton Aceptar
        Icon aceptar = new ImageIcon("C:\\Users\\aj_ic\\OneDrive\\Escritorio\\PuntoVenta\\src\\Parteprincipal3\\img\\valBot.png");
        JButton btAceptar = new JButton(aceptar);
        btAceptar.setPreferredSize(new Dimension(80, 40));


        //
        //**Boton Cancelar
        Icon cancelar = new ImageIcon("C:\\Users\\aj_ic\\OneDrive\\Escritorio\\PuntoVenta\\src\\Parteprincipal3\\img\\canBot.png");
        JButton btCancelar = new JButton(cancelar);

        btCancelar.setIcon(cancelar);

        btCancelar.setPreferredSize(new Dimension(80, 40));

        Botones.setLayout(new GridLayout(2,1));
        Botones.add(btAceptar);
        Botones.add(btCancelar);




        pImportes.setLayout(new BorderLayout());
        pImportes.add(PanelPrecios, BorderLayout.WEST);
        pImportes.add(Botones, BorderLayout.EAST);



        //Panel Billete
        JPanel pBillete = new JPanel();
        pBillete.setBorder(creabordes("Billete"));
        ImageIcon image=new ImageIcon("C:\\Users\\aj_ic\\OneDrive\\Escritorio\\PuntoVenta\\src\\Parteprincipal3\\img\\ico_bill_av_iv (1).png");
        JLabel imagen2=new JLabel(image);
        pBillete.add(imagen2);





        //Panel Importe/Billete
        JPanel pBilleteImporte = new JPanel();
        pBilleteImporte.setLayout(new BorderLayout());

        pBilleteImporte.add(pBillete, BorderLayout.SOUTH);
        pBilleteImporte.add(pImportes, BorderLayout.NORTH);

        //Tamaños

        pDetalles.setBackground(Color.blue);
        pDetalles.setSize(pDetalles.getPreferredSize());
        pBilleteImporte.setSize(new Dimension(200,130));
        panelPrincipal3.setBackground(Color.red);
        ventanaPrincipal3.setBackground(Color.gray);
        pGeneralParte3.setBackground(Color.yellow);
        pGeneralParte3.setSize(new Dimension(785,850));


        // Añadir paneles al marco

        panelPrincipal3.setLayout(new BorderLayout());
        pDetalles.add(pAsiento, BorderLayout.NORTH);
        pDetalles.add(pPosicion, BorderLayout.CENTER);
        pDetalles.add(pExtras, BorderLayout.SOUTH);
        panelPrincipal3.add(pBilleteImporte, BorderLayout.EAST);
        panelPrincipal3.add(pDetalles, BorderLayout.WEST);
        pGeneralParte3.add(panelPrincipal3);
        ventanaPrincipal3.add(pGeneralParte3);
        ventanaPrincipal3.setVisible(true);
    }

    public Border creabordes(String title){
        Border ImporteInterior = BorderFactory.createEmptyBorder(0, 5, 0, 0);
        Border ImporteExterior = BorderFactory.createTitledBorder(null, title, TitledBorder.LEFT, TitledBorder.TOP);
        return BorderFactory.createCompoundBorder(ImporteExterior, ImporteInterior);
    }

}
