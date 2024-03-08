package org.example;

import java.util.Random;

public class OperationsLevel {


    private static final Random RANDOM = new Random();
    private static final String[] OPERATIONS = {"suma", "resta", "multiplicacion", "division"};
    private static final int[] LEVEL1_NUMBERS = new int[10];
    private static final int[] LEVEL2_NUMBERS = new int[100];

    public static String getOperation() {
        int randomPosition = RANDOM.nextInt(OPERATIONS.length);
        return OPERATIONS[randomPosition];
    }

    public static int[] getLevel1Numbers() {
        for (int i = 0; i < LEVEL1_NUMBERS.length; i++) {
            LEVEL1_NUMBERS[i] = i;
        }
        int[] randomNumbers = new int[2];
        randomNumbers[0] = RANDOM.nextInt(LEVEL1_NUMBERS.length);
        randomNumbers[1] = RANDOM.nextInt(LEVEL1_NUMBERS.length);
        return randomNumbers;
    }

    public static int[] getLevel2Numbers() {
        for (int i = 0; i < LEVEL2_NUMBERS.length; i++) {
            LEVEL2_NUMBERS[i] = i;
        }
        int[] randomNumbers = new int[2];
        randomNumbers[0] = RANDOM.nextInt(LEVEL2_NUMBERS.length);
        randomNumbers[1] = RANDOM.nextInt(LEVEL2_NUMBERS.length);
        return randomNumbers;
    }




}
