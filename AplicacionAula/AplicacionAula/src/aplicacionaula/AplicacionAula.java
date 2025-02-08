package aplicacionaula;

public class AplicacionAula {

    public static void main(String[] args) {
        Profesor jesus,joaquin;
        Alumno juan,beatriz;
        Persona per;

        jesus   = new Profesor("Jesus");
        joaquin = new Profesor("Joaquin","B7");
        juan  = new Alumno("Juan");
        beatriz = new Alumno("Beatriz",4,5);
        per = new Persona();

        per.altura=3.3F;
        System.out.println("\n"+jesus.toString());   // Mostramos a los profesores
        System.out.println(joaquin.toString());
        jesus.setDespacho("C7");                     // Cambiamos el despacho de Jesus
        System.out.println(jesus.toString()+"\n");   // Comprobamos la nueva informacion

        jesus.darClase();                               // Jesus comineza la clase
        jesus.habla();
        juan.pregunta("¿Que es un objeto?");             // El alumno juan pregunta
        jesus.responderPregunta("¿Que es un objeto?");   // Jesus contesta
        beatriz.pregunta("¿Es lo mismo clase y objeto?");
        jesus.responderPregunta("¿Es lo mismo clase y objeto?");
        jesus.pregunta("¿Os habeis enterado?");
        
        // Creamos array de 10 delegados
        Delegado[] delegados = new Delegado[10];
        
        // Probamos protecciones
        // Public
        System.out.println(joaquin.tutoria);
        
        // Protected
        System.out.println(joaquin.altura);
        
        // Private
        //System.out.println(joaquin.despacho);
        
        // Ejercicios Java.lang
        
        // Valor absoluto de 3.7
        double valorAbsoluto = Math.abs(3.7);
        System.out.println("Valor absoluto de 3.7: " + valorAbsoluto);

        // Raíz cuadrada de 37
        double raizCuadrada = Math.sqrt(37);
        System.out.println("Raíz cuadrada de 37: " + raizCuadrada);

        // Si 'a' es minúscula, imprimir el mensaje "Es minúscula", sino "Es mayúscula"
        char caracter = 'a';
        if (Character.isLowerCase(caracter)) {
            System.out.println("Es minúscula");
        } else {
            System.out.println("Es mayúscula");
        }

        // Convertir 5 a String
        String stringNumero = Integer.toString(5);
        System.out.println("Convertir 5 a String: " + stringNumero);

        // Convertir "5" a int
        int numero = Integer.parseInt("5");
        System.out.println("Convertir \"5\" a int: " + numero);

        // Convertir 5.5 a String
        String stringNumeroDecimal = Double.toString(5.5);
        System.out.println("Convertir 5.5 a String: " + stringNumeroDecimal);

        // ¿Cuál es el máximo flotante?
        float maxFloat = Float.MAX_VALUE;
        System.out.println("Máximo flotante: " + maxFloat);

        // Imprimir el segundo carácter de "Hola"
        String palabra = "Hola";
        char segundoCaracter = palabra.charAt(1);
        System.out.println("Segundo carácter de \"Hola\": " + segundoCaracter);

        // Comparar "hola" con "Hola"
        String palabra1 = "hola";
        String palabra2 = "Hola";
        boolean sonIguales = palabra1.equals(palabra2);
        System.out.println("¿Son iguales \"hola\" y \"Hola\"? " + sonIguales);

        // Crear "Hola" y añadirle " y adiós" (sin crear un nuevo objeto)
        StringBuilder builder = new StringBuilder("Hola");
        builder.append(" y adiós");
        String saludo = builder.toString();
        System.out.println("Saludo: " + saludo);
    }

}
