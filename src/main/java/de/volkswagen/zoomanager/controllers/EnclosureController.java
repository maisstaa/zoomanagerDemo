package de.volkswagen.zoomanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.volkswagen.zoomanager.models.Enclosure;
import de.volkswagen.zoomanager.services.EnclosureService;

@RestController
@RequestMapping("/api/enclosures")
public class EnclosureController {

	private List<Enclosure> endclosureList = new ArrayList<>();

	@Autowired
	EnclosureService enclosureService;

	Session session;

	@GetMapping("")
	@CrossOrigin("http://localhost:3000")
	public List<Enclosure> listEnclosures() {
		return this.enclosureService.findAll();
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Enclosure getEnclosure(@PathVariable Long id) {
		return this.enclosureService.findById(id);
	}

	@CrossOrigin("http://localhost:3000")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Enclosure createEnclosure(@RequestBody Enclosure enclosure) {
		System.out.println("Created: " + enclosure);
		this.endclosureList.add(enclosure);
		return this.enclosureService.save(enclosure);
	}

	@PutMapping("/{id}")
	public Enclosure updateEnclosure(@RequestBody Enclosure enclosure) {
		return this.enclosureService.save(enclosure);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEnclosure(@PathVariable Long id) {
		// check for children (cascade)
		this.enclosureService.deleteById(id);
	}

	public List<Enclosure> getAnimalList() {
		return this.endclosureList;
	}
}
