package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SupportAddressDTO {
    private Long id;

    @JsonProperty(value = "belong_to")
    private String belongTo;

    @JsonProperty(value = "en_name")
    private String enName;

    @JsonProperty(value = "cn_name")
    private String cnName;

    private String level;

    public SupportAddressDTO() {
    }

    public SupportAddressDTO(Long id, String belongTo, String enName, String cnName, String level) {
        this.id = id;
        this.belongTo = belongTo;
        this.enName = enName;
        this.cnName = cnName;
        this.level = level;
    }
}
