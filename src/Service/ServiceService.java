package Service;

import Base.Service.BaseService;
import Entity.Service;

public interface ServiceService extends BaseService<Service> {
    Service createNewServiceForCostumer();
    void viewCostumerBill();
}
