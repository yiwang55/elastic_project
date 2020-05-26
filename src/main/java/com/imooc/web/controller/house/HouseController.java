package com.imooc.web.controller.house;

import com.imooc.base.ApiResponse;
import com.imooc.dto.ServiceMultipleResult;
import com.imooc.dto.SupportAddressDTO;
import com.imooc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {

    @Autowired
    private AddressService addressService;

    @GetMapping("address/support/cities")
    public ApiResponse getSupportCities(){
        ServiceMultipleResult<SupportAddressDTO> cities = addressService.getAllCities();
        if (cities.getResultSize() == 0){
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(cities);
    }
}
