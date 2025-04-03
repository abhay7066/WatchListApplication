package com.example.abhay.WhatchListApllication.Reposetry;

import com.example.abhay.WhatchListApllication.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReposetry extends JpaRepository<Movie, Integer> {

}
