package com.oficina;

import com.oficina.model.Cliente;

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
}
