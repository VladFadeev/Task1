package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.Airline;
import edu.epam.fadeev.entity.AirportSchedule;
import edu.epam.fadeev.entity.Weekday;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirportScheduleService {
    public List<Airline> findAirlinesByDestination(AirportSchedule schedule, String destination) {
        List<Airline> out = new ArrayList<Airline>();
        for (int i = 0; i < schedule.getLength(); i++) {
            if(schedule.getAirlineByIndex(i).getDestination() == destination)
                out.add(schedule.getAirlineByIndex(i));
        }
        return out;
    }

    public List<Airline> findAirlinesByWeekday(AirportSchedule schedule, Weekday weekday) {
        List<Airline> out = new ArrayList<Airline>();
        for (int i = 0; i < schedule.getLength(); i++) {
            if(schedule.getAirlineByIndex(i).isWeekdayIn(weekday))
                out.add(schedule.getAirlineByIndex(i));
        }
        return out;
    }

    public List<Airline> findAirlinesByWeekdayTime(AirportSchedule schedule, Weekday weekday, LocalTime time) {
        List<Airline> out = new ArrayList<Airline>();
        for (int i = 0; i < schedule.getLength(); i++) {
            if(schedule.getAirlineByIndex(i).isWeekdayIn(weekday) && time.compareTo(schedule.getAirlineByIndex(i).getDeparture()) < 0)
                out.add(schedule.getAirlineByIndex(i));
        }
        return out;
    }
}
