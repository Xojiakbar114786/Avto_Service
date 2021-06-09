package brr.uz.avto_service.entity;


import brr.uz.avto_service.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
public class Services extends AbsNameEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
