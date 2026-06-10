package com.oficina.model;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private Cliente cliente;
    private List<OrdemServico> ordensServico;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao,  Cliente cliente) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cliente = cliente;
        this.ordensServico = new ArrayList<>();
    }

    public void adicionarOrdemServico(OrdemServico ordemServico) {
        this.ordensServico.add(ordemServico);
    }

    public List<OrdemServico> getOrdensServicos() {
        return ordensServico;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
