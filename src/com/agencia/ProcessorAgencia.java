package com.agencia;

import java.util.ArrayList;
import java.util.Scanner;

public class ProcessorAgencia {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a  FaithBank---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");
        
        int operacao = input.nextInt();
        
        switch(operacao) {
        case 1:
        	criarConta();
        	break;
        case 2:
        	depositar();
        	break;
        case 3:
        	sacar();
        	break;
        case 4:
        	transferir();
        	break;
        case 5:
        	listarContas();
        	break;
        case 6:
        	System.out.println("Obrigado pelos serviços");
        	System.exit(0);
        	break;
        default:
        	System.out.println("Opcao inválida!");
        	operacoes();
        	break;
        }
        
	}
	
	public static void criarConta() {
		
		System.out.println("\nNome: ");
		String nome = input.next();
		
		System.out.println("\nCPF: ");
		String cpf = input.next();

		System.out.println("\nE-mail: ");
		String email = input.next();	
		
		Usuario usuario = new Usuario(nome, cpf, email);
		
		Conta conta = new Conta(usuario);
		
		contasBancarias.add(conta);
		System.out.println("Conta criada com sucesso!");
		
		operacoes();
	}
	
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					conta = c;									
				}
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Número da conta para depósito: ");
		int numeroContaDeposito = input.nextInt();
		
		Conta conta = encontrarConta(numeroContaDeposito);
		
		if(conta != null) {
			System.out.println("Informe o valor para depósito: ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
		}else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();		
	}
	
	public static void sacar() {
		System.out.println("Número da conta para depósito: ");
		int numeroContaSaque = input.nextInt();
		
		Conta conta = encontrarConta(numeroContaSaque);
		
		if(conta != null) {
			System.out.println("Informe o valor para saque: ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
		}else {
			System.out.println("Conta não encontrada");
		}
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Número da conta do remetente: ");
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemente = encontrarConta(numeroContaRemetente);
		
		if(contaRemente != null) {
			System.out.println("Número da conta do destinatário: ");
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Informe o valor da transferência: ");
				Double valor = input.nextDouble();
				
				contaRemente.transferir(contaDestinatario, valor);
			}else {
				System.out.println("A conta para transferência não foi encontrada!");
			}
		}else {
			System.out.println("A conta para transferência não foi encontrada!");
		}
		operacoes();
	}
	
	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
		}else {
			System.out.println("Não existem contas cadastradas!");
		}
		operacoes();
	}
	
}
