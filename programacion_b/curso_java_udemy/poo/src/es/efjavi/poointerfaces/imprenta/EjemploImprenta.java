package es.efjavi.poointerfaces.imprenta;

import es.efjavi.poointerfaces.imprenta.modelo.*;

import static es.efjavi.poointerfaces.imprenta.modelo.Genero.*;
import static es.efjavi.poointerfaces.imprenta.modelo.Imprimible.*;
public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum(new Persona("John", "Doe"), "Ingeniero de sistemas", "Resumen laboral...");
        cv.addExperiencia("Java").addExperiencia("Oracle DBA").addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador fullstack").addExperiencia("Angular");
        Informe informe = new Informe(new Persona("Martin", "Fowler"), new Persona("James", "Goslin"), "Estudio sobre microservicios");
        imprimir(cv);
        imprimir(informe);

        Libro libro = new Libro(new Persona("Bram", "Stoker"), "Drácula", TERROR);
        libro.addPagina(new Pagina("Capitulo 1"))
                .addPagina(new Pagina("Capitulo 2"))
                .addPagina(new Pagina("Capitulo 3"))
                .addPagina(new Pagina("Capitulo 4"))
                .addPagina(new Pagina("Capitulo 5"));
        imprimir(libro);

        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "Hola que tal, objeto generico de clase anonima";
            }
        });

        System.out.println(TEXTO_DEFECTO);
    }
}
