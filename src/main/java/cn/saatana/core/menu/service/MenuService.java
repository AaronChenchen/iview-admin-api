package cn.saatana.core.menu.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CurdService;
import cn.saatana.core.menu.dao.MenuDao;
import cn.saatana.core.menu.entity.Menu;

@Service
public class MenuService extends CurdService<MenuDao, Menu> {

}
