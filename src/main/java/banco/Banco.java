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
import java.rmi.Remote;
import java.rmi.RemoteException;

    public interface Banco extends Remote{
	
        String cria(String senha) throws RemoteException;
        
        String logar(int numerodaconta, String senha) throws RemoteException;
        
        String sair() throws RemoteException;
    
	String depositar(double valor, int numerodaconta) throws RemoteException;

        String depositar(double valor) throws RemoteException;
	
	String extrato() throws RemoteException;
        
        String transferir(int numerodaconta, double valor) throws RemoteException; 
}
