package Modelagem;

import java.util.ArrayList;

public class Marca {

	private String nome;
	private ArrayList<Modelo> alModelo;

	// -> Construtores
	public Marca() {
		nome = "Sem marca";
		alModelo = new ArrayList<Modelo>();
	}

	public Marca(String nome) {
		this.nome = nome;
		alModelo = new ArrayList<Modelo>();
	}

	public Marca(String nome, ArrayList<Modelo> modelo) {
		this.nome = nome;
		this.alModelo = modelo;
	}

	// -> Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Modelo> getModelo() {
		return alModelo;
	}

	public void setModelo(ArrayList<Modelo> modelo) {
		this.alModelo = modelo;
	}

	public void adicionarModelo(String nomeModelo) {
		Modelo novoModelo = new Modelo(nomeModelo);
		alModelo.add(novoModelo);
	}
}
