package si.fri.rso.api.beans;

import si.fri.rso.models.entities.Airplane;
import si.fri.rso.models.entities.Price;

import javax.enterprise.context.RequestScoped;
import javax.swing.text.html.parser.Entity;

@RequestScoped
public class PriceBean extends EntityBean<Price> {
    public PriceBean() {
        super(Price.class);
    }

}
