package example;

public class Sobremesa extends ItemMenu {

    // Construtor da classe Sobremesa, recebe o nome e preço da sobremesa
    public Sobremesa(String nome, double preco) {
        super(nome, preco); // Chama o construtor da classe base
    }

    // Sobrescreve o método getTipo() da classe base para devolver o tipo "Sobremesa"
    @Override
    public String getTipo() {
        return "Sobremesa";
    }

}