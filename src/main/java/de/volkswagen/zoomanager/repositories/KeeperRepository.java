package de.volkswagen.zoomanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.volkswagen.zoomanager.models.AnimalKeeper;

@Repository
public interface KeeperRepository extends JpaRepository<AnimalKeeper, Long> {

}
