package brr.uz.avto_service.payload;

import brr.uz.avto_service.entity.Attachment;
import brr.uz.avto_service.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private Double lat;
    private Double lan;

    @Pattern(regexp = "^+998(9[012345789]|6[125679]|7[01234569])[0-9]{7}$") //+998931234988
    private String phoneNumber;

    private String phoneHomeNumber;
    private String descriptionUz;
    private String descriptionRu;
    private List<Attachment> photoList;
    private List<Attachment> licencePhotoList;


    private Users users; //  kompaniyani egasi

    private List<Attachment> PhotoList;

    private String homePhoneNumber;

    private boolean delete = false;

    private boolean active = false;

    private Double money;

    private Long orderCount;


    public CompanyDto( String name, Double lat, Double lan, @Pattern(regexp = "^+998(9[012345789]|6[125679]|7[01234569])[0-9]{7}$") String phoneNumber, String phoneHomeNumber, String descriptionUz, String descriptionRu) {
        this.name = name;
        this.lat = lat;
        this.lan = lan;
        this.phoneNumber = phoneNumber;
        this.phoneHomeNumber = phoneHomeNumber;
        this.descriptionUz = descriptionUz;
        this.descriptionRu = descriptionRu;
    }

    public CompanyDto(Long id, String name, Double lat, Double lan, @Pattern(regexp = "^+998(9[012345789]|6[125679]|7[01234569])[0-9]{7}$") String phoneNumber, String phoneHomeNumber, String descriptionUz, String descriptionRu, List<Attachment> photoList, List<Attachment> licencePhotoList, Users users, List<Attachment> photoList1, String homePhoneNumber, Double money, Long orderCount) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lan = lan;
        this.phoneNumber = phoneNumber;
        this.phoneHomeNumber = phoneHomeNumber;
        this.descriptionUz = descriptionUz;
        this.descriptionRu = descriptionRu;
        this.photoList = photoList;
        this.licencePhotoList = licencePhotoList;
        this.users = users;
        this.PhotoList = photoList1;
        this.homePhoneNumber = homePhoneNumber;
        this.money = money;
        this.orderCount = orderCount;
    }

    public CompanyDto(Long id) {
        this.id = id;
    }
}
