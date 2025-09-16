package mainProject;


import java.util.Scanner;

public class Teste {
	public static void main (String [] args) {
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		Gestor gestor = new Gestor();
		
		while(true) {
		int opção = gestor.menuRegisto();
		switch(opção) {
		case 1:
			String tipo = gestor.vefTipo();
			String nome = gestor.vefNome();
			String email = gestor.vefEmail();
			String data = gestor.vefDataNascimento();
			String localidade = gestor.vefLocalidade();
			String password = gestor.vefPassword();
			if (tipo.equals("Agricultor")) {
				String descrição = gestor.vefDescrição();
				gestor.registarAgricultor(nome,email,data,descrição,password,localidade);
			}
			else {
				String consumidor = gestor.vefConsumidor();
				gestor.registarConsumidor(nome, email, data, password, localidade, consumidor);
			}
			break;
		case 2:
			User a =gestor.login();
			if(a != null) {
				if (a instanceof Agricultor) {
					Agricultor userLogado = (Agricultor) a;
					boolean loggedin = true;
					while(loggedin == true) {
						System.out.println("Menu Agricultor");
						System.out.println("1 - Registar produto");
						System.out.println("2 - Ver meus produtos");
						System.out.println("3 - Alterar ou apagar produtos");
						System.out.println("4 - Inserir Tecnica de cultivo");
						System.out.println("5 - Visualizar Tenicas de cultivo");
						System.out.println("6 - Visualizar Historico de Vendas");
						System.out.println("7 - Visualizar estatisticas dos produtos");
						System.out.println("8 - Logout");
						System.out.println("9 - Fechar o Programa");
						int escolha = ler.nextInt();
						switch(escolha) {
						case 1:
							System.out.println("Insira o nome do Produto");
							String nomeProduto = ler.next();
							System.out.println("Insira o preço");
							double preço = ler.nextDouble();
							System.out.println("Insira a quantidade em Stock");
							int quantidade = ler.nextInt();
							gestor.registarProduto(nomeProduto, preço, quantidade, userLogado);
							break;
						case 2:
							gestor.showProdutos(userLogado);
							break;
						case 3:
							gestor.editarApagarProdutos(userLogado);
							break;
						case 4:
							System.out.println("Insira um titulo");
							String titulo = ler.next();
							System.out.println("Insira a sua descrição");
							ler.nextLine();
							String descrição = ler.nextLine();
							String autor = a.getNome();
							Tecnica tecnica = gestor.registarTecnica(titulo, descrição, autor);
							userLogado.addTecnica(tecnica);
							break;
						case 5:
							gestor.showTecnicas();
							break;
						case 6:
							gestor.verHistorico(userLogado);
							break;
						case 7:
							gestor.verEstatisticas(userLogado);
							break;
						case 8:
							System.out.println("Logout com sucesso");
							loggedin = false;
							break;
						case 9:
							System.out.println("A fechar o programa...");
							System.exit(0);
							
						default:
							System.out.println("Opção Invalida");
						}//switch escolha
					}//while(logged in)
				}//if
				else {
					Consumidor userLogado = (Consumidor) a;
					boolean loggedin = true;
					while(loggedin == true) {
						System.out.println("Menu Consumidor");
						System.out.println("1 - Visualizar catalogo.");
						System.out.println("2 - Comprar Produtos.");
						System.out.println("3 - Ver historico.");
						System.out.println("4 - Logout.");
						System.out.println("5 - Fechar Programa.");
						int escolha = ler.nextInt();
						switch(escolha) {
						case 1:
							gestor.showCatalogo();
							break;
						case 2:
							gestor.showCatalogo();
							gestor.comprarProduto(userLogado);
							break;
						case 3:
							gestor.verCompras(userLogado);
							break;
						case 4:
							System.out.println("Logout com sucesso");
							loggedin = false;
							break;
						case 5:
							System.exit(0);
							break;
						}//escolha
					}//while C
				}//else
			}//if a != null
			break;
		case 3:
			System.out.println("A fechar o programa...");
			System.exit(0);
			break;
		default:
			System.out.println("Opção Invalida");
			break;
				}//switch 1
		}//while
	}//main
}//class
