package io.altar.jseproject.model;

import java.util.Arrays;

public class Product extends Entity{
	private Shelf[] shelfWithProduct;
	private int discountValue;
	private int iva;
	private int pvp;
	/**
	 * @param shelfWithProduct
	 * @param discountValue
	 * @param iva
	 * @param pvp
	 */
	public Product(Shelf[] shelfWithProduct, int discountValue, int iva, int pvp) {
		this.shelfWithProduct = shelfWithProduct;
		this.discountValue = discountValue;
		this.iva = iva;
		this.pvp = pvp;
	}
	/**
	 * @return the shelfWithProduct
	 */
	public Shelf[] getShelfWithProduct() {
		return shelfWithProduct;
	}
	/**
	 * @return the discountValue
	 */
	public int getDiscountValue() {
		return discountValue;
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
	 * @param shelfWithProduct the shelfWithProduct to set
	 */
	public void setShelfWithProduct(Shelf[] shelfWithProduct) {
		this.shelfWithProduct = shelfWithProduct;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produto Prateleira = " + Arrays.toString(shelfWithProduct) + ", Valor de desconto = " + discountValue
				+ ", iva = " + iva + ", pvp = " + pvp;
	}
	
	
	
}
