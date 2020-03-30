/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.rmi.Naming;

/**
 *
 * @author pyu
 */
public class Client {
    public static void main(String[] args) throws Exception{
         Acc a = ((Acc) Naming.lookup("rmi://127.0.0.1:1099/acc"));
         a.create();
    }
   
    
}
