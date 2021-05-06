package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Main {

	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();
	private static ArrayList<Modelo> modelo;
	private static Carro[] vagas = new Carro[100];

	public static void main(String[] args) {
		// -> Variáveis
		int opcao, opcaoMarca;
		Scanner teclado = new Scanner(System.in);

		// -> dummy data marcas
		final Marca m1 = new Marca("renault");
		final Marca m2 = new Marca("bmw");
		final Marca m3 = new Marca("mercedes");
		final Marca m4 = new Marca("audi");

		final Carro c1 = new Carro("AAAA-888");
		final Carro c2 = new Carro("AAAA-777");
		final Carro c3 = new Carro("AAAA-666");
		final Carro c4 = new Carro("AAAA-555");

		m1.adicionarModelo("sandero");
		m1.adicionarModelo("duster");
		m2.adicionarModelo("I8");
		m3.adicionarModelo("Classe GLE");
		m3.adicionarModelo("Classe A");
		m3.adicionarModelo("Classe CLA");

		marcas.add(m1);
		marcas.add(m2);
		marcas.add(m3);
		marcas.add(m4);

		// -> Menu
		do {
			System.out.println("\n=-=-= Menu de opcoes =-=-=\n");
			System.out.println(" 1 - Cadastrar Entrada do Carro");
			System.out.println(" 2 - Efetuar Saída do Carro");
			System.out.println(" 3 - Listar Marcas");
			System.out.println(" 4 - Listar Modelos");
			System.out.println(" 5 - Cadastrar marca");
			System.out.println(" 6 - Cadastrar modelo");
			System.out.println(" 7 - Relatório gerencial");
			System.out.println(" 0 - Sair do Programa");
			System.out.print(" >> ");
			opcao = teclado.nextInt();
			System.out.print("\n");

			switch (opcao) {
				case 1:
					entradaCarro();
					break;
				case 2:
					saidaCarro();
					break;
				case 3:
					System.out.println();
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					System.out.println("Há " + marcas.size() + " marca(s), estão são:");

					for (int i = 0; i < marcas.size(); i++) {
						System.out.println(i + " -> " + marcas.get(i).getNome());
					}
					System.out.println();
					break;
				case 4:
					System.out.println();
					System.out.println("Qual é a marca do seu carro? (digite o número)");
					for (int i = 0; i < marcas.size(); i++) {
						System.out.println(i + " -> " + marcas.get(i).getNome());
					}
					System.out.print(">> ");
					opcaoMarca = teclado.nextInt();
					System.out.print("\n");
					modelo = marcas.get(opcaoMarca).getModelo();
					System.out.println();
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					System.out.println("O(s) modelo(s) dentro dessa marca são:");
					for (int i = 0; i < modelo.size(); i++) {
						System.out.println(i + " -> " + modelo.get(i).getNome());
					}
					break;
				case 5:
					cadastrarMarca();
					break;
				case 6:
					cadastrarModelo();
					break;
				case 7:
					System.out.println("FALTA FAZER - Opção 5 escolhida");
					break;
				case 0:
					System.exit(0);
			}
		} while (opcao != 0);

		teclado.close();
	}

	private static void entradaCarro() {
		int opcaoMarca, opcaoNewModelo;
		String newModelo;
		Scanner teclado = new Scanner(System.in);

		System.out.println();
		System.out.println("Qual é a marca do seu carro? (digite o número)");
		System.out.print(">> ");
		opcaoMarca = teclado.nextInt();
		Marca opcao = marcas.get(opcaoMarca);
		System.out.print("\n");
		System.out.println("A marca que você escolheu é " + marcas.get(opcaoMarca).getNome());

		modelo = marcas.get(opcaoMarca).getModelo();
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("O(s) modelo(s) dentro dessa marca são:");

		for (int i = 0; i < modelo.size(); i++) {
			System.out.println(i + " -> " + modelo.get(i).getNome());
		}

		System.out.println();
		System.out.println("Você deseja incluir um novo modelo para esta marca?");
		System.out.println("Digite (1) para sim");
		System.out.println("Digite (2) para não");
		System.out.print(">> ");
		opcaoNewModelo = teclado.nextInt();
		System.out.print("\n");

		teclado.nextLine();
		switch (opcaoNewModelo) {
			case 1:
				System.out.println("Então digite o nome do modelo");
				System.out.print(">> ");
				newModelo = teclado.nextLine();
				System.out.print("\n");
				System.out.println("Você digitou " + newModelo + " como novo modelo");
				opcao.adicionarModelo(newModelo);
				break;
			case 2:
				System.out.println();
				System.out.println("Então escolha o modelo dentro dos existentes");
				for (int i = 0; i < modelo.size(); i++) {
					System.out.println(i + " -> " + modelo.get(i).getNome());
				}
				System.out.print(">> ");
				int escolhaModelo = teclado.nextInt();
				System.out.print("\n");
				System.out.println("Você escolheu o modelo " + modelo.get(escolhaModelo).getNome());
		}
		//TODO FAZER CADASTRO DO HORARIO DA ENTRADA DO CARRO
	}

	private static float saidaCarro() {
		float preco = 0;
		//TODO FAZER CADASTRO DO HORARIO DA SAIDA DO CARRO
		return preco;
	}

	private static void cadastrarMarca() {
		Scanner teclado = new Scanner(System.in);
		String marca;
		Marca m5;

		System.out.println();
		System.out.println("=-=-=-= Cadastrar Marca =-=-=-=");
		System.out.println("Marca: ");
		System.out.print(">> ");
		marca = teclado.nextLine();
		System.out.print("\n");
		m5 = new Marca(marca);
		marcas.add(m5);
		System.out.print("A marca " + marca + " foi adicionada com sucesso");
	}

	private static void cadastrarModelo() {
		Scanner teclado = new Scanner(System.in);
		String newModelo;
		int marcaEscolhida;

		System.out.println();
		System.out.println("=-=-=-= LISTA DE MARCAS =-=-=-=");
		for (int i = 0; i < marcas.size(); i++) {
			System.out.println(i + " -> " + marcas.get(i).getNome());
		}
		System.out.println("Em qual das marcas você quer cadastrar o modelo?");
		System.out.print(">> ");
		marcaEscolhida = teclado.nextInt();

		teclado.nextLine();
		System.out.println();
		System.out.println("=-=-=-= Cadastrar Modelo =-=-=-=");
		System.out.println("Modelo: ");
		System.out.print(">> ");
		newModelo = teclado.nextLine();
		Marca opcao = marcas.get(marcaEscolhida);
		opcao.adicionarModelo(newModelo);
		System.out.print("O modelo " + newModelo + " foi adicionada com sucesso");

		// TODO COMO FAZER PRO MODELO ENTRAR EM UMA MARCA...
	}
}
