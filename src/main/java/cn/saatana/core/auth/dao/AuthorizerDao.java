package cn.saatana.core.auth.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.alibaba.druid.util.StringUtils;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import cn.saatana.core.auth.entity.Authorizer;
import cn.saatana.core.common.BaseEntity.DataStatus;
import cn.saatana.core.common.CurdDao;

@Component
public class AuthorizerDao extends CurdDao<Authorizer> {

	public Authorizer getByUsername(String username) {
		String sql = "select * from authorizer where data_status = ? and username = ?";
		try {
			return jdbc.queryForObject(sql, new Object[] { DataStatus.NORMAL, username },
					(res, rownum) -> new Authorizer(res, rownum));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Authorizer get(String id) {
		String sql = "select * from authorizer where data_status = ? and id = ?";
		try {
			return jdbc.queryForObject(sql, new Object[] { DataStatus.NORMAL, id }, (set, rownum) -> {
				return new Authorizer(set, rownum);
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Authorizer> getAll(Collection<String> ids) {
		String sql = "select * from authorizer where id in (";
		List<Object> params = new ArrayList<>();
		for (String id : ids) {
			sql += "?,";
			params.add(id);
		}
		sql += ")";
		return jdbc.query(sql, params.toArray(), (set, rownum) -> {
			return new Authorizer(set, rownum);
		});
	}

	@Override
	public int total(Authorizer condition) {
		String sql = "select count(0) from authorizer where data_status = ?";
		List<Object> params = new ArrayList<>();
		params.add(DataStatus.NORMAL);
		if (!StringUtils.isEmpty(condition.getUsername())) {
			sql += " and username like concat('%',?,'%')";
			params.add(condition.getUsername());
		}
		return jdbc.queryForObject(sql, params.toArray(), (set, rownum) -> {
			return set.getInt(1);
		});
	}

	@Override
	public List<Authorizer> findPage(Authorizer condition, int start, int end) {
		String sql = "select * from authorizer where data_status = ?";
		List<Object> params = new ArrayList<>();
		params.add(DataStatus.NORMAL);
		if (!StringUtils.isEmpty(condition.getUsername())) {
			sql += " and username like concat('%',?,'%')";
			params.add(condition.getUsername());
		}
		sql += " limit ?,?";
		params.add(start);
		params.add(end);
		return jdbc.query(sql, params.toArray(), (set, rownum) -> {
			return new Authorizer(set, rownum);
		});
	}

	@Override
	public List<Authorizer> findList(Authorizer condition) {
		String sql = "select * from authorizer where data_status = ?";
		List<Object> params = new ArrayList<>();
		params.add(DataStatus.NORMAL);
		if (!StringUtils.isEmpty(condition.getUsername())) {
			sql += " and username like concat('%',?,'%')";
			params.add(condition.getUsername());
		}
		return jdbc.query(sql, params.toArray(), (set, rownum) -> {
			return new Authorizer(set, rownum);
		});
	}

	@Override
	public List<Authorizer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Authorizer entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAll(Collection<Authorizer> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Authorizer entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll(Collection<Authorizer> entities) {
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
