/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.valemobi.action;

import br.com.valemobi.entities.Cliente;
import br.com.valemobi.entities.DAO.ClienteDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mauri
 */
public class AdicionaClienteAction {
    
    private ClienteDao dao;
    
    public AdicionaClienteAction(ClienteDao dao){
        this.dao = dao;
    }

    public AdicionaClienteAction() {
        
    }
    public void adicionaClientesBanco(List<Cliente> listaCliente) throws SQLException{
        ClienteDao dao = new ClienteDao();
        for(Cliente c : listaCliente){
            dao.adiciona(c);
        }
        
    }
    
    public void incrementaListaCliente(List<Cliente> listaCliente, Cliente c){
        listaCliente.add(c);
    }
    
    public void mediaCliente560() throws SQLException{
        
        List<Cliente> helper = new ArrayList<Cliente>();
        Double total = 0.0;
        int nrClientesValidos = 0;
        
        helper = listaClientesValidos560(helper);
        
        for(Cliente c : helper){
            total = total + c.getTotal();
            nrClientesValidos++;
        }
        if(nrClientesValidos == 0){
            System.out.println("Media: 0");
            System.out.println("Não há clientes validos: 0");
        }
        System.out.println("Media:" + total/nrClientesValidos);
    }
    
    public List<Cliente> listaClientesValidos560(List<Cliente> clientes) throws SQLException{
        List<Cliente> helper = new ArrayList<Cliente>();
        
        helper = dao.lista();
        for(Cliente c : helper){
            if(c.getTotal() > 560 && c.getId() > 1500 && c.getId() < 2700 && c.getAtivo() == true ){
                clientes.add(c);
            }
        }
        return clientes;
    }
    
    public void imprimeClientesValidos560() throws SQLException{
         List<Cliente> clientes = new ArrayList<Cliente>();
         clientes = listaClientesValidos560(clientes);
         clientes = ordenarMenorMaior(clientes);
         for(Cliente c : clientes){
             System.out.println("Id:" + c.getId());
             System.out.println("CPF/CNPJ:" + c.getCpf_cnpj());
             System.out.println("Nome Cliente:" + c.getNome());
             System.out.println("Ativo:" + c.getAtivo());
             System.out.println("Total:" + c.getTotal());
             System.out.println();
         }
    }
    
    public List<Cliente> ordenarMenorMaior(List<Cliente> clientes) {
        Collections.sort(clientes);        
        return clientes;
    }
    
}
