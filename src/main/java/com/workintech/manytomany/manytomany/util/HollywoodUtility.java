package com.workintech.manytomany.manytomany.util;

import com.workintech.manytomany.manytomany.dto.ActorResponse;
import com.workintech.manytomany.manytomany.dto.MovieActorResponse;
import com.workintech.manytomany.manytomany.dto.MovieResponse;
import com.workintech.manytomany.manytomany.entity.Actor;
import com.workintech.manytomany.manytomany.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class HollywoodUtility {
    public static MovieActorResponse convertMovieActorResponse(Movie movie, Actor actor) {
        return new MovieActorResponse(movie, actor.getId(), actor.getFirstName(),
                actor.getLastName(), actor.getBirthDate());
    }

    public static List<ActorResponse> convertActorResponses(Movie savedMovie){
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : savedMovie.getActors()) {
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),
                    actor.getGender(), actor.getBirthDate()));
        }
        return actorResponses;
    }

    public static List<MovieResponse> convertMovieResponses(Actor savedActor){
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (Movie movie : savedActor.getMovies()) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return movieResponses;
    }
}