package cosminpetrea.u5w2d5.payloads.errors;

import java.util.Date;
import java.util.List;

public record ErrorsPayloadWithList(String message,
                                    Date timestamp,
                                    List<String> errorsList) {
}
