package introduccion;

public class WraperRelacional {
    public static void main(String[] args) {
        Integer num1 = Integer.valueOf(1000);
        Integer num2 = num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Son el mismo objeto? " + (num1 == num2));

        num2 = 1000;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Son el mismo objeto? " + (num1 == num2));

        System.out.println("Tienen el mismo valor? " + (num1.equals(num2)));
        System.out.println("Tienen el mismo valor? " + (num1.intValue() == num2.intValue()));

        num2 = 500;
        boolean condicion = num1 > num2;
        System.out.println("condicion = " + condicion);

        boolean condicion2 = num1.intValue() < num2.intValue();
        System.out.println("condicion2 = " + condicion2);

        Integer num3, num4;
        num3 = 1;
        num4 = 2;

        boolean primBoolean = num3 > num4; // false
        Boolean objBool = Boolean.valueOf(primBoolean);
        Boolean objBool2 = Boolean.valueOf("false");
        Boolean objBool3 = false;

        System.out.println("primBoolean = " + primBoolean);
        System.out.println("objBool = " + objBool);
        System.out.println("objBool2 = " + objBool2);

        System.out.println("Comparando dos objetos boolean: " + (objBool == objBool2));
        System.out.println("Comparando dos objetos boolean: " + (objBool.equals(objBool2)));
        System.out.println("Comparando dos objetos boolean: " + (objBool2.equals(objBool3)));
        System.out.println("Comparando dos objetos boolean: " + (objBool.equals(objBool3)));

        boolean primBoolean2 = objBool2.booleanValue();
        System.out.println("primBoolean2 = " + primBoolean2);
    }
}
