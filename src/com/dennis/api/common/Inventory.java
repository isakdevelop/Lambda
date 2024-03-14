package com.dennis.api.common;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Inventory<T> {
    private ArrayList<T> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void add(T t)  {
        inventory.add(t);
    }

    public T remove(int index) {
        return inventory.remove(index);
    }

    public T get(int index) {
        return inventory.get(index);
    }

    public boolean contains(T t)    {
        return inventory.contains(t);
    }

    public void clear() {
        inventory.clear();
    }

    public void forEach(Consumer<? super T> action)  {
        inventory.forEach(action);
    }

}

