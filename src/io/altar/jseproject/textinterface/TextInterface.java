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
	// INSTANCIAS --- singleton
	private static ProductRepository repositorioDeProducts = ProductRepository.getInstance();
	private static ShelfRepository repositorioDeShelfs = ShelfRepository.getInstance();
	// SCANNER
	private char screenOption;

	Scanner sc = new Scanner(System.in);

	// METODO SCANNER
	public void setScreenOption() {

		this.screenOption = sc.next().charAt(0);

	}

	// MENU INICIAL
	public void menuInicial() {
		System.out.println("Escolha uma opcao:\n");
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
			sc.close();
			break;
		default:
			System.out.println("Nao aplicavel");
			menuInicial();
			setScreenOption();
			break;
		}

	}

	// MENU PRODUTOS
	public void menuListarProdutos() {
		System.out.println("Por favor selecione uma das seguintes opcoes:\n");
		System.out.println("1 - Criar Novo produto.");
		System.out.println("2 - Editar um produto existente.");
		System.out.println("3 - Consultar o detalhe de um produto.");
		System.out.println("4 - Remover um produto.");
		System.out.println("5 - Voltar ao ecra anterior.");
		setScreenOption();
		switch (this.screenOption) {
		case '1':
			adicionarProduto();
			menuListarProdutos();
			break;
		case '2':
			System.out.println("|Editar um produto existente|\n");
			alterarProduto();
			menuListarProdutos();
			break;
		case '3':
			System.out.println("|Consultar o detalhe de um produto|\n");
			consultarProduto();
			menuListarProdutos();
			break;
		case '4':
			System.out.println("|Remover um produto|\n");
			eliminarProduto();
			menuListarProdutos();
			break;
		case '5':
			menuInicial();
			break;
		default:
			System.out.println("|Nao aplicavel|\n");
			menuListarProdutos();
			setScreenOption();
			break;
		}
	}

	// ADICIONAR PRODUTOS
	public void adicionarProduto() {
		System.out.println("Criar Novo produto:\n");
		// colocar um loop a perguntar nova prateleira
		System.out.println("1 - Prateleira onde quer colocar o produto.");
		Long id = sc.nextLong();
		repositorioDeShelfs.findById(id);
		List <Shelf> prateleira;
		//mudar isto adiconar ao produto
		prateleira.addShelves(repositorioDeShelfs);
		System.out.println("2 - Valor unitario de desconto.");
		int desconto = sc.nextInt();
		System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentagem)");
		int iva = sc.nextInt();
		System.out.println("4 - PVP (Preco de Venda ao Publico)");
		int pvp = sc.nextInt();
		Product produto = new Product(desconto, iva, pvp);
		repositorioDeProducts.save(produto);
		System.out.println(repositorioDeProducts.getAll());

	}

	// MODFICAR PRODUTOS
	public void alterarProduto() {

		System.out.println("Digite o id do produto a alterar");
		Long id = sc.nextLong();
		System.out.println(repositorioDeProducts.findById(id));

		// Prateleira onde esta o produto.
		System.out.println("\n 1 - Prateleira onde quer colocar o produto.");
		System.out.println(repositorioDeProducts.findById((long) id).getShelfWithProduct());
		sc.nextLine();
		System.out.println(
				"introduza o valor novo ou pressiona enter para eliminar as prateleiras que albergam o produto");
		String prateleiraCheck = sc.nextLine();
		if (prateleiraCheck.equals("")) {
			List<Long> shelfWithProduct = new ArrayList<Long>();
			repositorioDeProducts.findById((long) id).setShelfWithProduct(shelfWithProduct);
		} else {
			Long prateleira = Long.parseLong(prateleiraCheck);
			List<Long> shelfWithProduct = new ArrayList<Long>();
			shelfWithProduct.add(prateleira);
			repositorioDeProducts.findById((long) id).setShelfWithProduct(shelfWithProduct);
		}

		// Valor unitario de desconto
		System.out.println("2 - Valor unitario de desconto.");
		System.out.println(repositorioDeProducts.findById((long) id).getDiscountValue());

		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		String descontoCheck = sc.nextLine();
		if (descontoCheck.equals("")) {
			System.out.println("...O valor ficou o mesmo...");
		} else {
			int desconto = Integer.parseInt(descontoCheck);
			repositorioDeProducts.findById((long) id).setDiscountValue(desconto);
		}

		// IVA
		System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentagem)");
		System.out.println(repositorioDeProducts.findById((long) id).getIva());
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		String IvaCheck = sc.nextLine();
		if (IvaCheck.equals("")) {
			System.out.println("...O valor ficou o mesmo...");
		} else {
			int iva = Integer.parseInt(IvaCheck);
			repositorioDeProducts.findById((long) id).setIva(iva);
		}

		// PVP
		System.out.println("4 - PVP (Preco de Venda ao Publico)");
		System.out.println(repositorioDeProducts.findById((long) id).getPvp());

		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		String pvpCheck = sc.nextLine();
		if (pvpCheck.equals("")) {
			System.out.println("...O valor ficou o mesmo...");
		} else {
			int pvp = Integer.parseInt(pvpCheck);
			repositorioDeProducts.findById((long) id).setPvp(pvp);
		}
	}

	// CONSULTAR PRODUTOS
	public void consultarProduto() {
		System.out.println("Digite o id do produto a consultar:");
		int id = sc.nextInt();
		System.out.println(repositorioDeProducts.findById((long) id));
	}

	// ELIMINAR PRODUTOS
	public void eliminarProduto() {
		System.out.println("Criar Novo produto\n");
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

	// MENU PRATELEIRAS
	public void menuListarPrateleiras() {

		System.out.println("Por favor selecione uma das seguintes opcoes:\n");
		System.out.println("1 - Criar nova prateleira.");
		System.out.println("2 - Editar uma prateleira existente.");
		System.out.println("3 - Consultar o detalhe de uma prateleira.");
		System.out.println("4 - Remover uma prateleira.");
		System.out.println("5 - Voltar ao ecra anterior.");
		setScreenOption();
		switch (this.screenOption) {
		case '1':
			adicionarPrateleiras();
			menuListarPrateleiras();
			break;
		case '2':
			modificarPrateleiras();
			menuListarPrateleiras();
			break;
		case '3':
			consultarPrateleira();
			menuListarPrateleiras();
			break;
		case '4':
			eliminarPrateleira();
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

	// ADICIONAR PRATELEIRAS
	public void adicionarPrateleiras() {

		System.out.println("Criar Nova  Prateleira\n");
		System.out.println("1- Capacidade da Prateleira.");
		int capacidade = sc.nextInt();
		System.out.println("2 - Produto que Alberga.");
		int produtoNaPrateleira = sc.nextInt();
		System.out.println("3 - Preco de aluguer de localizacao diario)");
		int aluguer = sc.nextInt();
		System.out.println("Dados da Prateleira:\t capacidade:" + capacidade + ", Produto:" + produtoNaPrateleira
				+ ", aluguer:" + aluguer + ";");
		Shelf shelf = new Shelf(capacidade, produtoNaPrateleira, aluguer);
		repositorioDeShelfs.save(shelf);
		System.out.println(repositorioDeShelfs.getAll());

	}

	// MODFICAR PRATELEIRAS
	public void modificarPrateleiras() {

		System.out.println("Digite o id da prateleira a alterar");
		Long id = sc.nextLong();
		System.out.println(repositorioDeShelfs.findById(id));

		// CAPACIDADE DA PRATELEIRA
		System.out.println("\n 1 - Capacidade da Prateleira.");
		System.out.println(repositorioDeShelfs.findById((long) id).getProductInShelf());
		sc.nextLine();
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		String capacidadeCheck = sc.nextLine();
		if (capacidadeCheck.equals("")) {
			System.out.println("...O valor ficou o mesmo...");
		} else {
			int capacidade = Integer.parseInt(capacidadeCheck);
			repositorioDeShelfs.findById((long) id).setCapacity(capacidade);
		}

		// PRODUTO
		System.out.println("2 - Produto que Alberga.");
		System.out.println(repositorioDeShelfs.findById((long) id).getProductInShelf());

		System.out.println("introduza o valor novo ou pressiona enter para eliminar a referencia do produto");
		String produtoCheck = sc.nextLine();
		if (produtoCheck.equals("")) {
			int a = -1;
			repositorioDeShelfs.findById((long) id).setProductInShelf(a);
		} else {
			int produto = Integer.parseInt(produtoCheck);
			repositorioDeShelfs.findById((long) id).setProductInShelf(produto);
		}

		// ALUGUER
		System.out.println("3 - Aluguer");
		System.out.println(repositorioDeShelfs.findById((long) id).getDailyRentPrice());
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		String AluguerCheck = sc.nextLine();
		if (AluguerCheck.equals("")) {
			System.out.println("...O valor ficou o mesmo...");
		} else {
			int aluguer = Integer.parseInt(AluguerCheck);
			repositorioDeShelfs.findById((long) id).setDailyRentPrice(aluguer);
		}

	}

	// CONSULTAR PRATELEIRAS
	public void consultarPrateleira() {
		System.out.println("Digite o id da prateleira a consultar:");
		int id = sc.nextInt();
		System.out.println(repositorioDeShelfs.findById((long) id));

	}

	// ELIMINAR PRATELEIRAS
	public void eliminarPrateleira() {

		System.out.println("Digite o id da prateleira a eliminar");
		int id = sc.nextInt();
		System.out.println("Confirma a prateleira a eliminar, S/N");
		char eliminar = sc.next().charAt(0);
		if (eliminar == 's' || eliminar == 'S') {
			repositorioDeShelfs.removeById((long) id);
			System.out.println(repositorioDeShelfs.getAll());
		} else {
			System.out.println("Nao eliminada");
		}
	}

}
