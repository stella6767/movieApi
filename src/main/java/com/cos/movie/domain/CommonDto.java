package com.cos.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonDto<T> {
	private int statuscode;
	private T data;
		
	public CommonDto(int statuscode) {
		super();
		this.statuscode = statuscode;
	}	
	public CommonDto(int statuscode, T data) {
		super();
		this.statuscode = statuscode;
		this.data = data;
	}

}


