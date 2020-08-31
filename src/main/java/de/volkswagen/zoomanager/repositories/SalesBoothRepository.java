package de.volkswagen.zoomanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.volkswagen.zoomanager.models.SalesBooth;

@Repository
public interface SalesBoothRepository extends JpaRepository<SalesBooth, Long> {

}
