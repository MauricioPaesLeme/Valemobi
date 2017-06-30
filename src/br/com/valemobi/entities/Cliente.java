/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.valemobi.entities;

/**
 *
 * @author mauri
 */
public class  Cliente implements Comparable<Cliente> {
    private int id;
    private String nome;
    private int cpf_cnpj;
    private boolean ativo;
    private Double total;
    
   
    public Cliente(){
        
    }
    
    public Cliente(int id, String nome, int cpf_cnpj, boolean ativo, Double total){
        this.id = id;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.ativo = ativo;
        this.total = total;
        
    }
    
    public int getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getCpf_cnpj(){
        return cpf_cnpj;
    }
 
    public boolean getAtivo(){
        return ativo;
    }
    
    public Double getTotal(){
        return total;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCpf_cnpj(int cpf_cnpj){
        this.cpf_cnpj = cpf_cnpj;
    }
    
    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    
    public void setTotal(Double total){
        this.total = total;
    }
    
    public int compareTo(Cliente outroCliente) {
        if (this.total < outroCliente.total) {
            return -1;
        }
        if (this.total > outroCliente.total) {
            return 1;
        }
        return 0;
    }
    
}
