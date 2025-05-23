
import java.util.*;

public class UsoTallas {

	// enum talla { Pequeña, Mediana, Grande, Extra_Grande };

	enum talla {

		pequeña("s"), mediana("m"), grande("g"), extra_grande("xg");

		private talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}

		// getters
		public String getAbreviatura() { return abreviatura; }

		private String abreviatura;
	}

	public static void main(String[] args) {

		/*
		talla s = talla.Pequeña;
		talla m = talla.Mediana;
		talla g = talla.Grande;
		talla xg = talla.Extra_Grande;
		*/

		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una talla: (pequeña, mediana, grande o extra_grande)");
		String datos = entrada.next().toLowerCase();
		talla talla_introducida = Enum.valueOf(talla.class, datos);
		System.out.println("Talla: " + talla_introducida);
		System.out.println("Abreviatura: " + talla_introducida.getAbreviatura());
	}

}
