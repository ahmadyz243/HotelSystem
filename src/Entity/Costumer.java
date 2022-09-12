package Entity;


import Base.Entity.BaseEntity;
import Enumiration.Gender;

import java.io.Serializable;

public class Costumer extends BaseEntity implements Serializable {

    private static final int serialVersionUID = 1;
    private String name;
    private String lastname;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Costumer() {
    }

    public Costumer(int id, String name, String lastname, Gender gender) {
        super(id);
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                '}';
    }
}
