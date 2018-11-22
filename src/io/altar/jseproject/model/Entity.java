package io.altar.jseproject.model;

public class Entity {
	
	private Long Id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "Entity [Id=" + Id + "]";
	}
	
	

}
