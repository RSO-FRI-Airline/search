package si.fri.rso.api.endpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import si.fri.rso.api.beans.AirportBean;
import si.fri.rso.api.beans.ScheduleBean;
import si.fri.rso.models.entities.Airport;
import si.fri.rso.models.entities.Schedule;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;


@JsonIgnoreProperties(ignoreUnknown = true)
class SearchQuery{
    public Airport origin, destination;
    public String date;
}

class SearchResult{
    public Schedule schedule;
    public double[] fares;
    public String date;
}

@Path("search")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class SearchEndpoint {

    @Inject
    private ScheduleBean scheduleBean;

    private Random random = new Random();

    private SearchResult GetResult(Schedule s, SearchQuery query){
        SearchResult r = new SearchResult();
        r.schedule = s;
        r.fares = new double[3];
        double basePrice =
                LocalTime.now().get(ChronoField.HOUR_OF_DAY) > 15?8.98: 9.21;
        r.fares[0] = Math.round(basePrice * Math.sqrt(s.GetDuration()))-1;
        r.fares[1] = Math.round(r.fares[0] * (random.nextDouble()*0.2+1.1))-1;
        r.fares[2] = Math.round(r.fares[1] * (random.nextDouble()*0.1+1.1))-1;
        r.date = query.date;
        return r;
    }

    @POST
    public Response post(SearchQuery query){
        int i = LocalDate.parse(query.date).get(DAY_OF_WEEK);

        List<Schedule> schedules = scheduleBean.find(query.origin, query.destination);

        return Response.ok(schedules.stream()
                .filter(s -> (s.getDay_of_week() & i) > 0)
                .map(s -> GetResult(s, query))
                .toArray()).build();
    }
}
