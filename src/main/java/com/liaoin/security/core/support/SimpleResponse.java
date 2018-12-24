package com.liaoin.security.core.support;

import lombok.Data;

@Data
public class SimpleResponse {

    public SimpleResponse(Integer state ,String message,Object data){
        this.data = data;
        this.state = state;
        this.message = message;
    }
	private String message;
    private Object data;
    private Integer state;
}
