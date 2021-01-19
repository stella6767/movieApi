package com.cos.movie.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;

@RestController
@ControllerAdvice //Exception 낚아채기
public class MyExceptionHandler {
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public CommonDto argumentException(IllegalArgumentException e) {
		return new CommonDto(500, "fail");
	}
	
}
