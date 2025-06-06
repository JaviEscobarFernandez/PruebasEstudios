package introduccion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class EjemploJavaUtilCalendar {
    public static void main(String[] args) {
        Calendar calendario = Calendar.getInstance();

        calendario.set(2002, Calendar.FEBRUARY, 6, 19, 20, 10);
        calendario.set(Calendar.YEAR, 2001);
        calendario.set(Calendar.HOUR_OF_DAY, 10);
        Date fecha = calendario.getTime();
        System.out.println("calendario = " + fecha);

        SimpleDateFormat sd = new SimpleDateFormat("yyyy - MM - dd : HH-mm-ss");
        System.out.println("sd.format(fecha) = " + sd.format(fecha));

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una fecha con formato: (yyyy-MM-dd) ");
        SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha2 = sd2.parse(sc.nextLine());
            System.out.println("fecha2 = " + fecha2);
            System.out.println("sd.format(fecha2) = " + sd2.format(fecha2));

            Date fechaActual = new Date();
            if (fecha2.after(fechaActual))
                System.out.println("Fecha usuario es posterior que la fecha actual");
            else if (fecha.before(fechaActual))
                System.out.println("Fecha usuario es anterior que la fecha actual");
            else
                System.out.println("La fecha usuario es la misma que la actual");
        } catch (ParseException e) {
            // e.printStackTrace();
            System.err.println("La fecha no es correcta");
            System.err.println("El formato debe ser: yyyy-MM-dd");
            main(args);
        }
    }
}
