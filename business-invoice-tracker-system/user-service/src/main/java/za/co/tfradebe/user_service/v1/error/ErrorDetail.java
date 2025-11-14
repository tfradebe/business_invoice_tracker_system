package za.co.tfradebe.user_service.v1.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ErrorDetail {
    private String code;
    private String message;
    private Map<String, String> details;
}
