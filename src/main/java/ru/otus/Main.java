package ru.otus;

public class Main {
    public static void main(String[] args) {
        int[] array = {4,3,6,2,1,65,345,24,6456,2,5345,34152};
        Merger merger = new Merger(array);
        merger.sort();
        System.out.println("Simple merger");
        for (int i : merger.getSorted()) {
            System.out.println(i);
        }
        MultiMerger multiMerger = new MultiMerger(array);
        multiMerger.start();
        try {
            multiMerger.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Multimerger");
        for (int i : multiMerger.getSorted()) {
            System.out.println(i);
        }

    }
}
