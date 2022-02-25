package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.MessageResponseDTO;
import entity.Person;
import repository.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
	
	@Autowired
	public void PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder().message("Created person with ID:" + savedPerson.getId()).build();
	}
}
