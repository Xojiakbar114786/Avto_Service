package brr.uz.avto_service.entity;

import brr.uz.avto_service.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operation")
public class Operator extends AbsEntity{


    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private Date endTime;

    private Long answerOrderCount;
//
    private Long likes;

    private Long disLike;

    private Boolean activeOperator;
}
