package com.oficina;

import com.oficina.model.Cliente;
import com.oficina.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaOficina {

    private Scanner sc;
    private List<Cliente> clientes;

    public SistemaOficina() {
        this.sc = new Scanner(System.in);
        this.clientes = new ArrayList<>();
    }

    public void iniciar() {

        int opcao = 0;

        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    cadastrarVeiculo();
                    break;
                case 4:
                    listarVeiculos();
                    break;
                case 0:
                    System.out.println("\nEncerrando sistema...");
                    break;
                    
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {

        System.out.println("\n=== Oficina ===");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Cadastrar veiculo");
        System.out.println("4 - Listar veiculos");
        System.out.println("0 - Sair");
        System.out.print("Opcao: ");

    }

    private void cadastrarCliente() {

        System.out.print("\nNome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Cliente cliente = new Cliente(nome,cpf,telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        for (Cliente cliente : clientes) {

            System.out.println("\nNome do cliente: " + cliente.getNome());
            System.out.println("CPF do cliente: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
        }
    }

    private void cadastrarVeiculo() {

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        System.out.println("\nClientes cadastrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + 1 + " - " + clientes.get(i).getNome());
        }

        System.out.print("Escolha o cliente: ");
        int clienteVeiculo = sc.nextInt();
        sc.nextLine();

        Cliente clienteEscolhido = clientes.get(clienteVeiculo - 1);

        System.out.print("Digite a placa do veiculo: ");
        String placa = sc.nextLine();

        System.out.print("Digite a marca do veiculo: ");
        String marca =  sc.nextLine();

        System.out.print("Digite a modelo do veiculo: ");
        String modelo =  sc.nextLine();

        System.out.print("Digite a ano de fabricacao do veiculo: ");
        int anoFabricacao = sc.nextInt();
        sc.nextLine();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao, clienteEscolhido);
        clienteEscolhido.adicionarVeiculo(veiculo);
        System.out.println("Veiculo cadastrado com sucesso!");

    }

    private void listarVeiculos() {

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println("\nNome cliente: " + cliente.getNome());

            if (cliente.getVeiculos().isEmpty()) {
                System.out.println("Nenhum veiculo cadastrado!");
            }

            for (Veiculo veiculo : cliente.getVeiculos()) {
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Ano: " + veiculo.getAnoFabricacao());
            }
        }
    }
}
