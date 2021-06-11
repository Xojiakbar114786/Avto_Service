package brr.uz.avto_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String titleUz;
    private String titleRu;
    private String textUz;
    private String textRu;
    private List<Long> photoListId;
    private String url;
    private String date;
}
