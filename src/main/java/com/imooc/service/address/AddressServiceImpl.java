package com.imooc.service.address;

import com.imooc.dto.ServiceMultipleResult;
import com.imooc.dto.SupportAddressDTO;
import com.imooc.entity.SupportAddress;
import com.imooc.enumeration.Level;
import com.imooc.repository.SupportAddressRepository;
import com.imooc.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private SupportAddressRepository addressRepository;

    //entity transfer to dto tool
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ServiceMultipleResult<SupportAddressDTO> getAllCities() {
        List<SupportAddress> addresses = addressRepository.getAllByLevel(Level.CITY.getValue());

        //modelMapper转换，我一般用java8 lambda转换 需要在SupportAddressDTO定义有参构造函数
//        List<SupportAddressDTO> supportAddressDTOList = new ArrayList<>();
//        for (SupportAddress address : addresses) {
//            SupportAddressDTO addressDTO = modelMapper.map(address, SupportAddressDTO.class);
//            supportAddressDTOList.add(addressDTO);
//        }

        //java8 lambda转换 需要在SupportAddressDTO定义有参构造函数
        List<SupportAddressDTO> supportAddressDTOList = addresses.stream().map(add -> new SupportAddressDTO(add.getId(), add.getBelongTo(), add.getEnName(), add.getCnName(), add.getLevel())).collect(Collectors.toList());
        return new ServiceMultipleResult<>(supportAddressDTOList.size(), supportAddressDTOList);
    }
}
