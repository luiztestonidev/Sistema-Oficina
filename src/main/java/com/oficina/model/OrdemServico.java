package com.oficina.model;

public class OrdemServico {

    private final int numero;
    private String descricao;
    private double valor;
    private String status;
    private final Veiculo veiculo;

    public OrdemServico(int numero, Veiculo veiculo, String descricao, double valor, String status) {
        this.numero = numero;
        this.veiculo = veiculo;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
