package cn.saatana.modules.user.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.Safer;
import cn.saatana.core.common.CurdService;
import cn.saatana.modules.user.entity.User;
import cn.saatana.modules.user.repository.UserRepository;

@Service
public class UserService extends CurdService<UserRepository, User> {
	public User getUserByAuthId() {
		return repository.getByAuthorizerId(Safer.currentAuthId());
	}
}
