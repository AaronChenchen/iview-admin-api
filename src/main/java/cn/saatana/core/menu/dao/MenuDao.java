package cn.saatana.core.menu.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdDao;
import cn.saatana.core.menu.entity.Menu;

@Component
public class MenuDao extends CurdDao<Menu> {

	@Override
	public Menu get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getAll(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total(Menu condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> findPage(Menu condition, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> findList(Menu condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Menu entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAll(Collection<Menu> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Menu entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll(Collection<Menu> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Collection<String> ids) {
		// TODO Auto-generated method stub

	}

}
