package Principal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

		// -> dummy data modelo
		final Modelo mod1 = new Modelo("sandero");
		final Modelo mod2 = new Modelo("duster");
		final Modelo mod3 = new Modelo("I8");
		final Modelo mod4 = new Modelo("CLASSE A");
		final Modelo mod5 = new Modelo("CLASSE GLE");
		final Modelo mod6 = new Modelo("tt");

		// -> dummy data marca
		final Marca m1 = new Marca("renault");
		final Marca m2 = new Marca("bmw");
		final Marca m3 = new Marca("mercedes");
		final Marca m4 = new Marca("audi");

		// -> dummy data carro
		final Carro c1 = new Carro("AAAA-888", mod1);
		final Carro c2 = new Carro("AAAA-777", mod2);
		final Carro c3 = new Carro("AAAA-666", mod3);
		final Carro c4 = new Carro("AAAA-555", mod4);

		// -> dummy data vagas
		vagas[0] = c1;
		vagas[1] = c2;
		vagas[2] = c3;
		vagas[3] = c4;

		// -> dummy data - adicionar modelo (mod) na marca
		m1.adicionarModelo(mod1.getNome());
		m1.adicionarModelo(mod2.getNome());
		m2.adicionarModelo(mod3.getNome());
		m3.adicionarModelo(mod4.getNome());
		m3.adicionarModelo(mod5.getNome());
		m4.adicionarModelo(mod6.getNome());

		// -> dummy data - adicionar modelo (mod) na marca
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
					relatorioGerencial();
					break;
				case 0:
					System.exit(0);
				default:
					break;
			}
		} while (opcao != 0);

		teclado.close();
	}

	private static void entradaCarro() {
		Carro novoCarro = new Carro("0000");
		int opcaoMarca, opcaoNewModelo;
		String newModelo;
		Scanner teclado = new Scanner(System.in);
		int y = 0;
		int t = vagas.length;

		for (Carro c : vagas) {
			if (c != null) {
				y++;
			}
		}
		int total = t - y;

		System.out.println();
		System.out.println("Número de vagas ocupadas: " + y);
		System.out.println("Número de vagas disponíveis: " + total);

		System.out.println();
		System.out.println("Qual é a placa do seu carro? (digite neste padrão ZZZZ-999)");
		System.out.print(">> ");
		String placaCarro = teclado.nextLine();
		System.out.println("Placa digitada: " + placaCarro);
		novoCarro.setPlaca(placaCarro);

		System.out.println();
		System.out.println("Qual é a marca do seu carro? (digite o número)");
		for (int i = 0; i < marcas.size(); i++) {
			System.out.println(i + " -> " + marcas.get(i).getNome());
		}
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
				novoCarro.setModelo(new Modelo(newModelo));
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
				novoCarro.setModelo(modelo.get(escolhaModelo));
			default:
				break;
		}

		System.out.println();
		System.out.println("Qual horário da entrada do carro: ");
		System.out.println("(1) Entrada agora                 ");
		System.out.println("(2) Setar tempo de entrada        ");
		System.out.print(">> ");
		int tipoEntrada = teclado.nextInt();
		System.out.println();

		switch (tipoEntrada) {
			case 1:
				System.out.println();
				System.out.println("A entrada do carro foi: "
						+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
				novoCarro.setHoraEntrada(LocalDateTime.now());
				break;
			case 2:
				System.out.println("Forneça o dia da entrada: (exemplo 01...31)");
				System.out.print(">> ");
				int entradaDia = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça o mês da entrada: (exemplo 01...12)");
				System.out.print(">> ");
				int entradaMes = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça o ano da entrada: (exemplo 2000...2021)");
				System.out.print(">> ");
				int entradaAno = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça a hora da entrada: (exemplo 00...23)");
				System.out.print(">> ");
				int entradaHora = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça o minuto da entrada: (exemplo 00...60)");
				System.out.print(">> ");
				int entradaMinuto = teclado.nextInt();
				System.out.println();
				System.out.println(
						entradaDia + "/" + entradaMes + "/" + entradaAno + " - " + entradaHora + ":" + entradaMinuto);
				novoCarro.setHoraEntrada(
						LocalDateTime.of(entradaAno, entradaMes, entradaDia, entradaHora, entradaMinuto));
				break;
			default:
				break;
		}
		int lastVaga = 0;
		for (Carro c : vagas) {
			if (c != null) {
				lastVaga++;
			}
		}
		vagas[lastVaga] = novoCarro;
	}

	private static float saidaCarro() {
		Scanner teclado = new Scanner(System.in);
		float preco = 0;

		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null) {
				System.out.println("(" + i + ") " + vagas[i].getPlaca() + " - " + vagas[i].getModelo().getNome());
			}
		}
		System.out.println();
		System.out.println("Escolha qual carro você deseja retirar: (escolha pelo número)");
		System.out.print(">> ");
		int numRetirada = teclado.nextInt();
		System.out.println();
		
		System.out.println();
		System.out.println("Qual horário da saída do carro:  ");
		System.out.println("(1) Saída agora                  ");
		System.out.println("(2) Setar tempo de saída         ");
		System.out.print(">> ");
		int tipoSaida = teclado.nextInt();
		System.out.println();

		switch (tipoSaida) {
			case 1:
				System.out.println();
				LocalDateTime saida = LocalDateTime.now();
				System.out.println("A saida do carro foi: " + saida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
				vagas[numRetirada].setHoraSaida(saida);
				System.out.println("Valor a ser pago: " + vagas[numRetirada].saidaCarro());
				historico.add(vagas[numRetirada]);
				vagas[numRetirada] = null;
				break;
			case 2:
				System.out.println("Forneça o dia da saida: (exemplo 01...31)");
				System.out.print(">> ");
				int saidaDia = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça o mês da saida: (exemplo 01...12)");
				System.out.print(">> ");
				int saidaMes = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça o ano da saida: (exemplo 2000...2021)");
				System.out.print(">> ");
				int saidaAno = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça a hora da saida: (exemplo 00...23)");
				System.out.print(">> ");
				int saidaHora = teclado.nextInt();
				System.out.println();
				System.out.println("Forneça o minuto da saida: (exemplo 00...60)");
				System.out.print(">> ");
				int saidaMinuto = teclado.nextInt();
				System.out.println();
				System.out.println(saidaDia + "/" + saidaMes + "/" + saidaAno + " - " + saidaHora + ":" + saidaMinuto);
				vagas[numRetirada].set2HoraSaida(saidaDia, saidaMes, saidaAno, saidaHora, saidaMinuto);
				System.out.println("Valor a ser pago: " + vagas[numRetirada].saidaCarro());
				historico.add(vagas[numRetirada]);
				vagas[numRetirada] = null;
				break;
			default:
				break;
		}

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
	}

	private static void relatorioGerencial() {
		Scanner teclado = new Scanner(System.in);
		String dataSelecionada, dataSaida;

		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("              RELATÓRIO GERENCIAL               ");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		System.out.println("Data: (utilize o formato dd/MM/aaaa)");
		System.out.print(">> ");
		dataSelecionada = teclado.nextLine();

		for (Carro c : historico) {
			dataSaida = c.getHoraSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			if (dataSelecionada.equals(dataSaida)) {
				System.out.println();
				System.out.println("Placa: " + c.getPlaca());
				for (Marca marca : marcas) {
					for (Modelo modelo : marca.getModelo()) {
						if (c.getModelo().getNome().equals(modelo.getNome())) {
							System.out.println("Marca: " + marca.getNome() + " - " + "Modelo: " + modelo.getNome());
						}
					}
				}
				System.out.println("Data de entrada: " + c.getHoraEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
				System.out.println("Data de saída: " + c.getHoraSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
				System.out.println("Valor pago: " + c.getValor());
			}
		}
	}
}
