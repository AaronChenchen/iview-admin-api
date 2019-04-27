package cn.saatana.core.auth.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.auth.mapper.AuthorizerMapper;
import cn.saatana.core.common.CommonService;

@Service
public class AuthorizerService extends CommonService<AuthorizerMapper, Authorizer> {
	public Authorizer getByUsername(String username) {
		return mapper.getByUsername(username);
	}
}
