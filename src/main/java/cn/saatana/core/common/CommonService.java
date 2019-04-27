package cn.saatana.core.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class, readOnly = true)
public abstract class CommonService<Mapper extends CommonMapper<Entity>, Entity extends CommonEntity> {
	@Autowired
	protected Mapper mapper;

	public Entity get(String id) {
		return mapper.get(id);
	}

	public boolean exist(Entity entity) {
		return mapper.exist(entity);
	}

	public Page<Entity> findPage(Entity entity) {
		Page<Entity> page = PageHelper.<Entity>startPage(entity.getPage(), entity.getLimit());
		mapper.findList(entity);
		return page;
	}

	public List<Entity> findAll() {
		return mapper.findList(null);
	}

	public List<Entity> findList(Entity entity) {
		return mapper.findList(entity);
	}

	public List<Entity> findAllByIds(Iterable<String> ids) {
		return mapper.findByIds(ids);
	}

	@Transactional(readOnly = false)
	public void create(Entity entity) {
		if (entity != null) {
			entity.preCreate();
			mapper.insert(entity);
		}
	}

	@Transactional(readOnly = false)
	public void createAll(Iterable<Entity> entities) {
		if (entities != null) {
			entities.forEach(entity -> {
				entity.preCreate();
			});
			mapper.insertAll(entities);
		}
	}

	@Transactional(readOnly = false)
	public void update(Entity entity) {
		if (entity != null) {
			entity.preUpdate();
			mapper.update(entity);
		}
	}

	@Transactional(readOnly = false)
	public void updateAll(Iterable<Entity> entities) {
		if (entities != null) {
			entities.forEach(entity -> {
				entity.preUpdate();
			});
			mapper.updateAll(entities);
		}
	}

	@Transactional(readOnly = false)
	public Entity remove(String id) {
		Entity entity = get(id);
		if (entity != null) {
			entity.preRemove();
			mapper.update(entity);
		}
		return entity;
	}

	@Transactional(readOnly = false)
	public List<Entity> removeAll(Iterable<String> ids) {
		List<Entity> list = new ArrayList<>();
		if (ids != null) {
			ids.forEach(id -> {
				Entity entity = get(id);
				entity.preRemove();
				list.add(entity);
			});
			mapper.updateAll(list);
		}
		return list;
	}

	@Transactional(readOnly = false)
	public Entity restore(String id) {
		Entity entity = get(id);
		if (entity != null) {
			entity.preRestore();
			mapper.update(entity);
		}
		return entity;
	}

	@Transactional(readOnly = false)
	public List<Entity> restoreAll(Iterable<String> ids) {
		List<Entity> list = new ArrayList<>();
		if (ids != null) {
			ids.forEach(id -> {
				Entity entity = get(id);
				entity.preRestore();
				list.add(entity);
			});
			mapper.updateAll(list);
		}
		return list;
	}

	@Transactional(readOnly = false)
	public void delete(String id) {
		mapper.delete(id);
	}

	@Transactional(readOnly = false)
	public void deleteAll(Iterable<String> ids) {
		if (ids != null) {
			mapper.deleteAll(ids);
		}
	}
}
