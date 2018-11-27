package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Product extends Entity{
	
	private List <Shelf> shelves;
	private int discountValue;
	private int iva;
	private int pvp;



	/**
	 * @param shelves
	 * @param discountValue
	 * @param iva
	 * @param pvp
	 */
	public Product( int discountValue, int iva, int pvp) {
		super();
		this.shelves = new ArrayList<>();
		this.discountValue = discountValue;
		this.iva = iva;
		this.pvp = pvp;
	}
	
	
	/**
	 * @return the shelves
	 */
	public List<Shelf> getShelves() {
		return shelves;
	}


	/**
	 * @return the discountValue
	 */
	public int getDiscountValue() {
		return discountValue;
	}


	/**
	 * @param shelves the shelves to set
	 */
	public void addShelves(Shelf shelf) {
		this.shelves.add(shelf);
	}


	/**
	 * @return the iva
	 */
	public int getIva() {
		return iva;
	}
	/**
	 * @return the pvp
	 */
	public int getPvp() {
		return pvp;
	}

	/**
	 * @param discountValue the discountValue to set
	 */
	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}
	/**
	 * @param iva the iva to set
	 */
	public void setIva(int iva) {
		this.iva = iva;
	}
	/**
	 * @param pvp the pvp to set
	 */
	public void setPvp(int pvp) {
		this.pvp = pvp;
	}
	
	private String printShelves() {
		String str="";
		
		for(int i=0;i<this.shelves.size();i++) {
			str+=this.shelves.get(i).getId();
			str+=", ";
		}
		return str;
	}
	
	@Override
	public String toString() {
		return "Product [shelfWithProduct=" + printShelves() + "discountValue=" + discountValue + ", iva=" + iva
				+ ", pvp=" + pvp + "]";
	}
	
//	public List<Long> addToShelve(boolean state) {
//		
//		while (state == false) {
//			Long prateleira = sc.nextLong();
//			List<Long> shelfWithProduct = new ArrayList<Long>();
//			shelfWithProduct.add(prateleira);
//			System.out.println("Deseja adicionar o produto a mais prateleiras");
//			char adicionar = sc.next().charAt(0);
//			if (adicionar == 's' || adicionar == 'S') {
//				shelfWithProduct.add(prateleira);
//			} else {
//				state = true;
//
//				
//			}
//			
//		}
//	
//		
//}
}
