package brr.uz.avto_service.entity;
import brr.uz.avto_service.entity.template.AbsNameEntity;
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
public class Engineer extends AbsNameEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkStatus workStatus;

    @Column(nullable = false)
    private Date workStartTime;

    @Column(nullable = false)
    private Date workEndTime;

    private double salaryPrice;
}
