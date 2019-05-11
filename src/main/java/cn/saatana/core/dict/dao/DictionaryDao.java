package cn.saatana.core.dict.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdDao;
import cn.saatana.core.dict.entity.Dictionary;

@Component
public class DictionaryDao extends CurdDao<Dictionary> {

	@Override
	public Dictionary get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> getAll(Collection<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total(Dictionary condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Dictionary> findPage(Dictionary condition, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> findList(Dictionary condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Dictionary entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAll(Collection<Dictionary> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Dictionary entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll(Collection<Dictionary> entities) {
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
