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
    
    //Gera a media dos Clientes com total maior que 560, ID entre 1500 e 2700 e ativos
    public void mediaCliente560() throws SQLException{
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        Double total = 0.0;
        int nrClientesValidos = 0;
        
        clientes = dao.lista();
        clientes = listaClientesValidosTotal560(clientes);
        clientes = listaClientesValidosAtivo(clientes);
        clientes = listaClientesValidosTotal560(clientes);
        clientes = listaClientesValidosIDMenor2700(clientes);
        clientes = listaClientesValidosIDMaior1500(clientes);
        clientes = ordenarMenorMaior(clientes);
       
        
        for(Cliente c : clientes){
            total = total + c.getTotal();
            nrClientesValidos++;
        }
        if(nrClientesValidos == 0){
            System.out.println("Media: 0");
            System.out.println("Não há clientes validos: 0");
        } else{
            System.out.println("Media:" + total/nrClientesValidos);
            System.out.println();
            imprimeClientesValidos560(clientes);
        }

    }
    
    //Remove os clientes que não tem total maior 560
    public List<Cliente> listaClientesValidosTotal560(List<Cliente> clientes) throws SQLException{
        List<Cliente> helper = new ArrayList<Cliente>();
        
        for(Cliente c : clientes){
            if(c.getTotal() > 560){
                helper.add(c);
            }
        }
        return helper;
    }
    
    //Remove os clientes que não tem ID maior que 1500
    public List<Cliente> listaClientesValidosIDMaior1500(List<Cliente> clientes) throws SQLException{
        List<Cliente> helper = new ArrayList<Cliente>();
        for(Cliente c : clientes){
            if(c.getId() > 1500){
                helper.add(c);
            }
        }
        return helper;
    }
    
    //Remove os clientes que não tem ID menor que 2700
    public List<Cliente> listaClientesValidosIDMenor2700(List<Cliente> clientes) throws SQLException{
        List<Cliente> helper = new ArrayList<Cliente>();
        for(Cliente c : clientes){
            if(c.getId() < 2700){
                helper.add(c);
            }
        }
        return helper;
    }
    
    //Remove os clientes que não estao ativos
    public List<Cliente> listaClientesValidosAtivo(List<Cliente> clientes) throws SQLException{
        List<Cliente> helper = new ArrayList<Cliente>();
        for(Cliente c : clientes){
            if(c.getAtivo() == true){
                helper.add(c);
            }
        }
        return helper;
    }
    
    //Imprime os clientes utilizados na obtencao da media
    public void imprimeClientesValidos560(List<Cliente> clientes) throws SQLException{
         
         for(Cliente c : clientes){
             System.out.println("Id:" + c.getId());
             System.out.println("CPF/CNPJ:" + c.getCpf_cnpj());
             System.out.println("Nome Cliente:" + c.getNome());
             System.out.println("Ativo:" + c.getAtivo());
             System.out.println("Total:" + c.getTotal());
             System.out.println();
         }
    }
    
    //Ordena a Lista do Menor Total ao Maior
    public List<Cliente> ordenarMenorMaior(List<Cliente> clientes) {
        Collections.sort(clientes);        
        return clientes;
    }
    
}
