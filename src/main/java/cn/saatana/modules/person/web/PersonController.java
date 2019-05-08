package cn.saatana.modules.person.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.saatana.modules.person.entity.Person;
import cn.saatana.modules.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	private PersonService service;

	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}

	@RequestMapping("/page")
	public List<Person> page(@RequestParam(defaultValue = "") String lastname,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		return service.findPage(lastname, page, limit);
	}
}
