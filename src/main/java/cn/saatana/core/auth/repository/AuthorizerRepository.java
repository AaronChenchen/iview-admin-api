package cn.saatana.core.auth.repository;

import org.springframework.stereotype.Component;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.common.CurdRepository;

@Component
public interface AuthorizerRepository extends CurdRepository<Authorizer> {

	Authorizer getByUsername(String username);

}
