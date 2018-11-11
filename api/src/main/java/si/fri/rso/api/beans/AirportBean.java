package si.fri.rso.api.beans;

import si.fri.rso.models.entities.Airplane;
import si.fri.rso.models.entities.Airport;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AirportBean extends RegisterBean<Airport> {
    public AirportBean() {
        super(Airport.class);
    }

    public Airport create(String id, String city){
        Airport a = new Airport();
        a.setId(id);
        a.setCity(city);
        add(a);
        return a;
    }
}
