package io.altar.jseproject.model;

public class Product {
	private int productId = 0 ;
	private Shelf [] shelfWithProduct;
	private int discountValue;
	private int iva;
	private int pvp;


	/**
	 * @param productId TIREI DO CONSTRUCTOR
	 * @param shelfWithProduct
	 * @param discountValue
	 * @param iva
	 * @param pvp
	 */
	public Product(Shelf [] shelfWithProduct, int discountValue, int iva, int pvp) {
		this.shelfWithProduct = shelfWithProduct;
		this.discountValue = discountValue;
		this.iva = iva;
		this.pvp = pvp;
	}
	
	public void createProduct() {
		
	
	}

}
