package Repository;

import Base.Repository.BaseRepositoryImpl;
import Entity.Costumer;
import Entity.Service;
import Enumiration.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Service> implements ServiceRepository {
    String path;

    @Override
    public void save(Service service) throws IOException {
        if (file == null) {
            file = new File(getFilePath());
        }
        if(writer == null){
            writer = new FileWriter(file, true);
        }
        if(formatter == null){
            formatter = new Formatter(writer);
        }
        formatter.format("%s %s %s %s", service.getId(), service.getServicetype(),
                service.getAmount(), service.getCostumerid() + "\n");
        formatter.close();
    }

    @Override
    public Service findById(int id) throws FileNotFoundException {
        Service service;
        if (file == null) {
            file = new File(getFilePath());
        }
        scanner = new Scanner(file);
        while (scanner.hasNext()){
            service = new Service(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt());
            if(service.getId() == id){
                return service;
            }
        }
        System.out.println("Costumer not found!!!");
        return null;
    }

    @Override
    public List<Service> findAll() throws FileNotFoundException {
        Service service;
        List<Service> services = new ArrayList<>();
        if (file == null) {
            file = new File(getFilePath());
        }
        scanner = new Scanner(file);
        while (scanner.hasNext()){
            service = new Service(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt());
            services.add(service);
        }
        return services;
    }

    @Override
    public String getFilePath() {
        if (path == null){
            path = "C:\\Users\\Rayan system\\Desktop\\java\\HotelSystem\\HotelSystem\\ServicesHistory.txt";
        }
        return this.path;
    }
}
