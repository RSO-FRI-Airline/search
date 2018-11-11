package si.fri.rso.models.entities;

import javax.persistence.Entity;

@Entity
public class Airport extends RegisterEntity {
    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
