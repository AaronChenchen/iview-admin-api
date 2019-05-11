package cn.saatana.core.role.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdDao;
import cn.saatana.core.role.entity.Role;

@Component
public class RoleDao extends CurdDao<Role> {

	@Override
	public Role get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAll(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total(Role condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> findPage(Role condition, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findList(Role condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		String sql = "SELECT * FROM role";
		return jdbc.query(sql, new Object[] {}, (set, rownum) -> {
			return new Role(set, rownum);
		});
	}

	@Override
	public void create(Role entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAll(Collection<Role> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Role entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll(Collection<Role> entities) {
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
