package cn.saatana.core.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import cn.saatana.core.common.CommonMapper;
import cn.saatana.core.role.entity.Role;

@Mapper
@Component
public interface RoleMapper extends CommonMapper<Role> {

}
