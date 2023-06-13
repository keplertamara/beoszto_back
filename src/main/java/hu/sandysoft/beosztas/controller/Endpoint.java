package hu.sandysoft.beosztas.controller;

import hu.sandysoft.beosztas.ScheduleCalculation;
import hu.sandysoft.beosztas.dto.ErrorResponse;
import hu.sandysoft.beosztas.dto.Performance;
import hu.sandysoft.beosztas.dto.WeeklyTheaterSchedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Endpoint {
    @PostMapping("/add_week_schedule")
    public ResponseEntity<?> addPerformance(@RequestBody WeeklyTheaterSchedule weeklyTheaterSchedule) {
        ScheduleCalculation.weeklyTheaterSchedule = weeklyTheaterSchedule;
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
