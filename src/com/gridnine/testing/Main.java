package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        Filter filter = new FilterImp();
        System.out.println(filter.filterDepartureBeforeTheCurrentTime(flights) + "\n");
        System.out.println(filter.filterArrivalDateBeforeDepartureDate(flights) + "\n");
        System.out.println(filter.filterGroundTimeMoreTwoHours(flights));
    }
}
