package brr.uz.avto_service.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorDto {
    private Long id;
    private UUID userId;
    private Date startTime;
    private boolean active;
    private Date endTime;
    private long answerOrderCount;
    private long like;
    private long disLike;

}
