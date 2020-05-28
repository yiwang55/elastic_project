package com.imooc.repository;

import com.imooc.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long> {
    List<SupportAddress> getAllByLevel(String level);

    List<SupportAddress> findAllByLevelAndBelongTo(String value, String cityName);

    List<SupportAddress> findAllByLevel(String value);

    SupportAddress findByEnNameAndLevel(String cityEnName, String value);

    SupportAddress findByEnNameAndBelongTo(String regionEnName, String enName);
}
