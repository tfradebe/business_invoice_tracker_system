package za.co.tfradebe.notification_service.v1.dto;

import lombok.Data;
import za.co.tfradebe.notification_service.v1.dto.erro.ErrorDetail;
import za.co.tfradebe.notification_service.v1.dto.model.NotificationDto;

import java.util.List;

@Data
public class NotificationResponse {
    private String status;
    private String code;
    private List<ErrorDetail> error;
    private List<NotificationDto> data;
}
