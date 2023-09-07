package com.workintech.manytomany.manytomany.controller;

import com.workintech.manytomany.manytomany.dto.ActorResponse;
import com.workintech.manytomany.manytomany.dto.MovieActorRequest;
import com.workintech.manytomany.manytomany.dto.MovieActorResponse;
import com.workintech.manytomany.manytomany.dto.MovieResponse;
import com.workintech.manytomany.manytomany.entity.Actor;
import com.workintech.manytomany.manytomany.entity.Movie;
import com.workintech.manytomany.manytomany.service.ActorService;
import com.workintech.manytomany.manytomany.service.MovieService;
import com.workintech.manytomany.manytomany.util.HollywoodUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;
    private MovieService movieService;

    @Autowired
    public ActorController(ActorService actorService, MovieService movieService) {
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<ActorResponse> find() {
        List <ActorResponse> actorResponses = new ArrayList<>();
        List <Actor> actorsList = actorService.find();
        for(Actor actor : actorsList){
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(),
                    actor.getLastName(), actor.getGender(), actor.getBirthDate()));
        }
        return actorResponses;
    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable int id) {
        Actor actor = actorService.findById(id);
        return new ActorResponse(actor.getId(), actor.getFirstName(),
                actor.getLastName(), actor.getGender(), actor.getBirthDate());
    }
    @PostMapping("/justActor")
    public Actor save(@RequestBody Actor actor) {
        return actorService.save(actor);
    }
    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest) {
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        actor.addMovie(movie);
        Actor savedActor = actorService.save(actor);
        return HollywoodUtility.convertMovieActorResponse(movie, savedActor);
    }

    @PostMapping("/addMovie/{actorId}")
    public List <MovieResponse> addMovie(@RequestBody List <Movie> movies,
                                         @PathVariable int actorId) {
        Actor actor = actorService.findById(actorId);
        actor.addAllMovies(movies);
        Actor savedActor= actorService.save(actor);
        return HollywoodUtility.convertMovieResponses(savedActor);
    }

    @PostMapping("/{actorId}/{movieId}")
    public List<MovieResponse> addMovieToActor(@PathVariable int movieId,
                                               @PathVariable int actorId) {
        Actor actor = actorService.findById(actorId);
        Movie movie = movieService.findById(movieId);
        actor.addMovie(movie);
        movie.addActor(actor);
        actorService.save(actor);
        movieService.save(movie);
        return HollywoodUtility.convertMovieResponses(actor);
    }


    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor, @PathVariable int id) {
        Actor foundActor = actorService.findById(id);
        foundActor.setId(id);
        actor.setMovies(foundActor.getMovies());
        actorService.save(actor);
        return new ActorResponse(actor.getId(), actor.getFirstName(),
                actor.getLastName(), actor.getGender(), actor.getBirthDate());
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable int id) {
        Actor actor = actorService.findById(id);
        actorService.delete(actor);
        return new ActorResponse(actor.getId(), actor.getFirstName(),
                actor.getLastName(), actor.getGender(), actor.getBirthDate());
    }
}