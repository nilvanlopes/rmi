/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pyu
 */
public interface Chat extends Remote{
    
    void sendMsg(String message, String username) throws RemoteException;
    String updateChat(String username) throws RemoteException;
    void singIn(String username) throws RemoteException;
    boolean isUpdated(String username) throws RemoteException;
    
}
