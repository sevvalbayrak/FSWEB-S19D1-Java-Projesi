package com.workintech.manytomany.manytomany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private int id;
    private String name;
    private String directorName;
    private double rating;
    private LocalDate releaseDate;

}