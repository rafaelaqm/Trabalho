/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Cliente;

/**
 *
 * @author wyss2
 */
public class ClienteDAO {
    PreparedStatement pst;
    String sql;
    
    public void salvar(Cliente cliente) throws SQLException{
        sql="insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst=Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, cliente.getNome());
        pst.setString(3, cliente.getRg());
        pst.setString(4, cliente.getCpf());
        pst.setString(5, cliente.getSexo());
        pst.setString(6, cliente.getTelefone());
        pst.setString(7, cliente.getEmail());
        pst.setString(8, cliente.getRua());
        pst.setString(9, cliente.getNumero());
        pst.setString(10, cliente.getComplemento());
        pst.setString(11, cliente.getBairro());
        pst.setString(12, cliente.getCidade());
        pst.setString(13, cliente.getEstado());
        pst.setString(14, cliente.getCep());
        pst.execute();
        pst.close();
    }
    
    public void excluir(Cliente cliente) throws SQLException{
        sql = "delete from cliente where codCliente=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, cliente.getCodigo());
        pst.execute();
        pst.close();
    }
    
    public void alterar(Cliente cliente) throws SQLException{
        sql= "update cliente set Nome=?, Cpf=?, Rg=?, Sexo=?, Telefone=?, Email=?, Rua=?, Numero=?, Complemento=?, Bairro=?, Cidade=?, Estado=?, Cep=? where codCliente=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getCpf());
        pst.setString(3, cliente.getRg());
        pst.setString(4, cliente.getSexo());
        pst.setString(5, cliente.getTelefone());
        pst.setString(6, cliente.getEmail());
        pst.setString(7, cliente.getRua());
        pst.setString(8, cliente.getNumero());
        pst.setString(9, cliente.getComplemento());
        pst.setString(10, cliente.getBairro());
        pst.setString(11, cliente.getCidade());
        pst.setString(12, cliente.getEstado());
        pst.setString(13, cliente.getCep());
        pst.setInt(14, cliente.getCodigo());
        System.out.println(pst);
        pst.execute();
        pst.close();
    }
    
    public List<Cliente> ListaCliente() throws SQLException{
        List<Cliente> listaClientes;
        listaClientes = new ArrayList<>();
        sql="select * from cliente order by nome";
        pst = Conexão.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            listaClientes.add(new Cliente(rs.getInt("codCliente"), rs.getString("Nome"), rs.getString("Telefone"),
            rs.getString("Email"), rs.getString("Cidade"), rs.getString("Estado")));
        }
        pst.close();
        return listaClientes;
    }
}
