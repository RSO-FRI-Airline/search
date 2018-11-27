package si.fri.rso.api.endpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Metric;
import si.fri.rso.api.beans.AirportBean;
import si.fri.rso.api.beans.PriceBean;
import si.fri.rso.api.beans.ScheduleBean;
import si.fri.rso.models.entities.Airport;
import si.fri.rso.models.entities.Price;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;


@JsonIgnoreProperties(ignoreUnknown = true)
class SearchQuery{
    public Airport origin, destination;
    public Date date;
}

class SearchResult{
    public Schedule schedule;
    public Date date;
    public Price[] prices;
}

@Path("search")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class SearchEndpoint {

    @Inject
    @Metric(name = "price_counter")
    private Counter counter;

    @Inject
    private ScheduleBean scheduleBean;

    private Random random = new Random();

    @Inject
    private PriceBean priceBean;

    private SearchResult GetResult(Schedule s, SearchQuery query){
        SearchResult r = new SearchResult();
        r.schedule = s;
        r.prices = new Price[3];

        double basePrice =
                LocalTime.now().get(ChronoField.HOUR_OF_DAY) > 15?8.98: 9.21;

        Price p = new Price();
        p.setDate(query.date);
        p.setSchedule(s);
        p.setPrice(Math.round(basePrice * Math.sqrt(s.GetDuration()))-1);
        p.setTicketClass(0);
        priceBean.add(p);
        r.prices[0] = p;

        p = new Price();
        p.setDate(query.date);
        p.setSchedule(s);
        p.setPrice(Math.round(r.prices[0].getPrice() * (random.nextDouble()*0.2+1.1))-1);
        p.setTicketClass(1);
        priceBean.add(p);
        r.prices[1] = p;

        p = new Price();
        p.setDate(query.date);
        p.setSchedule(s);
        p.setPrice(Math.round(r.prices[1].getPrice() * (random.nextDouble()*0.1+1.1))-1);
        p.setTicketClass(2);
        priceBean.add(p);
        r.prices[2] = p;

        counter.inc(4);
        r.date = query.date;
        return r;
    }

    @POST
    @Metered(name = "search_requests")
    public Response post(SearchQuery query){
        Calendar c = Calendar.getInstance();
        c.setTime(query.date);
        int i = c.get(Calendar.DAY_OF_WEEK);

        List<Schedule> schedules = scheduleBean.find(query.origin, query.destination);

        return Response.ok(schedules.stream()
                .filter(s -> (s.getDay_of_week() & i) > 0)
                .map(s -> GetResult(s, query))
                .toArray()).build();
    }

    @Path("/price/{token}")
    @GET
    @Metered(name = "get_price_requests")
    public Response getPrice(@PathParam(value = "token") int token){
        return Response.ok(priceBean.get(token)).build();
    }
}
