/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cassiano
 */
public class AppEletronico {

   public static void main(String[] args){
        
        String nome;
        double inicial;
        Scanner entrada = new Scanner(System.in);
        Random numero = new Random();
        int conta = 1 + numero.nextInt(9999);
    
        
        System.out.println("Cadastrando novo cliente.");
        System.out.print("Ente com seu nome: ");
        nome = entrada.nextLine();
        
        System.out.print("Entre com o valor inicial depositado na conta: ");
        inicial = entrada.nextDouble();
        
        
        Conta minhaConta = new Conta(nome, conta, inicial);
        minhaConta.iniciar();
    }
    
}
    

