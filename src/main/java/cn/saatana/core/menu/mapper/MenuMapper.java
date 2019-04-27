package cn.saatana.core.menu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import cn.saatana.core.common.CommonMapper;
import cn.saatana.core.menu.entity.Menu;

@Mapper
@Component
public interface MenuMapper extends CommonMapper<Menu> {

}
