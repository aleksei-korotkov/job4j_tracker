package ru.job4j.collection;

import java.util.*;

public class Departments implements Comparator<String> {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String start = "";
            for (String element : value.split("/")) {
                start = start + element;
                temp.add(start);
                start = start + "/";
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }

    @Override
    public int compare(String left, String right) {
        return left.compareTo(right);
    }
}