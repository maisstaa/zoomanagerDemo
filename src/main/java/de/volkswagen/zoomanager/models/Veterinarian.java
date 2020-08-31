package de.volkswagen.zoomanager.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "employee_id")
public class Veterinarian extends AbstractEmployee {

	private static int animalCapacity = 25;

//	private List<Animal> responsibleAnimals = new ArrayList<>(animalCapacity);

}
