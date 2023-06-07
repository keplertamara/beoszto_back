package hu.sandysoft.beosztas.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WeeklyTheaterSchedule {
    private Map<String, List<Performance>> theaterSchedule;
}
