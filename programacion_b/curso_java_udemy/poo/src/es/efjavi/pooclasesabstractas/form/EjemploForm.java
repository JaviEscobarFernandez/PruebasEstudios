package es.efjavi.pooclasesabstractas.form;

import es.efjavi.pooclasesabstractas.form.elementos.*;
import es.efjavi.pooclasesabstractas.form.elementos.select.Opcion;
import es.efjavi.pooclasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("pass", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        lenguaje.addOpcion(new Opcion("1", "Java"))
        .addOpcion(new Opcion("2", "Python"))
        .addOpcion(new Opcion("3", "JavaScript"))
        .addOpcion(new Opcion("4", "TypeScript"))
        .addOpcion(new Opcion("5", "C++").setSelected());

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre +"' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola que tal? este campo esta deshabilitado");
        username.setValor("john.doe");
        password.setValor("123456");
        email.setValor("john.doe@correo.es");
        edad.setValor("28");
        experiencia.setValor("... más de 10 años de experiencia ...");

        List<ElementoForm> elementos = Arrays.asList(
                username, password, email, edad, experiencia, lenguaje, saludar);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if (!e.esValido())
                e.getErrores().forEach(System.err::println);
        });
    }
}
