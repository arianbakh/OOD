package model;

import com.j256.ormlite.field.DatabaseField;

public class ModelBase {
    @DatabaseField(generatedId = true)
    private Integer id;

    public Integer getId() {
        return id;
    }
}
