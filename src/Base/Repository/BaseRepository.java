package Base.Repository;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BaseRepository<T> {

    void save(T t) throws IOException;

    T findById(int id) throws FileNotFoundException;

    List<T> findAll() throws FileNotFoundException;
    String getFilePath();
    int generateId() throws FileNotFoundException;

}
