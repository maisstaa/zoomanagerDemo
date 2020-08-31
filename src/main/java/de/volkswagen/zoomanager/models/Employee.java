package de.volkswagen.zoomanager.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends AbstractEmployee {

//	@Override
//	public String toString() {
//		return "Employee [age=" + this.age + ", employeeId=" + this.employeeId + ", name=" + this.name + ", role="
//				+ this.role + ", salary=" + this.salary + ", getAge()=" + getAge() + ", getName()=" + getName()
//				+ ", getRole()=" + getRole() + ", getSalary()=" + getSalary() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}

}
