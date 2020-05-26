package com.imooc.service;

import com.imooc.dto.ServiceMultipleResult;
import com.imooc.dto.SupportAddressDTO;

public interface AddressService {
    ServiceMultipleResult<SupportAddressDTO> getAllCities();
}
