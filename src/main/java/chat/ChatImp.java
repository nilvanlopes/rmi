/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author pyu
 */


class User{

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
    String username;
    boolean updated;
    
    public User(String username, boolean updated) {
        this.username = username;
        this.updated = updated;
    }
   

}


public class ChatImp implements Chat{
    
    private String log;
    private ArrayList<User> users;

    public ChatImp() {
        this.log = "";
        this.users = new ArrayList();
    }
 
    

    @Override
    public void sendMsg(String message, String username) throws RemoteException {
        log = log + "\n" +username+" : "+message;
        int i;
        for(i=0; i<users.size(); i++){
            users.get(i).setUpdated(false);
        }
    }

    @Override
    public String updateChat(String username) throws RemoteException {
        int i;
        for(i=0; i<users.size(); i++){
            if (users.get(i).getUsername().equals(username)) users.get(i).setUpdated(true);
        }
        return log;
    }

    @Override
    public void singIn(String username) throws RemoteException {
       User u = new User(username,false);
       users.add(u);
    }

    @Override
    public boolean isUpdated(String username) throws RemoteException {
        int i;
        for(i=0; i<users.size(); i++){
            if (users.get(i).getUsername().equals(username)&& users.get(i).isUpdated()) return true;
        }
        return false;
    }

    
    
}
