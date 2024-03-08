package org.example;

import java.util.Scanner;
import static org.example.OperationsLevel.*;

public class Operation extends Validations{

    public static void getRandomOperation() throws InterruptedException {
        System.out.println("Va a comenzar el juego, responda las preguntas...");
        System.out.println("Escriba el resultado de las operaciones");
        Scanner sc = new Scanner(System.in);
        Operations op = new Operations();
        String operation;
        int resultado;
        int respuesta;
        int[] lvl1;
        int[] lvl2;
        int time;
        int contador = 0;
        forPrincipal:
        for (int i = 0; i < 20; i++) {
            long initNime = System.currentTimeMillis();
            long answerTime;
            time = 5 * 1000;
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
                    respuesta = sc.nextInt();
                    if (respuesta == -500) {
                        System.out.println("Su respuesta no fue recibida. Debe ingresar solo números enteros");
                        break forPrincipal;
                    }
                    answerTime = System.currentTimeMillis() - initNime;
                    if (answerTime > time){
                        System.out.println("El tiempo fue excedido..");
                        break forPrincipal;
                    }
                    resultado = op.getAdd();
                    if (respuesta == resultado) {
                        contador++;
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
                case "resta":
                    System.out.println("La operación es la siguiente: [" + op.getNumber1() + " - " + op.getNumber2() + "]");
                    System.out.print("Respuesta: ");
                    respuesta = sc.nextInt();
                    if (respuesta == -500) {
                        System.out.println("Su respuesta no fue recibida. Debe ingresar solo números enteros");
                        break forPrincipal;
                    }
                    answerTime = System.currentTimeMillis() - initNime;
                    if (answerTime > time){
                        System.out.println("El tiempo fue excedido..");
                        break forPrincipal;
                    }
                    resultado = op.getSubtract();
                    if (respuesta == resultado) {
                        contador++;
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
                case "multiplicacion":
                    System.out.println("La operación es la siguiente: [" + op.getNumber1() + " * " + op.getNumber2() + "]");
                    System.out.print("Respuesta: ");
                    respuesta = sc.nextInt();
                    if (respuesta == -500) {
                        System.out.println("Su respuesta no fue recibida. Debe ingresar solo números enteros");
                        break forPrincipal;
                    }
                    answerTime = System.currentTimeMillis() - initNime;
                    if (answerTime > time){
                        System.out.println("El tiempo fue excedido..");
                        break forPrincipal;
                    }
                    resultado = op.getMultiply();
                    if (respuesta == resultado) {
                        contador++;
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
                case "division":
                    resultado = op.getDivide();
                    System.out.println("La operación es la siguiente: [" + op.getNumber1() + " / " + op.getNumber2() + "]");
                    System.out.print("Respuesta: ");
                    respuesta = sc.nextInt();
                    if (respuesta == -500) {
                        System.out.println("Su respuesta no fue recibida. Debe ingresar solo números enteros");
                        break forPrincipal;
                    }
                    answerTime = System.currentTimeMillis() - initNime;
                    if (answerTime > time){
                        System.out.println("El tiempo fue excedido..");
                        break forPrincipal;
                    }
                    if (respuesta == resultado) {
                        contador++;
                        continue;
                    } else {
                        System.out.println("\nRespuesta incorrecta..");
                        break forPrincipal;
                    }
            }
        }
        System.out.println("juego finalizado!!");
        Thread.sleep(2000);
        if (contador == 20){
            System.out.println("En hora buena haz ganado el juego!!");
        }else {
            System.out.println("No se ha podido completar el reto. Obtuviste " + contador + " puntos de 20");
        }
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
