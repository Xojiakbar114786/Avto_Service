package brr.uz.avto_service.entity.template;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"nameUz", "nameRu","descriptionUz","descriptionRu"})})
public abstract class AbsNameEntity extends AbsEntity {
    @Column(nullable = false)
    private String nameUz;

    @Column(nullable = false)
    private String nameRu;

    @Column(nullable = false)
    private String descriptionUz;

    @Column(nullable = false)
    private String descriptionRu;
}
