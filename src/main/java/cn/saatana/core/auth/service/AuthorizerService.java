package cn.saatana.core.auth.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.auth.repository.AuthorizerRepository;
import cn.saatana.core.common.CurdService;

@Service
public class AuthorizerService extends CurdService<AuthorizerRepository, Authorizer> {
	public Authorizer getByUsername(String username) {
		return repository.getByUsername(username);
	}
}
