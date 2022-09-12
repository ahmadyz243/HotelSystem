package Service;

import Base.Service.BaseService;
import Entity.Costumer;

import java.io.FileNotFoundException;

public interface CostumerService extends BaseService<Costumer> {
    Costumer createNewCostumer();
    boolean existsById(int id);
}
