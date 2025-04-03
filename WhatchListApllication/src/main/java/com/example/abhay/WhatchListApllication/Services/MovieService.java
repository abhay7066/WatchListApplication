package com.example.abhay.WhatchListApllication.Services;
import com.example.abhay.WhatchListApllication.Entity.Movie;
import com.example.abhay.WhatchListApllication.Reposetry.MovieReposetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieReposetry movieReposetry;
    @Autowired
    RattingService rattingService;
     public void create(Movie movie)
     {


         movieReposetry.save(movie);
         String ratting= rattingService.getMoviebyTitle(movie.getTitle());
         if(ratting != null)
         if(ratting.equals("N/A")){
             movie.setRating(0);
         }
             else{
             movie.setRating(Float.parseFloat(ratting));
         }
             movieReposetry.save(movie);
         }

    public List<Movie> getAllMovie()
    {
        return movieReposetry.findAll();

    }
    public Movie getMovieById(Integer id)
    {
        return movieReposetry.findById(id).get();
    }

    public void update(Movie movie, Integer id)
    {
        Movie toBeUpadated= getMovieById(id);

        toBeUpadated.setTitle(movie.getTitle());
        toBeUpadated.setRating(movie.getRating());
        toBeUpadated.setPriority(movie.getPriority());
        toBeUpadated.setComment(movie.getComment());

        movieReposetry.save(toBeUpadated);
    }
}

