package de.volkswagen.zoomanager.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import de.volkswagen.zoomanager.models.Animal;
import de.volkswagen.zoomanager.repositories.AnimalRepositoy;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnimalService {

	private final AnimalRepositoy animalRepository;

	public List<Animal> findAll() {
		return this.animalRepository.findAll();
	}

	public Animal findById(Long id) {
		return this.animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public Animal save(Animal animal) {
		return this.animalRepository.save(animal);
	}

	public void deleteById(Long id) {
		this.animalRepository.deleteById(id);
	}
}
