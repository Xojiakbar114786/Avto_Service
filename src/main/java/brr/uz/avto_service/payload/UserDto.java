package brr.uz.avto_service.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String descriptionUz;
    private String descriptionRu;
    private Float lat;
    private Float lan;
    private String prePassword;
    private String oldPassword;
    private String newPassword;
    private boolean enabled;

    public UserDto(Long id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
