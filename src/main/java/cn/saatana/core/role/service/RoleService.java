package cn.saatana.core.role.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CurdService;
import cn.saatana.core.role.entity.Role;
import cn.saatana.core.role.repository.RoleRepository;

@Service
public class RoleService extends CurdService<RoleRepository, Role> {

}
