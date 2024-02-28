import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static ArrayList<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    cadastrarProduto(scanner);
                    break;
                case 3:
                    realizarVenda(scanner);
                    break;
                case 4:
                    exibirEstoque();
                    break;
                case 5:
                    exibirClientes();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Produto");
        System.out.println("3. Realizar Venda");
        System.out.println("4. Exibir Estoque");
        System.out.println("5. Exibir Clientes");
        System.out.println("0. Encerrar Sistema");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("Nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.next();
        System.out.print("Senha: ");
        String senha = scanner.next();

        Cliente cliente = new Cliente(nome, endereco, telefone, email, dataNascimento, senha);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void cadastrarProduto(Scanner scanner) {
        System.out.println("\n=== Cadastro de Produto ===");
        scanner.nextLine();
        System.out.print("Nome: ");
        
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em Estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(nome, descricao, preco, quantidadeEstoque);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void realizarVenda(Scanner scanner) {
    	 System.out.println("\n=== Realizar Venda ===");
         System.out.print("Informe o e-mail do cliente: ");
         String emailCliente = scanner.next();

         Cliente cliente = buscarCliente(emailCliente);

         if (cliente != null) {
             Venda venda = new Venda(cliente);

             int opcaoProduto;
             do {
                 exibirProdutos();
                 System.out.print("Escolha um produto (0 para encerrar): ");
                 opcaoProduto = scanner.nextInt();

                 if (opcaoProduto != 0) {
                     Produto produto = buscarProduto(opcaoProduto);

                     if (produto != null) {
                         System.out.print("Quantidade desejada: ");
                         int quantidade = scanner.nextInt();
                         venda.adicionarProduto(produto, quantidade);
                     } else {
                         System.out.println("Produto não encontrado.");
                     }
                 }

             } while (opcaoProduto != 0);

             vendas.add(venda);
             venda.exibirDetalhes();
         } else {
             System.out.println("Cliente não encontrado.");
         }
    }
    private static void realizarDeposito(Scanner scanner, Cliente cliente) {
        System.out.print("\nDeseja realizar um depósito para aumentar seu saldo? (S/N): ");
        String escolha = scanner.next();

        if (escolha.equalsIgnoreCase("S")) {
            System.out.print("Informe o valor do depósito: R$");
            double valorDeposito = scanner.nextDouble();
            cliente.realizarDeposito(valorDeposito);
            realizarVenda(scanner); // Tentar novamente a venda após o depósito
        } else {
            System.out.println("Operação cancelada. Saldo insuficiente para finalizar a compra.");
        }
    }
    
    private static void exibirEstoque() {
        System.out.println("\n=== Estoque ===");
        for (Produto produto : produtos) {
            produto.exibirInformacoes();
            System.out.println("--------------------");
        }
    }

    private static void exibirClientes() {
        System.out.println("\n=== Clientes ===");
        for (Cliente cliente : clientes) {
            cliente.exibirInformacoes();
            System.out.println("--------------------");
        }
    }
    
    private static Cliente buscarCliente(String emailCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(emailCliente)) {
                return cliente;
            }
        }
        return null;
    }

    private static void exibirProdutos() {
        System.out.println("\n=== Produtos Disponíveis ===");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i).getNome()+ " "+ produtos.get(i).getDescricao()+ "| Preco: "+ produtos.get(i).getPreco());
        }
        System.out.println("0. Encerrar escolha");
    }

    private static Produto buscarProduto(int opcaoProduto) {
        if (opcaoProduto > 0 && opcaoProduto <= produtos.size()) {
            return produtos.get(opcaoProduto - 1);
        }
        return null;
    }
    
}
