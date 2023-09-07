package com.workintech.manytomany.manytomany.dto;

import com.workintech.manytomany.manytomany.entity.Actor;
import com.workintech.manytomany.manytomany.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieActorRequest {
    private Actor actor;
    private Movie movie;
}