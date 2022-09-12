package Service.Impl;

import Base.Service.BaseServiceImpl;
import Entity.Costumer;
import Repository.CostumerRepository;
import Repository.CostumerRepositoryImpl;
import Service.CostumerService;
import Util.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CostumerServiceImpl extends BaseServiceImpl<Costumer, CostumerRepository> implements CostumerService {
    public CostumerServiceImpl(CostumerRepository repository) {
        super(repository);
    }

    @Override
    public void save(Costumer costumer) {
        try {
            repository.save(costumer);
        }catch (IOException e){
            System.out.println("IO exeption happened while saving costumer!!!");
        }
    }

    @Override
    public Costumer findById(int id) {
        return null;
    }

    @Override
    public Costumer createNewCostumer() {
        Costumer costumer = new Costumer();
        try {
            costumer.setId(repository.generateId());
        }catch (FileNotFoundException e){
            System.out.println("file not found while generating id!!!");
        }
        System.out.println("enter costumer's name:");
        costumer.setName(Menu.stringScanner());
        System.out.println("enter costumer's last name:");
        costumer.setLastname(Menu.stringScanner());
        costumer.setGender(Menu.chooseGender());
        return costumer;
    }

    @Override
    public boolean existsById(int id) {
        try {
            return repository.existsById(id);
        }catch (FileNotFoundException e){
            System.out.println("file not found while checking costumer ID!!!");
            return false;
        }
    }
}
