package de.volkswagen.zoomanager.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.volkswagen.zoomanager.models.Animal;
import de.volkswagen.zoomanager.services.AnimalService;

@RestController
@RequestMapping("/api/animals")
public class AnimalsController {

	private List<Animal> animalList = new ArrayList<>();

	@Autowired
	AnimalService animalService;

	Session session;

	@GetMapping("")
	@CrossOrigin("http://localhost:3000")
	public List<Animal> listAnimals() {
		return this.animalService.findAll();
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Animal getAnimal(@PathVariable Long id) {
		return this.animalService.findById(id);
	}

	@CrossOrigin("http://localhost:3000")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Animal createAnimal(@RequestBody @Valid Animal animal) {

		System.out.println("Created: " + animal);
		this.animalList.add(animal);

		return this.animalService.save(animal);
	}

	@PutMapping("/{id}")
	public Animal updateAnimal(@RequestBody Animal animal) {
		return this.animalService.save(animal);
	}

	@CrossOrigin("http://localhost:3000")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAnimal(@PathVariable Long id) {
		// check for children (cascade)
		this.animalService.deleteById(id);
	}

	public List<Animal> getAnimalList() {
		return this.animalList;
	}
}
