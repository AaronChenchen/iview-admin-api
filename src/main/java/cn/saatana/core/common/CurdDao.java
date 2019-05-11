package cn.saatana.core.common;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class CurdDao<Entity extends BaseEntity> {
	@Autowired
	protected JdbcTemplate jdbc;

	/**
	 * 主键查询
	 *
	 * @param id
	 * @return
	 */
	public abstract Entity get(String id);

	/**
	 * 批量主键查询
	 *
	 * @param ids
	 * @return
	 */
	public abstract List<Entity> getAll(Collection<String> ids);

	/**
	 * 总数量
	 *
	 * @param condition
	 * @return
	 */
	public abstract int total(Entity condition);

	/**
	 * 分页查询
	 *
	 * @param condition
	 * @param start
	 * @param end
	 * @return
	 */
	public abstract List<Entity> findPage(Entity condition, int start, int end);

	/**
	 * 条件查询
	 *
	 * @param condition
	 * @return
	 */
	public abstract List<Entity> findList(Entity condition);

	/**
	 * 查询全部
	 *
	 * @return
	 */
	public abstract List<Entity> findAll();

	/**
	 * 插入
	 *
	 * @param entity
	 */
	public abstract void create(Entity entity);

	/**
	 * 批量插入
	 *
	 * @param entities
	 */
	public abstract void createAll(Collection<Entity> entities);

	/**
	 * 更新\逻辑删除
	 *
	 * @param entity
	 */
	public abstract void update(Entity entity);

	/**
	 * 批量更新\逻辑删除
	 *
	 * @param entities
	 */
	public abstract void updateAll(Collection<Entity> entities);

	/**
	 * 物理删除
	 *
	 * @param id
	 */
	public abstract void delete(String id);

	/**
	 * 批量物理删除
	 *
	 * @param ids
	 */
	public abstract void deleteAll(Collection<String> ids);
}
