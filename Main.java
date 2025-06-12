import java.util.*;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Gernciador gerencia = new Gernciador();
		NumeroPessoas numP = new NumeroPessoas();
		System.out.println("---- Qual ação deseja realizar ? ----");
		int selecao = 0 ;
		 while(selecao != 7 ) {
			 System.out.println("1 - Cadastrar Participantes "+"\n" +
						"2 - Cadastrar Jogo " + "\n" +
						"3 - Cadastrar Local " + "\n" +
						"4 - Editar/Excluir Participantes" + "\n"+
						"5 - Editar/Excluir Jogo "+ "\n" +
						"6 - Dados armazenados " + "\n" +
						"7 - Sair ");
			selecao = entrada.nextInt();
			entrada.nextLine();
			switch (selecao) {
			case 1:
				System.out.println("Quantos Particpantes havera no total?");
				int ParticipantesTotal = entrada.nextInt();
				numP.setNumerototal(ParticipantesTotal);
				numP.setTotalBruto(ParticipantesTotal);
				entrada.nextLine();
				for(int i = 0 ; i < ParticipantesTotal ; i ++) {
							int NummeroP = i + 1 ;
							System.out.println("Digite o nome da " + NummeroP + " pessoa : ");
							String NomeP = entrada.nextLine();
							System.out.println("Digite a idade da " + NummeroP + " pessoa :");
							int idade = entrada.nextInt();
							entrada.nextLine();
							 if(idade> 0 ) {
								 Participantes pessoa = new Participantes(NomeP, NummeroP, idade);
								 gerencia.adicionarParticipante(pessoa);
							 } else {
								 System.out.println("Essa idade é invalida");
		
							 }
							 
				}
				 break;
			case 2 :
					System.out.println("Quanto Jogos deseja adicioar? no maximo 5");
					int verifica = entrada.nextInt();
					entrada.nextLine();
					if(verifica > 0 && verifica <= 5) {
						for( int i = 0 ; i < verifica ; i ++ ) {
							int n = i + 1 ;
							System.out.println("Qual o nome do "+ n + " Desafio?");
							String NomeD = entrada.nextLine();	
						   float ParticipanteM = numP.getNumerototal();
						   System.out.println("--Selecione como sera dividido--"  + "\n 1- Metade " +  "\n 2- 1/4" +  "\n 3- 1/6");
						   int eliminados = entrada.nextInt();
						   float Sobra = SobraParticipantes(ParticipanteM, eliminados);
						   numP.setNumerototal(Sobra);
							System.out.println("Escreva a quantidade de regras que ira ter esse desafio :");
							int Nregras = entrada.nextInt();
							entrada.nextLine();
							ArrayList<String> regras = new ArrayList<>();
							for(int a = 0 ; a < Nregras; a++) {
								int conta = a + 1 ; 
								System.out.print("Escreva a " + conta +"º  Regra -->" );
								regras.add(entrada.nextLine());
							}
							gerencia.listarLocais();
							System.out.println("Escolha o nome do local da prova");
							String LocalNome = entrada.nextLine();
							Local localselecionado = gerencia.buscarLocalPorNome(LocalNome);
							
							if(localselecionado != null) {
								if(localselecionado.getCapacidade() >= ParticipanteM) {
								Desafio desafio = new Desafio(NomeD, regras, localselecionado);
								gerencia.adicionarDesafio(desafio);	
								}else {
								System.out.println("Local não suporta o numero Max de participantes");
								}
							}else {
								System.out.println("Local não encontrado");
								
							}
							}
						
					} else {
						System.out.println("Adicione até 5 jogos");
					}

							
				break;
			case 3 :
					System.out.println("Nome do Local :");
					String nomeLocal = entrada.nextLine();
					System.out.println("Qual a capacidade desse Local? ");
					int Capacidade = entrada.nextInt();
					entrada.nextLine();
					Local local = new Local(nomeLocal, Capacidade);
					gerencia.adicionarLocal(local);
				break;
			case 4 : 
					System.out.println("Qual ação deseja realizar excluir ou editar um Participante? Escreva excluir para excluir e editar para editar");
					String escolha = entrada.nextLine();
					if(escolha.equalsIgnoreCase("editar")) {
						System.out.println("Nome do participante que deseja editar?");
						String nomeAntingo = entrada.nextLine();
						System.out.print("Nome do novo participante : ");
						String nomeNovo = entrada.nextLine();
						System.out.print("Coloque a idade desse novo participante :");
						int idadeNova = entrada.nextInt();
						entrada.nextLine();
						gerencia.editarParticipantes(nomeAntingo, nomeNovo, idadeNova);
					}else if(escolha.equalsIgnoreCase("excluir")) {
						System.out.println("Qual o nome do Participante que deseja Excluir?");
						String excluir = entrada.nextLine();
						gerencia.removerParticipante(excluir);
					}
				break;
			case 5 :
				System.out.println("Qual ação deseja realizar excluir ou editar um Desafio? Escreva excluir para excluir e editar para editar");
				String escolhaa = entrada.nextLine();
					if(escolhaa.equalsIgnoreCase("editar")) {
						System.out.println("Nome do Jogo que deseja editar :");
						String nomeDesafioAntigo = entrada.nextLine();
						System.out.println("Qual sera o novo nome do Desafio?");
						String novoNomeDesafio = entrada.nextLine();
						System.out.println("Qual seria a nova quantidade de regras?");
						int regrasQuantidade = entrada.nextInt();
						entrada.nextLine();
						ArrayList<String> novasRegras = new ArrayList<String>();
						for(int i = 0 ; i < regrasQuantidade; i ++) {
							int conta = i + 1;
							System.out.print("Escreva a " + conta +"º  Regra -->" );
							novasRegras.add(entrada.nextLine());
						}
						gerencia.listarLocais();
						System.out.println("Escolha o Local para esse desafio");
						String novoLocal = entrada.nextLine();
						Local novoLocalnome = gerencia.buscarLocalPorNome(novoLocal);
						if(novoLocal != null ) {
							gerencia.edicaoDesafio(nomeDesafioAntigo, novoNomeDesafio, novasRegras, novoLocalnome);
						}else {
							System.out.println("Não existe esse Local");
						}
					}else if(escolhaa.equalsIgnoreCase("excluir")) {
						System.out.println("Qual o nome do Jogo que deseja Excluir?");
						String Jexcluir = entrada.nextLine();
						gerencia.removerDesafio(Jexcluir);				
					}
				break;
			case 6:
				System.out.println("\n--- Participantes ---");
				gerencia.listarParticipantes();
				System.out.println("\n --- Locais ---");
				gerencia.listarLocais();
				System.out.println("\n --- Desafios ---");
				gerencia.listarDesafios();
				System.out.println("\n --- Quantidade de pessoas que sobram apos os desafios ---");
				System.out.println("de  "+ numP.getTotalBruto() + "sobrou " + numP.getNumerototal());
				break;
				
			case 7:
				break;
				
			default:
				System.out.println("Não tem essa opção no painel");
		}

		}
		 System.out.println("Programa Fechado");
		 entrada.close();
}
		

	public static float SobraParticipantes(float p , int x) {
		float NumeroR = 0;
		switch (x) {
		case 1:
			NumeroR = p / 2;

			break;
		case 2:
			NumeroR = p / 4;

			break;
		case 3:
			NumeroR = p / 6;

			break;
		default:
			System.out.println("Não temos essa opção ");
		}
		return (NumeroR);
		
	}
	
	}



