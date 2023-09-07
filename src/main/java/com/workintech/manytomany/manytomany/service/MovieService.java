package com.workintech.manytomany.manytomany.service;

import com.workintech.manytomany.manytomany.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> find();
    Movie findById(int id);
    Movie save(Movie movie);
    void delete(Movie movie);
}
