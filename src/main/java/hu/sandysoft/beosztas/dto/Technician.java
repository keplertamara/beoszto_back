package hu.sandysoft.beosztas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Technician {
    private String name;
    private String performance;
    private int table;
    private int move;
    private int head;
}
