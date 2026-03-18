package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftLength = left.length();
        int rightLength = right.length();
        int length;
        int result = 0;
        if (leftLength == rightLength) {
            length = leftLength;
        } else {
            length = Math.min(leftLength, rightLength);
        }
        for (int i = 0; i < length; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result == 0 ? Integer.compare(left.length(), right.length()) : result;
    }
}