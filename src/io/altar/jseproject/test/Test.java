package io.altar.jseproject.test;


import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;


public class Test {
	
	private static ProductRepository repositorioDeProducts = new ProductRepository();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TextInterface textInterface = new TextInterface();
//		textInterface.menuInicial();
		run();
	}
	
	public static void run() {
		
		//criar o produto
		Product produto1= new Product(10,23,50);
		Product produto2= new Product(10,23,50);
		repositorioDeProducts.save(produto1);
		repositorioDeProducts.save(produto2);
		
		//Procurar Pelo ID
		System.out.println(repositorioDeProducts.findById((long)0));
		System.out.println(repositorioDeProducts.findById((long)1));
		
		//Mostrar todos
		System.out.println(repositorioDeProducts.getAll());
		
		//Editar
		
		System.out.println(repositorioDeProducts.updateById((long)1));

		
		//Remover Pelo Id
		System.out.println(repositorioDeProducts.removeById((long)1));
		

}
}
