package brr.uz.avto_service.service;

import brr.uz.avto_service.collection.LocationCollection;
import brr.uz.avto_service.entity.Company;
import brr.uz.avto_service.entity.Users;
import brr.uz.avto_service.payload.ApiResponse;
import brr.uz.avto_service.payload.ApiResponseModel;
import brr.uz.avto_service.payload.CompanyDto;
import brr.uz.avto_service.repository.AttachmentRepository;
import brr.uz.avto_service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class CompanyService {


    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AttachmentRepository attachmentRepository;


    public ApiResponse ActiveService() {
        return new ApiResponse("List of active Locations", true, companyRepository.findByActiveTrue());
    }

    public ApiResponse selectedService(int R, Double lan, Double lat) {
        try {
            if (R <= 0) {
                return new ApiResponse("All locations", true, companyRepository.findByActiveTrue());
            } else if (lan == null && lat == null
                    || lan == null
                    || lat == null) {
                return new ApiResponse("Enter the correct location", false, null);
            } else {
                return new ApiResponse("NearBy locations", true, nearByLocations(R, lan, lat));
            }
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false, null);
        }
    }

    private List<LocationCollection> nearByLocations(int r, Double lan, Double lat) {
        return companyRepository.findByActiveAndLanBetweenAndLatBetween(true, lan - 0.009 * r, lan + 0.009 * r, lat - 0.009 * r, lat + 0.009 * r);
    }

    public ApiResponse createCompany(CompanyDto companyDto, Users users) {
        if (companyDto.getName().isEmpty()) {
            return new ApiResponse("Please enter the company name", false, null);
        } else {
            return new ApiResponse("a new company was created", true, companyRepository.save(new Company(
                    companyDto.getName(),
                    users,
                    companyDto.getLan(),
                    companyDto.getLat(),
                    companyDto.getPhoneNumber(),
                    companyDto.getPhoneHomeNumber(),
                    companyDto.getDescriptionUz(),
                    companyDto.getDescriptionRu()
            )));
        }
    }

    public ApiResponse editCompany(CompanyDto companyDto, Users users) {
        try {
            Company company1 = new Company();
            if (companyDto.getId() != null) {
                company1 = companyRepository.findById(companyDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Get Company"));
            }
            company1.setName(companyDto.getName() == null ? company1.getName() : companyDto.getName());
            company1.setPhoneNumber(companyDto.getPhoneNumber() == null ? company1.getPhoneNumber() : companyDto.getPhoneNumber());
            company1.setHomePhoneNumber(companyDto.getPhoneHomeNumber() == null ? company1.getHomePhoneNumber() : companyDto.getPhoneHomeNumber());
            company1.setLan(companyDto.getLan() == null ? company1.getLan() : companyDto.getLan());
            company1.setLat(companyDto.getLat() == null ? company1.getLat() : companyDto.getLat());
            company1.setLicencePhotoList(companyDto.getLicencePhotoList() == null ? company1.getLicencePhotoList() : companyDto.getLicencePhotoList());
            company1.setPhotoList(companyDto.getPhotoList() == null ? company1.getPhotoList() : companyDto.getPhotoList());
            company1.setDescriptionUz(companyDto.getDescriptionUz() == null ? company1.getDescriptionUz() : companyDto.getDescriptionUz());
            company1.setDescriptionRu(companyDto.getDescriptionRu() == null ? company1.getDescriptionRu() : companyDto.getDescriptionRu());
            company1.setMoney(companyDto.getMoney() == null ? company1.getMoney() : companyDto.getMoney());
            //  company1.setDelete(companyDto.isDelete() == false ? company1.isDelete() : companyDto.isDelete()==true);
            return new ApiResponse("company information has been updated", true, companyRepository.save(company1));

        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false, null);
        }
    }


    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiResponseModel handleException(Exception e) {
        return new ApiResponseModel(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    public ApiResponseModel deleteCompany(Long id){
        try {
            if (companyRepository.existsByActiveAndId(false,null)){
                return new ApiResponseModel(HttpStatus.NOT_FOUND.value(),"this user is not available",false);
            }else {
                return new ApiResponseModel(HttpStatus.OK.value(), "DELETED",companyRepository.delete(id));
            }
        }catch (Exception e){
            return new ApiResponseModel(786,"Exception",false);
        }
    }
}

