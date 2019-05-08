package cn.saatana.core.auth.dao;

import org.springframework.stereotype.Component;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.common.CurdDao;

@Component
public interface AuthorizerDao extends CurdDao<Authorizer> {

	Authorizer getByUsername(String username);

}
