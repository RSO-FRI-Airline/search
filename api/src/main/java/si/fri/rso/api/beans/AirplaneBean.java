package si.fri.rso.api.beans;

import si.fri.rso.models.entities.Airplane;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AirplaneBean extends RegisterBean<Airplane> {
    public AirplaneBean() {
        super(Airplane.class);
    }

    public Airplane create(String id, String name){
        Airplane a = new Airplane();
        a.setId(id);
        a.setName(name);
        add(a);
        return a;
    }
}
