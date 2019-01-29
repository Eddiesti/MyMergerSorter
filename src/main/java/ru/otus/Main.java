package ru.otus;


public class Main {
    public static void main(String[] args) {
        int[] array = {123, 123123, 123, 123, 345, 313, 42, 1, 2, 3, 4234, 5345, 64};
        MultiMerger multiMerger = new MultiMerger(array);
        Merger merger = new Merger(array);
        merger.sort();
        System.out.println("Merger");
        for (int i : merger.getSorted()) {
            System.out.println(i);
        }
        multiMerger.sort();
        System.out.println("MultiMerger");
        for (int i : multiMerger.getSorted()) {
            System.out.println(i);
        }
    }
}
