package com.cos.movie.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.SaveReqDto;
import com.cos.movie.domain.UpdateReqDto;



@RestController
public class MovieController {
	
	private MovieRepository movieRepository;
	
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() {
		System.out.println("findAll()");		
		return new CommonDto<>(200, movieRepository.findAll());
	}
	
	@GetMapping("/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) {
		System.out.println("findById()");
		return new CommonDto<>(200, movieRepository.findById(id));
	}
	
	
	@CrossOrigin
	@PostMapping("/movie")
	public CommonDto<String> save(@Valid @RequestBody SaveReqDto dto, BindingResult bindingResult) {
		System.out.println("save()");
		
		System.out.println("dto: "+dto);
		movieRepository.save(dto);

		return new CommonDto<>(200, "ok");		
	}
	
	@DeleteMapping("/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		System.out.println("delete()");
		
		movieRepository.delete(id);
		return new CommonDto<>(200,"ok");
	}
	
	
	@PutMapping("/movie/{id}")
	public CommonDto update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		System.out.println("update()");
		
		movieRepository.update(id, dto);
		return new CommonDto<>(200,"ok");
	}
	
	
}
