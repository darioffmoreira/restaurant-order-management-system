**Languages/Línguas**: [English](#documentation-in-english) | [Português](#documentação-em-português)

# Documentation in English

# Restaurant Order Management System

- [Introduction](#introduction)
- [Program Structure](#program-structure)
- [Features](#features)
  - [1. Add Item to Menu](#1-add-item-to-menu)
  - [2. Register Order](#2-register-order)
  - [3. List Orders by Customer](#3-list-orders-by-customer)
  - [4. List Orders by Month](#4-list-orders-by-month)
  - [5. Update Item Price in Menu](#5-update-item-price-in-menu)
  - [6. Remove Item from Menu](#6-remove-item-from-menu)
- [Technical resources used](#technical-resources-used)

---

## Introduction

This system was developed to manage a restaurant's menu and efficiently process customer orders. It allows the user to add items to the menu, register new orders, list orders by customer or month, and also manage the menu by updating or removing items.

---

## Program Structure

The program is divided into several main classes:

- **`Main.java`**: Controls the main flow of the application and user interactions.
- **`Restaurant.java`**: Responsible for managing the menu and orders. This class includes methods for adding items to the menu, processing orders, and calculating delivery fees.
- **`Order.java`**: Represents a customer’s order, including the requested items, customer details, and the total order calculation.
- **`MenuItem.java`**: Base class for menu items, including `Starter`, `Dessert`, and `MainCourse`.
- **`Starter.java`, `Dessert.java`, `MainCourse.java`**: Specific classes for each type of menu item, inheriting from `MenuItem`.

---

## Features

### 1. Add Item to Menu

The user can add new items to the menu by choosing between three categories:

- **Starter**: A simple starter with name and price.
- **Dessert**: A dessert with name and price.
- **Main Course**: A main course that includes a price per serving and the number of servings available.

#### Example Usage:

- The user chooses to add a "Main Course", providing the dish name, price per serving, and the available number of servings.

---

### 2. Register Order

The system allows users to register a new order for a customer. The user selects the items the customer wants, and the system calculates the total based on the item prices and delivery distance (if applicable).

#### Example Usage:

- The user selects the customer and the desired items. The system checks availability (for main courses) and calculates the total order, including the delivery fee based on distance.

---

### 3. List Orders by Customer

This feature allows listing all the orders made by a specific customer. This is useful for checking the order history of a particular customer.

#### Example Usage:

- The user enters the customer's name, and the system returns a list of all the orders made by that customer, with details of each order.

---

### 4. List Orders by Month

This feature allows listing orders placed in a specific month. The orders are filtered based on the creation date.

#### Example Usage:

- The user inputs the desired month (e.g., "05" for May), and the system lists all orders made during that month.

---

### 5. Update Item Price in Menu

The user can update the price of any item on the menu, thereby changing the value charged to the customer in new orders.

#### Example Usage:

- The user selects the item they wish to update, enters the new price, and the system updates the value in the menu.

---

### 6. Remove Item from Menu

Allows the user to remove an item from the menu, making it unavailable for future orders.

#### Example Usage:

- The user selects the item they wish to remove, and the system permanently removes it from the menu.

## Technical resources used

- **Java**: The main programming language used to develop the system.
- **IDE**: Integrated Development Environment, such as IntelliJ IDEA or Eclipse, for writing and debugging code.
- **Git**: Version control system used for source code management.
- **Maven**: Build automation and dependency management tool.

---

# Documentação em Português

# Sistema de Gestão de Pedidos de Restaurante

## Índice

- [Introdução](#introdução)
- [Estrutura do Programa](#estrutura-do-programa)
- [Funcionalidades](#funcionalidades)
  - [1. Adicionar Item ao Menu](#1-adicionar-item-ao-menu)
  - [2. Registar Pedido](#2-registar-pedido)
  - [3. Listar Pedidos por Cliente](#3-listar-pedidos-por-cliente)
  - [4. Listar Pedidos por Mês](#4-listar-pedidos-por-mês)
  - [5. Atualizar Preço de Item no Menu](#5-atualizar-preço-de-item-no-menu)
  - [6. Remover Item do Menu](#6-remover-item-do-menu)
- [Recursos técnicos utilizados](#recursos-técnicos-utilizados)

---

## Introdução

Este sistema foi desenvolvido para gerir o menu de um restaurante e processar os pedidos dos clientes de forma eficiente.
Permite ao utilizador adicionar itens ao menu, registar novos pedidos, listar pedidos por cliente ou por mês, e também gerir o menu ao atualizar ou remover itens.

---

## Estrutura do Programa

O programa está dividido em várias classes principais:

- **`Main.java`**: Controla o fluxo principal da aplicação e interações com o utilizador.
- **`Restaurante.java`**: Responsável por gerir o menu e os pedidos. Esta classe inclui métodos para adicionar itens ao menu, processar pedidos e calcular taxas de entrega.
- **`Pedido.java`**: Representa um pedido de um cliente, incluindo os itens solicitados, detalhes do cliente e cálculo do total do pedido.
- **`ItemMenu.java`**: Classe base para os itens do menu, incluindo `Entrada`, `Sobremesa`, e `PratoPrincipal`.
- **`Entrada.java`, `Sobremesa.java`, `PratoPrincipal.java`**: Classes específicas para cada tipo de item no menu, herdando de `ItemMenu`.

---

## Funcionalidades

### 1. Adicionar Item ao Menu

O utilizador pode adicionar novos itens ao menu, escolhendo entre três categorias:

- **Entrada**: Uma entrada simples com nome e preço.
- **Sobremesa**: Sobremesa com nome e preço.
- **Prato Principal**: Um prato principal que inclui um preço por porção e a quantidade de porções disponíveis.

#### Exemplo de Utilização:

- O utilizador escolhe adicionar um "Prato Principal", introduzindo o nome do prato, o preço por porção e o número de porções disponíveis.

---

### 2. Registar Pedido

O sistema permite registar um novo pedido para um cliente. O utilizador escolhe os itens que o cliente deseja, e o sistema calcula o total com base no preço dos itens e na distância para a entrega (se for o caso).

#### Exemplo de Utilização:

- O utilizador seleciona o cliente e os itens desejados. O sistema verifica se há quantidade disponível (para pratos principais) e calcula o total do pedido incluindo a taxa de entrega, que depende da distância.

---

### 3. Listar Pedidos por Cliente

Permite listar todos os pedidos feitos por um determinado cliente. Isto é útil para consultar o histórico de pedidos de um cliente específico.

#### Exemplo de Utilização:

- O utilizador introduz o nome do cliente, e o sistema devolve uma lista de todos os pedidos feitos por esse cliente, com detalhes de cada pedido.

---

### 4. Listar Pedidos por Mês

Esta funcionalidade permite listar os pedidos registados num determinado mês. Os pedidos são filtrados com base na data de criação.

#### Exemplo de Utilização:

- O utilizador insere o mês desejado (por exemplo, "05" para maio), e o sistema lista todos os pedidos feitos nesse mês.

---

### 5. Atualizar Preço de Item no Menu

O utilizador pode atualizar o preço de qualquer item do menu, modificando assim o valor cobrado ao cliente em novos pedidos.

#### Exemplo de Utilização:

- O utilizador escolhe o item que deseja atualizar, insere o novo preço, e o sistema atualiza o valor no menu.

---

### 6. Remover Item do Menu

Permite ao utilizador remover um item do menu, tornando-o indisponível para futuros pedidos.

#### Exemplo de Utilização:

- O utilizador seleciona o item que deseja remover, e o sistema o retira permanentemente do menu.

# Recursos técnicos utilizados

- **Java**: Linguagem de programação principal utilizada para desenvolver o sistema.
- **IDE**: Ambiente de Desenvolvimento Integrado, como IntelliJ IDEA ou Eclipse, para a escrita e depuração do código.
- **Git**: Sistema de controlo de versões utilizado para gestão do código fonte.
- **Maven**: Ferramenta de automação de compilação e gestão de dependências.