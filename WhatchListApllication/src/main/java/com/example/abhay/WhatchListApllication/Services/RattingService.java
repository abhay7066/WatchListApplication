package com.example.abhay.WhatchListApllication.Services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RattingService {

    String apiurl="https://www.omdbapi.com/?apikey=8ada777c&t=";

    public String getMoviebyTitle(String title)
    {
        try {
            //try to fetch ratting by calling omdb API
            //ReastTemplate use as a webclient like post man
            //this object use for programeticly called Reat API
            RestTemplate template=new RestTemplate();
            //call = API URl + title

            //for fetch JASON type object
            ResponseEntity<ObjectNode> response=template.getForEntity(apiurl+title,ObjectNode.class);

            ObjectNode JsonOnject=response.getBody();
            System.out.println(JsonOnject.path("imdbRating").asText());

            return JsonOnject.path("imdbRating").asText();
        }
        catch (Exception e)
        {
            //user enter ratting will be taken
            System.out.println("Either movie name is note available or API down "+ e.getMessage());
            return null;

        }
    }
}
