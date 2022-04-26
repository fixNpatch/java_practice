package com.ssu.anton_titov.java.lesson1.task1;

public class App {
    public static void main(String[] args) {
        App firstLesson = new App();
        firstLesson.start();
    }

    private void start() {
        Integer[] Array = new Integer[20];

        for(int i = 0; i < Array.length; i++){
            Array[i] = (int)(Math.random() * 10 - Math.random() * 10);
        }

        // вывод исходного массива
        this.result(Array);


        this.firstTask(Array.clone());
//        this.secondTask(Array.clone());
//        this.thirdTask(Array.clone());
//        this.fourthTask(Array.clone());
//        this.fifthTask(Array.clone());
//        this.sixthTask(Array.clone());
    }

    private void result(Integer[] array){
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.print("\n\n");
    }

    private void firstTask(Integer[] array){
        System.out.println("1. В массиве целых чисел поменять местами максимальный отрицательный элемент и минимальный положительный.");
        Integer max = array[0];
        Integer min = array[0];
        int maxIdx = 0;
        int minIdx = 0;

        for(int i = 0; i < array.length; i++){
            if (array[i] >= max) {
                max = array[i];
                maxIdx = i;
            }
            if (array[i] <= min) {
                min = array[i];
                minIdx = i;
            }
        }

        array[maxIdx] = array[minIdx];
        array[minIdx] = max;

        System.out.printf("Number %d was on %d position\nNumber %d was on %d position\n", max, maxIdx, min, minIdx);

        this.result(array);
    }

    private void secondTask(Integer[] array){
        System.out.println("2. В массиве целых чисел определить сумму элементов, состоящих на чётных позициях.");
        int summ = 0;
        for(int i = 0; i < array.length; i+=2){
            summ += array[i];
        }
        System.out.printf("Result is %d\n\n", summ);
    }

    private void thirdTask(Integer[] array){
        System.out.println("3. В массиве целых чисел заменить нулями отрицательные элементы.");

        for(int i = 0; i < array.length; i++){
            if (array[i] < 0) array[i] = 0;
        }

        this.result(array);
    }

    private void fourthTask(Integer[] array){
        System.out.println("4. В массиве целых чисел утроить каждый положительный элемент, который стоит перед отрицательным.");

        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > 0 && array[i+1] < 0) {
                array[i] *= 3;
                i++;
            }
        }

        this.result(array);
    }

    private void fifthTask(Integer[] array){
        System.out.println("5. В массиве целых чисел найти разницу между средним арифметическим и значение минимального элемента.");

        int min = array[0];
        int mean = 0;

        for(Integer integer: array){
            mean += integer;
            if(min > integer) min = integer;
        }

        mean /= array.length;

        System.out.printf("Min = %d, Mean = %d, Diff = %d\n\n", min, mean, mean - min);

    }

    private void sixthTask(Integer[] array){
        System.out.println("6. В массиве целых чисел вывести все элементы, которые встречаются больше одного раза и индексы которых нечётные.");

        Integer [] tmp = new Integer[20];

        this.result(array);

        int j = 0;
        int pos;
        while(j < array.length){
            int counter = 0;
            pos = -1;
            Boolean accept = false;
            for(int i = 0; i < array.length; i++){
                if(array[i] == array[j]) counter++;
                if(counter > 1) {
                    if (j % 2 != 0 || j == 0){
                        pos = j;
                        accept = true;
                        continue;
                    }
                    if (i % 2 != 0) {
                        if (pos == -1){
                            pos = i;
                        }
                        accept = true;
                    }
                }
            }

            for(int k = 0; k < j; k++){
                if(array[k] == array[j]) accept = false;
            }

            if(accept) System.out.printf("%d counted with %d repeats. first met on pos %d\n", array[j], counter, pos + 1);
            j++;
        }
    }
}
