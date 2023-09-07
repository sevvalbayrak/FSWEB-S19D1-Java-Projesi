package com.workintech.manytomany.manytomany.service;

import com.workintech.manytomany.manytomany.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> find();
    Actor findById(int id);
    Actor save(Actor actor);
    void delete(Actor actor);
}
