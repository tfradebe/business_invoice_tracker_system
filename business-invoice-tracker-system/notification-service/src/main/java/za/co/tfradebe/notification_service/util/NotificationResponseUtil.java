package za.co.tfradebe.notification_service.util;

import za.co.tfradebe.notification_service.v1.dto.erro.ErrorDetail;
import za.co.tfradebe.notification_service.v1.dto.model.NotificationDto;
import za.co.tfradebe.notification_service.v1.dto.*;

import java.util.List;

public class NotificationResponseUtil {

    private NotificationResponseUtil(){}

    public static NotificationResponse createSuccessResponse(NotificationDto notificationDtoDto) {
        return createSuccessResponse(List.of(notificationDtoDto));
    }

    public static NotificationResponse createSuccessResponse(List<NotificationDto> invoiceDtoList) {
        var response = new NotificationResponse();
        response.setData(invoiceDtoList);
        response.setStatus("SUCCESS");
        return response;
    }

    public static NotificationResponse createFailResponse(String code, List<ErrorDetail> errors) {
        var response = new NotificationResponse();
        response.setStatus("ERROR");
        response.setCode(code);
        response.setError(errors);
        return response;
    }


    public static ErrorDetail createErrorDetails(String code, String message){
        var error = new ErrorDetail();
        error.setCode(code);
        error.setMessage(message);
        return error;
    }
}
