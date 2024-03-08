package org.example;

import java.util.Scanner;

public class Validations {

    protected static boolean validateNumber(Scanner scanner){
        try {
            if (!scanner.hasNextInt()) {
                System.out.println("No ha ingresado un número entero. Por favor, inténtelo de nuevo:");
                scanner.next();
                return validateNumber(scanner);
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static int waitForResponse(Scanner scanner, int tiempoMaximo) {
        Thread hiloDeEspera = new Thread(() -> {
            try {
                Thread.sleep(tiempoMaximo * 1000L);
                Thread.currentThread().interrupt();
            } catch (InterruptedException ignored) {
            }
        });
        hiloDeEspera.start();

        Integer respuesta;
        try {
            respuesta = scanner.nextInt();
            hiloDeEspera.interrupt(); // Interrumpir el hilo de espera si el usuario responde a tiempo
            //if(respuesta.)
        } catch (Exception e) {
            respuesta = -500; // Devolver -1 si ocurre alguna excepción (no hay respuesta a tiempo)
        }
        return respuesta;
    }

    private static String normalizarCadena(String cadena) {
        return java.text.Normalizer.normalize(cadena, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
    }

    protected static String validaRespuesta(String respuesta){
        Scanner scanner = new Scanner(System.in);
        respuesta = normalizarCadena(respuesta);
        if (!respuesta.equals("si") && !respuesta.equals("no")){
            System.out.println("Su respuesta no es válida por favor ingrese una respuesta válida (si/no)");
            respuesta = scanner.next();
            return validaRespuesta(respuesta);
        }
        return respuesta;
    }

}
