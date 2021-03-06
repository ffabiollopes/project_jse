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
		System.out.println(repositorioDeProducts.getAll());
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
		List<Shelf> prateleira = new ArrayList<>();
		boolean adicionar = false;
		System.out.println("Deseja adicionar o produto a uma prateira?");
		char colocarEmPrateleira = sc.next().charAt(0);
		if (colocarEmPrateleira == 's' || colocarEmPrateleira == 'S') {
			adicionar = true;
		}
		while (adicionar == true) {
			System.out.println("1 - Prateleira onde quer colocar o produto.");
			Long id = sc.nextLong();
			Shelf sitio = repositorioDeShelfs.findById(id);
			if (sitio == null) {
				System.out.println("Nao existe");
				Shelf shelf = new Shelf(100, 0);
				repositorioDeShelfs.saveMyId(shelf, id);
				sitio = repositorioDeShelfs.findById(id);
				prateleira.add(sitio);
				System.out.println(prateleira);
			} else {
				//mudar a logica
				sitio = repositorioDeShelfs.findById(id);
				prateleira.add(sitio);
			}
			System.out.println("Deseja adicionar o produto a mais prateleiras?");
			char escolha = sc.next().charAt(0);
			if (escolha == 'n' || escolha == 'N') {
				adicionar = false;
			}
		}
		System.out.println("2 - Valor unitario de desconto.");
		int desconto = sc.nextInt();
		System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentagem)");
		int iva = sc.nextInt();
		System.out.println("4 - PVP (Preco de Venda ao Publico)");
		int pvp = sc.nextInt();
		Product produto = new Product(desconto, iva, pvp);
		produto.addShelves(prateleira);
		repositorioDeProducts.save(produto);
		
	}

	// MODFICAR PRODUTOS
	public void alterarProduto() {

		System.out.println("Digite o id do produto a alterar");
		Long id = sc.nextLong();
		System.out.println(repositorioDeProducts.findById(id));
		// Prateleira onde esta o produto.
		// ADICIONAR MAIS, EU POSSO CRER DAR UM ID ESPECIFICO PARA A PRATELEIRA
		System.out.println("\n 1 - Prateleira onde quer colocar o produto.");
		System.out.println(repositorioDeProducts.findById((long) id).getShelves());
		sc.nextLine();
		System.out.println(
				"introduza o valor novo ou pressiona enter para eliminar as prateleiras que albergam o produto");
		String prateleiraCheck = sc.nextLine();
		if (prateleiraCheck.equals("")) {
			List<Shelf> prateleira = new ArrayList<>();
			repositorioDeProducts.findById((long) id).addShelves(prateleira);
		} else {// mudar isto
			Long novaPrateleira = Long.parseLong(prateleiraCheck);
			Shelf temp = repositorioDeShelfs.findById(novaPrateleira);
			List<Shelf> prateleira = new ArrayList<>();
			prateleira.add(temp);
			repositorioDeProducts.findById((long) id).addShelves(prateleira);
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
		System.out.println(repositorioDeShelfs.getAll());
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
		List<Product> produtoList = new ArrayList<>();
		List<Shelf> prateleira = new ArrayList<>();
		System.out.println("Criar Nova  Prateleira\n");
		System.out.println("1- Capacidade da Prateleira.");
		int capacidade = sc.nextInt();
		System.out.println("2 - Produto que Alberga.");
		Long id = sc.nextLong();
		Product produtoParaPrateleira = repositorioDeProducts.findById(id);
		produtoList.add(produtoParaPrateleira);
		System.out.println("3 - Preco de aluguer de localizacao diario)");
		int aluguer = sc.nextInt();
		Shelf shelf = new Shelf(capacidade, aluguer);
		shelf.addProduct(produtoList);
		repositorioDeShelfs.save(shelf);
		prateleira.add(shelf);		
		repositorioDeProducts.findById(id).addShelves(prateleira);
		

	}

	// MODFICAR PRATELEIRAS
	public void modificarPrateleiras() {

		System.out.println("Digite o id da prateleira a alterar");
		Long id = sc.nextLong();
		System.out.println(repositorioDeShelfs.findById(id));

		// CAPACIDADE DA PRATELEIRA
		System.out.println("\n 1 - Capacidade da Prateleira.");
		System.out.println(repositorioDeShelfs.findById((long) id).getProduct());
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
		System.out.println(repositorioDeShelfs.findById((long) id).getProduct());

		System.out.println("introduza o valor novo ou pressiona enter para eliminar a referencia do produto");
		String produtoCheck = sc.nextLine();
		if (produtoCheck.equals("")) {
			List<Product> produtoList = new ArrayList<>();
			repositorioDeShelfs.findById((long) id).addProduct(produtoList);
		} else {
			List<Product> produtoList = new ArrayList<>();
			System.out.println("Novo Produto");
			Long idProduto = sc.nextLong();
			Product produtoParaPrateleira = repositorioDeProducts.findById(idProduto);
			produtoList.add(produtoParaPrateleira);
			repositorioDeShelfs.findById((long) id).addProduct(produtoList);
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
		Long id = sc.nextLong();
		System.out.println(repositorioDeShelfs.findById(id));

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
