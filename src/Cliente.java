import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
	private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String senha;
    private double saldo;

    public Cliente(String nome, String endereco, String telefone, String email, String dataNascimento, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.saldo = 100.0; // Saldo inicial de 100 reais
    }
    
   
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean realizarDeposito(double valorDeposito) {
        if (valorDeposito > 0) {
            this.saldo += valorDeposito;
            System.out.println("Depósito realizado com sucesso. Novo saldo: R$" + this.saldo);
            return true;
        } else {
            System.out.println("Valor de depósito inválido.");
            return false;
        }
    }
    
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Saldo: R$" + saldo);
    }
}