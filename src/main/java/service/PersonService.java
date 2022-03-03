package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.MessageResponseDTO;
import dto.request.PersonDTO;
import entity.Person;
import exception.PersonNotFounException;
import repository.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
	
	@Autowired
	public void PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = Person.builder().firstName(personDTO.getFirstName()).lastName(personDTO.getLastName())
				.CPF(personDTO.getCPF()).bithDate(personDTO.getBithDate()).phones(personDTO.getPhones()).build();
		
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO.builder().message("Created person with ID:" + savedPerson.getId()).build();
	}

	public List<Person> listALL() {
		List<Person> Everyone = personRepository.findAll();
		return Everyone;
	}
	
	public Optional<Person> findById(Long id) throws PersonNotFounException {
		Optional<Person> optionalPerson =  personRepository.findById(id);
		if(optionalPerson.isEmpty()) {
			throw new PersonNotFounException(id);
		}
		return optionalPerson;
	}
}
