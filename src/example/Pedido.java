package example;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Pedido {
    private List<ItemMenu> itens;
    private String clienteNome;
    private String clienteContacto;
    private double taxaEntrega;
    private double distancia;
    private LocalDate dataPedido;

    // Construtor que inicializa um novo pedido (Pedido) com os detalhes do cliente e informações de entrega
    public Pedido(String clienteNome, String clienteContacto, double distancia, double taxaEntrega) {
        this.itens = new ArrayList<>();
        this.clienteNome = clienteNome;
        this.clienteContacto = clienteContacto;
        this.distancia = distancia;
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = LocalDate.now();
    }

    // Método para adicionar um item ao pedido
    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    // Método para calcular o total do pedido, incluindo o custo dos itens e a taxa de entrega
    public double calcularTotal() {
        double total = 0;

        // Percorre a lista de itens e soma os preços
        for (ItemMenu item : itens) {
            total += item.getPreco();
        }

        // Adiciona a taxa de entrega ao total
        total += (distancia * taxaEntrega);
        return total;
    }

    // Getter para obter o nome do cliente
    public String getClienteNome() {
        return clienteNome;
    }

    // Getter para obter o contacto do cliente
    public String getClienteContacto() {
        return clienteContacto;
    }

    // Getter para obter a lista de itens do pedido
    public List<ItemMenu> getItens() {
        return itens;
    }

    // Getter para obter a data do pedido
    public LocalDate getDataPedido() {
        return dataPedido;
    }
}