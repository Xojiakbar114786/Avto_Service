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
public class Company extends AbsEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @Column(nullable = false)
    private Float lan;

    @Column(nullable = false)
    private Float lat;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Attachment> licencePhotoList;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Attachment> PhotoList;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String homePhoneNumber;

    private String descriptionUz;

    private String descriptionRu;

    private boolean delete = false;

    private boolean active = false;

    private Double money;

    private Long orderCount;

}
