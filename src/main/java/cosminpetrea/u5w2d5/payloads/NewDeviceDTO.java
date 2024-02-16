package cosminpetrea.u5w2d5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record NewDeviceDTO(

        @NotEmpty(message = "Please insert type")
        @NotBlank
        String type


) {
}
