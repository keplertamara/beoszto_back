package hu.sandysoft.beosztas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
}
