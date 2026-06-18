package sistema_agenda;

public class Arvore {
	private Contato raiz;
	private Integer contador = 0;

	public Arvore() {
		this.raiz = null;
	}

	public Arvore(Contato raiz) {
		this.raiz = raiz;
	}

	public Contato getRaiz() {
		return raiz;
	}

	public void setRaiz(Contato raiz) {
		this.raiz = raiz;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	private boolean estaVazia() {
		return this.raiz == null;
	}

	private Integer comparacao(Contato nome, Contato raiz) {
		return nome.getNome().compareToIgnoreCase(raiz.getNome());
	}

	public void inserir(Contato raiz, Contato novo) {
		if (estaVazia()) {
			this.raiz = novo;
			return;
		}
		if (comparacao(novo, raiz) <= 0) {
			if (raiz.getEsquerda() == null) {
				raiz.setEsquerda(novo);
			} else {
				inserir(raiz.getEsquerda(), novo);
			}
		} else {
			if (raiz.getDireita() == null) {
				raiz.setDireita(novo);
			} else {
				inserir(raiz.getDireita(), novo);
			}
		}

	}

	public Contato buscar(Contato raiz, String nome) {
		if (estaVazia() || raiz == null) {
			return null;
		}
		if (nome.compareToIgnoreCase(raiz.getNome()) == 0) {
			return raiz;
		} else if (nome.compareToIgnoreCase(raiz.getNome()) <= 0) {
			return buscar(raiz.getEsquerda(), nome);
		} else {
			return buscar(raiz.getDireita(), nome);
		}
	}

	public Contato excluir(Contato raiz, String nome) {
		if (estaVazia() || raiz == null) {
			return null;
		}

		if (nome.compareToIgnoreCase(raiz.getNome()) < 0) {
			raiz.setEsquerda(excluir(raiz.getEsquerda(), nome));
		} else if (nome.compareToIgnoreCase(raiz.getNome()) > 0) {
			raiz.setDireita(excluir(raiz.getDireita(), nome));
		} else {
			if (raiz.getEsquerda() == null) {
				return raiz.getDireita();
			} else if (raiz.getDireita() == null) {
				return raiz.getEsquerda();
			}

			Contato substituto = menorSubstituto(raiz.getDireita());

			raiz.setNome(substituto.getNome());
			raiz.setTelefone(substituto.getTelefone());
			raiz.setEmail(substituto.getEmail());
			raiz.setCidade(substituto.getCidade());

			raiz.setDireita(excluir(raiz.getDireita(), substituto.getNome()));
		}
		return raiz;
	}

	private Contato menorSubstituto(Contato contato) {
		if (contato.getEsquerda() == null) {
			return contato;
		} else {
			return menorSubstituto(contato.getEsquerda());
		}
	}

	public void ordemAlfabetica(Contato raiz) {
		if (raiz == null) {
			return;
		} else {
			ordemAlfabetica(raiz.getEsquerda());
			System.out.println("-> " + raiz.toString());
			ordemAlfabetica(raiz.getDireita());
		}
	}

	public void preOrdem(Contato raiz) {
		if (raiz == null) {
			return;
		} else {
			System.out.print("-> " + raiz.toString());
			preOrdem(raiz.getEsquerda());
			preOrdem(raiz.getDireita());
		}
	}

	public void posOrdem(Contato raiz) {
		if (raiz == null) {
			return;
		} else {
			posOrdem(raiz.getEsquerda());
			posOrdem(raiz.getDireita());
			System.out.print("-> " + raiz.toString());
		}
	}

	public void mostrarMenorContato(Contato raiz) {
		if (estaVazia()) {
			System.out.println("Lista vazia");
			return;
		}
		if (raiz.getEsquerda() == null) {
			System.out.println(raiz.toString());
			return;
		} else {
			mostrarMenorContato(raiz.getEsquerda());
		}
	}

	public void mostrarMaiorContato(Contato raiz) {
		if (estaVazia()) {
			System.out.println("Lista vazia");
			return;
		}
		if (raiz.getDireita() == null) {
			System.out.println(raiz.toString());
			return;
		} else {
			mostrarMaiorContato(raiz.getDireita());
		}
	}

	public Integer quantidadeContatos(Contato raiz) {
		if (estaVazia()) {
			return contador;
		}
		if (raiz == null) {
			return 0;
		}
		return 1 + quantidadeContatos(raiz.getEsquerda()) + quantidadeContatos(raiz.getDireita());
	}

	public Integer alturaArvore(Contato raiz) {
		if (estaVazia()) {
			return contador;
		}
		if (raiz.getDireita() != null && raiz.getEsquerda() != null) {
			int alturaDireita = alturaArvore(raiz.getDireita());
			int alturaEsquerda = alturaArvore(raiz.getEsquerda());
			if (alturaDireita > alturaEsquerda) {
				return 1 + alturaDireita;
			} else {
				return 1 + alturaEsquerda;
			}
		} else if (raiz.getDireita() != null && raiz.getEsquerda() == null) {
			return 1 + alturaArvore(raiz.getDireita());
		} else if (raiz.getDireita() == null && raiz.getEsquerda() != null) {
			return 1 + alturaArvore(raiz.getEsquerda());
		} else {
			return 1;
		}
	}
}
