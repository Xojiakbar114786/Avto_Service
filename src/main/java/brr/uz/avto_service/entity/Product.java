package brr.uz.avto_service.entity;

import brr.uz.avto_service.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductBrand productBrand;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductModel productModel;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Attachment> photoList;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(nullable = false)
    private String descriptionRu;

    @Column(nullable = false)//?
    private double inComPrice;

    @Column(nullable = false)//?
    private double salePrice;

    @Column(nullable = false)
    private String count;
}
