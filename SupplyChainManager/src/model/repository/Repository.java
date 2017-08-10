package model.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

public abstract class Repository<T> {
    private Dao<T, Integer> dao;

    @SuppressWarnings("unchecked")
    Repository() {
        try {
            dao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public List<T> getAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public void save(T object) {
        try {
            dao.update(object);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void create(T object) {
        try {
            dao.create(object);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    Dao<T, Integer> getDao() {
        return dao;
    }
}
