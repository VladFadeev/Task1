package edu.epam.fadeev.entity;

import java.util.List;

public class AirportSchedule {
    private List<Airline> schedule;

    public AirportSchedule(List<Airline> schedule) {
        this.schedule = schedule;
    }

    public void setSchedule(List<Airline> schedule) {
        this.schedule = schedule;
    }

    public List<Airline> getSchedule() {
        return schedule;
    }

    public Airline getAirlineByIndex(int index) {
        return schedule.get(index);
    }

    public int getLength() {
        return schedule.size();
    }
}
