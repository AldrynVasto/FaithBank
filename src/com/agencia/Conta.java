package com.agencia;

import com.agencia.util.AgenciaUtil;

public class Conta {

	private static int contadorDeNumeroContas = 1;
	
	private int numeroConta;
	private Usuario usuario;
	private Double saldo = 0.0;
	
	public Conta(Usuario usuario) {
		this.numeroConta = contadorDeNumeroContas;
		this.usuario = usuario;
		contadorDeNumeroContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return  "\nNúmero da conta: " + this.getNumeroConta() +
				"\nNome: " + this.usuario.getNome() +
				"\nCPF: " + this.usuario.getCPF() +
				"\nE-mail: " + this.usuario.getEmail() +
				"\nSaldo: " + AgenciaUtil.doubleToString(this.getSaldo()) +
				"\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Depósito realizado com sucesso!");
		}else {
			System.out.println("Não foi possível realizar o depósito!");			
		}	
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		}else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	
	public void transferir(Conta contaDeposito, Double valorTransferencia) {
		if(valorTransferencia > 0 && this.getSaldo() >= valorTransferencia) {
			setSaldo(getSaldo() - valorTransferencia);
			contaDeposito.saldo = contaDeposito.getSaldo() + valorTransferencia;
			System.out.println("Transferência realizada com sucesso!");
		}else {
			System.out.println("Não foi possível realizar a transferência!");
		}
	}
			
}
