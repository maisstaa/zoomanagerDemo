package de.volkswagen.zoomanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.volkswagen.zoomanager.models.Enclosure;

@Repository
public interface EnclosureRepository extends JpaRepository<Enclosure, Long> {

}
