package com.oficina.model;

public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private Cliente cliente;

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao,  Cliente cliente) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cliente = cliente;
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
