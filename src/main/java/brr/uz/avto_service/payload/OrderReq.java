package brr.uz.avto_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderReq {

    private Long id;
    private String name;
    private String phoneNumber;
    private Double lan;
    private Double lat;
    private Long companyId;
    private Long serviceItem;

    public OrderReq(Long id, String name, String phoneNumber, Double lan, Double lat, Long companyId, Long serviceItem) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.lan = lan;
        this.lat = lat;
        this.companyId = companyId;
        this.serviceItem = serviceItem;
    }
}
