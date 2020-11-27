package edu.epam.fadeev.entity;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportSchedule that = (AirportSchedule) o;
        return Objects.equals(schedule, that.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AirportSchedule{");
        sb.append("schedule=").append(schedule);
        sb.append('}');
        return sb.toString();
    }
}
