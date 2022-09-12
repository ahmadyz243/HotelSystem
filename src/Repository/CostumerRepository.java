package Repository;

import Base.Repository.BaseRepository;
import Entity.Costumer;

import java.io.FileNotFoundException;

public interface CostumerRepository extends BaseRepository<Costumer> {
    boolean existsById(int id) throws FileNotFoundException;
}
