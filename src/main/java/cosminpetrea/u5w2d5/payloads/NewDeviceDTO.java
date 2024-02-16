package cosminpetrea.u5w2d5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record NewDeviceDTO(

        @NotEmpty(message = "Please insert type")
        @NotBlank
        String type



) {
}
