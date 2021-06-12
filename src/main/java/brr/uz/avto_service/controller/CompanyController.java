package brr.uz.avto_service.controller;


import brr.uz.avto_service.payload.ApiResponse;
import brr.uz.avto_service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;


        @GetMapping("/getActive")
    public ApiResponse getLocation(){
       return companyService.ActiveService();
    }

    @GetMapping("/getService")
    public ApiResponse selectedService(@RequestParam int R,
                                       @RequestParam Double lan,
                                       @RequestParam Double lat){
        return companyService.selectedService(R,lan,lat);
    }
}
