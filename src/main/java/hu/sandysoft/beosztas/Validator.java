package hu.sandysoft.beosztas;

import hu.sandysoft.beosztas.dto.Performance;
import hu.sandysoft.beosztas.dto.Technician;

public class Validator {
    public boolean validate(Performance performance) {
        return !performance.getName().toLowerCase().contains("insert")
                    && !performance.getName().toLowerCase().contains("select")
                    && !performance.getName().toLowerCase().contains("delete")
                    && !performance.getName().toLowerCase().contains("drop")
                    && !performance.getName().toLowerCase().contains("create");
    }

    public boolean validate (Technician technician) {
        String performance = technician.getPerformance();
        return !performance.toLowerCase().contains("insert")
                && !performance.toLowerCase().contains("select")
                && !performance.toLowerCase().contains("delete")
                && !performance.toLowerCase().contains("drop")
                && !performance.toLowerCase().contains("create")
                && !technician.getName().toLowerCase().contains("insert")
                && !technician.getName().toLowerCase().contains("select")
                && !technician.getName().toLowerCase().contains("delete")
                && !technician.getName().toLowerCase().contains("drop")
                && !technician.getName().toLowerCase().contains("create");
    }
}
