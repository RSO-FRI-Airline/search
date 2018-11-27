package si.fri.rso.api.beans;

import org.eclipse.microprofile.metrics.Histogram;
import org.eclipse.microprofile.metrics.annotation.Metric;
import si.fri.rso.models.entities.Airport;
import si.fri.rso.models.entities.Schedule;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import java.sql.Time;
import java.util.List;

@RequestScoped
public class ScheduleBean extends RegisterBean<Schedule> {

    @Inject
    @Metric(name = "simple_histogram")
    Histogram histogram;

    @Inject
    AirportBean airportBean;

    @Inject
    AirplaneBean airplaneBean;

    public ScheduleBean() {
        super(Schedule.class);
    }

    private int calculateDays(String days){
        int r = 0;
        for(int i = 0 ; i < 7; i++){
            if(days.contains((i+1)+"")){
                r |= 1 << i;
            }
        }
        return r;
    }

    private Time calculateTime(String time){
        String[] split = time.split(":");
        return new Time(Integer.parseInt(split[0]), Integer.parseInt(split[1]),0);
    }

    public Schedule create(String days, String dep, String arr, String id, String orig, String dest, String air){
        Schedule a = new Schedule();
        a.setId(id);
        a.setDay_of_week(calculateDays(days));
        a.setStart_time(calculateTime(dep));
        a.setEnd_time(calculateTime(arr));
        a.setOrigin(airportBean.get(orig));
        a.setDestination(airportBean.get(dest));
        a.setAirplane(airplaneBean.get(air));
        add(a);
        return a;
    }

    public List<Schedule> find(Airport origin, Airport destination){
        Query q = em.createQuery("SELECT o FROM Schedule o" +
                " WHERE o.destination.id = '" + destination.getId() +"'"+
                " AND o.origin.id = '" + origin.getId()+"'");
        List<Schedule> results = q.getResultList();
        histogram.update(results.size());
        return results;
    }
}
