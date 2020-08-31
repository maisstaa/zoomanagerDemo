package de.volkswagen.zoomanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long animalId;

	@ManyToOne(optional = true)
	@JoinColumn(nullable = true)
	private Enclosure enclosure;

	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "smallint default 1")
	private @NonNull AnimalClass animalClass;
	private @NonNull String animalSpecies;
	private @NonNull String animalName;
	private @NonNull int age;
	private @NonNull boolean animalGender; // 1 = male, 0 = female or Enum..
	private @NonNull double costOfRationPerMonth;

//	private Veterinarian responsibleVet;

	@Builder
	public Animal(Enclosure enclosure, @NonNull AnimalClass animalClass, @NonNull String animalSpecies,
			@NonNull String animalName, @NonNull int age, @NonNull boolean animalGender,
			@NonNull double costOfRationPerMonth) {
		this.enclosure = enclosure;
		this.animalClass = animalClass;
		this.animalSpecies = animalSpecies;
		this.animalName = animalName;
		this.animalGender = animalGender;
		this.costOfRationPerMonth = costOfRationPerMonth;
	}

	@ManyToOne
	@JoinColumn(name = "enclosureId")
	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	@Column(name = "animalClass")
	@Enumerated(EnumType.ORDINAL)
	public AnimalClass getAnimalClass() {
		return this.animalClass;
	}
}
