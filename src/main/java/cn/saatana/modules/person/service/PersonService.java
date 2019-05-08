package cn.saatana.modules.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.saatana.modules.person.entity.Person;
import cn.saatana.modules.person.repository.PersonRepository;

@Service
public class PersonService {
	private PersonRepository repository;

	@Autowired
	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}

	public List<Person> findPage(String lastname, int page, int limit) {
		int start = (page - 1) * limit;
		int end = page * limit;
		return repository.findByLastname(lastname, start, end);
	}
}
