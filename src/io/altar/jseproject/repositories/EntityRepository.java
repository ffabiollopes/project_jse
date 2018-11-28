package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import io.altar.jseproject.model.Entity;

public abstract class EntityRepository<T extends Entity> {
	
	private Map<Long, T> map = new HashMap<Long, T>();
//comeca a um, nao ha produtos nem prateleiras 0;
	private long actualId = 0;

	public void save(T entity) {
		entity.setId(actualId);

		map.put(entity.getId(), entity);
		actualId++;
	}
	public void saveMyId(T entity, Long id) {
		entity.setId(id);
		map.put(entity.getId(), entity);
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
	

}
