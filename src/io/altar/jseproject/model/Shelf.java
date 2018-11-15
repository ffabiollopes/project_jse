package io.altar.jseproject.model;


public class Shelf {
	
	private int shelfId = 0;
	private int capacity;
	private Product [] productInShelf;
	private int dailyRentPrice;


	/**
	 * @param shelfId
	 * @param capacity
	 * @param productInShelf
	 * @param dailyRentPrice
	 */
	public Shelf(int capacity, Product productInShelf[], int dailyRentPrice) {
		this.capacity = capacity;
		this.productInShelf = productInShelf;
		this.dailyRentPrice = dailyRentPrice;
	}

}

