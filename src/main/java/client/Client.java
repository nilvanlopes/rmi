/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.rmi.Naming;
import java.util.Scanner;
/**
 *
 * @author pyulo
 */
public class Client {
 
	public static void main(String args[]) throws Exception{
                Scanner ler = new Scanner(System.in);
		Banco banco = (Banco) Naming.lookup("rmi://127.0.0.1:1099/banco");
		int numeroconta;
                double valor;
                String senha;
                int op=0;
                
                System.out.println("Escolha uma Opção\n");
                System.out.println("1- Realizar depósito em conta\n");
                System.out.println("2- Acessar sua Conta\n");
                op = ler.nextInt();
                switch (op) {
                case 1:
                    System.out.println("Digite o numero da conta : ");
                    numeroconta = ler.nextInt();
                    System.out.println("Digite o valor a ser depositado : ");
                    valor = ler.nextDouble();
                    banco.depositar(valor, numeroconta);
                    break;
                case 2 :
                    System.out.println("Digite o numero da Conta : ");
                    numeroconta = ler.nextInt();
                    System.out.println("Digite a senha : ");
                    senha = ler.next();
                    banco.logar(numeroconta, senha);
                        while(op!=0){
                            System.out.println("Escolha uma Opção\n");
                            System.out.println("1- Realizar depósito em conta\n");
                            System.out.println("2- Ver seu Saldo\n");
                            System.out.println("3- Realizar Transferencia\n");
                            System.out.println("0- Sair\n");
                            op = ler.nextInt();
                            if(op==1){
                            System.out.println("Digite o valor a ser depositado : ");
                            valor = ler.nextDouble();
                            banco.depositar(valor);}
                            else if(op==2){
                            System.out.println(banco.extrato());
                            }
                            else if(op==3){
                            System.out.println("Digite o numero da conta : ");
                            numeroconta = ler.nextInt();
                            System.out.println("Digite o valor a ser depositado : ");
                            valor = ler.nextDouble();
                            banco.transferir(numeroconta, valor);
                            }
                            else{
                            banco.sair();
                            op=0;
                            }
                        }
                default:
                    throw new AssertionError();
            }
	}
	

}
