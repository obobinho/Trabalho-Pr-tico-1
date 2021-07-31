import java.util.Scanner;

public class Trabalho {
	public static void main(String[] args)
	{
		Scanner ler = new Scanner(System.in);
		char opcao;
		int quantCliente=10, quantProduto=10;
		String[][] cliente= new String[21][4];
		String[][] estoque= new String[21][6];
		
		//Pré-carregamento de dados
		cliente=clienteCarregado(cliente);
		estoque=estoqueCarregado(estoque);
		
		do
		{
			menu();
			opcao=ler.next().charAt(0);
			ler.nextLine();
			System.out.println();
			System.out.println();
			
			switch (opcao)
			{
				case '1':
					quantCliente=quantidadeClientes(ler, quantCliente);
					cliente=cadastroCliente(ler, quantCliente, cliente);
				break;
				case '2':
					cliente=buscaCliente(ler, quantCliente, cliente);
				break;
				case '3':
					quantProduto=quantidadeProdutos(ler, quantProduto);
					estoque=cadastroProduto(ler, quantProduto, estoque);
				break;
				case '4':
					estoque=buscaProduto(ler, quantProduto, estoque);
				break;
				case '5':
					estoque=cadastroVenda(ler, quantCliente, cliente, quantProduto, estoque);
				break;
				case '6':
					mostraEstoque(ler, estoque, quantProduto);
				break;
				case '7':
					System.out.println("                       ¡Ciao!");
				break;
				default:
					System.out.println("Opção inválida!\n");
				break;
			}
		}
		while(opcao != '7');
			
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static String[][] clienteCarregado(String cliente[][])
	{	
		for(int cont1=1; cont1 <= 10;cont1++)
		{
			cliente[cont1][1]="Cliente" + String.valueOf(cont1);
			cliente[cont1][2]="Lugar" + String.valueOf(cont1);
			cliente[cont1][3]="Telefone" + String.valueOf(cont1);
		}
		
		return cliente;
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static String[][] estoqueCarregado(String estoque[][])
	{
		for(int cont1=1; cont1 <= 10;cont1++)
		{
			estoque[cont1][1]="Produto" + String.valueOf(cont1);
			estoque[cont1][2]="Descricao" + String.valueOf(cont1);
			estoque[cont1][3]="Preco" + String.valueOf(cont1);
			estoque[cont1][4]="Lucro" + String.valueOf(cont1);
			estoque[cont1][5]=String.valueOf(cont1);
		}
		
		return estoque;
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void menu()
	{
		System.out.println("1. Cadastro de novo cliente");
		System.out.println("2. Busca por cliente");
		System.out.println("3. Cadastro de novo produto");
		System.out.println("4. Busca por produto");
		System.out.println("5. Cadastro de venda");
		System.out.println("6. Mostrar produtos em estoque");
		System.out.println("7. Sair");
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public static int quantidadeClientes(Scanner ler, int quantCliente)
	{
		char tamanho;
		
		do
		{
			System.out.println("Digite a quantidade de clientes a serem cadastrados: ");
			tamanho =ler.next().charAt(0);
			ler.nextLine();
			System.out.println();
			System.out.println();
			
			//Tabela ascii usada como base para as condições, sendo '48'=0 e '57'=9
			if (tamanho < (char)48 || tamanho > (char)57)
			{
				System.out.println("Número inválido!");
				System.out.println();
				System.out.println();
			}
		}
		while(tamanho < (char)48 || tamanho > (char)57);
		
		//Retorna a quantidade de clientes atual somada à nova quantidade
		return quantCliente+Character.getNumericValue(tamanho);
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static String[][] cadastroCliente(Scanner ler, int quantCliente, String cliente[][])
	{	
		int tamanho=0;
		
		//Descobre os espaços não nulos, aumentando  a quantidade da variável "tamanho"
		for(int contad=1; contad <= quantCliente;contad++)
		{
		    if(cliente[contad][1] != null)
		    {
		    	tamanho++;
		    }
		}
		
		for(int cont1=tamanho+1; cont1 <= quantCliente;cont1++)
		{
			System.out.println("Digite o nome do cliente " + cont1 + ": ");
			cliente[cont1][1]=ler.nextLine();

			System.out.println("Digite o endereço do cliente " + cont1 + ": ");
			cliente[cont1][2]=ler.nextLine();

			System.out.println("Digite o telefone do cliente " + cont1 + ": ");
			cliente[cont1][3]=ler.nextLine();
			System.out.println();
			System.out.println();
		}
		
		return cliente;
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public static String[][] buscaCliente(Scanner ler, int quantCliente, String cliente[][])
	{	
		String checaCliente;
		char decisao, menu;
		
		do
		{
			int valida=0;
			
			System.out.println("Digite o nome do cliente cadastrado: ");
			checaCliente=ler.nextLine();
			
			for(int cont1=1; cont1 <= quantCliente;cont1++)
			{
				if(cliente[cont1][1].equalsIgnoreCase(checaCliente))
				{
					valida++;
						
					System.out.println("Nome: " + cliente[cont1][1]);
					System.out.println("Endereço: " + cliente[cont1][2]);
					System.out.println("Telefone: " + cliente[cont1][3]);
					System.out.println();
					System.out.println("Deseja alterar algum dado?");
					System.out.println();
					System.out.println("1. Sim");
					System.out.println("2. Não");
					decisao=ler.next().charAt(0);
					System.out.println();
					System.out.println();
						
					if(decisao == '1')
					{
						do
						{
							//Char menu sempre resetará no início do (do while) para que seja usado após o switch
							menu='\0';
							
							System.out.println("1. Nome");
							System.out.println("2. Endereço");
							System.out.println("3. Telefone");
							System.out.println("4. Sair");
							menu=ler.next().charAt(0);
							ler.nextLine();
							System.out.println();
							System.out.println();
								
							switch (menu)
							{
								case '1':
									System.out.println("Digite o nome do cliente " + cont1 + ": ");
									cliente[cont1][1]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '2':
									System.out.println("Digite o endereço do cliente " + cont1 + ": ");
									cliente[cont1][2]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '3':
									System.out.println("Digite o telefone do cliente " + cont1 + ": ");
									cliente[cont1][3]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '4':
								break;
								default:
									System.out.println("Opção inválida!\n");
								break;
							}
							
							//Se algum dado foi alterado, os dados do cliente atual aparecerão
							if (menu >= (char)49 && menu <= (char)51)
							{
								System.out.println("Nome: " + cliente[cont1][1]);
								System.out.println("Endereço: " + cliente[cont1][2]);
								System.out.println("Telefone: " + cliente[cont1][3]);
								System.out.println();
								System.out.println();
							}
						}
						while(menu != '4');
					}
				}
			}
			
			if(valida == 0)
			{
				System.out.println("Cliente não encontrado! Deseja buscar novamente?");
				System.out.println();
				System.out.println("1. Sim");
				System.out.println("2. Não");
				decisao=ler.next().charAt(0);
				System.out.println();
				System.out.println();
			}
			else
			{
				System.out.println("Deseja buscar novamente?");
				System.out.println();
				System.out.println("1. Sim");
				System.out.println("2. Não");
				decisao=ler.next().charAt(0);
				System.out.println();
				System.out.println();
			}
			ler.nextLine();
		}
		while(decisao == '1');
		
		return cliente;	
	}
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static int quantidadeProdutos(Scanner ler, int quantProduto)
	{
		char tamanho=0;
	
		do
		{
			System.out.println("Digite a quantidade de produtos a serem cadastrados: ");
			tamanho=ler.next().charAt(0);
			ler.nextLine();
			System.out.println();
			System.out.println();
			
			if (tamanho < (char)48 || tamanho > (char)57)
			{
				System.out.println("Número inválido!");
				System.out.println();
				System.out.println();
			}
		}
		while(tamanho < (char)48 || tamanho > (char)57);

		return quantProduto+Character.getNumericValue(tamanho);
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static String[][] cadastroProduto(Scanner ler, int quantProduto, String estoque[][])
	{
		int tamanho=0;
		
		for(int cont=1; cont <= quantProduto;cont++) {
		    if(estoque[cont][1] != null) {
		    	tamanho++;
		    }
		}
		
		for(int cont=tamanho+1; cont <= quantProduto;cont++)
		{
			System.out.println("Digite o nome do produto " + cont + ": ");
			estoque[cont][1]=ler.nextLine();

			System.out.println("Digite a descrição do produto " + cont + ": ");
			estoque[cont][2]=ler.nextLine();
			
			System.out.println("Digite o valor de compra do produto " + cont + ": ");
			estoque[cont][3]=ler.nextLine();
			
			System.out.println("Digite a porcentagem de lucro do produto " + cont + ": ");
			estoque[cont][4]=ler.nextLine();
			
			System.out.println("Digite a quantidade em estoque do produto " + cont + ": ");
			estoque[cont][5]=ler.nextLine();
			System.out.println();
			System.out.println();
		}
		
		return estoque;
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static String[][] buscaProduto(Scanner ler, int quantProduto, String estoque[][])
	{	
		String checaProduto;
		char decisao, menu;
		
		do
		{
			int valida=0;
			
			System.out.println("Digite o nome do produto cadastrado: ");
			checaProduto=ler.nextLine();
			
			for(int cont1=1; cont1 <= quantProduto;cont1++)
			{
				if(estoque[cont1][1].equalsIgnoreCase(checaProduto))
				{
					valida++;
						
					System.out.println("Nome: " + estoque[cont1][1]);
					System.out.println("Descrição: " + estoque[cont1][2]);
					System.out.println("Valor de compra: " + estoque[cont1][3]);
					System.out.println("Porcentagem de lucro: " + estoque[cont1][4]);
					System.out.println("Quantidade em estoque: " + estoque[cont1][5]);
					System.out.println();
					System.out.println("Deseja alterar algum dado?");
					System.out.println();
					System.out.println("1. Sim");
					System.out.println("2. Não");
					decisao=ler.next().charAt(0);
					System.out.println();
					System.out.println();
						
					if(decisao == '1')
					{
						do
						{
							menu='\0';
							
							System.out.println("1. Nome");
							System.out.println("2. Descrição");
							System.out.println("3. Valor de compra");
							System.out.println("4. Porcentagem de lucro");
							System.out.println("5. Quantidade em estoque");
							System.out.println("6. Sair");
							menu=ler.next().charAt(0);
							ler.nextLine();
							System.out.println();
							System.out.println();
								
							switch (menu)
							{
								case '1':
									System.out.println("Digite o nome do produto " + cont1 + ": ");
									estoque[cont1][1]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '2':
									System.out.println("Digite a descrição do produto " + cont1 + ": ");
									estoque[cont1][2]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '3':
									System.out.println("Digite o valor de compra do produto " + cont1 + ": ");
									estoque[cont1][3]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '4':
									System.out.println("Digite a porcentagem de lucro do produto " + cont1 + ": ");
									estoque[cont1][4]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '5':
									System.out.println("Digite a quantidade em estoque do produto " + cont1 + ": ");
									estoque[cont1][5]=ler.nextLine();
									System.out.println();
									System.out.println();
								break;
								case '6':
								break;
								default:
									System.out.println("Opção inválida!\n");
								break;
							}
							
							if (menu >= (char)49 && menu <= (char)53)
							{
								System.out.println("Nome: " + estoque[cont1][1]);
								System.out.println("Descrição: " + estoque[cont1][2]);
								System.out.println("Valor de compra: " + estoque[cont1][3]);
								System.out.println("Porcentagem de lucro: " + estoque[cont1][4]);
								System.out.println("Quantidade em estoque: " + estoque[cont1][5]);
								System.out.println();
								System.out.println();
							}
						}
						while(menu != '6');
					}
				}
			}
			
			if(valida == 0)
			{
				System.out.println("Produto não encontrado! Deseja buscar novamente?");
				System.out.println();
				System.out.println("1. Sim");
				System.out.println("2. Não");
				decisao=ler.next().charAt(0);
				System.out.println();
				System.out.println();
			}
			else
			{
				System.out.println("Deseja buscar novamente?");
				System.out.println();
				System.out.println("1. Sim");
				System.out.println("2. Não");
				decisao=ler.next().charAt(0);
				System.out.println();
				System.out.println();
			}
			ler.nextLine();
		}
		while(decisao == '1');
		
		return estoque;
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static String[][] cadastroVenda(Scanner ler, int quantCliente, String cliente[][], int quantProduto, String estoque[][])
	{
		String checaCliente, checaProduto;
		char decisao;
		int quantEstoque, valida1=0, valida2=0;
		
		do
		{
			valida1=0;
			
			System.out.println("			Clientes");
			for(int cont=1; cont <= quantCliente;cont++)
			{
				System.out.println(cliente[cont][1]);
			}
			
			System.out.println();
			System.out.println("Digite o nome de um cliente: ");
			checaCliente=ler.nextLine();
			System.out.println();
			System.out.println();
			
			for(int cont1=1; cont1 <= quantCliente;cont1++)
			{
				if(cliente[cont1][1].equalsIgnoreCase(checaCliente))
				{
					valida1++;

					do
					{
						valida2=0;
						
						System.out.println("			Produtos");
						for(int cont2=1; cont2 <= quantProduto;cont2++)
						{
							System.out.println(estoque[cont2][1] + " - " + estoque[cont2][2] + " - " + estoque[cont2][3] + " - " + estoque[cont2][4]  + " - " + estoque[cont2][5]);
						}
									
						System.out.println("Digite o nome de um produto: ");
						checaProduto=ler.nextLine();
						System.out.println();
						System.out.println();
										
						for(int cont3=1; cont3 <= quantProduto;cont3++)
						{
							if(estoque[cont3][1].equalsIgnoreCase(checaProduto))
							{
								valida2++;
								
								if (Integer.valueOf(estoque[cont3][5]) > 0)
								{
									System.out.println("Qual a quantidade de " + estoque[cont3][1] + " que foi vendida?");
									quantEstoque=ler.nextInt();
									System.out.println();
									System.out.println();
									
									if (Integer.valueOf(estoque[cont3][5]) < quantEstoque || quantEstoque < 0)
									{
										System.out.println("Há apenas " + estoque[cont3][5] + " de " + estoque[cont3][1]);
										System.out.println();
										System.out.println();
									}
									else{
										estoque[cont3][5]=String.valueOf(Integer.valueOf(estoque[cont3][5])-quantEstoque);
									}
								}
								else
								{
									System.out.println("Não tem mais " + estoque[cont3][1] + " disponível para vendas!");
									System.out.println();
									System.out.println();
								}
							}
						}
										
						if(valida2 == 0)
						{
							System.out.println("Produto não encontrado! Deseja buscar novamente?");
							System.out.println();										
							System.out.println("1. Sim");
							System.out.println("2. Não");
							decisao=ler.next().charAt(0);
							System.out.println();
							System.out.println();
						}
						else
						{
							System.out.println("Deseja cadastrar vendas para " + cliente[cont1][1] + " novamente?");
							System.out.println();
							System.out.println("1. Sim");
							System.out.println("2. Não");
							decisao=ler.next().charAt(0);
							System.out.println();
							System.out.println();
						}
						ler.nextLine();
					}
					while(decisao == '1');
				}
			}
			
			if(valida1 == 0)
			{
				System.out.println("Cliente não encontrado! Deseja buscar novamente?");
				System.out.println();
				System.out.println("1. Sim");
				System.out.println("2. Não");
				decisao=ler.next().charAt(0);
				System.out.println();
				System.out.println();
			}
			else
			{
				System.out.println("Deseja buscar cliente novamente?");
				System.out.println();
				System.out.println("1. Sim");
				System.out.println("2. Não");
				decisao=ler.next().charAt(0);
				System.out.println();
				System.out.println();
			}
			ler.nextLine();
		}
		while(decisao == '1');

		
		return estoque;
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static void mostraEstoque(Scanner ler, String estoque[][], int quantProduto)
	{
		String sair;
		
		for(int cont=1; cont <= quantProduto;cont++)
		{
			System.out.println(estoque[cont][1] + " - " + estoque[cont][2] + " - " + estoque[cont][3] + " - " + estoque[cont][4] + " - " + estoque[cont][5]);
		}
		System.out.println();
		System.out.println();
		sair=ler.nextLine();

	}
}

