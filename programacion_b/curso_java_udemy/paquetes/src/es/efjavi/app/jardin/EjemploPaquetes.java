package es.efjavi.app.jardin;

import es.efjavi.app.hogar.*;

import static es.efjavi.app.hogar.Persona.*;
import static es.efjavi.app.hogar.ColorPelo.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Javi");
        p.setNombre("Escobar Fernández");
        p.setColorPelo(MARRON);
        System.out.println(p.getNombre() + " " + p.getApellido());

        Perro perro = new Perro();
        perro.nombre = "Zeus";
        perro.raza = "Bulldog francés";

        String jugando = perro.jugar(p);
        System.out.println(jugando);

        String saludo = saludar();
        System.out.println(saludo);

        String generoMujer = GEN_FEMENINO;
        String generoHombre = GEN_MASCULINO;
        System.out.println(generoMujer + " " + generoHombre);
    }
}
