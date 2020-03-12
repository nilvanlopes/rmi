/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.rmi.Naming;
import java.util.Scanner;
/**
 *
 * @author pyulo
 */
public class Client {
 
	public static void main(String args[]) throws Exception{
                Scanner ler = new Scanner(System.in);
		Banco banco = ((Banco) Naming.lookup("rmi://127.0.0.1:1099/banco"));
		int numeroconta;
                double valor;
                String senha;
                int op=10;
                
              
                while(op!=0){  
                System.out.println("Escolha uma Opção");
                System.out.println("1- Realizar depósito em conta");
                System.out.println("2- Acessar sua Conta");
                System.out.println("3- Criar Conta");
                System.out.println("0- Sair");
                System.out.print("---> ");
                op = ler.nextInt();
                
                switch (op) {
                case 1:{
                    System.out.print("Digite o numero da conta : ");
                    numeroconta = ler.nextInt();
                    System.out.print("Digite o valor a ser depositado : ");
                    valor = ler.nextDouble();
                    banco.depositar(valor, numeroconta);
                    break;}
                case 2 :{
                    System.out.print("Digite o numero da Conta : ");
                    numeroconta = ler.nextInt();
                    System.out.print("Digite a senha : ");
                    senha = ler.next();
                    System.out.println(banco.logar(numeroconta, senha));
                    while(op!=11){
                            System.out.println("Escolha uma Opção");
                            System.out.println("1- Realizar depósito em conta");
                            System.out.println("2- Ver seu Saldo");
                            System.out.println("3- Realizar Transferencia");
                            System.out.println("0- Sair");
                            System.out.print("---> ");
                            op = ler.nextInt();
                    switch (op) {
                        case 1:
                            System.out.print("Digite o valor a ser depositado : ");
                            valor = ler.nextDouble();
                            System.out.println(banco.depositar(valor));
                            break;
                        case 2:
                            System.out.println(banco.extrato());
                            break;
                        case 3:
                            System.out.print("Digite o numero da conta : ");
                            numeroconta = ler.nextInt();
                            System.out.print("Digite o valor a ser depositado : ");
                            valor = ler.nextDouble();
                            System.out.println(banco.transferir(numeroconta, valor));
                            break;
                        default:
                            System.out.println(banco.sair());
                            op=11;
                            break;
                    }
                    }
                        break;}
                case 3 :{ 
                    System.out.print("Digite a senha : ");
                    senha = ler.next();
                    System.out.println(banco.cria(senha));
                    break;
                        }
                
                case 0 : {
                    op=0;
                    break;
                }
                
                default:
                    System.out.println("Opção inválida");
            }
          }
	}
	

}
