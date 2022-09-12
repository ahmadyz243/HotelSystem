package Service.Impl;

import Base.Service.BaseServiceImpl;
import Entity.Service;
import Repository.ServiceRepository;
import Service.ServiceService;
import Repository.ServiceRepositoryImpl;
import Util.AppContex;
import Util.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceServiceImpl extends BaseServiceImpl<Service, ServiceRepository> implements ServiceService {
    public ServiceServiceImpl(ServiceRepository repository) {
        super(repository);
    }


    @Override
    public Service createNewServiceForCostumer() {
        Service service = new Service();
        try {
            service.setId(repository.generateId());
        } catch (FileNotFoundException e) {
            System.out.println("file not found while generating id!!!");
        }
        System.out.println("enter the service type:");
        service.setServicetype(Menu.stringScanner());
        System.out.println("Amount:");
        service.setAmount(Menu.numberScanner());
        System.out.println("enter costumer id:");
        int costumerid = 0;
        do {
            costumerid = Menu.numberScanner();
            if (!AppContex.costumerService.existsById(costumerid)) {
                System.out.println("costumer does not exists!");
            }
        } while (!AppContex.costumerService.existsById(costumerid));
        service.setCostumerid(costumerid);
        return service;
    }

    @Override
    public void viewCostumerBill() {
        int id, totalprice = 0;
        List<Service> serviceList = new ArrayList<>();
        do {
            System.out.println("enter costumer's ID:");
            id = Menu.numberScanner();
            if (!AppContex.costumerService.existsById(id)) {
                System.out.println("costumer does not exists!!!");
            } else {
                try {
                    serviceList = repository.findAll();
                } catch (FileNotFoundException e) {
                    System.out.println("file not found while selecting services!!!");
                }
                for (Service service:serviceList) {
                    if(service.getCostumerid() == id){
                        System.out.println(service);
                        totalprice += service.getAmount();
                    }
                }
                System.out.println("total price = " + totalprice);
                break;
            }
        } while (true);
    }

    @Override
    public void save(Service service) {
        try {
            repository.save(service);
        } catch (IOException e) {
            System.out.println("IO exeption happened while saving service!!!");
        }
    }

    @Override
    public Service findById(int id) {
        return null;
    }
}
