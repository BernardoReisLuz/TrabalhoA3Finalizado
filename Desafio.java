import java.util.ArrayList;


public class Desafio {
	private String nome ;
	private ArrayList<String> regras;
	private Local local;
	
		
	public Desafio(String nome , ArrayList<String> regras , Local local) {
	this.nome = nome ;
	this.regras = regras;
	this.local = local;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getRegras() {
		return regras;
	}
	public void setRegras(ArrayList<String> regras) {
		this.regras = regras;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public String toString() {
        return "Desafio: " + nome + 
               "\nRegras: " + regras + 
               "\nLocal: " + local.getNome();

	}
	
	}



