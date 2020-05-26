package com.imooc.dto;

import lombok.Data;

import java.util.List;

@Data
public class ServiceMultipleResult<T> {
    private long total;
    private List<T> result;

    public ServiceMultipleResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public int getResultSize(){
        if (this.result == null){
            return 0;
        }
        return this.result.size();
    }
}
