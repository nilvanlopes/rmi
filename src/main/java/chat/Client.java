/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author pyu
 */
public class Client {
    public static void main(String[] args) throws Exception,RemoteException{
        Scanner read = new Scanner(System.in);
        Chat chat = ((Chat) Naming.lookup("rmi://127.0.0.1:1099/chat"));
        String username;
        String message;
        System.out.print("Digite seu nome de usuário : ");
        username = read.nextLine();
        chat.singIn(username);
        
        Runnable updateLog = () -> {
            try {
            while(true){
                Runtime.getRuntime().exec("clear");
                if(chat.isUpdated(username)==false){
                System.out.println(chat.updateChat(username));       }
                
                    }
                } 
            catch (RemoteException ex) {System.out.println("No server");}
            catch (IOException e){System.out.println("erro na limpeza");}
        
        };
        new Thread(updateLog).start();
        
        while(true){
        message = read.nextLine();
        chat.sendMsg(message, username);
        }

    }    
}
