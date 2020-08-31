package de.volkswagen.zoomanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.volkswagen.zoomanager.models.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

}
