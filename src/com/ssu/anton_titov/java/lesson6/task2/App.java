package com.ssu.anton_titov.java.lesson6.task2;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        String path = args[0];
        Integer number = Integer.parseInt(args[1]);
        App application = new App();
        application.startApplication(path, number);
    }

    public void startApplication(String path, Integer number) {
        List<Runnable> functions = new ArrayList<>(4);
        functions.add(new First(path));
        functions.add(new Second(path));
        functions.add(new Third(path));
        functions.add(new Fourth(path));
        functions.get(number - 1).run();
    }

    static class First implements Runnable {
        private final String folder;

        public First(String folder) {
            this.folder = folder;
        }

        @Override
        public void run() {
            File directory = new File(folder);
            File[] files = directory.listFiles();
            if (files == null) {
                return;
            }
            Stream<File> stream = Arrays.stream(files);
            Optional<File> result = stream.filter(File::isFile).max(new Comparator<File>() {
                @Override
                public int compare(File first, File second) {
                    int firstCount = 0;
                    for (int i = 0; i < first.getName().length(); ++i) {
                        if (first.getName().charAt(i) == 's') {
                            ++firstCount;
                        }
                    }
                    int secondCount = 0;
                    for (int i = 0; i < second.getName().length(); ++i) {
                        if (second.getName().charAt(i) == 's') {
                            ++secondCount;
                        }
                    }
                    return Integer.compare(firstCount, secondCount);
                }
            });
            if (result.isPresent()) {
                System.out.println(result.get().getAbsolutePath());
            } else {
                System.out.println("No file with 's' character.");
            }
        }
    }

    static class Second implements Runnable {
        private final String folder;

        public Second(String folder) {
            this.folder = folder;
        }

        @Override
        public void run() {
            File directory = new File(folder);
            File[] files = directory.listFiles();
            if (files == null) {
                return;
            }
            Stream<File> stream = Arrays.stream(files);
            List<File> largestFiles = stream
                    .filter(File::isFile)
                    .sorted(Comparator.comparingLong(File::length).reversed())
                    .limit(5)
                    .parallel()
                    .collect(Collectors.toList());
            for (File file : largestFiles) {
                System.out.printf("%s %d\n", file.getName(), file.length());
            }
        }
    }

    static class Third implements Runnable {
        private final String folder;

        public Third(String folder) {
            this.folder = folder;
        }

        @Override
        public void run() {
            double mean = 0;
            File directory = new File(folder);
            File[] files = directory.listFiles();
            if (files == null) {
                return;
            }
            for (File file : files) {
                mean += file.length();
            }
            System.out.println(mean / files.length);
        }
    }

    static class Fourth implements Runnable {
        private final String folder;

        public Fourth(String folder) {
            this.folder = folder;
        }

        @Override
        public void run() {
            File directory = new File(folder);
            File[] files = directory.listFiles();
            if (files == null) {
                return;
            }
            Map<Character, Integer> group = new HashMap<>();
            for (File file : files) {
                Character firstLetter = file.getName().charAt(0);
                if (group.containsKey(firstLetter)) {
                    Integer count = group.get(firstLetter);
                    group.put(firstLetter, count + 1);
                } else {
                    group.put(firstLetter, 1);
                }
            }
            for (Character key : group.keySet()) {
                System.out.printf("%c %d\n", key, group.get(key));
            }
        }
    }
}
