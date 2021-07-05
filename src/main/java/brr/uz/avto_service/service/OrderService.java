package brr.uz.avto_service.service;

import brr.uz.avto_service.entity.Company;
import brr.uz.avto_service.entity.Order;
import brr.uz.avto_service.entity.ServiceItem;
import brr.uz.avto_service.payload.ApiResponse;
import brr.uz.avto_service.payload.OrderReq;
import brr.uz.avto_service.repository.CompanyRepository;
import brr.uz.avto_service.repository.OrderRepository;
import brr.uz.avto_service.repository.ServiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ServiceItemRepository serviceItemRepository;




    public ApiResponse orderCreate(OrderReq orderReq) {
        try {
            Company companyId1 = findCompanyId(orderReq.getCompanyId());

            ServiceItem byServiceItem = findByServiceItem(orderReq.getServiceItem());

            if (orderReq.getPhoneNumber().isEmpty()) {
                return new ApiResponse("you must enter your phone number", false, null);
            } else if (orderReq.getLan()==null || orderReq.getLat()==null) {
                return new ApiResponse("location error", false, null);

            } else if (companyId1 != null && byServiceItem != null) {

                return new ApiResponse(
                        "the order was successfully completed",
                        true,
                        orderRepository.save(new
                                Order(
                                companyId1,
                                byServiceItem,
                                orderReq.getLan(),
                                orderReq.getLat(),
                                orderReq.getName(),
                                orderReq.getPhoneNumber()

                        )));
            }else {
                return new ApiResponse("there is no such company or service",
                        false,
                        null);
            }
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(),false);
        }
    }


    private Company findCompanyId(Long id){
        Optional<Company> byId = companyRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else {
            return null;
        }
    }

    private ServiceItem findByServiceItem(Long id){
        Optional<ServiceItem> serviceItemById = serviceItemRepository.findById(id);
        if (serviceItemById.isPresent()){
            return serviceItemById.get();
        }else {
            return null;
        }
    }


}
