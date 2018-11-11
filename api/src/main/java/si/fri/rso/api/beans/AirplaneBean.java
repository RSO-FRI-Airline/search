package si.fri.rso.api.beans;

import si.fri.rso.models.entities.Airplane;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AirplaneBean extends EntityBean<Airplane> {
    public AirplaneBean() {
        super(Airplane.class);
    }
}
