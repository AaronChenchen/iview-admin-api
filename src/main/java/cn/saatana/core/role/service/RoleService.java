package cn.saatana.core.role.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CurdService;
import cn.saatana.core.role.dao.RoleDao;
import cn.saatana.core.role.entity.Role;

@Service
public class RoleService extends CurdService<RoleDao, Role> {

}
