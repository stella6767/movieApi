package com.cos.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonDto<T> {
	private int statuscode;
	private T msg;
		
	public CommonDto(int statuscode) {
		super();
		this.statuscode = statuscode;
	}	
	public CommonDto(int statuscode, T msg) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
	}

}


