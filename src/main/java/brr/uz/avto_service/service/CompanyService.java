package brr.uz.avto_service.service;

import brr.uz.avto_service.collection.LocationCollection;
import brr.uz.avto_service.payload.ApiResponse;
import brr.uz.avto_service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;


    public ApiResponse ActiveService(){
        return new ApiResponse("List of active Locations",true,companyRepository.findByActiveTrue());
    }

    public ApiResponse selectedService(int R, Double lan, Double lat) {
        try {
            if (R <= 0){
                return new ApiResponse("All locations",true,companyRepository.findByActiveTrue());
            }else if (lan==0 && lat==0 || lan==0 || lat==0){
                return new ApiResponse("Enter the correct location",false,null);
            }else {
                return new ApiResponse("NearBy locations",true,nearByLocations(R,lan,lat));
            }
        }catch (Exception e){
            return new ApiResponse(e.getMessage(),false,null);
        }
    }


    private List<LocationCollection> nearByLocations(int r, Double lan, Double lat){
        return companyRepository.findByActiveAndLanBetweenAndLatBetween(true,lan-0.009*r,lan+0.009*r,lat-0.009*r,lat+0.009*r);
    }
}
