package com.imooc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (SupportAddress)实体类
 *
 * @author makejava
 * @since 2020-05-26 16:21:59
 */
@Entity
@Data
@Table(name = "support_address")
public class SupportAddress implements Serializable {
    private static final long serialVersionUID = 146464781547192649L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
    * 上一级行政单位名
    */
    @Column(name = "belong_to")
    private String belongTo;
    /**
    * 行政单位英文名缩写
    */
    @Column(name = "en_name")
    private String enName;
    /**
    * 行政单位中文名
    */
    @Column(name = "cn_name")
    private String cnName;
    /**
    * 行政级别 市-city 地区-region
    */
    private String level;
    /**
    * 百度地图经度
    */
    @Column(name = "baidu_map_lng")
    private Double baiduMapLng;
    /**
    * 百度地图纬度
    */
    @Column(name = "baidu_map_lat")
    private Double baiduMapLat;

}