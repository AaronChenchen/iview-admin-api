package cn.saatana.test.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {
	@RequestMapping("{name}")
	public String hello(@PathVariable String name) {
		return "Hello," + name;
	}
}
