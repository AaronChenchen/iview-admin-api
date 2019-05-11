package cn.saatana;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.auth.service.AuthorizerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorizerTests {
	@Autowired
	private AuthorizerService service;

	@Test
	public void getByUsername() {
		Authorizer auth = service.getByUsername("admin");
		Assert.assertNotNull(auth);
	}

}
