package Base.Entity;

import java.io.Flushable;

public abstract class BaseEntity {
    public BaseEntity() {
    }

    private int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
