package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shelf extends Entity {
	private List <Product> product;
	private int capacity;
	private int dailyRentPrice;


	


	/**
	 * @param capacity
	 * @param productInShelf
	 * @param dailyRentPrice
	 */
	public Shelf(int capacity,int dailyRentPrice) {
		super();
		this.product = new ArrayList<>();
		this.capacity = capacity;
		this.dailyRentPrice = dailyRentPrice;
	}


	

	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}




	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}



	/**
	 * @return the dailyRentPrice
	 */
	public int getDailyRentPrice() {
		return dailyRentPrice;
	}




	/**
	 * @param product the product to set
	 */
	public void addProduct(List<Product> product) {
		this.product = product;
	}




	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @param dailyRentPrice the dailyRentPrice to set
	 */
	public void setDailyRentPrice(int dailyRentPrice) {
		this.dailyRentPrice = dailyRentPrice;
	}




	@Override
	public String toString() {
		return "[Shelf="+getId()+ ", capacity=" + capacity + ", productInShelf=" + product + ", dailyRentPrice="
				+ dailyRentPrice + "]";
	}


	
	

}

