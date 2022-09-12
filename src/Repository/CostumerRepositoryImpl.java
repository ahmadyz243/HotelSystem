package Repository;

import Base.Repository.BaseRepositoryImpl;
import Entity.Costumer;
import Enumiration.Gender;

import java.io.*;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class CostumerRepositoryImpl extends BaseRepositoryImpl<Costumer> implements CostumerRepository {
    @Override
    public void save(Costumer costumer) throws IOException {
        if (file == null) {
            file = new File(getFilePath());
        }
        if(writer == null){
            writer = new FileWriter(file, true);
        }
        if(formatter == null){
            formatter = new Formatter(writer);
        }
        formatter.format("%s %s %s %s", costumer.getId(), costumer.getName(),
                costumer.getLastname(), costumer.getGender() + "\n");
        formatter.close();
    }

    @Override
    public Costumer findById(int id) throws FileNotFoundException {
        Costumer costumer;
        if (file == null) {
            file = new File(getFilePath());
        }
        scanner = new Scanner(file);
        while (scanner.hasNext()){
            costumer = new Costumer(
                    scanner.nextInt(), scanner.next(), scanner.next(), Gender.valueOf(scanner.next()));
            if(costumer.getId() == id){
                return costumer;
            }
        }
        System.out.println("Costumer not found!!!");
        return null;
    }

    @Override
    public List<Costumer> findAll() {
        return null;
    }

    @Override
    public String getFilePath() {
        if (path == null) {
            path = "C:\\Users\\Rayan system\\Desktop\\java\\HotelSystem\\HotelSystem\\HotelCostumers.txt";
        }
        return this.path;
    }


    @Override
    public boolean existsById(int id) throws FileNotFoundException {
        Costumer costumer;
        if (file == null) {
            file = new File(getFilePath());
        }
        scanner = new Scanner(file);
        while (scanner.hasNext()){
            costumer = new Costumer(
                    scanner.nextInt(), scanner.next(), scanner.next(), Gender.valueOf(scanner.next()));
            if(costumer.getId() == id){
                return true;
            }
        }
        return false;
    }
}
