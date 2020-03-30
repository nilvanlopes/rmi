/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author pyu
 */
public class Server {
    public static void main(String[] args) throws Exception{
        
		Chat chat = new ChatImp();
		
		Chat chatStub = (Chat) UnicastRemoteObject.exportObject(chat, 0);
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		registry.rebind("chat", chatStub); 		
		
		System.out.println("Aguardando Requisicao");
    }
}
