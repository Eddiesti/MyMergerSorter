package ru.otus;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiMergerThread extends Thread {
    private int[] unsorted, sorted;
    private static final int MAX_THREADS = 4;
    private static AtomicInteger activeThreads = new AtomicInteger(0);

    public MultiMergerThread(int[] unsorted) {
        this.unsorted = unsorted;
    }

    public void run() {
        int middle;
        int[] left, right;
        if (unsorted.length <= 1) {
            sorted = unsorted;
        } else {
            middle = unsorted.length / 2;
            left = new int[middle];
            right = new int[unsorted.length - middle];
            System.arraycopy(unsorted, 0, left, 0, middle);
            System.arraycopy(unsorted, middle, right, 0, unsorted.length - middle);
            if (MAX_THREADS < activeThreads.get()) {
                MultiMergerThread leftSort = new MultiMergerThread(left);
                MultiMergerThread rightSort = new MultiMergerThread(right);
                leftSort.start();
                rightSort.start();
                try {
                    leftSort.join();
                    rightSort.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sorted = Merger.merge(leftSort.getSorted(), rightSort.getSorted());
            } else {
                Merger leftSort = new Merger(left);
                Merger rightSort = new Merger(right);
                leftSort.sort();
                rightSort.sort();
                sorted = Merger.merge(leftSort.getSorted(), rightSort.getSorted());
            }
        }
    }

    public int[] getSorted() {
        return sorted;
    }
}