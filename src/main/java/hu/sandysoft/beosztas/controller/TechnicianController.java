package hu.sandysoft.beosztas.controller;

import hu.sandysoft.beosztas.Validator;
import hu.sandysoft.beosztas.dto.ErrorResponse;
import hu.sandysoft.beosztas.dto.Technician;
import hu.sandysoft.beosztas.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TechnicianController {

    @Autowired
    private TechnicianRepository technicianRepository;
    private final Validator validator = new Validator();

    @GetMapping("/technicians")
    public ResponseEntity<List<Technician>> technicians() {
        return new ResponseEntity<>(technicianRepository.getTechnicians(), HttpStatus.OK);
    }

    @PostMapping("/add_technician")
    public ResponseEntity<?> addTechnician(@RequestBody Technician technician) {
        if(validator.validate(technician)) {
            return new ResponseEntity<>(technicianRepository.addTechnician(technician), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Forbidden Text value"), HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/delete_technician/{name}")
    public ResponseEntity<?> deleteTechnician(@PathVariable String name) {
        return handleEvent(() -> technicianRepository.deleteTechnicianByName(name),  "Technician deleted successfully");
    }

    @DeleteMapping("/delete_technician_by_performance/{performance}")
    public ResponseEntity<?> deleteTechnicianByPerformance(@PathVariable String performance) {
        return handleEvent(() -> technicianRepository.deleteTechnicianByPerformance(performance), "Technicians deleted successfully");
    }

    private<T> ResponseEntity<?> handleEvent(ExceptionSupplier<T> f, String body) {
        try {
            f.get();
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("Technician not found"), HttpStatus.NOT_FOUND);
        }
    }
}
