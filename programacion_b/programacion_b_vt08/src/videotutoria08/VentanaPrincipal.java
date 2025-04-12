package videotutoria08;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L; // Atributo para establecer la version de nuestro programa
    private JPanel panelInicial; // Panel principal de nuestra ventana, se puede llamar como se prefiera, no es necesario contentPane
    private JTextField campoNombre;

    /**
     * Create the frame.
     */
    public VentanaPrincipal() {
        setTitle("Mi primera aplicación gráfica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define la operacion de cierre, para que se cierre al cerrar programa, sino seguira ejecutandose
        setBounds(100, 100, 694, 529); // Coordenadas para definir el tamaño de nuestra ventana
        panelInicial = new JPanel();
        panelInicial.setToolTipText("barra superior");

        setContentPane(panelInicial);
        panelInicial.setLayout(null);
        
        campoNombre = new JTextField();
        campoNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                campoNombre.setForeground(new Color(125, 255, 0));
            }
        });
        campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
        campoNombre.setBounds(195, 34, 254, 54);
        panelInicial.add(campoNombre);
        campoNombre.setColumns(10);
        
        JLabel etiquetaNombre = new JLabel("Introduce tu nombre:");
        etiquetaNombre.setBounds(51, 45, 131, 33);
        panelInicial.add(etiquetaNombre);

        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(267, 307, 182, 48);
        panelInicial.add(textArea1);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(campoNombre.getText());
            }
        });
        botonAceptar.setBounds(339, 157, 165, 33);
        panelInicial.add(botonAceptar);
        
        JMenuBar barraSuperior = new JMenuBar();
        barraSuperior.setToolTipText("barraSuperior");
        barraSuperior.setBounds(0, 0, 668, 22);
        panelInicial.add(barraSuperior);
        
        JMenu menuPrincipal = new JMenu("Menu Principal");
        barraSuperior.add(menuPrincipal);
        
        JMenuItem menuPrincipalItem1 = new JMenuItem("Item 1");
        menuPrincipalItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Hola Xavales");
            }
        });
        menuPrincipal.add(menuPrincipalItem1);
        
        JMenu propiedades = new JMenu("Propiedades");
        barraSuperior.add(propiedades);
        
        JMenuItem ajustes = new JMenuItem("Ajustes");
        propiedades.add(ajustes);
        

    }
}
