package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;


public class TextInterface {

	private char screenOption;
	Scanner sc = new Scanner(System.in);

	/**
	 * @param screenOption
	 *            the screenOption to set
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

		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1 - Criar Novo produto.");
		System.out.println("2 - Editar um produto existente.");
		System.out.println("3 - Consultar o detalhe de um produto.");
		System.out.println("4 - Remover um produto.");
		System.out.println("5 - Voltar ao ecrã anterior.");
		setScreenOption();
		switch (this.screenOption) {
		case '1':
			adicionarProduto();
			menuListarProdutos();
			break;
		case '2':
			System.out.println("Editar um produto existente");
			menuListarProdutos();
			break;
		case '3':
			System.out.println("Consultar o detalhe de um produto");
			menuListarProdutos();
			break;
		case '4':
			System.out.println("Remover um produto");
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
	//verificar o parseint
	public void adicionarProduto() {
		System.out.println("Criar Novo produto");
		System.out.println("1 - Prateleira onde quer colocar o produto.");
		int prateleira = Integer.parseInt(sc.nextInt());
		System.out.println("2 - Valor unitário de desconto.");
		int desconto = sc.nextInt();
		System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentage)");
		int iva = sc.nextInt();
		System.out.println("4 - PVP (Preço de Venda ao Público)");
		int pvp= sc.nextInt();
		System.out.println("prateleira:"+prateleira+" desconto:"+ desconto+" iva:"+iva+" pvp:"+pvp);
		Product produto = new Product(null,desconto,iva,pvp);
		System.out.println(produto);
	}
	
	

	public void menuListarPrateleiras() {

		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1 - Criar nova prateleira.");
		System.out.println("2 - Editar uma prateleira existente.");
		System.out.println("3 - Consultar o detalhe de uma prateleira.");
		System.out.println("4 - Remover uma prateleira.");
		System.out.println("5 - Voltar ao ecrã anterior.");
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
			System.out.println("4 - Preço de aluguer de localização (diário)");
			String aluguer= sc.next();
			Integer aluguerInt = Integer.parseInt(aluguer);
			System.out.println(" capacidade:"+ capacidadeInt+" produtos:"+produtoInt+" aluguer:"+aluguerInt);
			Shelf shelf = new Shelf(capacidadeInt,null,aluguerInt);
			System.out.println(shelf);
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