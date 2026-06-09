package com.oficina;

import com.oficina.model.Cliente;
import com.oficina.model.Veiculo;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Joao","12345678900","47999999999");
        Veiculo v1 = new Veiculo("AAA-111","VW","Gol",2000,cliente);
        Veiculo v2 = new Veiculo("BBB-222","FIAT","Uno",2001,cliente);

        cliente.adicionarVeiculo(v1);
        cliente.adicionarVeiculo(v2);

        System.out.println("\nCliente: " + cliente.getNome());
        System.out.println("\nVeiculos:");

        for(Veiculo v : cliente.getVeiculos()){
            System.out.println("- " + v.getModelo());
        }
    }
}
