package com.workintech.manytomany.manytomany.dto;

import com.workintech.manytomany.manytomany.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieActorResponse {

    private Movie movie;
    private int actorId;
    private String actorFirstName;
    private String actorLastName;
    private LocalDate actorBirthDate;
}