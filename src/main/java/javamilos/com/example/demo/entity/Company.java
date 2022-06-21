package javamilos.com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private int employees;

    public Company(){
    }

    public Company(long id, String name, String address, int employees){
        this.id = id;
        this.name=name;
        this.address=address;
        this.employees=employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Company{" + "name="+ name + ", address=" + address + ", ëmployees=" + employees +'}';
    }
}
