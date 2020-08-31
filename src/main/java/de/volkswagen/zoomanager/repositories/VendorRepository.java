package de.volkswagen.zoomanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.volkswagen.zoomanager.models.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
