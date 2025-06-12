
public class Participantes {
	
	private String nome;
	private int numero;
	private int idade ;
	
	public Participantes(String nome , int numero , int idade ) {
		this.nome = nome;
		this.numero = numero;
		this.idade = idade;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	 public String toString() {
	        return "Nome: " + nome + ", Número: " + numero + ", Idade: " + idade;
	    }
	
	

}
