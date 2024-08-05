package com.gridnine.testing;

import java.util.List;

public interface Filter {
    List<Flight> filterDepartureBeforeTheCurrentTime(List<Flight> flights);

    List<Flight> filterArrivalDateBeforeDepartureDate(List<Flight> flights);

    List<Flight> filterGroundTimeMoreTwoHours(List<Flight> flights);
}
