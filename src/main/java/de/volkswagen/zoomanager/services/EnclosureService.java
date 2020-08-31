package de.volkswagen.zoomanager.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import de.volkswagen.zoomanager.models.Enclosure;
import de.volkswagen.zoomanager.repositories.EnclosureRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnclosureService {

	private final EnclosureRepository enclosureRepository;

	public List<Enclosure> findAll() {
		return this.enclosureRepository.findAll();
	}

	public Enclosure findById(Long id) {
		return this.enclosureRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public Enclosure save(Enclosure animal) {
		return this.enclosureRepository.save(animal);
	}

	public void deleteById(Long id) {
		this.enclosureRepository.deleteById(id);
	}
}
