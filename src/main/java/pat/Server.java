/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author pyu
 */
public class Server {
    
	public static void main(String args[])  throws Exception{
		
		Acc acc = new Accounts();
		
		Acc accStub = (Acc) UnicastRemoteObject.exportObject(acc, 0);
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		registry.rebind("acc", accStub); 		
		
		System.out.println("Aguardando Requisicao");
		
	}
}
