package vt02;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandlerPersona extends DefaultHandler {
    // Creamos un atributo por cada elemento del documento XML
    boolean isPerson = false;
    boolean isName = false;
    boolean isAge = false;

    // startElement se encarga de localizar el inicio del elemento.
    // Establecemos el atributo a true en base al element que ha localizado.
    // Asi manejamos el control sobre el element que estamos procesando.
    @Override
    public void startElement(String uri, String localName, String elementos, Attributes atributos) throws SAXException {
        System.out.println("Inicio del elemento: " + elementos);
        switch (elementos) {
            case "person": isPerson = true; break;
            case "name": isName = true; break;
            case "age": isAge = true; break;
        }
    }
    // characters comprueba que atributo ha sido marcado a true en startElement.
    // lo procesará, imprimirá su contenido y finalizará estableciendo el atributo a false.
    @Override
    public void characters(char ch[], int inicio, int length) throws SAXException {
        if (isPerson) {
            System.out.println("Persona: " + new String(ch, inicio, length));
            isPerson = false;
        } else if (isName) {
            System.out.println("Nombre: " + new String(ch, inicio, length));
            isName = false;
        } else if (isAge) {
            System.out.println("Edad: " + new String(ch, inicio, length));
            isAge = false;
        }
    }
    // endElement lo utilizaremos para finalizar el procesado del elemento.
    @Override
    public void endElement(String uri, String localName, String elementos) throws SAXException {
        System.out.println("Fin del elemento: " + elementos);
    }
}

