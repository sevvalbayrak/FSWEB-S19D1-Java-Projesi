package com.workintech.manytomany.manytomany.service;

import com.workintech.manytomany.manytomany.dao.ActorDao;
import com.workintech.manytomany.manytomany.entity.Actor;
import com.workintech.manytomany.manytomany.exeptions.MovieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    private ActorDao actorDao;

    @Autowired
    public ActorServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }
    @Override
    public List<Actor> find() {
        return actorDao.findAll();
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> optionalActor = actorDao.findById(id);
        if(optionalActor.isPresent()){
            return optionalActor.get();
        }
        throw new MovieException("Actor is not exist: " + id, HttpStatus.BAD_REQUEST);
    }
    @Override
    public Actor save(Actor actor) {
        return actorDao.save(actor);
    }

    @Override
    public void delete(Actor actor) {
        actorDao.delete(actor);
    }
}
