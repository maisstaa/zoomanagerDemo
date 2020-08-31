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
public class SalesBooth {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long boothId;

//	private @NonNull Vendor vendor;
	private @NonNull double earnings;

//	private @NonNull BoothType boothType;

}
