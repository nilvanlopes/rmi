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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server {
	
	public static void main(String args[])  throws Exception{
		
		Banco banco = new BancoImp();
		
		Banco bancoStub = (Banco) UnicastRemoteObject.exportObject(banco, 0);
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		registry.rebind("banco", bancoStub); 		
		
		System.out.println("Aguardando Requisicao");
		
	}

}
