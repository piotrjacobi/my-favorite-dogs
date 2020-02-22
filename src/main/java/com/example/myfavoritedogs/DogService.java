package com.example.myfavoritedogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository repo;

    public void save(Dog dog) {
        repo.save(dog);
    }

    public List<Dog> listAll() {
        return repo.findAll();
    }
}
