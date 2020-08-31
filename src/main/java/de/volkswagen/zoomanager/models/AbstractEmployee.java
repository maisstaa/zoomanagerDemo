package de.volkswagen.zoomanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.NonNull;

@Entity(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	private @NonNull EmployeeRole role;
	private @NonNull String name;
	private @NonNull double age;

	private @NonNull double salary;
}
