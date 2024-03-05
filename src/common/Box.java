package common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box <T>{
    private Map<String, T> box;

    public Box() {
        this.box = new HashMap<>();
    }

    public T put(String key, T value)    {  return box.put(key, value); }

    public void put2(List<String> keys, Inventory<T> values)    {
        for (int i = 0; i < keys.size(); i++)   {
            box.put(keys.get(i), values.get(i));
        }

        box.forEach((k, v) -> System.out.printf("%s : %s%n", k, v));
    }

    public T get(String key)    {   return box.get(key);    }

    public int size()   {   return box.size();  }

    public void clear() {   box.clear();    }
}
