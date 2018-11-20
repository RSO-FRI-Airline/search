package si.fri.rso.models.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Price extends BaseEntity{

    private float price;

    @ManyToOne
    private Schedule schedule;

    private Date date;

    private int ticketClass;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(int ticketClass) {
        this.ticketClass = ticketClass;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
