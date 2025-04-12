package videotutoria08;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Netflix extends JFrame {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private final static ButtonGroup buttonGroup = new ButtonGroup();
    private String video = "comedia.mp4";

    /**
     * Create the frame.
     */
    public Netflix() {
        setTitle("n0tflix - reproducir videos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 828, 348);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(36, 36, 36));
        contentPane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel textoPrincipal = new JLabel("¿Qué te apetece ver?");
        textoPrincipal.setForeground(new Color(0, 128, 255));
        textoPrincipal.setFont(new Font("Arial", Font.BOLD, 28));
        textoPrincipal.setBounds(30, 121, 306, 50);
        contentPane.add(textoPrincipal);

        JLabel imagen = new JLabel("");
        imagen.setIcon(setImage("img/comedia.jpg"));
        imagen.setBounds(591, 11, 200, 280);
        imagen.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        contentPane.add(imagen);

        // Creamos un actionListener para asignar a todos los radioButtons
        ActionListener actionListenerRB = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dependiendo del titulo establecemos una imagen y video u otra
                switch (e.getActionCommand()) {
                    case "Comedia":
                        imagen.setIcon(setImage("img/comedia.jpg"));
                        video = "comedia.mp4";
                        break;
                    case "Terror":
                        imagen.setIcon(setImage("img/terror.jpg"));
                        video = "terror.mp4";
                        break;
                    case "Fantasia":
                        imagen.setIcon(setImage("img/fantasia.jpg"));
                        video = "fantasia.mp4";
                        break;
                    case "Aventuras":
                        imagen.setIcon(setImage("img/aventuras.jpg"));
                        video = "aventuras.mp4";
                        break;
                    case "Acción":
                        imagen.setIcon(setImage("img/accion.jpg"));
                        video = "accion.mp4";
                        break;
                    default:
                        break;
                }
            }
        };

        // Radio buttons creados en la funcion para reutilizar codigo
        JRadioButton botonComedia = createRadioButton("Comedia", actionListenerRB);
        botonComedia.setSelected(true);
        botonComedia.setBounds(360, 44, 121, 23);
        
        JRadioButton botonTerror = createRadioButton("Terror", actionListenerRB);
        botonTerror.setBounds(360, 84, 121, 23);
        
        JRadioButton botonFantasia = createRadioButton("Fantasia", actionListenerRB);
        botonFantasia.setBounds(360, 124, 121, 23);
        
        JRadioButton botonAventuras = createRadioButton("Aventuras", actionListenerRB);
        botonAventuras.setBounds(360, 164, 121, 23);
        
        JRadioButton botonAccion = createRadioButton("Acción", actionListenerRB);
        botonAccion.setBounds(360, 204, 121, 23);

        // Boton para ejecutar el video
        JButton ejecutar = new JButton("Ejecutar");
        ejecutar.setForeground(new Color(0, 128, 255));
        ejecutar.setFont(new Font("Arial", Font.BOLD, 24));
        ejecutar.setBackground(new Color(0, 0, 0));
        ejecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutarVideo(video);
            }
        });
        ejecutar.setBounds(360, 241, 128, 50);
        contentPane.add(ejecutar);
    }

    // Metodo para crear los radio buttons
    private static JRadioButton createRadioButton(String title, ActionListener at) {
        JRadioButton radioButton = new JRadioButton(title);
        radioButton.setFont(new Font("Arial", Font.BOLD, 20));
        radioButton.setBounds(360, 204, 121, 23);
        radioButton.setForeground(new Color(255, 255, 255));
        radioButton.setBackground(new Color(36, 36, 36));
        radioButton.addActionListener(at);
        buttonGroup.add(radioButton);
        contentPane.add(radioButton);
        return radioButton;
    }

    // Metodo para crear una imagen ajustando su escala
    private static ImageIcon setImage(String path) {
        Image img = new ImageIcon(path).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(200, 280, Image.SCALE_SMOOTH));
        return img2;
    }

    // Metodo para ejecutar el video abriendo el reproductor de windows.
    @SuppressWarnings("deprecation")
    private static void ejecutarVideo(String video) {
        Process process;
        try {
            // Obtener la ruta relativa del archivo dentro del proyecto
            String rutaRelativa = "video/" + video; // Ajusta según la ubicación real
            File archivoVideo = new File(rutaRelativa);

            // Convertir la ruta relativa a una absoluta
            String rutaAbsoluta = archivoVideo.getCanonicalPath();

            // Comando para ejecutar el reproductor con el archivo de video
            String comando = "\"C:\\Archivos de programa\\Windows Media Player\\wmplayer.exe\" \"" + rutaAbsoluta + "\"";
            
            // Ejecutar el comando
            process = Runtime.getRuntime().exec(comando);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
