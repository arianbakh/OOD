package model.repository;

import java.util.ArrayList;

public abstract class Repository<T> {
    private ArrayList<T> objects;

    Repository() {
        objects = new ArrayList<>();
    }

    public ArrayList<T> getAll() {
        return objects;
    }

    public void save(T object) {
        objects.add(object);
    }
}
