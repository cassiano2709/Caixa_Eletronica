/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Conta {

    private String nome;
    private int conta, saques;
    private double saldo;
    private int valor, n100, n50, n20, n10, cont;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome, int conta, double saldo_inicial) {
        this.nome = nome;
        this.conta = conta;
        saldo = saldo_inicial;
        saques = 0;
        valor = cont = 0;
    }

    public void extrato() {
        
        System.out.println("\tEXTRATO");
        System.out.println("Nome: " + this.nome);
        System.out.println("Número da conta: " + this.conta);
        System.out.printf("Saldo atual: %.2f\n", this.saldo);
        System.out.println("Saques realizados hoje: " + this.saques + "\n");

    }

    public void sacar(int valor) {
        if (valor > 0) {
            n100 = valor / 100;
            int r100 = valor % 100;
            //r100 = r100 % 100;             
            System.out.println("Número de cédulas de R$ 100: " +  n100);

            n50 = r100 / 50;
            int r50 = (int)r100 % 50;
            System.out.println("Número de cédulas de R$ 50: " + n50);

            n20 = r50 / 20;
            int r20 = (int)r50 % 20;
            System.out.println("Número de cédulas de R$ 20: " + n20);

            n10 = r20 / 10;
            int r10 = (int)r20 % 10;
            System.out.println("Número de cédulas de R$ 10: " + n10);
        }
        if (saldo >= valor) {
            saldo -= valor;
            saques++;

            System.out.println("Sacado: " + valor);
            //System.out.println("Cédulas:");
            System.out.println("Novo saldo: " + saldo + "\n");

        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depositado: " + valor);
        System.out.println("Novo saldo: " + saldo + "\n");
    }

    public void iniciar() {
        int opcao;

        do {
            exibeMenu();
            opcao = entrada.nextInt();
            escolheOpcao(opcao);
        } while (opcao != 4);
    }

    public void exibeMenu() {

        System.out.println("\t Escolha a opção desejada");
        System.out.println("1 - Consultar Extrato");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sair\n");
        System.out.print("Opção: ");

    }

    public void escolheOpcao(int opcao) {
        int valor;

        switch (opcao) {
            case 1:
                extrato();
                Date d = new Date();
        
        System.out.println(d.toString());
        
        Calendar c = Calendar.getInstance();
        
        c.setTime(d);
        
        c.add(c.DAY_OF_MONTH, 2);
        
        if(c.SUNDAY == c.get(c.DAY_OF_WEEK))
            
            System.out.println("DOMINGO");
        
        if(c.MONDAY == c.get(c.DAY_OF_WEEK))
            
            System.out.println("SEGUNDA");
        
         if(c.TUESDAY == c.get(c.DAY_OF_WEEK))
             
             System.out.println("TERÇA");
         
         if(c.WEDNESDAY == c.get(c.DAY_OF_WEEK))
             
             System.out.println("QUARTA");
         
         if(c.THURSDAY == c.get(c.DAY_OF_WEEK))
             
             System.out.println("QUINTA");
        
        if(c.FRIDAY == c.get(c.DAY_OF_WEEK))
             System.out.println("SEXTA");
        
                break;
            case 2:
                if (saques < 3) {
                    System.out.print("Quanto deseja sacar: ");
                    valor = entrada.nextInt();
                    sacar(valor);
                } else {
                    System.out.println("Limite de saques diários atingidos.\n");
                }
                break;

            case 3:
                System.out.print("Quanto deseja depositar: ");
                valor = entrada.nextInt();
                depositar(valor);
                break;

            case 4:
                System.out.println("Sistema encerrado.");
                break;

            default:
                System.out.println("Opção inválida");
        }
    }

    boolean sacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
