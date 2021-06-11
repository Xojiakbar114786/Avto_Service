package brr.uz.avto_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private Float lat;
    private Float lan;
    private String phoneNumber;
    private String phoneHomeNumber;
    private String descriptionUz;
    private String descriptionRu;
    private Long userId;
    private List<Long> photoList;
    private List<Long> licencePhotoList;
}
