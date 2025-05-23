

public class PruebaCadenasCaracteres {

	public static void main(String[] args) {
		String prueba = "Javi";
		int longitud = prueba.length();
		System.out.println("La longitud de \"" + prueba + "\" es: " + longitud);
		System.out.println("La primera leta es: " + prueba.charAt(0));
		System.out.println("La ultima leta es: " + prueba.charAt(longitud - 1));
		
		String frase = "Hoy es un día estupendo para hacer pruebas en Java.";
		String fragmento = frase.substring(10, 23);
		System.out.println(fragmento);
		String nombre = "Javi";
		System.out.println("¿" + prueba + " es igual que " + nombre +"?: " + prueba.equals(nombre));
	}

}
