package ru.otus;

public class MultiMerger implements Sorter {
    private int[] unsorted, sorted;

    public MultiMerger(int[] unsorted) {
        this.unsorted = unsorted;
    }

    public void sort() {
        MultiMergerThread multiMergerThread = new MultiMergerThread(unsorted);
        multiMergerThread.start();
        try {
            multiMergerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sorted = multiMergerThread.getSorted();
    }

    public int[] getSorted() {
        return sorted;
    }
}
