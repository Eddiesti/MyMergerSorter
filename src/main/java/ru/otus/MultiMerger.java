package ru.otus;

public class MultiMerger extends Thread {
    private int[] unsorted, sorted;
    private static final int MAX_THREADS = 4;


    public MultiMerger(int[] unsorted) {
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
            if (activeCount() < MAX_THREADS) {
                MultiMerger leftSort = new MultiMerger(left);
                MultiMerger rightSort = new MultiMerger(right);
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
