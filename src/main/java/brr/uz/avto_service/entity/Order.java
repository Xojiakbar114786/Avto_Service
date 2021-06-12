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
    private Double lat;

    @Column(nullable = false)
    private Double lan;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String descriptionUz;

    public Order(Company company, ServiceItem serviceItem, Double lat, Double lan, String clientName) {
        this.company = company;
        this.serviceItem = serviceItem;
        this.lat = lat;
        this.lan = lan;
        this.clientName = clientName;
    }

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String descriptionRu;
}
