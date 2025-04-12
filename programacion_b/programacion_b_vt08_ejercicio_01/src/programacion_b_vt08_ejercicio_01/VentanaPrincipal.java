package programacion_b_vt08_ejercicio_01;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaPrincipal() {
        setTitle("Ver Películas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 946, 444);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label con el texto inicial
        JLabel textoInicial = new JLabel("¿Qué te apetece ver hoy?");
        textoInicial.setForeground(new Color(0, 128, 255));
        textoInicial.setFont(new Font("Arial", Font.BOLD, 30));
        textoInicial.setBounds(44, 179, 376, 50);
        contentPane.add(textoInicial);

        // Creamos los diferentes radioButtons
        JRadioButton buttonComedia = new JRadioButton("Comedia");
        buttonComedia.setFont(new Font("Arial", Font.BOLD, 20));
        buttonComedia.setBounds(453, 48, 109, 23);
        contentPane.add(buttonComedia);
        
        JRadioButton buttonTerror = new JRadioButton("Terror");
        buttonTerror.setFont(new Font("Arial", Font.BOLD, 20));
        buttonTerror.setBounds(453, 119, 109, 23);
        contentPane.add(buttonTerror);
        
        JRadioButton buttonFantasia = new JRadioButton("Fantasia");
        buttonFantasia.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFantasia.setBounds(453, 190, 109, 23);
        contentPane.add(buttonFantasia);
        
        JRadioButton buttonAventuras = new JRadioButton("Aventuras");
        buttonAventuras.setFont(new Font("Arial", Font.BOLD, 20));
        buttonAventuras.setBounds(453, 261, 148, 23);
        contentPane.add(buttonAventuras);
        
        JRadioButton buttonAccion = new JRadioButton("Acción");
        buttonAccion.setFont(new Font("Arial", Font.BOLD, 20));
        buttonAccion.setBounds(453, 332, 109, 23);
        contentPane.add(buttonAccion);

        // Establecemos un JLabel para establecer una imagen dependiendo del radioButton seleccionado
        JLabel labelImagen = new JLabel("");
        labelImagen.setBounds(684, 23, 221, 371);
        contentPane.add(labelImagen);

        // Agrupamos los radioButtons en un mismo grupo, para solo poder seleccionar uno.
        ButtonGroup btGroup = new ButtonGroup();
        btGroup.add(buttonComedia);
        btGroup.add(buttonTerror);
        btGroup.add(buttonFantasia);
        btGroup.add(buttonAventuras);
        btGroup.add(buttonAccion);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Establecemos la ruta de la imagen dependiendo del radiobutton que se active
                String path = "";
                if (e.getSource() == buttonComedia)
                    path = "img/comedia.jpg";
                else if (e.getSource() == buttonTerror)
                    path = "img/terror.jpg";
                else if (e.getSource() == buttonFantasia)
                    path = "img/fantasia.jpg";
                else if (e.getSource() == buttonAventuras)
                    path = "img/aventuras.jpg";
                else if (e.getSource() == buttonAccion)
                    path = "img/accion.jpg";

                // Ajustamos la imagen a un tamaño determinado
                Image img = new ImageIcon(path).getImage();
                labelImagen.setIcon(new ImageIcon(img.getScaledInstance(200, 280, Image.SCALE_SMOOTH)));
            }
        };

        // Enlazamos los radioButtons al ActionListener para que puedan escuchar para desencadenar el action
        buttonComedia.addActionListener(listener);
        buttonTerror.addActionListener(listener);
        buttonFantasia.addActionListener(listener);
        buttonAventuras.addActionListener(listener);
        buttonAccion.addActionListener(listener);
    }
}
