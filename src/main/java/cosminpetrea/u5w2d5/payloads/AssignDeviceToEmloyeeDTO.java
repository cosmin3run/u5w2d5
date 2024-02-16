package cosminpetrea.u5w2d5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AssignDeviceToEmloyeeDTO(
        @NotEmpty(message = "You need to set the EmployeeID")
        UUID id
) {
}
