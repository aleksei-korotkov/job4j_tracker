package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int minuend) {
        return minuend - x;
    }

    public int divide(int dividend) {
        return dividend / x;
    }

    public int sumAllOperation(int digit) {
        return Calculator.sum(digit)
                + this.multiply(digit)
                + Calculator.minus(digit)
                + this.divide(digit);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5);
        System.out.println(result);
        result = Calculator.minus(15);
        System.out.println(result);
        result = calculator.divide(100);
        System.out.println(result);
        result = calculator.sumAllOperation(10);
        System.out.println(result);
    }
}