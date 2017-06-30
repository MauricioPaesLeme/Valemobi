/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.valemobi;

import br.com.valemobi.action.AdicionaClienteAction;
import br.com.valemobi.entities.Cliente;
import br.com.valemobi.entities.DAO.ClienteDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mauri
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        
        int opcao;
        Cliente cliente = new Cliente();
        ClienteDao dao = new ClienteDao();
        AdicionaClienteAction clienteAction = new AdicionaClienteAction(dao);
        Scanner sc1 = new Scanner(System.in);
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        
        do{
   
            System.out.print("Digite o nome dele:");
            cliente.setNome(sc1.next());
            System.out.print("Digite o cpf/cnpj:");
            cliente.setCpf_cnpj(sc1.nextInt());
            System.out.print("Digite o quanto de saldo ele tem:");
            cliente.setTotal(sc1.nextDouble()); 
            clienteAction.incrementaListaCliente(listaCliente, cliente);
            
            System.out.println("Deseja acrescentar mais um cliente?(1 para sim, 0 para terminar)");
            opcao = sc1.nextInt();
        }while(opcao!=0);
        
        clienteAction.adicionaClientesBanco(listaCliente);
        clienteAction.mediaCliente560();
        clienteAction.imprimeClientesValidos560();
        

        
    }
    
}
