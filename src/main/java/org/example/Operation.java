package org.example;

import java.util.Scanner;
import static org.example.OperationsLevel.*;

public class Operation extends Validations{

    public static void getRandomOperation() {
        System.out.println("Va a comenzar el juego, responda las preguntas, sino te mueres weon");
        System.out.println("Escriba el resultado de las operaciones");
        Scanner sc = new Scanner(System.in);
        Operations op = new Operations();
        String operation;
        int resultado;
        int respuesta;
        int[] lvl1;
        int[] lvl2;
        int time;
        forPrincipal:
        for (int i = 0; i < 20; i++) {
            time = 5;
            lvl1 = getLevel1Numbers();
            operation = getOperation();
            if (i + 1 <= 5) {
                System.out.println("Nivel 1 pregunta " + (i + 1));
                op.setNumbers(lvl1[0], lvl1[1]);

                if ((op.getNumber1() == 0 || op.getNumber2() == 0) && operation.equals("division")) {
                    lvl1 = getLevel1Numbers();
                    op.setNumbers(lvl1[0], lvl1[1]);
                }
            }
            if (i + 1 > 5) {
                lvl2 = getLevel2Numbers();
                System.out.println("Nivel 2 pregunta " + (i + 1));
                op.setNumbers(lvl2[0], lvl2[1]);

                if ((op.getNumber1() == 0 || op.getNumber2() == 0) && operation.equals("division")) {
                    lvl2 = getLevel1Numbers();
                    op.setNumbers(lvl2[0], lvl2[1]);
                }
            }


            switch (operation) {
                case "suma":
                    System.out.println("La operación es la siguiente: [" + op.getNumber1() + " + " + op.getNumber2() + "]");
                    System.out.print("Respuesta: ");
                    respuesta = waitForResponse(sc, time);
                    if (respuesta == -1) {
                        System.out.println("Su respuesta no fue recibida. El tiempo expiró");
                        break forPrincipal;
                    }
                    resultado = op.getAdd();
                    if (respuesta == resultado) {
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
                case "resta":
                    System.out.println("La operación es la siguiente: [" + op.getNumber1() + " - " + op.getNumber2() + "]");
                    System.out.print("Respuesta: ");
                    respuesta = waitForResponse(sc, time);
                    if (respuesta == -1) {
                        System.out.println("Su respuesta no fue recibida. El tiempo expiró");
                        break forPrincipal;
                    }
                    resultado = op.getSubtract();
                    if (respuesta == resultado) {
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
                case "multiplicacion":
                    System.out.println("La operación es la siguiente: [" + op.getNumber1() + " * " + op.getNumber2() + "]");
                    System.out.print("Respuesta: ");
                    respuesta = waitForResponse(sc, time);
                    if (respuesta == -1) {
                        System.out.println("Su respuesta no fue recibida. El tiempo expiró");
                        break forPrincipal;
                    }
                    resultado = op.getMultiply();
                    if (respuesta == resultado) {
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
                case "division":
                    resultado = op.getDivide();
                    System.out.println("La operación es la siguiente: [" + op.getNumber1() + " / " + op.getNumber2() + "]");
                    System.out.print("Respuesta: ");
                    respuesta = waitForResponse(sc, time);
                    if (respuesta == -1) {
                        System.out.println("Su respuesta no fue recibida. El tiempo expiró");
                        break forPrincipal;
                    }
                    if (respuesta == resultado) {
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
            }
        }
        System.out.println("juego finalizado!!");
        System.out.println("Desea comenzar el juego de nuevo? [si/no]");
        String respuestaRep = sc.next();
        respuestaRep = validaRespuesta(respuestaRep);
        if (respuestaRep.equals("si")){
            getRandomOperation();
        }else {
            System.out.println("Gracias por jugar.");
        }
    }
}
