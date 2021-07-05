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
    private Users users; //  kompaniyani egasi

    @Column(nullable = false)
    private Double lan;

    @Column(nullable = false)
    private Double lat;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Attachment> licencePhotoList;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Attachment> PhotoList;

    private String phoneNumber;

    private String homePhoneNumber;

    private String descriptionUz;

    private String descriptionRu;

    private boolean delete = false;

    private boolean active = false;

    private Double money;

    private Long orderCount;

    public Company(String name, Users users, Double lan, Double lat, String phoneNumber, boolean active) {
        this.name = name;
        this.users = users;
        this.lan = lan;
        this.lat = lat;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    public Company(String name, Users users, Double lan, Double lat, String phoneNumber, String homePhoneNumber, String descriptionUz, String descriptionRu) {
        this.name = name;
        this.users = users;
        this.lan = lan;
        this.lat = lat;
        this.phoneNumber = phoneNumber;
        this.homePhoneNumber = homePhoneNumber;
        this.descriptionUz = descriptionUz;
        this.descriptionRu = descriptionRu;
    }

}
