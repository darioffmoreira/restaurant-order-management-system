package example;

public class PratoPrincipal extends ItemMenu {

    private int quantidadeDoses;
    private double precoPorDose;

    // Construtor da classe PratoPrincipal, inicializa o nome, quantidade de doses e preço por dose
    public PratoPrincipal(String nome, int quantidadeDoses, double precoPorDose) {
        super(nome, precoPorDose * quantidadeDoses);  // Preço total
        this.quantidadeDoses = quantidadeDoses;
        this.precoPorDose = precoPorDose;
    }

    // Método que devolve a quantidade de doses disponíveis
    public int getQuantidadeDoses() {
        return quantidadeDoses;
    }

    // Método para atualizar o preço por dose, e automaticamente recalcula o preço total do item
    public void setPrecoPorDose(double precoPorDose) {
        this.precoPorDose = precoPorDose;
        // Atualiza o preço total no objeto ItemMenu (preço por dose * quantidade de doses)
        super.setPreco(precoPorDose * quantidadeDoses);
    }

    // Sobrescreve o método getPreco() para devolver o preço total do prato (quantidade * preço por dose)
    @Override
    public double getPreco() {
        // Calcula o preço total de todas as doses
        return precoPorDose * quantidadeDoses;
    }

    // Sobrescreve o método getTipo() para indicar que este item é um "Prato Principal"
    @Override
    public String getTipo() {
        return "Prato Principal";
    }

    // Método para reduzir a quantidade de doses disponíveis quando o prato é pedido
    public void decrementarQuantidade() {
        if (quantidadeDoses > 0) {
            quantidadeDoses--;
        } else {
            System.out.println("Não há mais '" + getNome() + "' disponível.");
        }
    }

}
