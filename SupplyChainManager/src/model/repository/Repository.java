package model.repository;

import java.util.ArrayList;

public abstract class Repository<T> {
    public abstract ArrayList<T> getAll();
    public abstract void save(T object);
}
