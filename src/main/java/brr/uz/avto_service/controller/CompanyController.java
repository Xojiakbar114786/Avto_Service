package brr.uz.avto_service.controller;


import brr.uz.avto_service.entity.Users;
import brr.uz.avto_service.payload.ApiResponse;
import brr.uz.avto_service.payload.ApiResponseModel;
import brr.uz.avto_service.payload.CompanyDto;
import brr.uz.avto_service.security.CurrentUser;
import brr.uz.avto_service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @GetMapping("/getCompanyActive")
    public ApiResponse getLocation(){
       return companyService.ActiveService();
    }


    @GetMapping("/getService")
    public ApiResponse selectedService(@RequestParam int R,
                                       @RequestParam Double lan,
                                       @RequestParam Double lat){
        return companyService.selectedService(R,lan,lat);
    }

    @PostMapping("/createCompany")
    public ApiResponse createCompany(@RequestBody CompanyDto companyDto,
                                     @CurrentUser Users users){
        return companyService.createCompany(companyDto,users);
    }

    @PutMapping("/editCompany")
    public ApiResponse editCompany(@RequestBody CompanyDto companyDto,Users users){
        return companyService.editCompany(companyDto,users);
    }


    @DeleteMapping("/deleteCompany/{id}")
    public ApiResponseModel deleteCompany(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }

}
