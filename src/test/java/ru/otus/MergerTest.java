package ru.otus;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergerTest {
    private int[] notSorted = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
    private int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private Sorter merger;
    @Before
    public void init(){
        merger = new Merger(notSorted);
    }

    @Test
    public void sort() {
        merger.sort();
        int[] sorted = merger.getSorted();
        assertArrayEquals(this.sorted,sorted);
    }
}