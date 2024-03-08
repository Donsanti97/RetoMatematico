package org.example;

import java.util.Scanner;

import static org.example.Operation.*;

public class Start extends Validations{

    public static void start(){
        System.out.println("""
                                Bienvenido a Reto Matemático
        A continuación se generarán una serie de preguntas con respuesta única.
        Usted deberá responder solo con números enteros. A medida que vaya avanzando
        el nivel de complejidad aumentará.
        Buena suerte!!!""");
        try {
            var sc = new Scanner(System.in);
            Thread.sleep(2000);
            System.out.print("""
                    El juego va a comenzar. Ingrese 1 para iniciar: """);
            validateNumber(sc);
            int opcion = sc.nextInt();
            while (opcion != 1){
                System.out.println("Ingrese 1 para comenzar");
                validateNumber(sc);
                opcion = sc.nextInt();
            }
            getRandomOperation();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
