/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author pyulo
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banco extends Remote{
	
        void cria(String senha) throws RemoteException;
        
        void logar(int numerodaconta, String senha) throws RemoteException;
        
        void sair()throws RemoteException;
    
	void depositar(double valor, int numerodaconta) throws RemoteException;

        void depositar(double valor) throws RemoteException;
	
	String extrato() throws RemoteException;
        
        void transferir(int numerodaconta, double valor) throws RemoteException; 
}
