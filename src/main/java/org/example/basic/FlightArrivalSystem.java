package org.example.basic;

import java.time.LocalDate;
import java.util.List;

public class FlightArrivalSystem {

    private static final String CURRENT_STATUS = "Delayed";
    private static final String LINE_BREAK = "\n";

    public String getFlightStatus(List<LocalDate> arrivalDates) {
        StringBuilder status = new StringBuilder();
        for (LocalDate arrivalDate : arrivalDates) {
            if (arrivalDate.isAfter(LocalDate.now())) {
                status.append(arrivalDate).append(LINE_BREAK);
            } else {
                status.append(CURRENT_STATUS).append(LINE_BREAK);
            }
        }
        return status.toString();
    }
}
