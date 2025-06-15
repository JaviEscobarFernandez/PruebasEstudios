package es.efjavi.zoologico;

public class EjemploMamiferos {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[7];
        mamiferos[0] = new Lobo("Monte", 1.5f, 2.1f, 45f, "Canis lupus", "Gris Azulado", 14f);
        mamiferos[1] = new Perro("Jardin", 0.3f, 0.8f,26f, "Canis lupus familiaris", "Blanco", 5, 21);
        mamiferos[2] = new Perro("Jardin", 0.4f, 1.2f,30f, "Canis lupus familiaris", "Negro", 4, 27);
        mamiferos[3] = new Perro("Jardin", 0.5f, 2.0f,40f, "Canis lupus familiaris", "Canela", 6, 10);
        mamiferos[4] = new Tigre("Sabana Africana", 2f, 3f, 48f, "Panthera tigris", 14f, 70, "Tigre de Bengala");
        mamiferos[5] = new Leon("LLanura Africana", 2.3f, 3.1f, 50f, "Panthera leo", 18f, 60, 10, 114);
        mamiferos[6] = new Guepardo("Africa", 1.8f, 2.3f, 35f, "Acinonyx jubatus", 12f, 130);

        for (Mamifero m : mamiferos) {
            StringBuilder sb = new StringBuilder();
            sb.append(m).append("\n")
                .append(m.comer()).append("\n")
                .append(m.dormir()).append("\n")
                .append(m.correr()).append("\n")
                .append(m.comunicarse()).append("\n");
            System.out.println(sb.toString());
        }
    }
}
