package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import io.altar.jseproject.model.Entity;

public abstract class EntityRepository<T extends Entity> {
	
	private Map<Long, T> map = new HashMap<Long, T>();

	private long actualId = 0;

	public void save(T entity) {
		entity.setId(actualId);

		map.put(entity.getId(), entity);
		actualId++;
	}
	
	public T findById(Long id) {
		return map.get(id);
	}

	public void removeById(Long id) {
		map.remove(id);
	}

	public void update(T entity) {
		map.replace(entity.getId(), entity);
	}
	
	public Collection<T> getAll() {
		return map.values();
	}
	
	public Map<Long, T> getMap(){
		return map;
	}

}
