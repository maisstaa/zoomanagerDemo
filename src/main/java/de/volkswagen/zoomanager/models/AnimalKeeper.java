package de.volkswagen.zoomanager.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "employee_id")
public class AnimalKeeper extends AbstractEmployee {

	@ManyToMany(mappedBy = "responsibleKeepersForEnclosure")
	private Set<Enclosure> responsibleEnclosures = new HashSet<>();
}
