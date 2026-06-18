package sistema_agenda;

public class Contato {
	private String nome, telefone, email, cidade;
	private Contato esquerda, direita;

	public Contato(String nome, String telefone, String email, String cidade) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cidade = cidade;
		this.esquerda = null;
		this.direita = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Contato getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Contato esquerda) {
		this.esquerda = esquerda;
	}

	public Contato getDireita() {
		return direita;
	}

	public void setDireita(Contato direita) {
		this.direita = direita;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cidade=" + cidade + "]";
	}
}
