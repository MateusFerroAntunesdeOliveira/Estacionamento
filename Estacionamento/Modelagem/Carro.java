package Modelagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.*;

public class Carro implements Comparable<Carro>{

	// -> Inicialização
	private String placa;
	private float valor;
	private Modelo modelo;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;

	// -> Construtores
	public Carro() {
		super();
		placa = "Sem placa";
		valor = 0;
		modelo = new Modelo();
		horaEntrada = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
		horaSaida = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
	}

	public Carro(String placa) {
		super();
		this.placa = placa;
		valor = 0;
		modelo = new Modelo();
		horaEntrada = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
		horaSaida = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
	}

	public Carro(String placa, float valor) {
		super();
		this.placa = placa;
		this.valor = valor;
		modelo = new Modelo();
		horaEntrada = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
		horaSaida = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
	}

	public Carro(String placa, Modelo modelo) {
		super();
		this.placa = placa;
		valor = 0;
		this.modelo = modelo;
		horaEntrada = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
		horaSaida = LocalDateTime.of(2021, 1, 1, 12, 0, 0);
	}

	public Carro(String placa, float valor, Modelo modelo) {
		super();
		this.placa = placa;
		this.valor = valor;
		this.modelo = modelo;
		horaEntrada = LocalDateTime.now();
	}

	public Carro(String placa, float valor, Modelo modelo, LocalDateTime horaEntrada) {
		super();
		this.placa = placa;
		this.valor = valor;
		this.modelo = modelo;
		this.horaEntrada = LocalDateTime.now();
	}

	public Carro(String placa, Modelo modelo, LocalDateTime horaSaida) {
		super();
		this.placa = placa;
		valor = 0;
		this.modelo = modelo;
		this.horaSaida = LocalDateTime.now();
	}

	// -> Getters e Setters
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public void set2HoraSaida(int dia, int mes, int ano, int hora, int minuto) {
		this.horaSaida = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}

	public float saidaCarro() {
		long duracao = horaEntrada.until(horaSaida, MINUTES);

		if (duracao <= 60) {
			this.valor = 10;
		} else {
			duracao = duracao - 60;
			this.valor = 10 + ((duracao / 15) * 2);
		}
		return valor;
	}

	@Override
	public String toString() {
		return "Placa: " + placa + " \nModelo " + modelo + " \nEntrada no estacionamento: " + horaEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
	}

	@Override
	public int compareTo(Carro compCarro) {
		return this.horaEntrada.compareTo(compCarro.getHoraEntrada());
	}
}
