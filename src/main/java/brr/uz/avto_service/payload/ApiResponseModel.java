package brr.uz.avto_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseModel {

    private int success;
    private String message;
    private Object info;

    public ApiResponseModel(int success, String message) {
        this.success = success;
        this.message = message;
    }
}
