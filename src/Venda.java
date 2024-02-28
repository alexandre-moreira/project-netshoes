import java.util.ArrayList;
import java.util.List;

public class Venda {
	private Cliente cliente;
    private ArrayList<Produto> produtos;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getQuantidadeEstoque() >= quantidade) {
            produtos.add(produto);
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
            cliente.setSaldo(cliente.getSaldo() - (produto.getPreco() * quantidade));
            System.out.println("Produto adicionado à venda.");
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    public void exibirDetalhes() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos na Venda:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + " " + produto.getDescricao());
        }
        System.out.println("Total da Venda: R$" + calcularTotal());
    }

    private double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }
    
    public boolean finalizarCompra() {
        double totalVenda = calcularTotal();
        
        if (cliente.getSaldo() >= totalVenda) {
            cliente.setSaldo(cliente.getSaldo() - totalVenda);
            System.out.println("Compra finalizada com sucesso. Saldo atual: R$" + cliente.getSaldo());
            return true;
        } else {
            System.out.println("Saldo insuficiente para finalizar a compra. Realize um depósito.");
            return false;
        }
    }
}
