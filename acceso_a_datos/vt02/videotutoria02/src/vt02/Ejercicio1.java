package vt02;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Ejercicio 1: Crear la clase MyHandlerPErsona con los metodos necesarios
 * para que analice el fichero xml: "xmlFile.xml"
 * 
 * El fichero xmlFile.xml, contiene tres elementos <person>
 * cada uno con un <name> y un <age>.
 * 
 * Al analizar el fichero, se imprimira el nombre y la edad de cada persona.
 */
public class Ejercicio1 {

	public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MyHandlerPersona handler = new MyHandlerPersona();
            saxParser.parse("Ejercicio1" + File.separator + "xmlFile.xml", handler);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
