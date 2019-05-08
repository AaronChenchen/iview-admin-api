package cn.saatana.core.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class, readOnly = true)
public abstract class CurdService<Dao extends CurdDao<Entity>, Entity extends BaseEntity> {
	@Autowired
	protected Dao dao;

	/**
	 * 主键查询
	 *
	 * @param id
	 * @return
	 */
	public Entity get(String id) {
		return dao.get(id);
	}

	/**
	 * 批量主键查询
	 *
	 * @param ids
	 * @return
	 */
	public List<Entity> getAll(Collection<String> ids) {
		return dao.getAll(ids);
	}

	/**
	 * 总数量
	 *
	 * @param condition
	 * @return
	 */
	public int total(Entity condition) {
		return dao.total(condition);
	}

	/**
	 * 分页查询
	 *
	 * @param condition
	 * @param start
	 * @param end
	 * @return
	 */
	public Page<Entity> findPage(Entity condition) {
		int page = condition.getPage();
		int limit = condition.getLimit();
		int start = (page - 1) * limit;
		int end = page * limit;
		Page<Entity> res = new Page<>();
		res.setList(dao.findPage(condition, start, end));
		res.setTotal(total(condition));
		return res;
	}

	/**
	 * 条件查询
	 *
	 * @param condition
	 * @return
	 */
	public List<Entity> findList(Entity condition) {
		return dao.findList(condition);
	}

	/**
	 * 查询全部
	 *
	 * @return
	 */
	public List<Entity> findAll() {
		return dao.findAll();
	}

	/**
	 * 插入
	 *
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public String create(Entity entity) {
		String id = entity.preCreate();
		dao.create(entity);
		return id;
	}

	/**
	 * 批量插入
	 *
	 * @param entities
	 */
	@Transactional(readOnly = false)
	public List<String> createAll(Collection<Entity> entities) {
		List<String> ids = new ArrayList<>();
		entities.forEach(item -> {
			ids.add(item.preCreate());
		});
		dao.createAll(entities);
		return ids;
	}

	/**
	 * 更新
	 *
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void update(Entity entity) {
		entity.preUpdate();
		dao.update(entity);
	}

	/**
	 * 批量更新
	 *
	 * @param entities
	 */
	@Transactional(readOnly = false)
	public void updateAll(Collection<Entity> entities) {
		entities.forEach(item -> {
			item.preUpdate();
		});
		dao.updateAll(entities);
	}

	/**
	 * 逻辑删除
	 *
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	public Entity remove(String id) {
		Entity entity = get(id);
		entity.preRemove();
		dao.update(entity);
		return entity;
	}

	/**
	 * 批量逻辑删除
	 *
	 * @param ids
	 * @return
	 */
	@Transactional(readOnly = false)
	public List<Entity> removeAll(Collection<String> ids) {
		List<Entity> entities = getAll(ids);
		entities.forEach(item -> {
			item.preRemove();
		});
		dao.updateAll(entities);
		return entities;
	}

	/**
	 * 物理删除
	 *
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void delete(String id) {
		dao.delete(id);
	}

	/**
	 * 批量物理删除
	 *
	 * @param ids
	 */
	@Transactional(readOnly = false)
	public void deleteAll(Collection<String> ids) {
		dao.deleteAll(ids);
	}

	/**
	 * 恢复
	 *
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	public Entity restore(String id) {
		Entity entity = get(id);
		entity.preRestore();
		dao.update(entity);
		return entity;
	}

	/**
	 * 批量恢复
	 *
	 * @param ids
	 * @return
	 */
	@Transactional(readOnly = false)
	public List<Entity> restoreAll(Collection<String> ids) {
		List<Entity> entities = getAll(ids);
		entities.forEach(item -> {
			item.preRestore();
		});
		dao.updateAll(entities);
		return entities;
	}
}
