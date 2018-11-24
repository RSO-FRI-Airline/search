package si.fri.rso.api.endpoints;

import si.fri.rso.api.beans.AirportBean;
import si.fri.rso.models.entities.Airport;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("airports")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AirportsEndpoint {
    @Inject
    private AirportBean airportBean;

    @GET
    public Response get(){
        List<Airport> airports = airportBean.get();
        return Response.ok(airports).build();
    }
}