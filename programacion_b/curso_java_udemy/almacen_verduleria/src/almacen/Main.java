package almacen;

public class Main {
    public static void main(String[] args) {
        Producto[] productos = new Producto[8];
        productos[0] = new Lacteo("Yogur", 2.87, 4, 47);
        productos[1] = new Lacteo("Leche Entera", 1.24, 1, 89);
        productos[2] = new Fruta("Manzana", 2.1, 2, "Rojo");
        productos[3] = new Fruta("Plátano", 3, 2.5, "Amarillo");
        productos[4] = new Limpieza("Detergente", 3.45, "Polvo", 3);
        productos[5] = new Limpieza("Jabón", 1.2, "Líquido", 2);
        productos[6] = new NoPerecible("Bombilla led", 3, 1, 1);
        productos[7] = new NoPerecible("Galletas", 4, 4, 324);

        System.out.println("Listando los productos:");
        System.out.println("===========================================");
        System.out.println();
        for (Producto p : productos) {
            System.out.println(p);
            System.out.println("===========================================");
            System.out.println();
        }
    }
}
