package de.volkswagen.zoomanager.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.volkswagen.zoomanager.repositories.AnimalRepositoy;
import de.volkswagen.zoomanager.repositories.EnclosureRepository;

// loading some Data into the db.
@Component
public class DatabaseLoader implements CommandLineRunner {

	private final AnimalRepositoy animalRepo;
	private final EnclosureRepository enclosureRepo;

	@Autowired
	public DatabaseLoader(AnimalRepositoy repo, EnclosureRepository enRepo) {
		this.animalRepo = repo;
		this.enclosureRepo = enRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		this.animalRepo.save(new Animal(AnimalClass.REPTILE, "Frosch", "Froggy", 3, true, 2));
		this.animalRepo.save(new Animal(AnimalClass.BIRD, "Dohle", "Hedwig", 10, false, 40));
		this.animalRepo.save(new Animal(AnimalClass.FISH, "Tigerhai", "Sharky", 20, false, 122));
		this.animalRepo.save(new Animal(AnimalClass.MAMMAL, "Roter Panda", "Crocci", 8, true, 33));
	}
}
