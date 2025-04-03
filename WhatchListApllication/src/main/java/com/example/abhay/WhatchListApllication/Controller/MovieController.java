package com.example.abhay.WhatchListApllication.Controller;

import com.example.abhay.WhatchListApllication.Entity.Movie;
import com.example.abhay.WhatchListApllication.Services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    //firse gertmapping for view and model
    @GetMapping("/watchlistItemForm")     // @RequestParam use here for upadate only we have not use alway hence it enitialy set false
    public ModelAndView showWatchlistForm(@RequestParam(required = false) Integer id)
    {
        String viewName="watchlistItemForm";
        Map<String,Object> modal=new HashMap<>();
        // if id = null than we want to peg that submit detail
        if(id==null)
        {
            modal.put("watchlistItem", new Movie());

        }
        // if id=not null than we want t update detail, so we have all deatil from that id modal
        else
        {
            modal.put("watchlistItem",movieService.getMovieById(id));

        }
//        Movie  m=new Movie();
//        m.setTitle("xyz ");
//        m.setPriority("low");
//        m.setComments("good");
//        m.setRating(7.89F);
//        modal.put("watchlistItem",m);


        return new ModelAndView(viewName,modal);

    }

    // post mapping for submit button for create or stoere data
    // here we use same end point as first get mapping because both have smae view
    @PostMapping("/watchlistItemForm")       // valid is use for runtime, mean it sai controler that valid the movie entity
                                                  // MOdalAttribute use for mapping valid backend with frontend object, which is here movie(backend) with watchlistItem(frontend )
    public ModelAndView submitWatchlistForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            //if erro are there, redisplay the from and let user enter again
            return new ModelAndView("watchlistItemForm");
        }
        //for update
//        System.out.println(movie);
        /*
        if(id=null)
        {
        create new movie
        }
        else
        {
         update movie
        }
         */
        Integer id= movie.getId();

       // System.out.println(id);
        if(id==null)
        {
            movieService.create(movie);
        }
        else
        {
            movieService.update(movie,id);
        }

        RedirectView rd=new RedirectView();
        rd.setUrl("/watchlist");

        return new ModelAndView(rd);
    }

    //get mapping for show movie item and get data from database
    @GetMapping("/watchlist")
    public ModelAndView getWatchlist()
    {
        String viewName="watchlist";
        Map<String,Object> modal= new HashMap<>();
        List<Movie> movieList = movieService.getAllMovie();
        modal.put("watchlistRows",movieList);
        modal.put("noofmovie",movieList.size());
        return new ModelAndView(viewName,modal);

    }
}


