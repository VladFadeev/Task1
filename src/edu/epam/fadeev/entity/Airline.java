package edu.epam.fadeev.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String destination;
    private int flightNumber;
    private PlaneType planeType;
    private LocalTime departure;
    private List<Weekday> weekdays;

    public Airline(String destination, int flightNumber, PlaneType planeType,
                   LocalTime departure, Weekday[] weekdays) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departure = departure;
        this.weekdays = List.of(weekdays);
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public  void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public  void setWeekdays(Weekday[] weekdays) {
        this.weekdays = List.of(weekdays);
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public List<Weekday> getWeekdays() {
        return weekdays;
    }

    public boolean isWeekdayIn(Weekday weekday) {
        for (int i = 0; i < weekdays.size(); i++) {
            if(weekday == weekdays.get(i))
                return true;
        }
        return false;
    }
}
