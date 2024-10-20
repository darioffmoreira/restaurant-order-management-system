package example;

public class ItemMenu {
    private String nome;
    private double preco;
    private int quantidadeDisponivel;

    // Construtor utilizado para criar Entradas e Sobremesas, que não têm quantidade disponível
    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeDisponivel = 0;
    }

    // Construtor utilizado para criar Prato Principal, onde a quantidade disponível é considerada
    public ItemMenu(String nome, double preco, int quantidadeDisponivel) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // Getter para o nome do item
    public String getNome() {
        return nome;
    }

    // Getter para o preço do item
    public double getPreco() {
        return preco;
    }

    // Setter para alterar o preço do item
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Decrementa a quantidade disponível de um Prato Principal, garantindo assim que não fica negativa
    public void decrementarQuantidade() {
        if (quantidadeDisponivel > 0) {
            quantidadeDisponivel--;
        } else {
            System.out.println("Não há mais '" + nome + "' disponível.");
        }
    }

    // Método que retorna o tipo genérico de item, pode ser sobrescrito nas subclasses
    public String getTipo() {
        return "Item Genérico";
    }
}
