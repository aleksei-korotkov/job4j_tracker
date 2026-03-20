package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] splitStringLeft = left.split("\\.", 2);
        String[] splitStringRight = right.split("\\.", 2);
        return Integer.compare(Integer.parseInt(splitStringLeft[0]), Integer.parseInt(splitStringRight[0]));
    }
}