package com.ssu.anton_titov.java.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class App {
    private static final int THREADS_COUNT = 64;

    public static void main(String[] args) throws Exception {
        App application = new App();
        application.startApplication();
    }

    public void startApplication() throws Exception {
        int n = 10000000;
        int[] a = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            a[i] = rnd.nextInt();
        }
        long begin = System.currentTimeMillis();
        sort(a, 0, n - 1);
        System.out.printf("Usual time: %d ms.\n", System.currentTimeMillis() - begin);
        for (int i = 0; i < n; ++i) {
            a[i] = rnd.nextInt();
        }
        ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);
        begin = System.currentTimeMillis();
        new QuickSort(a, 0, n - 1, THREADS_COUNT, service).call();
        System.out.printf("Parallel time: %d ms.\n", System.currentTimeMillis() - begin);
        service.shutdown();
    }

    static class QuickSort implements Callable<Object> {
        private final int[] a;
        private final int left;
        private final int right;
        private final int threadsCount;
        private final ExecutorService service;

        public QuickSort(int[] a, int left, int right, int threadsCount, ExecutorService service) {
            this.a = a;
            this.left = left;
            this.right = right;
            this.threadsCount = threadsCount;
            this.service = service;
        }

        @Override
        public Object call() throws Exception {
            if (left >= right) {
                return null;
            }
            int middle = (left + right) / 2;
            Pair<Integer, Integer> p = partition(a[middle]);
            if (right - left < 11) {
                bubbleSort();
            } else if (right - left > a.length / (threadsCount / 2)) {
                List<Callable<Object>> todo = new ArrayList<>(2);
                todo.add(new QuickSort(a, left, p.getFirst(), threadsCount, service));
                todo.add(new QuickSort(a, p.getSecond(), right, threadsCount, service));
                service.invokeAll(todo);
            } else {
                sort(a, left, p.getFirst());
                sort(a, p.getSecond(), right);
            }
            return new Object();
        }

        private void bubbleSort() {
            for (int i = left; i <= right; ++i) {
                for (int j = i + 1; j <= right; ++j) {
                    if (a[i] > a[j]) {
                        int tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                    }
                }
            }
        }

        private Pair<Integer, Integer> partition(int x) {
            int i = left;
            int j = right;
            while (i <= j) {
                while (a[i] < x) {
                    ++i;
                }
                while (a[j] > x) {
                    --j;
                }
                if (i <= j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    ++i;
                    --j;
                }
            }
            return new Pair<>(j, i);
        }
    }

    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        Pair<Integer, Integer> p = partition(a, left, right, a[middle]);
        sort(a, left, p.getFirst());
        sort(a, p.getSecond(), right);
    }

    private static Pair<Integer, Integer> partition(int[] a, int left, int right, int x) {
        int i = left;
        int j = right;
        while (i <= j) {
            while (a[i] < x) {
                ++i;
            }
            while (a[j] > x) {
                --j;
            }
            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i;
                --j;
            }
        }
        return new Pair<>(j, i);
    }

    static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T f, U s) {
            first = f;
            second = s;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
}
