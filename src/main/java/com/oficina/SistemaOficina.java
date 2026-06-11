package com.oficina;

import com.oficina.model.Cliente;
import com.oficina.model.OrdemServico;
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
                case 5:
                    criarOrdemServico();
                    break;
                case 6:
                    listarOrdemServico();
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
        System.out.println("5 - Criar ordem de servico");
        System.out.println("6 - Listar ordem de servico");
        System.out.println("0 - Sair");
        System.out.print("Opcao: ");

    }

    private void exibirTitulo(String titulo) {

        int largura = 40;

        System.out.println();
        System.out.println("=".repeat(largura));

        int espacos = (largura - titulo.length()) / 2;
        System.out.println(" ".repeat(espacos) + titulo);

        System.out.println("=".repeat(largura));
        System.out.println();
    }

    private void cadastrarCliente() {

        exibirTitulo("CADASTRO DE CLIENTE");

        System.out.print("Nome do cliente: ");
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

        exibirTitulo("LISTA DE CLIENTES");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }

        for (Cliente cliente : clientes) {

            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("CPF do cliente: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println();
        }
    }

    private void cadastrarVeiculo() {

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        exibirTitulo("CADASTRO DE VEICULOS");

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

        System.out.print("Digite o modelo do veiculo: ");
        String modelo =  sc.nextLine();

        System.out.print("Digite o ano de fabricacao do veiculo: ");
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

        exibirTitulo("LISTA DE VEICULOS");

        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNome());

            if (cliente.getVeiculos().isEmpty()) {
                System.out.println("Nenhum veiculo cadastrado!");
            }

            for (Veiculo veiculo : cliente.getVeiculos()) {
                System.out.println("\nDados do veiculo de(a) " + cliente.getNome());
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Ano: " + veiculo.getAnoFabricacao());
                System.out.println();
            }
        }
    }

    private void criarOrdemServico() {

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        exibirTitulo("CRIAR ORDEM DE SERVICO");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + 1 + " - " + clientes.get(i).getNome());
        }

        System.out.print("Escolha o cliente: ");
        int clienteIndex = sc.nextInt();
        sc.nextLine();

        Cliente cliente = clientes.get(clienteIndex - 1);

        if (cliente.getVeiculos().isEmpty()) {
            System.out.println("Esse cliente nao possui veiculos!");
            return;
        }

        List<Veiculo> veiculos = cliente.getVeiculos();

        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(i + 1 + " - " + veiculos.get(i).getPlaca() + " | " + veiculos.get(i).getModelo());
        }

        System.out.print("Escolha o veiculo: ");
        int veiculoIndex = sc.nextInt();
        sc.nextLine();

        Veiculo veiculo = veiculos.get(veiculoIndex - 1);

        System.out.print("Descricao: ");
        String descricao = sc.nextLine();

        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        OrdemServico os = new OrdemServico ((int)(Math.random() * 1000), veiculo, descricao, valor, "ABERTA") ;
        veiculo.adicionarOrdemServico(os);
        System.out.println("Ordem de servico criada com sucesso!");
    }

    private void listarOrdemServico() {

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        exibirTitulo("LISTA DE ORDEM DE SERVICO");

        for (int i = 0; i < clientes.size(); i++) {

            Cliente cliente = clientes.get(i);
                System.out.println(i + 1 + " - " + clientes.get(i).getNome());

            if (cliente.getVeiculos().isEmpty()) {
                System.out.println("Nenhum veiculo cadastrado!\n");
                continue;
            }

            for (Veiculo veiculo : cliente.getVeiculos()) {
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Ano de fabricacao: " + veiculo.getAnoFabricacao());

                if (veiculo.getOrdensServicos().isEmpty()) {
                    System.out.println("Nenhuma OS cadastrada!\n");
                    continue;
                }

                for (OrdemServico ordemServico : veiculo.getOrdensServicos()) {
                    System.out.println("\nOS #" + ordemServico.getNumero());
                    System.out.println("Descricao: " + ordemServico.getDescricao());
                    System.out.printf("Valor: R$ %.2f%n" , ordemServico.getValor());
                    System.out.println("Status: " + ordemServico.getStatus());
                }
            }
        }
    }
}
