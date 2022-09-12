package Entity;


import Base.Entity.BaseEntity;

import java.io.Serializable;

public class Service extends BaseEntity implements Serializable {
    public Service() {
    }
    private static final int serialVersionUID = 2;
    private int costumerid;
    private String servicetype;
    private int amount;

    @Override
    public String toString() {
        return "Service{" +
                "servicetype='" + servicetype + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Service(int id, String servicetype, int amount, int costumerid) {
        super(id);
        this.costumerid = costumerid;
        this.servicetype = servicetype;
        this.amount = amount;
    }

    public int getCostumerid() {
        return costumerid;
    }

    public void setCostumerid(int costumerid) {
        this.costumerid = costumerid;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
