package brr.uz.avto_service.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDto {
    private Long id;
    private String textUz;
    private String textRu;
    private List<Long> photoListId;
}
