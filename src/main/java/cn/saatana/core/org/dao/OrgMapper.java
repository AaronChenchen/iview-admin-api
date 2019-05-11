package cn.saatana.core.org.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdDao;
import cn.saatana.core.org.entity.Org;

@Component
public class OrgMapper extends CurdDao<Org> {

	@Override
	public Org get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Org> getAll(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total(Org condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Org> findPage(Org condition, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Org> findList(Org condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Org> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Org entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAll(Collection<Org> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Org entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll(Collection<Org> entities) {
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
