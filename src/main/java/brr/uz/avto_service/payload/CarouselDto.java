package brr.uz.avto_service.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarouselDto {
    private Long id;
    private Long photoId;
    private String textUz;
    private String textRu;
}

