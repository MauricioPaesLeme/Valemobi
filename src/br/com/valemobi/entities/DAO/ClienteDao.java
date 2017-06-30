/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.valemobi.entities.DAO;

import br.com.valemobi.ConnectionFactory;
import br.com.valemobi.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



/**
 *
 * @author mauri
 */

public class ClienteDao {
    
    private final Connection conexao;
    

    public ClienteDao() throws SQLException{
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Cliente c) throws SQLException{
        ClienteDao dao = new ClienteDao();
        int id = ultimoClienteAdicionado();
        id++;
        String sql = "insert into tb_customer_account " +
                "(id_customer,cpf_cnpj,nm_customer,is_active,vl_total) " +
                "values (?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, c.getCpf_cnpj());
            stmt.setString(3, c.getNome());
            stmt.setBoolean(4, c.getAtivo());
            stmt.setDouble(5, c.getTotal());
            
            stmt.execute();
        }catch(SQLException e) {
            throw new RuntimeException(e);
            }                 
        
    }
   
    public List<Cliente> lista() throws SQLException {
	List<Cliente> cliente = new ArrayList<Cliente>();	
        PreparedStatement stmt = this.conexao
					.prepareStatement("select * from tb_customer_account");
        try {
			
			

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona o cliente na lista
				cliente.add(populaLista(rs));
			}

			rs.close();
			stmt.close();

			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
    public Cliente populaLista(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();

		// popula o objeto cliente
		cliente.setId(rs.getInt("id_customer"));
                cliente.setCpf_cnpj(rs.getInt("cpf_cnpj"));
		cliente.setNome(rs.getString("nm_customer"));
		cliente.setAtivo(rs.getBoolean("is_active"));
                cliente.setTotal(rs.getDouble("vl_total"));

		
		return cliente;
	}
    
    //Recupera o ultimo ID adicionado pelo sistema
    public int ultimoClienteAdicionado() {
		try {
			List<Cliente> cliente = new ArrayList<Cliente>();
			PreparedStatement stmt = this.conexao
					.prepareStatement("select * from tb_customer_account where id_customer = (select max(ID_customer) from tb_customer_account)");

			ResultSet rs = stmt.executeQuery();
                        

			while (rs.next()) {
				// adiciona o cliente na lista
				cliente.add(populaLista(rs));
			}

			rs.close();
			stmt.close();

			return cliente.get(0).getId();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
