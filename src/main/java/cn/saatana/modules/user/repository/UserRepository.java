package cn.saatana.modules.user.repository;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdRepository;
import cn.saatana.modules.user.entity.User;

@Component
public interface UserRepository extends CurdRepository<User> {
	User getByAuthorizerId(String authorizerId);
}
