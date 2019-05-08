package cn.saatana.core.common;

import java.util.Collection;
import java.util.List;

public interface CurdDao<Entity extends BaseEntity> {
	/**
	 * 主键查询
	 *
	 * @param id
	 * @return
	 */
	Entity get(String id);

	/**
	 * 批量主键查询
	 *
	 * @param ids
	 * @return
	 */
	List<Entity> getAll(Collection<String> ids);

	/**
	 * 总数量
	 *
	 * @param condition
	 * @return
	 */
	int total(Entity condition);

	/**
	 * 分页查询
	 *
	 * @param condition
	 * @param start
	 * @param end
	 * @return
	 */
	List<Entity> findPage(Entity condition, int start, int end);

	/**
	 * 条件查询
	 *
	 * @param condition
	 * @return
	 */
	List<Entity> findList(Entity condition);

	/**
	 * 查询全部
	 *
	 * @return
	 */
	List<Entity> findAll();

	/**
	 * 插入
	 *
	 * @param entity
	 */
	void create(Entity entity);

	/**
	 * 批量插入
	 *
	 * @param entities
	 */
	void createAll(Collection<Entity> entities);

	/**
	 * 更新\逻辑删除
	 *
	 * @param entity
	 */
	void update(Entity entity);

	/**
	 * 批量更新\逻辑删除
	 *
	 * @param entities
	 */
	void updateAll(Collection<Entity> entities);

	/**
	 * 物理删除
	 *
	 * @param id
	 */
	void delete(String id);

	/**
	 * 批量物理删除
	 *
	 * @param ids
	 */
	void deleteAll(Collection<String> ids);
}
