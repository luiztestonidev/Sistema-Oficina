package com.oficina;

import com.oficina.model.Cliente;
import com.oficina.model.OrdemServico;
import com.oficina.model.StatusOrdemServico;
import com.oficina.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaOficina {

    private final Scanner sc;
    private final List<Cliente> clientes;
    private int proximoNumeroOs;

    public SistemaOficina() {
        this.sc = new Scanner(System.in);
        this.clientes = new ArrayList<>();
        this.proximoNumeroOs = 1;
    }

    public void iniciar() {

        int opcao = 0;

        do {
            exibirMenu();
            opcao = lerOpcaoValida(7)

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
                case 7:
                    alterarStatusOrdemServico();
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
        System.out.println("7 - Alterar status da OS");
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

    private int lerOpcaoValida(int limiteMaximo) {

        while (true) {

            try {
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao >= 1 && opcao <= limiteMaximo) {
                    return opcao;
                }

                System.out.print("Opcao invalida. Tente novamente: ");

            } catch (Exception e) {
                System.out.print("Digite apenas numeros: ");
                sc.nextLine();
            }
        }
    }

    private void cadastrarCliente() {

        exibirTitulo("CADASTRO DE CLIENTE");

        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone);
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

            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
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
        int clienteVeiculo = lerOpcaoValida(clientes.size());

        Cliente clienteEscolhido = clientes.get(clienteVeiculo - 1);

        System.out.print("Digite a placa do veiculo: ");
        String placa = sc.nextLine();

        System.out.print("Digite a marca do veiculo: ");
        String marca = sc.nextLine();

        System.out.print("Digite o modelo do veiculo: ");
        String modelo = sc.nextLine();

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
        int clienteIndex = lerOpcaoValida(clientes.size());

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
        int veiculoIndex = lerOpcaoValida(veiculos.size());

        Veiculo veiculo = veiculos.get(veiculoIndex - 1);

        System.out.print("Descricao: ");
        String descricao = sc.nextLine();

        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        OrdemServico os = new OrdemServico(proximoNumeroOs++, veiculo, descricao, valor, StatusOrdemServico.ABERTA);
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
            System.out.println(i + 1 + " - " + clientes.get(i).getNome());
        }

        System.out.print("Escolha o cliente: ");
        int clienteIndex = lerOpcaoValida(clientes.size());

        Cliente cliente = clientes.get(clienteIndex - 1);

        System.out.println("\nCliente: " + cliente.getNome());

        if (cliente.getVeiculos().isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado!");
            return;
        }

        for (Veiculo veiculo : cliente.getVeiculos()) {

            System.out.println("\nDados do veiculo:");
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Ano de fabricacao: " + veiculo.getAnoFabricacao());

            if (veiculo.getOrdensServicos().isEmpty()) {
                System.out.println("Nenhuma OS cadastrada!");
                continue;
            }

            for (OrdemServico ordemServico : veiculo.getOrdensServicos()) {
                System.out.println("\nOS #" + ordemServico.getNumero());
                System.out.println("Descricao: " + ordemServico.getDescricao());
                System.out.printf("Valor: R$ %.2f%n", ordemServico.getValor());
                System.out.println("Status: " + ordemServico.getStatus());
            }
        }
    }

    private void alterarStatusOrdemServico() {

        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado!");
            return;
        }

        exibirTitulo("ALTERAR STATUS DE ORDEM DE SERVICO");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i).getNome());
        }

        System.out.print("Escolha o cliente: ");
        int clienteIndex = lerOpcaoValida(clientes.size());

        Cliente cliente = clientes.get(clienteIndex - 1);

        if (cliente.getVeiculos().isEmpty()) {
            System.out.println("Nenhum veículo cadastrado para este cliente!");
            return;
        }

        System.out.println("\nVeículos do cliente:");

        List<Veiculo> veiculos = cliente.getVeiculos();

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);

            System.out.println((i + 1) + " - " + veiculo.getPlaca() + " | " + veiculo.getModelo());
        }

        System.out.print("Escolha o veículo: ");
        int veiculoIndex = lerOpcaoValida(veiculos.size());

        Veiculo veiculo = veiculos.get(veiculoIndex - 1);

        if (veiculo.getOrdensServicos().isEmpty()) {
            System.out.println("Nenhuma OS cadastrada para este veículo!");
            return;
        }

        List<OrdemServico> ordensServicos = veiculo.getOrdensServicos();

        System.out.println("\nOrdens de Serviço:");

        for (int i = 0; i < ordensServicos.size(); i++) {

            OrdemServico ordemServico = ordensServicos.get(i);

            System.out.println((i + 1) + " - OS #" + ordemServico.getNumero() + " | " + ordemServico.getStatus());
        }

        System.out.print("Escolha a OS: ");
        int ordemServicoIndex = lerOpcaoValida(ordensServicos.size());

        OrdemServico ordemServico = ordensServicos.get(ordemServicoIndex - 1);

        System.out.println("\n1 - ABERTA");
        System.out.println("2 - EM_ANDAMENTO");
        System.out.println("3 - FINALIZADA");

        System.out.print("Novo status: ");
        int opcaoStatus = lerOpcaoValida(3);

        switch (opcaoStatus) {
            case 1:
                ordemServico.setStatus(StatusOrdemServico.ABERTA);
                break;
            case 2:
                ordemServico.setStatus(StatusOrdemServico.EM_ANDAMENTO);
                break;
            case 3:
                ordemServico.setStatus(StatusOrdemServico.FINALIZADA);
                break;
        }

        System.out.println("\nStatus da OS #" + ordemServico.getNumero() + " alterado para " + ordemServico.getStatus());
    }
}