package example;

public class Entrada extends ItemMenu {

    // Construtor da classe Entrada, recebe o nome e o preço da entrada
    public Entrada(String nome, double preco) {
        super(nome, preco);
    }

    // Sobrescreve o método getTipo() da classe base para devolver o tipo "Entrada"
    @Override
    public String getTipo() {
        return "Entrada";
    }

}