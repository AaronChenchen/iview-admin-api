package cn.saatana.core.common;

import java.util.List;

public interface CommonMapper<Entity extends CommonEntity> {
	Entity get(String id);

	List<Entity> findList(Entity entity);

	List<Entity> findByIds(Iterable<String> ids);

	boolean exist(Entity entity);

	void insert(Entity entity);

	void insertAll(Iterable<Entity> list);

	void update(Entity entity);

	void updateAll(Iterable<Entity> list);

	void delete(String id);

	void deleteAll(Iterable<String> ids);

}
