package test.epam.fadeev.service;

import edu.epam.fadeev.entity.Airline;
import edu.epam.fadeev.entity.AirportSchedule;
import edu.epam.fadeev.entity.PlaneType;
import edu.epam.fadeev.entity.Weekday;
import edu.epam.fadeev.service.AirportScheduleService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class AirportScheduleServiceTest {
    public AirportSchedule schedule;
    @BeforeClass
    public void scheduleInit() {
        Airline line1 = new Airline("Moscow", 34, PlaneType.TU134, LocalTime.of(10,40), new Weekday[]{Weekday.MONDAY, Weekday.FRIDAY});
        Airline line2 = new Airline("Minsk", 634, PlaneType.TU154, LocalTime.of(12,50), new Weekday[]{Weekday.MONDAY, Weekday.SATURDAY});
        Airline line3 = new Airline("Moscow", 345, PlaneType.TU154, LocalTime.of(11,20), new Weekday[]{Weekday.MONDAY, Weekday.SUNDAY});
        Airline line4 = new Airline("Moscow", 24, PlaneType.BOEING747, LocalTime.of(15,30), new Weekday[]{Weekday.THURSDAY, Weekday.FRIDAY});
        Airline line5 = new Airline("Minsk", 734, PlaneType.BOEING767, LocalTime.of(18,30), new Weekday[]{Weekday.MONDAY});
        Airline line6 = new Airline("Tomsk", 374, PlaneType.TU204, LocalTime.of(13,45), new Weekday[]{Weekday.WEDNESDAY, Weekday.FRIDAY});
        Airline line7 = new Airline("Riga", 894, PlaneType.AIRBUSA320, LocalTime.of(22,10), new Weekday[]{Weekday.WEDNESDAY, Weekday.FRIDAY, Weekday.MONDAY});
        Airline line8 = new Airline("Omsk", 90, PlaneType.AIRBUSA330, LocalTime.of(19,0), new Weekday[]{Weekday.MONDAY, Weekday.FRIDAY});
        schedule = new AirportSchedule(List.of(line1, line2, line3, line4, line5, line6, line7, line8));
    }

    @Test
    public void findAirlinesByDestinationTest() {
        String destination = "Moscow";
        AirportScheduleService t = new AirportScheduleService();
        List<Airline> actual = t.findAirlinesByDestination(schedule, destination);
        List<Airline> expected = List.of(schedule.getAirlineByIndex(0), schedule.getAirlineByIndex(2), schedule.getAirlineByIndex(3));
        assertEquals(actual, expected);
    }

    @Test
    public void findAirlinesByWeekdayTest() {
        Weekday day = Weekday.MONDAY;
        AirportScheduleService t = new AirportScheduleService();
        List<Airline> actual = t.findAirlinesByWeekday(schedule, day);
        List<Airline> expected = List.of(schedule.getAirlineByIndex(0), schedule.getAirlineByIndex(1), schedule.getAirlineByIndex(2), schedule.getAirlineByIndex(4), schedule.getAirlineByIndex(6), schedule.getAirlineByIndex(7));
        assertEquals(actual, expected);
    }

    @Test
    public void findNoneAirlinesByWeekdayTest() {
        Weekday day = Weekday.TUESDAY;
        AirportScheduleService t = new AirportScheduleService();
        List<Airline> actual = t.findAirlinesByWeekday(schedule, day);
        List<Airline> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    public void findAirlinesByWeekdayTime() {
        Weekday day = Weekday.FRIDAY;
        LocalTime time = LocalTime.of(13,50);
        AirportScheduleService t = new AirportScheduleService();
        List<Airline> actual = t.findAirlinesByWeekdayTime(schedule, day, time);
        List<Airline> expected = List.of(schedule.getAirlineByIndex(3), schedule.getAirlineByIndex(6), schedule.getAirlineByIndex(7));
        assertEquals(actual, expected);
    }
}