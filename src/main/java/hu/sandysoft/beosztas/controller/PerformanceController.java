package hu.sandysoft.beosztas.controller;

import hu.sandysoft.beosztas.Validator;
import hu.sandysoft.beosztas.dto.ErrorResponse;
import hu.sandysoft.beosztas.dto.Performance;
import hu.sandysoft.beosztas.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PerformanceController {

    @Autowired
    private PerformanceRepository performanceRepository;

    private final Validator validator = new Validator();

    @GetMapping("/performances")
    public ResponseEntity<List<Performance>> performances() {
        return new ResponseEntity<>(performanceRepository.getPerformances(), HttpStatus.OK);
    }

    @PostMapping("/add_performance")
    public ResponseEntity<?> addPerformance(@RequestBody Performance performance) {
        if(validator.validate(performance)) {
            return new ResponseEntity<>(performanceRepository.addPerformance(performance), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Forbidden Text value"), HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/delete_performance/{name}")
    public ResponseEntity<?> deletePerformance(@PathVariable String name) {
        try {
            performanceRepository.deletePerformanceByName(name);
            return new ResponseEntity<>("Performance deleted successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("Performance not found"), HttpStatus.NOT_FOUND);
        }
    }
}