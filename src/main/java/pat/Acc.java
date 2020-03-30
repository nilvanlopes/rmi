/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pyu
 */
public interface Acc extends Remote{
    void create() throws RemoteException;
}
