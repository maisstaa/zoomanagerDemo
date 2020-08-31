package de.volkswagen.zoomanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.volkswagen.zoomanager.models.Animal;

public interface AnimalRepositoy extends JpaRepository<Animal, Long> {

}
