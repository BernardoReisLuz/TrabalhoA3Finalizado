import java.util.*;
public class Gernciador {
	ArrayList<Participantes> participantes = new ArrayList<Participantes>();
	ArrayList<Local> locais = new ArrayList<Local>();
	ArrayList<Desafio> desafio = new ArrayList<Desafio>();
	
	public void adicionarParticipante(Participantes pessoa ) {
		participantes.add(pessoa);
	}
	public void removerParticipante(String nome) {
		participantes.removeIf(pessoa -> pessoa.getNome().equalsIgnoreCase(nome));
		
		
	}
	public void listarParticipantes() {
        participantes.forEach(System.out::println);
    }

    // Métodos para Locais
    public void adicionarLocal(Local l) {
        locais.add(l);
    }

    public void listarLocais() {
        locais.forEach(System.out::println);
    }

    public Local buscarLocalPorNome(String nome) {
        for (Local local : locais) {
            if (local.getNome().equalsIgnoreCase(nome)) {
                return local;
            }
        }
        return null;
    }

    // Métodos para Desafios
    public void adicionarDesafio(Desafio desafi) {
            desafio.add(desafi);
        }

    public void removerDesafio(String nome) {
        desafio.removeIf(desaffi -> desaffi.getNome().equalsIgnoreCase(nome));
    }

    public void listarDesafios() {
        desafio.forEach(System.out::println);
    }
    
    public void edicaoDesafio(String nomeDesafio , String novoNome , ArrayList<String> novaRegras , Local novoLocal ) {
    	for(Desafio desaf : desafio) {
    		if(desaf.getNome().equalsIgnoreCase(nomeDesafio)) {
    		desaf.setNome(novoNome);
    		desaf.setRegras(novaRegras);
    		desaf.setLocal(novoLocal);
    		System.out.println("Atualizado do Desafio para um novo. ");
    		return;
    
    	}
    	System.out.println("Não encontramos esse Desafio para editalo.");
    }}
	public void editarParticipantes(String nomeP , String novoNome , int novaidade) {
		for(Participantes participante : participantes) {
			if(participante.getNome().equalsIgnoreCase(nomeP)) {
			participante.setNome(novoNome);
			participante.setIdade(novaidade);
			System.out.println("Atualizado os dados para o novo participante.");
		}
		System.out.println("Não encontramos esse participante para editar.");
	}}
			
    }
	
		
