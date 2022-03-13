package Parteprincipal2;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SegundoBloque {

    public Border creabordes(String title){
        Border ImporteInterior = BorderFactory.createEmptyBorder(0, 5, 0, 0);
        Border ImporteExterior = BorderFactory.createTitledBorder(null, title, TitledBorder.LEFT, TitledBorder.TOP);
        return BorderFactory.createCompoundBorder(ImporteExterior, ImporteInterior);
    }

    public void segundoBloque(){
        JFrame ventanaPrincipal2 = new JFrame("segundo bloque");
        ventanaPrincipal2.setSize(875, 325);
        ventanaPrincipal2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal2.setLayout(new BorderLayout());

        //PartePrincipal2

        JPanel partePrincipal2=new JPanel();


        // titulo
        JPanel ptitulo=new JPanel();
        JLabel ltitulo=new JLabel("LOS VUELOS DISPONIBLES SON:");

        ptitulo.add(ltitulo);

        //Panel ida
        JPanel pIdaDisponible=new JPanel();
        pIdaDisponible.setBorder(creabordes("Ida"));
        JRadioButton rbOpcion1= new JRadioButton("Texto de prueba; Aqui van los vuelos disponibles");
        JRadioButton rbOpcion2 = new JRadioButton("Texto de prueba; Aqui van los vuelos disponibles");

        Box box1 = Box.createVerticalBox();
        box1.add(rbOpcion1,BorderLayout.NORTH);
        box1.add(rbOpcion2,BorderLayout.SOUTH);

        pIdaDisponible.setLayout(new BorderLayout());

        pIdaDisponible.add(box1);


        //Panel Vuelta
        JPanel pVueltaDisponible=new JPanel();
        pVueltaDisponible.setBorder(creabordes("Vuelta"));
        JRadioButton rbOpcionVuelta3= new JRadioButton("Texto de prueba; Aqui van los vuelos disponibles");
        JRadioButton rbOpcionVuelta4 = new JRadioButton("Texto de prueba; Aqui van los vuelos disponibles");

        Box box2 = Box.createVerticalBox();
        box2.add(rbOpcionVuelta3,BorderLayout.NORTH);
        box2.add(rbOpcionVuelta4,BorderLayout.SOUTH);

        pVueltaDisponible.setLayout(new BorderLayout(5,10));
        pVueltaDisponible.add(box2);

        //Boton Confirmar
        JPanel pConfirmar=new JPanel();
        JButton bConfirmar=new JButton("Confirmar Elecciones");
        bConfirmar.setPreferredSize(new Dimension(180,30));
        pConfirmar.add(bConfirmar);





        JPanel prueba=new JPanel();
        partePrincipal2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        prueba.setSize(prueba.getPreferredSize());


        partePrincipal2.setLayout(new BorderLayout());

        partePrincipal2.add(ptitulo,BorderLayout.NORTH);
        partePrincipal2.add(pIdaDisponible,BorderLayout.WEST);
        partePrincipal2.add(pVueltaDisponible,BorderLayout.EAST);
        partePrincipal2.add(pConfirmar,BorderLayout.SOUTH);
        prueba.add(partePrincipal2);
        ventanaPrincipal2.add(prueba);


        ventanaPrincipal2.setVisible(true);
        ventanaPrincipal2.pack();


    }

}
