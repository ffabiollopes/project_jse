package io.altar.jseproject.model;


public class Shelf extends Entity {
	
	private int capacity;
	private Product [] productInShelf;
	private int dailyRentPrice;


	/**
	 * @param capacity
	 * @param productInShelf
	 * @param dailyRentPrice
	 */
	public Shelf(int capacity, Product productInShelf[], int dailyRentPrice) {
		this.capacity = capacity;
		this.productInShelf = productInShelf;
		this.dailyRentPrice = dailyRentPrice;
	}


	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}


	/**
	 * @return the productInShelf
	 */
	public Product[] getProductInShelf() {
		return productInShelf;
	}


	/**
	 * @return the dailyRentPrice
	 */
	public int getDailyRentPrice() {
		return dailyRentPrice;
	}


	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	/**
	 * @param productInShelf the productInShelf to set
	 */
	public void setProductInShelf(Product[] productInShelf) {
		this.productInShelf = productInShelf;
	}


	/**
	 * @param dailyRentPrice the dailyRentPrice to set
	 */
	public void setDailyRentPrice(int dailyRentPrice) {
		this.dailyRentPrice = dailyRentPrice;
	}
	
	

}

