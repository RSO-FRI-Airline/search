package si.fri.rso.models.entities;

import javax.persistence.*;

@Entity
public class Airplane extends RegisterEntity{

    private String name;

    private int number_of_seats;

    public void setName(String name){
        this.name = name;
    }

    public String getName() { return name; }

}
