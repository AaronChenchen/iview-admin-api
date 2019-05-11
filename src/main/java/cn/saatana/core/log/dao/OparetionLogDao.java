package cn.saatana.core.log.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdDao;
import cn.saatana.core.log.entity.OparetionLog;

@Component
public class OparetionLogDao extends CurdDao<OparetionLog> {

	@Override
	public OparetionLog get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OparetionLog> getAll(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total(OparetionLog condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OparetionLog> findPage(OparetionLog condition, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OparetionLog> findList(OparetionLog condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OparetionLog> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(OparetionLog entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAll(Collection<OparetionLog> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OparetionLog entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll(Collection<OparetionLog> entities) {
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
