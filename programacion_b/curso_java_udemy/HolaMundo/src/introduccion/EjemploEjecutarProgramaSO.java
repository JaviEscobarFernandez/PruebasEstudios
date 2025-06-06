package introduccion;

public class EjemploEjecutarProgramaSO {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        Process proceso;

        try {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.startsWith("windows")) {
                proceso = run.exec("notepad");
            } else if (osName.startsWith("mac"))
                proceso = run.exec("textedit");
            else if (osName.contains("nux") || osName.contains("nix"))
                proceso = run.exec("gedit");
            else
                proceso = run.exec("gedit");
            proceso.waitFor();
        } catch(Exception e) {
            System.err.println("Comando desconocido: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Se ha cerrado el editor de texto.");
        System.exit(0);
    }
}
