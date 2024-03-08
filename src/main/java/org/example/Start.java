package org.example;

import java.util.Scanner;

import static org.example.Operation.*;

public class Start extends Validations{

    public static void start(){
        System.out.println("""
                                Bienvenido a Reto Matemático
        A continuación se generarán una serie de preguntas con respuesta única.
        Usted deberá responder solo con números enteros. A medida que vaya avanzando
        el nivel de complejidad aumentará. El tiempo para responder las preguntas
        está limitado a 5 segundos.
        Buena suerte!!!""");
        try {
            var sc = new Scanner(System.in);
            Thread.sleep(2000);
            System.out.print("""
                    El juego va a comenzar. Ingrese 1 para iniciar: """);
            validateNumber(sc);
            int opcion = sc.nextInt();
            if (opcion == 1){
                getRandomOperation();
            } else {
                System.out.println("Saliendo de la aplicación");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
