package example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        // Taxa de entrega por km
        Restaurante restaurante = new Restaurante(1.5);

        while (true) {
            System.out.println("\n=============================");
            System.out.println("        MENU PRINCIPAL       ");
            System.out.println("=============================");
            System.out.println("1. Adicionar item ao menu");
            System.out.println("2. Registrar novo pedido");
            System.out.println("3. Listar todos os pedidos de um cliente");
            System.out.println("4. Listar todas as vendas de um determinado mês");
            System.out.println("5. Total faturado em um determinado mês");
            System.out.println("6. Atualizar item do menu");
            System.out.println("7. Remover item do menu");
            System.out.println("8. Sair");
            System.out.println("=============================");
            System.out.print("Escolha uma opção (1-8): ");

            // Verifica se a entrada é um número
            if (!ler.hasNextInt()) {
                System.out.println("Nota: Deverá inserir um número válido entre 1 e 8.");
                ler.next();
                continue;
            }

            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    restaurante.adicionarItemAoMenu();
                    break;
                case 2:
                    restaurante.registrarPedido();
                    break;
                case 3:
                    restaurante.listarPedidosPorCliente();
                    break;
                case 4:
                    restaurante.listarPedidosPorMes();
                    break;
                case 5:
                    restaurante.totalFaturadoPorMes();
                    break;
                case 6:
                    restaurante.atualizarItemMenu();
                    break;
                case 7:
                    restaurante.removerItemMenu();
                    break;
                case 8:
                    System.out.println("A sair da aplicação");
                    ler.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}