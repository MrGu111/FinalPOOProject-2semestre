package mainProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {
	Scanner ler = new Scanner (System.in);
	private ArrayList<User> users;
	private ArrayList<Produto> catalogo;
	private ArrayList<Tecnica> tecnicasCultivo;
	
	public Gestor() {
		users = new ArrayList<>();
		catalogo = new ArrayList<>();
		tecnicasCultivo = new ArrayList<>();
	}//Gestor
	
	public void addUser (User user) {
		users.add(user);
	}//addUser
	
	public int menuRegisto() {
		System.out.println("Menu");
		System.out.println("1 - Registar");
		System.out.println("2 - Login");
		System.out.println("3 - Fechar o programa");
		int opção = ler.nextInt();
		return opção;
	}//menuRegisto
	
	public String vefTipo() {
		System.out.println("Indique o tipo de conta (Agricultor/Consumidor)");
		while (true) {
			System.out.println("1 - Agricultor");
	        System.out.println("2 - Consumidor");
	        int tipo = ler.nextInt();
	        
	        if (tipo == 1) {
	            return "Agricultor";
	        }//if
	        if (tipo == 2) {
	            return "Consumidor";
	        }//if
	        
	        System.out.println("Opção inválida");
		}//while
	}//tipoConta
	
	public String vefNome(){
		while (true) {
			boolean existe = false;
			System.out.println("Insira o nome de utilizador:");
			String nome = ler.next();
			
			for (User user : users) {
				if(user.getNome().equals(nome)) {
					existe = true;
					break;
				}//if
			}//for
			
			if(existe == true) {
				System.out.println("Nome já existente");
			}//if
			
			else {
				return nome;
			}//else
			
		}//while
	}//vefNome
	
	public String vefEmail() {
		while (true) {
			Boolean existe = false;
			System.out.println("Insira o email: ");
			String email = ler.next();
			
			if(!email.contains("@")) {
				System.out.println("Email Invalido! Tem de conter '@' ");
				continue;
			}//if
			
			if(email.indexOf("@") == 0 || email.indexOf("@") == email.length() - 1) {
				System.out.println("Email Invalido! Não pode conter '@' no inicio ou fim do email");
				continue;
			}//if
			
			for (User user : users) {
				if(user.getEmail().equals(email)) {
					System.out.println("Email já em uso");
					existe = true;
					break;
				}//if
			}//for
			
			if(existe == true) {
				continue;
			}//if
			
			else {
				return email;
			}//else
			
		}//while
	}//vefEmail
	
	public String vefDataNascimento(){
		while (true) {
			System.out.println("Insira a data de Nascimento (dd/mm/aaaa):");
			String data = ler.next();
	        
	        if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
	            return data;
	        }//if
	        
	        System.out.println("Formato inválido! Use dd/mm/aaaa.");
	    }//while
	}//vefDataNascimento
	
	public String vefLocalidade() {
		System.out.println("Insira a localidade:");
		String localidade = ler.next();
		return localidade;
	}//vefLocalidade
	
	public String vefPassword() {
		while (true) {
			boolean letra = false;
			boolean numero = false;
			System.out.println("Insira a password: (Minimo 5 caracteres, tem de conter pelo menos 1 letra e 1 numero)");
			String password = ler.next();
		
			if(password.length() < 5) {
				System.out.println("Password demasiado pequena.");
				continue;
			}//if
			
			for (char c : password.toCharArray()) {
				if(Character.isLetter(c)) {
					letra = true;
				}//if
				else if (Character.isDigit(c)){
					numero = true;
				}//else
				if (letra == true && numero == true) {
                    break;
                }
			}//for
			
			if (letra == false) {
				System.out.println("A password necessita ter pelo menos uma letra");
			}//if
			
			if(numero == false) {
				System.out.println("A password necessita ter pelo menos um numero");
			}//if
			
			if(letra == true && numero == true) {
				return password;
			}//if
		}//while
	}//verPassword
	
	public String vefDescrição() {
		System.out.println("Insira uma descrição:");
		ler.nextLine();
		String descrição = ler.nextLine();
		return descrição;
	}//vefDescricao
	
	public String vefConsumidor() {
		System.out.println("Insira que tipo de consumidor (Singular/Empresarial)");
		while (true) {
			System.out.println("1 - Singular");
	        System.out.println("2 - Empresarial");
	        int tipo = ler.nextInt();
	        
	        if (tipo == 1) {
	            return "Singular";
	        }//if
	        if (tipo == 2) {
	            return "Empresarial";
	        }//if
	        
	        System.out.println("Opção inválida");
		}//while
	}//vefConsumidor
	
	public void registarAgricultor(String nome, String email, String dataNascimento, String descrição, String password,String localidade) {
		users.add(new Agricultor(nome, email, dataNascimento, descrição, password, localidade));
	}//registarAgricultor
	
	public void registarConsumidor(String nome, String email, String dataNascimento, String password,String localidade, String tipo) {
		users.add(new Consumidor(nome,email,dataNascimento,password,tipo,localidade));
	}//registarConsumidor
	
	public Tecnica registarTecnica(String titulo,String descrição,String autor){
		Tecnica tecnica = new Tecnica (titulo,descrição,autor);
		tecnicasCultivo.add(tecnica);
		return tecnica;
	}//registarTecnica
	
	public void registarProduto(String nome,double preço,int quantidade,Agricultor agricultor) {
		boolean x = false;
		Produto produtoExiste = null;
		for (Produto produto1 : catalogo) {
			if(produto1.getNome().equalsIgnoreCase(nome)) {
				produtoExiste = produto1;
				x = true;
			}//if
		}//for
		
		if (x == false) {
			produtoExiste = new Produto (nome);
			catalogo.add(produtoExiste);
		}//if
		
		ProduAgric criarProduto = new ProduAgric (preço,quantidade,agricultor,produtoExiste);
		produtoExiste.addAgricultor(criarProduto);
		agricultor.addProduto(criarProduto);
	}//registarProduto
	
	public User login() {
		System.out.println("Insira o nome de Utilizador:");
		String nomeU = ler.next();
		System.out.println("Insira a password:");
		String password = ler.next();
		for(User user : users) {
			if(user.getNome().equals(nomeU)) {
				for (User user1 : users) {
					if(user1.getPassword().equals(password)) {
						System.out.println("Sucesso");
						return user;
					}//if
				}//for
			}//if
		}//for
		System.out.println("Nome de Utilizador incorreto ou Password Incorreta");
		return null;
	}//login
	
	public void editarApagarProdutos(Agricultor agricultor) {
		boolean x = false;
		ProduAgric produtoEscolhido = null;
		ArrayList <ProduAgric> produtosAgric = agricultor.getProdutos();
		
		if(produtosAgric.isEmpty()) {
			System.out.println("Não existem produtos registados");
			return;
		}//if
		
		System.out.println("Produtos que se encontram registados na sua conta");
		for(ProduAgric produto : produtosAgric) {
			System.out.println("Nome: "+ produto.getProduto().getNome());
			System.out.println("Preço: "+ produto.getPreço() + "€");
			System.out.println("Quantidade em stock: " + produto.getQuantidade());
			System.out.println("----------------");
		}//for
		
		System.out.println("\nInsira o nome do produto que deseja modificar ou apagar:");
		String nomeProduto = ler.next();
		for (ProduAgric produto : produtosAgric) {
			if(produto.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
				produtoEscolhido = produto;
				x = true;
			}//if
		}//for
		
		if (x == true) {
			System.out.println("Opções");
			System.out.println("1 - Editar produto.");
			System.out.println("2 - Apagar produto.");
			int opção = ler.nextInt();
			switch(opção) {
			case 1:
				System.out.println("Opções");
				System.out.println("1 - Alterar preço.");
				System.out.println("2 - Alterar quantidade.");
				System.out.println("3 - Alterar ambos.");
				System.out.println("4 - Voltar ao menu principal.");
				int escolha = ler.nextInt();
				switch(escolha) {
				case 1:
					System.out.println("Insira o novo preço");
					double novoPreço = ler.nextDouble();
					produtoEscolhido.setPreço(novoPreço);
					break;
				case 2:
					System.out.println("Insira a nova quantidade em stock.");
					int quantidade = ler.nextInt();
					produtoEscolhido.setQuantidade(quantidade);
					break;
				case 3:
					System.out.println("Insira o novo preço");
					novoPreço = ler.nextDouble();
					produtoEscolhido.setPreço(novoPreço);
					System.out.println("Insira a nova quantidade em stock.");
					quantidade = ler.nextInt();
					produtoEscolhido.setQuantidade(quantidade);
				case 4:
					break;
				default:
					System.out.println("Opção Invalida");
				}//switch escolha
				break;
			case 2:
				System.out.println("Tem a certeza? (Sim/Não)");
				String resposta = ler.next();
				if (resposta.equalsIgnoreCase("Sim")) {
					produtosAgric.remove(produtoEscolhido);
					System.out.println("Produto apagado com sucesso");
					break;
				}//if
				if(resposta.equalsIgnoreCase("Não")) {
					System.out.println("Operação anulada");
					break;
				}
				else {
					System.out.println("Resposta Invalida");
				}
			default:
				System.out.println("Opção invalida");
				break;
			}//switch opção
		}//if
	}//editarApagarProdutos
	
	public void showProdutos(Agricultor userLogado) {
		System.out.println("Produtos registados:");
		for (ProduAgric produto : userLogado.getProdutos()) {
			System.out.println("Nome: "+ produto.getProduto().getNome());
			System.out.println("Preço: "+ produto.getPreço() + "€");
			System.out.println("Quantidade em stock: " + produto.getQuantidade());
			System.out.println("----------------");
		}//for
	}//showProdutos
	
	public void showCatalogo() {
		for (User user : users) {
			if(user instanceof Agricultor) {
				Agricultor agricultor = (Agricultor) user;
				ArrayList <ProduAgric> produtos = agricultor.getProdutos();
				
				System.out.println("Agricultor:" + agricultor.getNome());
				for (ProduAgric produto : produtos) {
					System.out.println("Produto: " + produto.getProduto().getNome());
					System.out.println("Preço: " + produto.getPreço() + "€");
					System.out.println("Quantidade: " + produto.getQuantidade());
					System.out.println("------------");
				}
			}
		}//for
	}//showCatalogo
	
	public void showTecnicas() {
		for (User user : users) {
			if (user instanceof Agricultor) {
				Agricultor agricultor = (Agricultor) user;
				ArrayList <Tecnica> tecnicasCultivo = agricultor.getTecnicas();			
				for (Tecnica tecnica : tecnicasCultivo) {
					System.out.println("Titulo: " + tecnica.getTitulo());
					System.out.println("Descrição: " + tecnica.getDescrição());
					System.out.println("Autor: " + tecnica.getAutor());
					System.out.println("------------");	
				}//for
			}//if
		}//for
	}//showTecnicas
	
	public void comprarProduto(Consumidor consumidor) {
		Agricultor agricultorEncontrado = null;
		ProduAgric produtoEscolhido = null;
		boolean continuarCompra = true;
		
		System.out.println("De qual agricultor deseja realizar a sua compra?");
		String agric = ler.next();
		
		for (User user : users) {
			if (user instanceof Agricultor && user.getNome().equals(agric)) {
				System.out.println("Agricultor encontrado!");
				agricultorEncontrado = (Agricultor) user;
				break;
			}//if
		}//for
		
		if(agricultorEncontrado == null) {
			System.out.println("Agricultor não encontrado");
			return;
		}//if
		
		Compra compraAtual = new Compra(consumidor,agricultorEncontrado,0.0);
		
		while (continuarCompra == true) {
			boolean produtoEncontrado = false;
			
			System.out.println("Produtos Disponiveis: ");
			ArrayList<ProduAgric> produtos = agricultorEncontrado.getProdutos();
			
			if(produtos.isEmpty()) {
				System.out.println("O agricultor não tem produtos a venda.");
				continue;
			}//if
		
			for(ProduAgric produto : produtos) {
				System.out.println("Produto: " + produto.getProduto().getNome());
				System.out.println("Preço: " + produto.getPreço() + "€");
				System.out.println("Quantidade: " + produto.getQuantidade());
				System.out.println("------------");
			}//for
		
			System.out.println("Insira o nome do produto que deseja comprar? ");
			String nomeProduto = ler.next();
		
			for(ProduAgric produto : produtos) {
				if(produto.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
					produtoEscolhido = (ProduAgric) produto;
					System.out.println("Produto encontrado");
					produtoEncontrado = true;
					break;
				}//if
			}//for
		
			if(produtoEncontrado == false) {
				System.out.println("Produto não encontrado");
				continue;
			}//if
		
			System.out.println("O produto encontra-se com " + produtoEscolhido.getQuantidade() + " unidades disponiveis.");
			System.out.println("Quantas unidades de " + produtoEscolhido.getProduto().getNome() + " deseja comprar?");
			int quantidade = ler.nextInt();
		
			if(quantidade < 0 || quantidade > produtoEscolhido.getQuantidade()) {
				System.out.println("Quantidade Invalida.");
				continue;	
			}//if
			
			produtoEscolhido.setQuantidade(produtoEscolhido.getQuantidade() - quantidade);
			DetalheCompra detalhes = new DetalheCompra(produtoEscolhido,quantidade);
			compraAtual.addProdutoCompra(detalhes);
			
			compraAtual.setTotal(compraAtual.getTotal() + (produtoEscolhido.getPreço() * quantidade));
			
			System.out.println("Deseja continuar a sua compra? (S/N)");
			String resposta = ler.next();
			
			if(resposta.equalsIgnoreCase("N")) {
				continuarCompra = false;
			}//if
		}//while
		
		if (!compraAtual.getProdutos().isEmpty()) {
			System.out.println("Resumo da compra:");
			System.out.println("Produtos comprados:");
			for (DetalheCompra detalhe : compraAtual.getProdutos()) {
				System.out.println("Produto: " + detalhe.getProduto().getProduto().getNome());
				System.out.println("Quantidade: " + detalhe.getQuantidade());
				System.out.println("Preço pago:" + (detalhe.getQuantidade() * detalhe.getProduto().getPreço()) + "€");
				System.out.println("-----------------");
			}//for
			
			System.out.println("TOTAL PAGO: " + compraAtual.getTotal() + "€");
		}//if
		
		consumidor.addCompra(compraAtual);
		
		agricultorEncontrado.addCompra(compraAtual);
		
	}//comprarProduto
	
	public void verHistorico(Agricultor agricultor) {
		ArrayList<Compra> historico = agricultor.getHistorico();
		for (Compra compra : historico) {
				if(!compra.getProdutos().isEmpty()) {
					ArrayList <DetalheCompra> produtos = compra.getProdutos();
					System.out.println("Compra realizada a " + compra.getData());
					System.out.println("Consumidor: " + compra.getConsumidor().getNome());
					for(DetalheCompra produto : produtos) {
						System.out.println("Nome: " + produto.getProduto().getProduto().getNome());
						System.out.println("Quantidade comprada: " + produto.getQuantidade());
						System.out.println("Preço total por unidade: " + produto.getProduto().getPreço() + "€");
						System.out.println("Preço total recebido pelo produto: " + (produto.getProduto().getPreço()*produto.getQuantidade()) + "€");
						System.out.println("--------------");
					}//for
					System.out.println("Preço Total:" + compra.getTotal() + "€");
					System.out.println("-------------------------------------------");
				}//if
			}//for
		}//verHistorico
	
	public void verCompras(Consumidor consumidor) {
		ArrayList <Compra> compras = consumidor.getHistorico();
		for (Compra compra : compras) {
			if(!compra.getProdutos().isEmpty()) {
				ArrayList <DetalheCompra> produtos = compra.getProdutos();
				System.out.println("Compra realizada a " + compra.getData());
				System.out.println("Agricultor: " + compra.getAgricultor().getNome());
				for(DetalheCompra produto : produtos) {
					System.out.println("Nome: " + produto.getProduto().getProduto().getNome());
					System.out.println("Quantidade comprada: " + produto.getQuantidade());
					System.out.println("Preço total por unidade: " + produto.getProduto().getPreço() + "€");
					System.out.println("Preço total pago pelo produto: " + (produto.getProduto().getPreço()*produto.getQuantidade()) + "€");
					System.out.println("--------------");
				}//for
				System.out.println("Preço Total:" + compra.getTotal() + "€");
				System.out.println("-------------------------------------------");
				}//if
		}//for
	}//verCompras
	
	public void verEstatisticas(Agricultor agricultor) {
		ArrayList <Compra> compras = agricultor.getHistorico();
		double receitaTotal = 0;
		String [] nomesProdutos = new String[1000];
		int [] quantidadesVendidas = new int[1000];
		int produtosDiferentes = 0;
		
		if (compras.isEmpty()) {
			System.out.println("Ainda não foram realizadas vendas.");
	        return;
		}//if
		
		for (Compra compra : compras) {
			receitaTotal += compra.getTotal();
			
			for(DetalheCompra detalhe : compra.getProdutos()) {
				
				boolean produtoJaExiste = false;
				
	            for (int i = 0; i < produtosDiferentes; i++) {
	                if (nomesProdutos[i].equals(detalhe.getProduto().getProduto().getNome())) {
	                    quantidadesVendidas[i] += detalhe.getQuantidade();
	                    produtoJaExiste = true;
	                    break;
	                }//if
			}//for
	            
	            if (!produtoJaExiste && produtosDiferentes < 1000) {
	                nomesProdutos[produtosDiferentes] = detalhe.getProduto().getProduto().getNome();
	                quantidadesVendidas[produtosDiferentes] = detalhe.getQuantidade();
	                produtosDiferentes++;
	            }//if
			}//for
		}//for
		
		for (int i = 0; i < produtosDiferentes - 1; i++) {
	        for (int j = 0; j < produtosDiferentes - i - 1; j++) {
	            if (quantidadesVendidas[j] < quantidadesVendidas[j + 1]) {
	            	
	                String tempNome = nomesProdutos[j];
	                nomesProdutos[j] = nomesProdutos[j + 1];
	                nomesProdutos[j + 1] = tempNome;
	               
	                int tempQtd = quantidadesVendidas[j];
	                quantidadesVendidas[j] = quantidadesVendidas[j + 1];
	                quantidadesVendidas[j + 1] = tempQtd;
	            }//if
	        }//for
	    }//for
		
		System.out.println("ESTATÍSTICAS:");
	    System.out.println("Total de vendas realizadas: " + compras.size());
	    System.out.println("Total em receita: " + receitaTotal + "€");
	    
	    System.out.println("\nTop 3 produtos mais vendidos:");
	    int limite = Math.min(3, produtosDiferentes);
	    for (int i = 0; i < limite; i++) {
	        System.out.println((i+1) + ". " + nomesProdutos[i] + " - " + quantidadesVendidas[i] + " unidades");
	    }

	}//verEstatisticas
}