package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${projects.developer.fullname}")
    private String fullName;

    @Value("${course.name}")
    private String courseName;

    @GetMapping("/workintech/animal")
    public List<Animal> getAnimals() {
        return animals.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        Animal animal = animals.get(id);
        return animal;
    }

    @PostMapping("/workintech/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/workintech/animal/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animals.remove(id);
    }


    @PostConstruct
    public void loadAll() {
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "maymun"));
    }


}
