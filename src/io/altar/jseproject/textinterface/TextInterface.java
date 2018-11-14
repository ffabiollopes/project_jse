package io.altar.jseproject.textinterface;

import java.util.Scanner;


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

		System.out.println("Por favor selecione uma das seguintes opções p:");
		System.out.println("1 - Criar Novo produto.");
		System.out.println("2 - Editar um produto existente.");
		System.out.println("3 - Consultar o detalhe de um produto.");
		System.out.println("4 - Remover um produto.");
		System.out.println("5 - Voltar ao ecrã anterior.");
		setScreenOption();
		switch (this.screenOption) {
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

	public void menuListarPrateleiras() {

		System.out.println("Por favor selecione uma das seguintes opções a:");
		System.out.println("1 - Criar Novo produto.");
		System.out.println("2 - Editar um produto existente.");
		System.out.println("3 - Consultar o detalhe de um produto.");
		System.out.println("4 - Remover um produto.");
		System.out.println("5 - Voltar ao ecrã anterior.");
		setScreenOption();
		switch (this.screenOption) {
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