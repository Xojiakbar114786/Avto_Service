package brr.uz.avto_service.entity;

import brr.uz.avto_service.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceItem extends AbsNameEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Attachment> photoList;

    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceType serviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Services services;

    @ManyToOne(fetch = FetchType.LAZY)
    private CarCategory carCategory;

    private Date startTime;

    private Date endTime;

    private boolean active=true;

    private double price;
}
