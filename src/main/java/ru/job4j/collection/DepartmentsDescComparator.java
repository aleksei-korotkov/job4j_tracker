package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
            String[] leftParts = left.split("/");
            String[] rightParts = right.split("/");
            int minLength = Math.min(leftParts.length, rightParts.length);
            if (minLength > 0) {
                int result = rightParts[0].compareTo(leftParts[0]);
                if (result != 0) {
                    return result;
                }
            }
            for (int i = 1; i < minLength; i++) {
                int result = leftParts[i].compareTo(rightParts[i]);
                if (result != 0) {
                    return result;
                    }
                }
            return Integer.compare(leftParts.length, rightParts.length);
    }
}