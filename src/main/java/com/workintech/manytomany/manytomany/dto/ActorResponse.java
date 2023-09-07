package com.workintech.manytomany.manytomany.dto;

import com.workintech.manytomany.manytomany.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorResponse {
    private int actorId;
    private String actorFirstName;
    private String actorLastName;
    private Gender gender;
    private LocalDate actorBirthDate;
}