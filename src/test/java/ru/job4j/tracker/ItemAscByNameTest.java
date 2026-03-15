package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    void whenItemSortedAscendingByName() {
        List<Item> items = Arrays.asList(new Item("Reboot server"),
                new Item("Implement task №2"),
                new Item("Fix bug №2"),
                new Item("Implement task №1"),
                new Item("Fix bug №1"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("Fix bug №1"),
                new Item("Fix bug №2"),
                new Item("Implement task №1"),
                new Item("Implement task №2"),
                new Item("Reboot server"));
        assertThat(items).containsAll(expected);
    }
}