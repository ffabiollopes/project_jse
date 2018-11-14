package io.altar.jseproject.model;

public class Product {
	private int productId;
	private Shelf [] shelfWithProduct = new Shelf[1];
	private int discountValue;
	private int iva;
	private float pvp;

	/**
	 * @param productId
	 * @param shelfWithProduct
	 * @param discountValue
	 * @param iva
	 * @param pvp
	 */
	public Product(int productId, Shelf [] shelfWithProduct, int discountValue, int iva, float pvp) {
		this.productId = productId;
		this.shelfWithProduct = shelfWithProduct;
		this.discountValue = discountValue;
		this.iva = iva;
		this.pvp = pvp;
	}


}
