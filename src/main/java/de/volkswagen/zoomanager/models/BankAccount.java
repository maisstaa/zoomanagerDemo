package de.volkswagen.zoomanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

	private @NonNull double balance;

}
