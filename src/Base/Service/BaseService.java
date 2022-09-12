package Base.Service;

import java.io.IOException;

public interface BaseService<T> {
    void save(T t);
    T findById(int id);
}
