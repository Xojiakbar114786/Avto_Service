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
@Table(name = "orders")
public class Order extends AbsEntity {

    @Column(nullable = false)
    private String orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceItem serviceItem;

    @ManyToOne(fetch = FetchType.LAZY)
    private PriceType priceType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Operator operator;

    @Column(nullable = false)
    private Float lat;

    @Column(nullable = false)
    private Float lan;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(nullable = false)
    private String descriptionRu;
}
