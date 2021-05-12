package Modelagem;

public class Modelo {

	// -> Inicialização
	private String nome;

	// -> Construtores
	public Modelo() {
		nome = "Sem modelo";
	}

	public Modelo(String nome) {
		this.nome = nome;
	}

	// -> Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Modelo: " + nome;
	}
}
