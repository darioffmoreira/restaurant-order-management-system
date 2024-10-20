package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    private List<ItemMenu> menu;
    private List<Pedido> pedidos;
    private double taxaEntrega;

    // Construtor da classe Restaurante
    public Restaurante(double taxaEntrega) {
        this.menu = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.taxaEntrega = taxaEntrega;
    }

    // Método para adicionar item ao menu
    public void adicionarItemAoMenu() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha o tipo que pretende adicionar: ");
        System.out.println("1. Entrada");
        System.out.println("2. Sobremesa");
        System.out.println("3. Prato Principal");

        int tipoItem = ler.nextInt();
        ler.nextLine();

        System.out.print("Digite o nome do item: ");
        String nomeItem = ler.nextLine();

        // Verifica o tipo do item selecionado e adiciona ao menu
        if (tipoItem == 1 || tipoItem == 2) {
            System.out.print("Digite o preço do item: ");
            double precoItem = ler.nextDouble();
            if (tipoItem == 1) {
                menu.add(new Entrada(nomeItem, precoItem));
            } else if (tipoItem == 2) {
                menu.add(new Sobremesa(nomeItem, precoItem));
            }
        } else if (tipoItem == 3) {
            System.out.print("Digite o número de doses: ");
            int quantidadeDoses = ler.nextInt();
            System.out.print("Digite o preço por dose: ");
            double precoPorDose = ler.nextDouble();
            menu.add(new PratoPrincipal(nomeItem, quantidadeDoses, precoPorDose));
        } else {
            System.out.println("Opção inválida.");
        }
    }

    // Método para registar um novo pedido
    public void registrarPedido() {
        Scanner ler = new Scanner(System.in);

        // Verifica se há itens disponíveis no menu
        if (menu.isEmpty()) {
            System.out.println("Nenhum item disponível.");
            return;
        }

        System.out.print("Digite o nome do cliente: ");
        String clienteNome = ler.nextLine();
        System.out.print("Digite o contacto do cliente: ");
        String clienteContacto = ler.nextLine();
        System.out.print("Digite a distância para entrega (em km): ");
        double distancia = ler.nextDouble();
        ler.nextLine();

        // Cria um novo pedido e adiciona à lista de pedidos
        Pedido pedido = new Pedido(clienteNome, clienteContacto, distancia, taxaEntrega);
        pedidos.add(pedido);

        boolean temItemDisponivel = false;

        // Verifica a disponibilidade de itens
        for (ItemMenu item : menu) {
            if (item instanceof PratoPrincipal) {
                PratoPrincipal prato = (PratoPrincipal) item;
                if (prato.getQuantidadeDoses() > 0) {
                    temItemDisponivel = true; // Pelo menos um prato principal disponível
                    break;
                }
            } else if (item instanceof Entrada || item instanceof Sobremesa) {
                temItemDisponivel = true; // Se houver pelo menos uma entrada ou sobremesa
                break;
            }
        }

        // Se não houver itens disponíveis
        if (!temItemDisponivel) {
            System.out.println("Nenhum item disponível.");
            return; // Encerra o pedido se não houver itens disponíveis
        }

        String adicionarMais;
        do {
            // Apresenta o menu e solicita a escolha do item
            System.out.println("Escolha um item do menu: ");
            listarMenu();

            // Verifica se o menu tem itens antes de solicitar o número
            if (menu.isEmpty()) {
                System.out.println("Nenhum item disponível.");
                return;
            }

            System.out.print("Digite o número do item: ");
            int numeroItem = ler.nextInt();
            ler.nextLine();

            // Verifica se o item selecionado é válido
            if (numeroItem > 0 && numeroItem <= menu.size()) {
                ItemMenu itemSelecionado = menu.get(numeroItem - 1);

                // Adiciona o item ao pedido
                boolean adicionadoComSucesso = adicionarItemAoPedido(pedido, itemSelecionado);

                // Confirma se o item foi adicionado com sucesso
                if (adicionadoComSucesso) {
                    System.out.println("Item adicionado: " + itemSelecionado.getNome());
                } else {
                    System.out.println("Este item não pode ser adicionado ao pedido.");
                }
            } else {
                System.out.println("Item não encontrado.");
            }

            System.out.print("Deseja adicionar mais itens? (s/n): ");
            adicionarMais = ler.nextLine();

        } while (adicionarMais.equalsIgnoreCase("s"));
    }

    // Método auxiliar para adicionar itens ao pedido
    private boolean adicionarItemAoPedido(Pedido pedido, ItemMenu item) {

        /*
            1 - Verifica a quantidade disponível de doses de um prato principal.
            2 - Caso ainda existam doses, adiciona o prato ao pedido e decrementa a quantidade disponível.
            3 - Caso contrário, informa o utilizador que o prato principal está esgotado.

            Porque usar "instanceof": verifica se um objeto é uma instãncia de uma determinada class.
            Objetivo: Instanceof PratoPrincipal: Verifica se o item é um prato principal para aplicar uma lógica de controlo de stock.
        */
        if (item instanceof PratoPrincipal) {
            PratoPrincipal prato = (PratoPrincipal) item;

            // Verifica se ainda há doses disponíveis do prato principal
            if (prato.getQuantidadeDoses() > 0) {
                pedido.adicionarItem(prato);
                prato.decrementarQuantidade();
                return true;
            } else {
                // Mensagem de erro quando o prato principal está esgotado
                System.out.println("Este prato principal '" + prato.getNome() + "' está esgotado.");
                return false;
            }
        } else {
            // Entradas/sobremesas, não é necessário verificar quantidade
            pedido.adicionarItem(item);
            return true;
        }
    }

    // Método para listar os itens disponíveis no menu
    public void listarMenu() {
        System.out.println("Menu:");

        boolean temPratoPrincipalDisponivel = false;

        // Listar entradas no menu
        for (ItemMenu item : menu) {
            if (item instanceof Entrada) {
                System.out.println((menu.indexOf(item) + 1) + ". " + item.getNome() + " - " + item.getPreco() + " EUR (" + item.getTipo() + ")");
            }
        }

        // Listar sobremesas no menu
        for (ItemMenu item : menu) {
            if (item instanceof Sobremesa) {
                System.out.println((menu.indexOf(item) + 1) + ". " + item.getNome() + " - " + item.getPreco() + " EUR (" + item.getTipo() + ")");
            }
        }

        // Listar pratos principais disponíveis no menu
        for (ItemMenu item : menu) {
            if (item instanceof PratoPrincipal) {
                PratoPrincipal prato = (PratoPrincipal) item;
                if (prato.getQuantidadeDoses() > 0) {
                    System.out.println((menu.indexOf(item) + 1) + ". " + item.getNome() + " - " + item.getPreco() + " EUR (" + item.getTipo() + ")");
                    temPratoPrincipalDisponivel = true;
                }
            }
        }

        // Se não houver pratos principais disponíveis
        if (!temPratoPrincipalDisponivel) {
            System.out.println("Nenhum prato principal disponivel.");
        }
    }

    // Método para listar os pedidos de um cliente específico
    public void listarPedidosPorCliente() {
        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o contacto do cliente: ");
        String clienteContacto = ler.nextLine();
        boolean encontrado = false;

        // Percorre a lista de pedidos e encontra os pedidos do cliente
        for (Pedido pedido : pedidos) {
            if (pedido.getClienteContacto().equalsIgnoreCase(clienteContacto)) {
                encontrado = true;
                System.out.println();
                System.out.println("** ---------------------------- **");
                System.out.println("Pedido de " + pedido.getClienteNome() + " em " + pedido.getDataPedido());
                for (ItemMenu item : pedido.getItens()) {
                    System.out.println("- " + item.getNome() + " (" + item.getPreco() + " EUR)");
                }
                System.out.println("Total do Pedido: " + pedido.calcularTotal() + " EUR");
                System.out.println();
                System.out.println("** ---------------------------- **");
            }
        }

        // Se nenhum pedido for encontrado
        if (!encontrado) {
            System.out.println("Nenhum pedido de cliente encontrado com o contacto: " + clienteContacto);
        }
    }

    // Método para listar os pedidos feitos num determinado mês
    public void listarPedidosPorMes() {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o mês (1-12): ");
        int mes = ler.nextInt();
        System.out.print("Digite o ano (AAAA): ");
        int ano = ler.nextInt();

        boolean encontrado = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getDataPedido().getMonthValue() == mes && pedido.getDataPedido().getYear() == ano) {
                encontrado = true;
                System.out.println();
                System.out.println("** ---------------------------- **");
                System.out.println("Pedido de " + pedido.getClienteNome() + " em " + pedido.getDataPedido());
                for (ItemMenu item : pedido.getItens()) {
                    System.out.println("- " + item.getNome() + " (" + item.getPreco() + " EUR)");
                }
                System.out.println("Total do Pedido: " + pedido.calcularTotal() + " EUR");
                System.out.println();
                System.out.println("** ---------------------------- **");
            }
        }

        // Se nenhum pedido for encontrado
        if (!encontrado) {
            System.out.println("Nenhum pedido encontrado para o mês " + mes + "/" + ano);
        }
    }

    // Método para calcular o total faturado num determinado mês
    public void totalFaturadoPorMes() {
        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o mês (1-12): ");
        int mes = ler.nextInt();
        System.out.print("Insira o ano (AAAA): ");
        int ano = ler.nextInt();

        double totalFaturado = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getDataPedido().getMonthValue() == mes && pedido.getDataPedido().getYear() == ano) {
                totalFaturado += pedido.calcularTotal();
            }
        }

        System.out.println("Total faturado em " + mes + "/" + ano + ": " + totalFaturado + " EUR");
    }

    // Método para atualizar um item no menu
    public void atualizarItemMenu() {
        listarMenu();

        // Verifica se há itens disponíveis no menu
        if (menu.isEmpty()) {
            System.out.println("Nenhum item disponível para atualizar.");
            return;
        }

        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o número do item a ser atualizado: ");
        int numeroItem = ler.nextInt();
        ler.nextLine();

        // Verifica se o número do item está dentro dos limites do menu
        if (numeroItem > 0 && numeroItem <= menu.size()) {
            ItemMenu item = menu.get(numeroItem - 1);
            System.out.print("Insira o novo preço: ");
            double novoPreco = ler.nextDouble();

            if (item instanceof PratoPrincipal) {
                ((PratoPrincipal) item).setPrecoPorDose(novoPreco);
            } else {
                item.setPreco(novoPreco);
            }

            System.out.println("Item atualizado com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    // Método para remover um item do menu
    public void removerItemMenu() {
        listarMenu();

        // Verifica se há itens disponíveis no menu
        if (menu.isEmpty()) {
            System.out.println("Nenhum item disponível para eliminar.");
            return;
        }

        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o número do item a ser removido: ");
        int numeroItem = ler.nextInt();
        ler.nextLine();

        // Verifica se o número do item está dentro dos limites do menu
        if (numeroItem > 0 && numeroItem <= menu.size()) {
            ItemMenu item = menu.get(numeroItem - 1);
            menu.remove(item);
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    // Método para obter a lista do menu
    public List<ItemMenu> getMenu() {
        return menu;
    }
}