package io.altar.jseproject.model;


public class Shelf {
	
	private int shelfId = 0;
	private int capacity = 0;
	private Product [] productInShelf = new Product[1];
	private int dailyRentPrice = 0;


	/**
	 * @param shelfId
	 * @param capacity
	 * @param productInShelf
	 * @param dailyRentPrice
	 */
	public Shelf(int shelfId, int capacity, Product productInShelf[], int dailyRentPrice) {
		this.shelfId = shelfId;
		this.capacity = capacity;
		this.productInShelf = productInShelf;
		this.dailyRentPrice = dailyRentPrice;
	}

}

