package com.ssu.anton_titov.java.lesson1.task2;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App firstLesson = new App();
        firstLesson.start();
    }

    private void start() {
        int A, B;
        int[] resetPair;
        Scanner scanner = new Scanner(System.in);

        resetPair = this.reset(scanner);
        A = resetPair[0];
        B = resetPair[1];

        System.out.println(A + " " + B);

        while (true){

            System.out.println("Symb|\tAction");
            System.out.println("==================");
            System.out.println(" *\t|\tMultiply");
            System.out.println(" \\\t|\tDivide");
            System.out.println(" +\t|\tAdd");
            System.out.println(" -\t|\tDifference");
            System.out.println(" ?\t|\tNew numbers");
            System.out.println("stop|\tQuit program");

            String str = scanner.next();

            switch (str) {
                case "*":
                    this.multiply(A, B);
                    break;
                case "\\":
                    this.div(A, B);
                    break;
                case "+":
                    this.add(A, B);
                    break;
                case "-":
                    this.diff(A, B);
                    break;
                case "?":
                    resetPair = this.reset(scanner);
                    A = resetPair[0];
                    B = resetPair[1];
                    break;
                case "stop":
                    return;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    private void multiply(int a, int b){
        System.out.println(a * b);
    }
    private void add(int a, int b){
        System.out.println(a + b);
    }
    private void div(int a, int b){
        System.out.println(a / b);
    }
    private void diff(int a, int b){
        System.out.println(a - b);
    }
    private int[] reset(Scanner scanner){
        int A, B;
        System.out.println("Enter new numbers");
        A = scanner.nextInt();
        B = scanner.nextInt();

        return new int[]{A, B};

    }
}