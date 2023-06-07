package hu.sandysoft.beosztas.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Performance {
    private String name;
    private int preparation_time;
    private int table_needed;
    private int move_needed;
    private int head_needed;
}
