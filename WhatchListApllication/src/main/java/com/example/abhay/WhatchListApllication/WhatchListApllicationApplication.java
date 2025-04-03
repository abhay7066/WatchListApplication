package com.example.abhay.WhatchListApllication;

import com.example.abhay.WhatchListApllication.Entity.Movie;
import com.example.abhay.WhatchListApllication.Reposetry.MovieReposetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatchListApllicationApplication {
	@Autowired
	MovieReposetry movieReposetry;

	public static void main(String[] args) {
		SpringApplication.run(WhatchListApllicationApplication.class, args);
	}


}
