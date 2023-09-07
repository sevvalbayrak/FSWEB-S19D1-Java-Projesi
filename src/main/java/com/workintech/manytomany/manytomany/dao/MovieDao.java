package com.workintech.manytomany.manytomany.dao;

import com.workintech.manytomany.manytomany.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie,Integer> {
}
