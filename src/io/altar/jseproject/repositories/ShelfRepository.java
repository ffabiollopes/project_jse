package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Shelf;

public class ShelfRepository extends EntityRepository <Shelf> {
	
	private static ShelfRepository INSTANCE;
  
     
    private ShelfRepository() {        
    }
     
    public static ShelfRepository getInstance() {
        
        return INSTANCE;
    }

}



