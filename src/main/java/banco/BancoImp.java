/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author pyulo
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

class Conta{
	private double saldo;
        private final int numerodaconta;
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

    private final ArrayList<Conta> contas;
    private Conta ContaLogada;

    public BancoImp() throws RemoteException {
        this.contas = new ArrayList();
        this.ContaLogada = null;
    }
    
    @Override
    public String cria(String senha) throws RemoteException {
        Conta acc = new Conta(0.0, contas.size(), senha);
        contas.add(acc);
        return ("Conta Número : "+acc.getNumerodaconta()+" criada\n");
    }
    
    @Override
    public String logar(int numerodaconta, String senha) throws RemoteException {
        int n = contas.size();
        int i;
        for (i=0; i<n; i++) {
            if(contas.get(i).getNumerodaconta()==numerodaconta && contas.get(i).getSenha().equals(senha)){
            ContaLogada = contas.get(i);
            return "Login Completo\n";
            }
        }  
       return ("Número da Conta ou senha incorretos\n");
    }

    @Override
    public String depositar(double valor,int numerodaconta) throws RemoteException {
         for (Conta conta: contas) {
            if(conta.getNumerodaconta()==numerodaconta){
            conta.setSaldo(conta.getSaldo()+valor);
            return "Deposito Realizado\n";
            }
        }
        return "Número da Conta ou senha incorretos\n";
    }
    
    @Override
    public String depositar(double valor) throws RemoteException {
        if(ContaLogada==null){return "Realize o Login\n";}
        ContaLogada.setSaldo(ContaLogada.getSaldo()+valor);
        return "Depósito Realizado\n";
    }

    @Override
    public String extrato() throws RemoteException {
        if(ContaLogada==null){return"Realize o Login\n";}
        return ("Saldo : "+ContaLogada.getSaldo().toString());
    }

    @Override
    public String transferir(int numerodaconta, double valor) throws RemoteException {
        if(ContaLogada==null){return "Realize o Login\n";}
        for (Conta conta: contas) {
            if(conta.getNumerodaconta()==numerodaconta){
            conta.setSaldo(conta.getSaldo()+valor);
            ContaLogada.setSaldo(ContaLogada.getSaldo()-valor);
            return "Transferencia Realizada\n";
            }
        }  
        return "Número da Conta ou senha incorretos\n";
    }

    @Override
    public String sair() throws RemoteException {
       ContaLogada = null;
       return "BYE\n";
    }
    
    
}

