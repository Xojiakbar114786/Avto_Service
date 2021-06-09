package brr.uz.avto_service.entity;


import brr.uz.avto_service.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductModel extends AbsEntity {

    @Column(nullable = false)
    private String key;// product type. For example "car battary"

    @Column(nullable = false)
    private String value; // product value ""key => (car battary)" (value =>black)"
}