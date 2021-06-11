package brr.uz.avto_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private Object object;
    private Integer page;
    private Integer size;
    private Integer totalPages;

    public ApiResponse(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(Object object, Integer page, Integer size, Integer totalPages) {
        this.object = object;
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
    }
}
