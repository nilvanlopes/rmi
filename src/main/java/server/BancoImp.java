/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author pyulo
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Conta{
	private Double saldo;
        private Integer numerodaconta;
        private String senha;

    public Conta(Double saldo, Integer numerodaconta, String senha) {
        this.saldo = saldo;
        this.numerodaconta = numerodaconta;
        this.senha = senha;
    }

    protected Double getSaldo() {
        return saldo;
    }

    protected void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    protected Integer getNumerodaconta() {
        return numerodaconta;
    }

    protected String getSenha() {
        return senha;
    }

    protected void setSenha(String senha) {
        this.senha = senha;
    }
    
        

}

public class BancoImp implements Banco{

    private ArrayList<Conta> contas;
    private Conta ContaLogada;

    public BancoImp() throws RemoteException {
        this.contas = new ArrayList();
        this.ContaLogada = null;
    }
    
    @Override
    public void cria(String senha) throws RemoteException {
        Conta acc = new Conta(0.0, contas.size(), senha);
        contas.add(acc);
        System.out.println("Conta Número : "+acc.getNumerodaconta()+"criada");
    }
    
    @Override
    public void logar(int numerodaconta, String senha) throws RemoteException {
        
        for (Conta conta: contas) {
            if(conta.getNumerodaconta()==numerodaconta && conta.getSenha()==senha){
            ContaLogada = conta;
            return;
            }
        }  
        System.out.println("Número da Conta ou senha incorretos");
    }

    @Override
    public void depositar(double valor,int numerodaconta) throws RemoteException {
         for (Conta conta: contas) {
            if(conta.getNumerodaconta()==numerodaconta){
            conta.setSaldo(conta.getSaldo()+valor);
            return;
            }
        }
        System.out.println("Número da Conta ou senha incorretos");
    }
    
    @Override
    public void depositar(double valor) throws RemoteException {
        if(ContaLogada==null){System.out.println("Realize o Login");return;}
        ContaLogada.setSaldo(ContaLogada.getSaldo()+valor);
    }

    @Override
    public String extrato() throws RemoteException {
        if(ContaLogada==null){return"Realize o Login";}
        return ("Saldo : "+ContaLogada.getSaldo().toString());
    }

    @Override
    public void transferir(int numerodaconta, double valor) throws RemoteException {
        if(ContaLogada==null){System.out.println("Realize o Login");return;}
        for (Conta conta: contas) {
            if(conta.getNumerodaconta()==numerodaconta){
            conta.setSaldo(conta.getSaldo()+valor);
            ContaLogada.setSaldo(ContaLogada.getSaldo()-valor);
            return;
            }
        }  
        System.out.println("Número da Conta ou senha incorretos");
    }

    @Override
    public void sair() throws RemoteException {
       ContaLogada = null;
    }
    
    
}

