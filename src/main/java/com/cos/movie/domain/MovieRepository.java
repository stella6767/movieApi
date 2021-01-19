package com.cos.movie.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	
	List<Movie> movies = new ArrayList<>();
	
	
	public MovieRepository() {
		movies.add(new Movie(1,"매트릭스",3.5,Timestamp.valueOf(LocalDateTime.now())));
		movies.add(new Movie(2,"공각기동대",3.1,Timestamp.valueOf(LocalDateTime.now())));
		movies.add(new Movie(3,"사랑과 영혼",4.5,Timestamp.valueOf(LocalDateTime.now())));
		movies.add(new Movie(4,"쿵푸판다",2.5,Timestamp.valueOf(LocalDateTime.now())));
	}

	
	public List<Movie> findAll(){ //원래는 DB 연결해서 가져와야 되지만 지금은 그냥 주입
		//List<Movie> movies = new ArrayList<>();
		return movies;
	}
	
	
	public Movie findById(int id){
		return movies.get(id-1);
	}
		
	
	public void save(SaveReqDto dto) {
		
		int id = movies.size();
				
		System.out.println("insert 하기: " + id);
		
		String title = dto.getTitle();
		double rating = dto.getRating();
		
		movies.add(new Movie(id+1, title, rating,Timestamp.valueOf(LocalDateTime.now()) ));			
	}
	
	
	public void delete(int id) {
		System.out.println("삭제하기");
		
		int count = id;
		movies.get(count).setId(movies.get(count).getId()-1);
		
		movies.remove(id-1);			
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println("수정하기");
		
		//Movie movie =movies.get(id-1);
		
		String title = dto.getTitle();
		double rating = dto.getRating();
		
		movies.get(id-1).setTitle(title);
		movies.get(id-1).setRating(rating);
		
	}
}
