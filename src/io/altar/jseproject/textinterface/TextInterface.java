package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.EntityRepository;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {

	private static ProductRepository repositorioDeProducts = ProductRepository.getInstance();
	private static ShelfRepository repositorioDeShelfs = ShelfRepository.getInstance();

	private char screenOption;
	Scanner sc = new Scanner(System.in);

	/**
	 * @param screenOption the screenOption to set
	 */
	public void setScreenOption() {

		this.screenOption = sc.next().charAt(0);

	}

	public void menuInicial() {
		System.out.println("Escolha uma opcao:");
		System.out.println("1 - Listar produtos.");
		System.out.println("2 - Listar prateleiras.");
		System.out.println("3 - Sair.");
		setScreenOption();
		switch (this.screenOption) {
		case '1':
			menuListarProdutos();

			break;
		case '2':
			menuListarPrateleiras();
			break;
		case '3':
			System.out.println("O programa vai ser encerrado");
			break;
		default:
			System.out.println("Nao aplicavel");
			menuInicial();
			setScreenOption();
			break;
		}

	}

	public void menuListarProdutos() {
		System.out.println("Por favor selecione uma das seguintes opcÌ§oÌƒes:");
		System.out.println("1 - Criar Novo produto.");
		System.out.println("2 - Editar um produto existente.");
		System.out.println("3 - Consultar o detalhe de um produto.");
		System.out.println("4 - Remover um produto.");
		System.out.println("5 - Voltar ao ecraÌƒ anterior.");
		setScreenOption();
		switch (this.screenOption) {
		case '1':
			adicionarProduto();
			menuListarProdutos();
			break;
		case '2':
			System.out.println("Editar um produto existente");
			alterarProduto();
			menuListarProdutos();
			break;
		case '3':
			System.out.println("Consultar o detalhe de um produto");
			consultarProduto();
			menuListarProdutos();
			break;
		case '4':
			System.out.println("Remover um produto");
			eliminarProduto();
			menuListarProdutos();
			break;
		case '5':
			menuInicial();
			break;
		default:
			System.out.println("Nao aplicavel");
			menuListarProdutos();
			setScreenOption();
			break;
		}
	}

	public void adicionarProduto() {
		System.out.println("Criar Novo produto");
		System.out.println("1 - Prateleira onde quer colocar o produto.");
		int prateleira = sc.nextInt();
		System.out.println("2 - Valor unitaÌ�rio de desconto.");
		int desconto = sc.nextInt();
		System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentagem)");
		int iva = sc.nextInt();
		System.out.println("4 - PVP (PrecÌ§o de Venda ao PuÌ�blico)");
		int pvp = sc.nextInt();
		System.out.print("Dados do Produto Inserido: ");
		System.out
				.println("prateleira:" + prateleira + ", desconto:" + desconto + ", iva:" + iva + ", pvp:" + pvp + ";");
		Product produto = new Product(prateleira, desconto, iva, pvp);
		repositorioDeProducts.save(produto);
		System.out.println(repositorioDeProducts.getAll());

	}

	public void alterarProduto() {
		
	System.out.println("Digite o id do produto a alterar");
	Long id = sc.nextLong();
//	Product idDoProduto = repositorioDeProducts.findById(id);
//	System.out.println(idDoProduto);
	System.out.println();
	System.out.println("1 - Prateleira onde quer colocar o produto.");
	int prateleiraProduto = repositorioDeProducts.findById((long)id).getShelfWithProduct();
	System.out.println(prateleiraProduto);
	int prateleira = sc.nextInt();
	repositorioDeProducts.findById((long)id).setShelfWithProduct(prateleira);
	System.out.println();
	
	System.out.println("2 - Valor unitario de desconto.");
	int descontoProduto = repositorioDeProducts.findById((long)id).getDiscountValue();
	System.out.println(descontoProduto);
	int desconto = sc.nextInt();
	repositorioDeProducts.findById((long)id).setDiscountValue(desconto);
	System.out.println();
	
	System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentagem)");
	int ivaProduto = repositorioDeProducts.findById((long)id).getIva();
	System.out.println(ivaProduto);
	int iva = sc.nextInt();
	repositorioDeProducts.findById((long)id).setIva(iva);
	System.out.println();
	
	System.out.println("4 - PVP (Preco de Venda ao Publico)");
	int pvpProduto = repositorioDeProducts.findById((long)id).getPvp();
	System.out.println(pvpProduto);
	int pvp= sc.nextInt();
	repositorioDeProducts.findById((long)id).setPvp(pvp);
	System.out.println();
	}

	/**
	 * CONSULTAR PRODUTOS
	 */
	public void consultarProduto() {
		System.out.println("Digite o id do produto a consultar");
		int id = sc.nextInt();
		System.out.println(repositorioDeProducts.findById((long) id));
	}

	public void eliminarProduto() {
		System.out.println("Criar Novo produto");
		System.out.println("Digite o id do produto a eliminar");
		int id = sc.nextInt();
		System.out.println("Confirma o produto a eliminar, S/N");
		char eliminar = sc.next().charAt(0);
		if (eliminar == 's' || eliminar == 'S') {
			repositorioDeProducts.removeById((long) id);
			System.out.println(repositorioDeProducts.getAll());
		} else {
			System.out.println("Nao eliminado");
		}
	}

	public void menuListarPrateleiras() {

		System.out.println("Por favor selecione uma das seguintes opcÌ§oÌƒes:");
		System.out.println("1 - Criar nova prateleira.");
		System.out.println("2 - Editar uma prateleira existente.");
		System.out.println("3 - Consultar o detalhe de uma prateleira.");
		System.out.println("4 - Remover uma prateleira.");
		System.out.println("5 - Voltar ao ecraÌƒ anterior.");
		setScreenOption();
		switch (this.screenOption) {
		case '1':
			System.out.println("Criar Nova  Prateleira");
			System.out.println("2 - Capacidade.");
			String capacidade = sc.next();
			Integer capacidadeInt = Integer.parseInt(capacidade);
			System.out.println("3 - Produto que Alberga.");
			String produto = sc.next();
			Integer produtoInt = Integer.parseInt(produto);
			System.out.println("4 - PrecÌ§o de aluguer de localizacÌ§aÌƒo (diaÌ�rio)");
			String aluguer = sc.next();
			Integer aluguerInt = Integer.parseInt(aluguer);
			Shelf shelf = new Shelf(capacidadeInt, produto, aluguerInt);
			repositorioDeShelfs.save(shelf);
			System.out.println(repositorioDeShelfs.getAll());
			menuListarPrateleiras();
			break;
		case '2':
			System.out.println("Editar um produto existente");
			menuListarPrateleiras();
			break;
		case '3':
			System.out.println("Consultar o detalhe de um produto");
			menuListarPrateleiras();
			break;
		case '4':
			System.out.println("Remover um produto.");
			menuListarPrateleiras();
			break;
		case '5':
			menuInicial();
			break;
		default:
			System.out.println("Nao aplicavel");
			menuListarPrateleiras();
			setScreenOption();
			break;
		}
	}
}