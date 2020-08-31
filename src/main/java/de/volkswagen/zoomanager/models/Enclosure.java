package de.volkswagen.zoomanager.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Enclosure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long enclosureId;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Animal.class, mappedBy = "enclosure")
	private List<Animal> animalsInEnclosure = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Enclosure_Keeper")
	@JoinColumn(name = "enclosureId")
	@Where(clause = "employee_type = '1'")
	@JsonIgnore
	private Set<AnimalKeeper> responsibleKeepersForEnclosure = new HashSet<>();

	private @NonNull String enclosureName;
	private @NonNull double costOfMaintenancePerMonth;

	public void setAnimals(List<Animal> animals) {
		this.animalsInEnclosure = animals;
	}

}
