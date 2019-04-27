package cn.saatana.core.auth.mapper;

import org.springframework.stereotype.Component;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.common.CommonMapper;

@Component
public interface AuthorizerMapper extends CommonMapper<Authorizer> {

	Authorizer getByUsername(String username);

}
