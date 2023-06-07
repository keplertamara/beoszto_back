package hu.sandysoft.beosztas.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TechnicianSchedule {

    private Map<String, List<String>> workerSchedule;
}
