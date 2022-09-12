package Base.Repository;

import Base.Entity.BaseEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;


public abstract class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository<T> {
    protected File file;
    protected Scanner scanner;
    protected String path;
    protected FileWriter writer;
    protected Formatter formatter;
    @Override
    public int generateId() throws FileNotFoundException {
        file = new File(getFilePath());
        scanner = new Scanner(file);
        int id = 0;
        while (scanner.hasNextLine()){
            id = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        }
        return ++id;
    }
}
