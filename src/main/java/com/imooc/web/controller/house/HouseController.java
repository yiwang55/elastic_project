package com.imooc.web.controller.house;

import com.imooc.base.ApiResponse;
import com.imooc.dto.ServiceMultiResult;
import com.imooc.dto.SubwayDTO;
import com.imooc.dto.SubwayStationDTO;
import com.imooc.dto.SupportAddressDTO;
import com.imooc.service.house.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private IAddressService AddressService;

    /**
     * 获取支持城市列表
     * @return
     */
    @GetMapping("address/support/cities")
        public ApiResponse getSupportCities() {
        ServiceMultiResult<SupportAddressDTO> result = AddressService.getAllCities();
        if (result.getResultSize() == 0) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(result.getResult());
    }

    /**
     * 获取对应城市支持区域列表
     * @param cityEnName
     * @return
     */
    @GetMapping("address/support/regions")
    public ApiResponse getSupportRegions(@RequestParam(name = "city_name") String cityEnName) {
        ServiceMultiResult<SupportAddressDTO> addressResult = AddressService.findAllRegionsByCityName(cityEnName);
        if (addressResult.getResult() == null || addressResult.getTotal() < 1) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(addressResult.getResult());
    }

    /**
     * 获取具体城市所支持的地铁线路
     * @param cityEnName
     * @return
     */
    @GetMapping("address/support/subway/line")
    public ApiResponse getSupportSubwayLine(@RequestParam(name = "city_name") String cityEnName) {
        List<SubwayDTO> subways = AddressService.findAllSubwayByCity(cityEnName);
        if (subways.isEmpty()) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        return ApiResponse.ofSuccess(subways);
    }

    /**
     * 获取对应地铁线路所支持的地铁站点
     * @param subwayId
     * @return
     */
    @GetMapping("address/support/subway/station")
    public ApiResponse getSupportSubwayStation(@RequestParam(name = "subway_id") Long subwayId) {
        List<SubwayStationDTO> stationDTOS = AddressService.findAllStationBySubway(subwayId);
        if (stationDTOS.isEmpty()) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
        }

        return ApiResponse.ofSuccess(stationDTOS);
    }

}
