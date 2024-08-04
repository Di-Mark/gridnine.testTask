package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FilterImp implements Filter{
    @Override
    public List<Flight> filterDepartureBeforeTheCurrentTime(List<Flight> flights) {
        return  flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> !segment.getDepartureDate()
                                .isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> filterArrivalDateBeforeDepartureDate(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> !segment.getArrivalDate()
                                .isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> filterGroundTimeMoreTwoHours(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> !(flight.getSegments().size() > 1)
                        || !checkTimeBetweenArrivalAndDeparture(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private boolean checkTimeBetweenArrivalAndDeparture(List<Segment> segments) {
        double time = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            time += Duration.between(segments.get(i).getArrivalDate(),
                    segments.get(i + 1).getDepartureDate()).toMinutes();
        }
        return time / 60 > 2;
    }
}
