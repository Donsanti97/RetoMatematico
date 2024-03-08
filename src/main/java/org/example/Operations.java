package org.example;

import java.util.Objects;

public class Operations {
    private int number1;
    private int number2;

    public Operations(){
    }

    public int getAdd(){
        return number1 + number2;
    }

    public int getSubtract(){
        return number1 - number2;
    }

    public int getMultiply(){
        return number1 * number2;
    }

    public int getDivide(){
        if (number2 > number1){
            int sum = number1 + number2;
            number1 = number2;
            number2 = sum - number1;
        }
        return number1 / number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumbers(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
}
