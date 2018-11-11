package si.fri.rso.api;

import si.fri.rso.api.beans.AirplaneBean;
import si.fri.rso.api.beans.AirportBean;
import si.fri.rso.api.beans.ScheduleBean;

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
public class Seeder {

    @Inject
    private AirplaneBean airplaneBean;

    @Inject
    private ScheduleBean scheduleBean;

    @Inject
    private AirportBean airportBean;

    @GET
    @Path("airplanes")
    public Response seedAirplanes() {
        airplaneBean.create("A319", "Airbus A319");
        airplaneBean.create("CRJ7", "Canadair Regional Jet 700");
        airplaneBean.create("CRJ9", "Canadair Regional Jet 900");
        airplaneBean.create("SB20", "Saab 2000");

        return Response.ok("Airplanes seeded").build();
    }

    @GET
    @Path("airports")
    public Response seedAirports() {
        airportBean.create("LJLJ", "Ljubljana");
        airportBean.create("EHAM", "Amsterdam");
        airportBean.create("LYBE", "Belgrade");
        airportBean.create("EBBR", "Brussels");
        airportBean.create("LROP", "Bucharest");
        airportBean.create("EKCH", "Copenhagen");
        airportBean.create("LDDU", "Dubrovnik");
        airportBean.create("EDDL", "Dusseldorf");
        airportBean.create("EDDF", "Frankfurt");
        airportBean.create("LSGG", "Geneva");
        airportBean.create("EDDH", "Hamburg");
        airportBean.create("LTBA", "Istanbul");
        airportBean.create("UKKK", "Kyiv");
        airportBean.create("UUEE", "Moscow");
        airportBean.create("EDDM", "Munich");
        airportBean.create("LFPG", "Paris");
        airportBean.create("LYPG", "Podgorica");
        airportBean.create("LKPR", "Prague");
        airportBean.create("BKPR", "Priština");
        airportBean.create("LYSA", "Sarajevo");
        airportBean.create("LWSK", "Skopje");
        airportBean.create("LBSF", "Sofia");
        airportBean.create("LATI", "Tirana");
        airportBean.create("LOWW", "Vienna");
        airportBean.create("EPWA", "Warsaw");
        airportBean.create("LSZH", "Zurich");

        return Response.ok("Airplanes seeded").build();
    }

    @GET
    @Path("schedule")
    public Response seedSchedule(){
        scheduleBean.create("----5--", "05:35", "07:30", "JP 434", "LJLJ", "EHAM", "CRJ9");
        scheduleBean.create("-2-----", "06:35", "08:30", "JP 435", "LJLJ", "EHAM", "CRJ9");
        scheduleBean.create("-----6-", "07:30", "09:25", "JP 436", "LJLJ", "EHAM", "CRJ9");
        scheduleBean.create("1-34---", "16:45", "18:40", "JP 499", "LJLJ", "EHAM", "A319");
        scheduleBean.create("------7", "17:05", "19:00", "JP 500", "LJLJ", "EHAM", "CRJ9");
        scheduleBean.create("---4---", "17:05", "19:00", "JP 501", "LJLJ", "EHAM", "CRJ9");
        scheduleBean.create("-----6-", "09:45", "10:45", "JP 9801", "LJLJ", "LYBE", "CRJ9");
        scheduleBean.create("-2-----", "09:45", "11:05", "JP 9803", "LJLJ", "LYBE", "CRJ9");
        scheduleBean.create("1-345--", "09:45", "11:05", "JP 9802", "LJLJ", "LYBE", "CRJ9");
        scheduleBean.create("12345-7", "20:50", "22:10", "JP 9804", "LJLJ", "LYBE", "A319");
        scheduleBean.create("123456-", "07:00", "08:40", "JP 376", "LJLJ", "EBBR", "A319");
        scheduleBean.create("12345-7", "17:15", "18:55", "JP 394", "LJLJ", "EBBR", "A319");
        scheduleBean.create("---4-6-", "06:45", "08:35", "JP 510", "LJLJ", "EKCH", "A319");
        scheduleBean.create("1-----7", "17:10", "19:00", "JP 513", "LJLJ", "EKCH", "CRJ9");
        scheduleBean.create("12-----", "06:45", "08:20", "JP 168", "LJLJ", "EDDL", "CRJ7");
        scheduleBean.create("---4---", "17:15", "18:50", "JP 164", "LJLJ", "EDDL", "CRJ7");
        scheduleBean.create("1234-67", "06:55", "08:15", "JP 118", "LJLJ", "EDDF", "A319");
        scheduleBean.create("1234567", "07:00", "08:20", "JP 116", "LJLJ", "EDDF", "A319");
        scheduleBean.create("12345-7", "13:50", "15:10", "JP 112", "LJLJ", "EDDF", "CRJ9");
        scheduleBean.create("1234567", "17:50", "19:10", "JP 124", "LJLJ", "EDDF", "A319");
        scheduleBean.create("12-456-", "09:35", "12:40", "JP 9302", "LJLJ", "LTBA", "CRJ9");
        scheduleBean.create("1-3-567", "19:55", "23:15", "JP 9304", "LJLJ", "LTBA", "A319");
        scheduleBean.create("12345--", "10:00", "13:50", "JP 914", "LJLJ", "UUEE", "A319");
        scheduleBean.create("-----67", "11:00", "14:50", "JP 913", "LJLJ", "UUEE", "A319");
        scheduleBean.create("1234567", "07:00", "08:05", "JP 102", "LJLJ", "EDDM", "CRJ9");
        scheduleBean.create("1234567", "16:55", "17:50", "JP 108", "LJLJ", "EDDM", "CRJ9");
        scheduleBean.create("--34-6-", "06:40", "08:30", "JP 322", "LJLJ", "LFPG", "CRJ9");
        scheduleBean.create("1---5--", "17:05", "18:55", "JP 342", "LJLJ", "LFPG", "A319");
        scheduleBean.create("1234567", "12:10", "13:15", "JP 852", "LJLJ", "LYPG", "SB20");
        scheduleBean.create("1-3----", "07:20", "08:25", "JP 568", "LJLJ", "LKPR", "SB20");
        scheduleBean.create("-2--5--", "17:00", "18:05", "JP 567", "LJLJ", "LKPR", "SB20");
        scheduleBean.create("1234567", "12:30", "13:55", "JP 838", "LJLJ", "BKPR", "SB20");
        scheduleBean.create("1234567", "12:30", "13:30", "JP 700", "LJLJ", "LYSA", "CRJ7");
        scheduleBean.create("1234567", "12:25", "13:55", "JP 826", "LJLJ", "LWSK", "CRJ9");
        scheduleBean.create("1-3-5--", "12:15", "13:55", "JP 324", "LJLJ", "LBSF", "SB20");
        scheduleBean.create("1234567", "12:20", "13:40", "JP 704", "LJLJ", "LATI", "CRJ7");
        scheduleBean.create("123456-", "07:05", "07:55", "JP 284", "LJLJ", "LOWW", "CRJ7");
        scheduleBean.create("1234567", "17:55", "18:45", "JP 136", "LJLJ", "LOWW", "CRJ7");
        scheduleBean.create("1-34-6-", "13:50", "15:30", "JP 9516", "LJLJ", "EPWA", "CRJ9");
        scheduleBean.create("-2--5-7", "17:10", "18:55", "JP 9518", "LJLJ", "EPWA", "CRJ7");
        scheduleBean.create("1234567", "07:15", "08:35", "JP 364", "LJLJ", "LSZH", "A319");
        scheduleBean.create("12345-7", "13:15", "14:25", "JP 310", "LJLJ", "LSZH", "CRJ9");
        scheduleBean.create("1234567", "17:05", "18:15", "JP 306", "LJLJ", "LSZH", "A319");
        scheduleBean.create("----5--", "09:25", "11:05", "JP 439", "EHAM", "LJLJ", "CRJ9");
        scheduleBean.create("-2-----", "09:55", "11:35", "JP 438", "EHAM", "LJLJ", "CRJ9");
        scheduleBean.create("-----6-", "10:30", "12:10", "JP 437", "EHAM", "LJLJ", "CRJ9");
        scheduleBean.create("1-34--7", "20:20", "22:00", "JP 498", "EHAM", "LJLJ", "A319");
        scheduleBean.create("-----6-", "07:15", "08:20", "JP 9806", "LYBE", "LJLJ", "CRJ9");
        scheduleBean.create("-2-----", "07:15", "08:40", "JP 9807", "LYBE", "LJLJ", "CRJ9");
        scheduleBean.create("1-345--", "07:15", "08:40", "JP 9808", "LYBE", "LJLJ", "CRJ9");
        scheduleBean.create("12345-7", "18:30", "19:50", "JP 9805", "LYBE", "LJLJ", "A319");
        scheduleBean.create("123456-", "09:45", "11:20", "JP 377", "EBBR", "LJLJ", "A319");
        scheduleBean.create("12345-7", "20:25", "22:00", "JP 395", "EBBR", "LJLJ", "A319");
        scheduleBean.create("---4-6-", "09:30", "11:20", "JP 511", "EKCH", "LJLJ", "A319");
        scheduleBean.create("1-----7", "19:55", "21:45", "JP 512", "EKCH", "LJLJ", "CRJ9");
        scheduleBean.create("12-----", "09:40", "11:10", "JP 169", "EDDL", "LJLJ", "CRJ7");
        scheduleBean.create("---4---", "20:10", "21:40", "JP 165", "EDDL", "LJLJ", "CRJ7");
        scheduleBean.create("1234567", "10:10", "11:20", "JP 117", "EDDF", "LJLJ", "A319");
        scheduleBean.create("12345-7", "16:00", "17:10", "JP 113", "EDDF", "LJLJ", "CRJ9");
        scheduleBean.create("1234567", "20:45", "21:55", "JP 125", "EDDF", "LJLJ", "A319");
        scheduleBean.create("12-456-", "07:20", "08:40", "JP 9301", "LTBA", "LJLJ", "CRJ9");
        scheduleBean.create("1-3-567", "17:45", "19:00", "JP 9303", "LTBA", "LJLJ", "A319");
        scheduleBean.create("12345--", "15:15", "17:15", "JP 915", "UUEE", "LJLJ", "A319");
        scheduleBean.create("-----67", "16:15", "18:15", "JP 916", "UUEE", "LJLJ", "A319");
        scheduleBean.create("1234567", "10:20", "11:20", "JP 103", "EDDM", "LJLJ", "CRJ9");
        scheduleBean.create("1234567", "20:55", "21:45", "JP 109", "EDDM", "LJLJ", "CRJ9");
        scheduleBean.create("--34-6-", "09:50", "11:30", "JP 323", "LFPG", "LJLJ", "CRJ9");
        scheduleBean.create("1---5--", "20:05", "21:45", "JP 343", "LFPG", "LJLJ", "A319");
        scheduleBean.create("1234567", "14:55", "15:50", "JP 853", "LYPG", "LJLJ", "SB20");
        scheduleBean.create("1-3----", "10:20", "11:20", "JP 569", "LKPR", "LJLJ", "SB20");
        scheduleBean.create("-2--5--", "20:35", "21:35", "JP 570", "LKPR", "LJLJ", "SB20");
        scheduleBean.create("1234567", "14:45", "16:00", "JP 839", "BKPR", "LJLJ", "SB20");
        scheduleBean.create("1234567", "14:50", "15:50", "JP 701", "LYSA", "LJLJ", "CRJ7");
        scheduleBean.create("1234567", "14:40", "16:10", "JP 827", "LWSK", "LJLJ", "CRJ9");
        scheduleBean.create("1-3-5--", "14:30", "16:10", "JP 325", "LBSF", "LJLJ", "SB20");
        scheduleBean.create("1234567", "14:40", "16:05", "JP 705", "LATI", "LJLJ", "CRJ7");
        scheduleBean.create("12345--", "10:40", "11:25", "JP 285", "LOWW", "LJLJ", "CRJ7");
        scheduleBean.create("-----67", "10:45", "11:30", "JP 286", "LOWW", "LJLJ", "CRJ7");
        scheduleBean.create("-----6-", "20:55", "21:40", "JP 138", "LOWW", "LJLJ", "CRJ7");
        scheduleBean.create("12345-7", "21:05", "21:40", "JP 137", "LOWW", "LJLJ", "CRJ7");
        scheduleBean.create("1-34-6-", "11:20", "13:15", "JP 9528", "EPWA", "LJLJ", "CRJ9");
        scheduleBean.create("-2--5-7", "14:40", "16:35", "JP 9529", "EPWA", "LJLJ", "CRJ7");
        scheduleBean.create("1234567", "10:20", "11:20", "JP 941", "LSZH", "LJLJ", "A319");
        scheduleBean.create("12345-7", "15:15", "16:15", "JP 942", "LSZH", "LJLJ", "CRJ9");
        scheduleBean.create("1234567", "20:55", "21:55", "JP 943", "LSZH", "LJLJ", "A319");
        return Response.ok("avto").build();
    }
}