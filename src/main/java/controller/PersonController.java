package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dto.MessageResponseDTO;
import dto.request.PersonDTO;
import entity.Person;
import service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService personService;
	
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}



	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Validated PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	
	@GetMapping
	public List<Person> listAll(){
		return personService.listALL();
	}
}
