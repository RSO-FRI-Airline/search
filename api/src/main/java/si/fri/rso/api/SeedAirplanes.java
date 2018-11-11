package si.fri.rso.api;

import si.fri.rso.api.beans.AirplaneBean;
import si.fri.rso.models.entities.Airplane;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("seed")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class SeedAirplanes {

    @Inject
    private AirplaneBean airplaneBean;

    @GET
    @Path("airplanes")
    public Response getEnrollmentTokenForStudent() {
        Airplane p = new Airplane();
        p.setName("Airbus A319");
        airplaneBean.add(p);

        return Response.ok("Airplanes seeded").build();
    }
}