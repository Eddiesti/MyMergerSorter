package ru.otus;

import org.junit.Before;

import static org.junit.Assert.*;

public class MultiMergerTest {
    private int[] notSorted = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
    private int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private Sorter multiMerger;

    @Before
    public void init() {
        multiMerger = new MultiMerger(notSorted);
    }

    @org.junit.Test
    public void sort() {
        multiMerger.sort();
        int[] sorted = multiMerger.getSorted();
        assertArrayEquals(this.sorted,sorted);
    }

}