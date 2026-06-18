package sistema_agenda;

import java.util.Scanner;

public class Servicos {

	public Servicos() {

	}

	private Scanner scan = new Scanner(System.in);
	private Arvore arvore = new Arvore();

	public void menuPrincipal() {
		int opcao;

		do {
			System.out.println("\n===== AGENDA DE CONTATOS =====");
			System.out.println("1 - Inserir contato");
			System.out.println("2 - Buscar contato");
			System.out.println("3 - Excluir contato");
			System.out.println("4 - Lista de contatos em ordem alfabetica");
			System.out.println("5 - Lista de contatos em pre-ordem");
			System.out.println("6 - Lista de contatos em pos-ordem");
			System.out.println("7 - Mostrar menor contato (alfabeticamente)");
			System.out.println("8 - Mostrar maior contato (alfabeticamente)");
			System.out.println("9 - Quantidade de contatos");
			System.out.println("10 - Altura da arvore");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opcao: ");

			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				menuInserir();
				break;
			case 2:
				menuBuscar();
				break;
			case 3:
				menuExcluir();
				break;
			case 4:
				menuOrdemAlfabetica();
				break;
			case 5:
				menuPreOrdem();
				break;
			case 6:
				menuPosOrdem();
				break;
			case 7:
				menuMenorContato();
				break;
			case 8:
				menuMaiorContato();
				break;
			case 9:
				menuQuantidadeContatos();
				break;
			case 10:
				menuAlturaArvore();
				break;
			case 0:
				System.out.println("Fim do sistema");
				break;
			default:
				System.out.println("Opcao invalida! Tente novamente.");
			}

		} while (opcao != 0);

		scan.close();
	}

	public void menuInserir() {
		System.out.println("\n--- Inserir novo contato ---");

		System.out.print("Nome: ");
		String nome = scan.nextLine();

		System.out.print("Telefone: ");
		String telefone = scan.nextLine();

		System.out.print("Email: ");
		String email = scan.nextLine();

		System.out.print("Cidade: ");
		String cidade = scan.nextLine();

		Contato novoContato = new Contato(nome, telefone, email, cidade);

		arvore.inserir(arvore.getRaiz(), novoContato);

		System.out.println("Contato inserido!");
		arvore.toString();
	}

	public void menuBuscar() {
		System.out.println("\n--- Buscar contato ---");
		System.out.print("Digite o nome a ser buscado: ");
		String nome = scan.nextLine();

		Contato encontrado = arvore.buscar(arvore.getRaiz(), nome);

		if (encontrado != null) {
			System.out.println("Contato encontrado:");
			System.out.println(encontrado.toString());
		} else {
			System.out.println("Contato nao encontrado.");
		}
	}

	public void menuExcluir() {
		System.out.println("\n--- Excluir contato ---");
		System.out.print("Digite o nome a ser excluido: ");
		String nome = scan.nextLine();

		Contato encontrado = arvore.buscar(arvore.getRaiz(), nome);

		if (encontrado == null) {
			System.out.println("Contato nao encontrado. Nada foi excluido.");
			return;
		}

		Contato novaRaiz = arvore.excluir(arvore.getRaiz(), nome);
		arvore.setRaiz(novaRaiz);
		arvore.setContador(arvore.getContador() - 1);

		System.out.println("Contato excluido com sucesso!");
	}

	public void menuOrdemAlfabetica() {
		System.out.println("\n--- Contatos em ordem alfabetica ---");
		if (arvore.getRaiz() == null) {
			System.out.println("A agenda esta vazia.");
			return;
		}
		arvore.ordemAlfabetica(arvore.getRaiz());
		System.out.println();
	}

	public void menuPreOrdem() {
		System.out.println("\n--- Contatos em pre-ordem ---");
		if (arvore.getRaiz() == null) {
			System.out.println("A agenda esta vazia.");
			return;
		}
		arvore.preOrdem(arvore.getRaiz());
		System.out.println();
	}

	public void menuPosOrdem() {
		System.out.println("\n--- Contatos em pos-ordem ---");
		if (arvore.getRaiz() == null) {
			System.out.println("A agenda esta vazia.");
			return;
		}
		arvore.posOrdem(arvore.getRaiz());
		System.out.println();
	}

	public void menuMenorContato() {
		System.out.println("\n--- Menor contato (ordem alfabetica) ---");
		arvore.mostrarMenorContato(arvore.getRaiz());
	}

	public void menuMaiorContato() {
		System.out.println("\n--- Maior contato (ordem alfabetica) ---");
		arvore.mostrarMaiorContato(arvore.getRaiz());
	}

	public void menuQuantidadeContatos() {
		System.out.println("\n--- Quantidade de contatos ---");
		System.out.println("Total de contatos: " + arvore.quantidadeContatos(arvore.getRaiz()));
	}

	public void menuAlturaArvore() {
		System.out.println("\n--- Altura da arvore ---");
		System.out.println("Altura: " + arvore.alturaArvore(arvore.getRaiz()));
	}

	private int lerInteiro() {
		while (!scan.hasNextInt()) {
			System.out.print("Entrada invalida. Digite um numero: ");
			scan.next();
		}
		int valor = scan.nextInt();
		scan.nextLine();
		return valor;
	}
}
