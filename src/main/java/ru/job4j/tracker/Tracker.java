package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> itemByName = new ArrayList<>(items.size());
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemByName.add(item);
            }
        }
        return List.copyOf(itemByName);
    }

    private int indexOf(int id) {
    int result = -1;
    for (Item item : items) {
        if (item.getId() == id) {
            result = items.indexOf(item);
            break;
        }
    }
    return result;
}

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.remove(index);
            items.add(index, item);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
    }
}