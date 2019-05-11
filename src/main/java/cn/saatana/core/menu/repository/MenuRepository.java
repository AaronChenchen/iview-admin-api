package cn.saatana.core.menu.repository;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdRepository;
import cn.saatana.core.menu.entity.Menu;

@Component
public interface MenuRepository extends CurdRepository<Menu> {

}
