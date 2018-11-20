package io.altar.jseproject.test;


import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.TextInterface;


public class Test {

	public static void main(String[] args) {

		TextInterface textInterface = new TextInterface();
		textInterface.menuInicial();
		
//		products();
//		shelves();
	}
	
//	public static void products() {
//		
//		repositorioDeProducts.toString();
//		//criar o produto
//		Product produto1= new Product(null,10,23,50);
//		Product produto2= new Product(null,10,23,50);
//		repositorioDeProducts.save(produto1);
//		repositorioDeProducts.save(produto2);
//		
//		//Procurar Pelo ID
//		System.out.println(repositorioDeProducts.findById((long)0));
//		System.out.println(repositorioDeProducts.findById((long)1));
//		
//		//Mostrar todos
//		System.out.println(repositorioDeProducts.getAll());
//		
//		//Editar
//		repositorioDeProducts.updateById(produto1);
//
//
//		//Remover Por Id
//		repositorioDeProducts.removeById((long) 1);	
//}
//	
//public static void shelves() {
//		
//		repositorioDeShelfs.toString();
//		//criar o produto
//		Shelf shelf1= new Shelf(10,null,50);
//		Shelf shelf2= new Shelf(10,null,50);
//		repositorioDeShelfs.save(shelf1);
//		repositorioDeShelfs.save(shelf2);
//		
//		//Procurar Pelo ID
//		System.out.println(repositorioDeShelfs.findById((long)0));
//		System.out.println(repositorioDeShelfs.findById((long)1));
//		
//		//Mostrar todos
//		System.out.println(repositorioDeShelfs.getAll());
//		
//		//Editar
//		repositorioDeShelfs.updateById(shelf1);
//
//
//		//Remover Por Id
//		repositorioDeShelfs.removeById((long) 1);
//	
//		
//		
//}
}
