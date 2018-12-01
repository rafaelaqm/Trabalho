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
import Model.Funcionario;

/**
 *
 * @author wyss2
 */
public class FuncionarioDAO {
    PreparedStatement pst;
    String sql;
    
    public void salvar(Funcionario funcionario) throws SQLException{
        sql="insert into funcionario values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst=Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, funcionario.getFuncao());
        pst.setDouble(3, funcionario.getSalario());
        pst.setString(4, funcionario.getNome());
        pst.setString(5, funcionario.getRg());
        pst.setString(6, funcionario.getCpf());
        pst.setString(7, funcionario.getSexo());
        pst.setString(8, funcionario.getTelefone());
        pst.setString(9, funcionario.getEmail());
        pst.setString(10, funcionario.getRua());
        pst.setString(11, funcionario.getNumero());
        pst.setString(12, funcionario.getComplemento());
        pst.setString(13, funcionario.getBairro());
        pst.setString(14, funcionario.getCidade());
        pst.setString(15, funcionario.getEstado());
        pst.setString(16, funcionario.getCep());
        pst.execute();
        pst.close();
    }
    
    public void excluir(Funcionario funcionario) throws SQLException{
        sql = "delete from funcionario where codFuncionario=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, funcionario.getCodigo());
        pst.execute();
        pst.close();
    }
    
    public void alterar(Funcionario funcionario) throws SQLException{
        sql= "update funcionario set Funcao=?, Salario=?, Nome=?, Cpf=?, Rg=?, Sexo=?, Telefone=?, Email=?, Rua=?, Numero=?, Complemento=?, Bairro=?, Cidade=?, Estado=?, Cep=? where codFuncionario=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setString(1, funcionario.getFuncao());
        pst.setDouble(2, funcionario.getSalario());
        pst.setString(3, funcionario.getNome());
        pst.setString(4, funcionario.getCpf());
        pst.setString(5, funcionario.getRg());
        pst.setString(6, funcionario.getSexo());
        pst.setString(7, funcionario.getTelefone());
        pst.setString(8, funcionario.getEmail());
        pst.setString(9, funcionario.getRua());
        pst.setString(10, funcionario.getNumero());
        pst.setString(11, funcionario.getComplemento());
        pst.setString(12, funcionario.getBairro());
        pst.setString(13, funcionario.getCidade());
        pst.setString(14, funcionario.getEstado());
        pst.setString(15, funcionario.getCep());
        pst.setInt(16, funcionario.getCodigo());
        
        System.out.println(pst);
        pst.execute();
        pst.close();
    }
    
    public List<Funcionario> ListaFuncionario() throws SQLException{
        List<Funcionario> listaFuncionario;
        listaFuncionario = new ArrayList<>();
        sql="select * from funcionario order by nome";
        pst = Conexão.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            listaFuncionario.add(new Funcionario(rs.getInt("codFuncionario"), rs.getString("Nome"), rs.getString("Telefone"),
            rs.getString("Email"), rs.getString("Cidade"), rs.getString("Estado")));
        }
        pst.close();
        return listaFuncionario;
    }
    
    public List<Funcionario> ListaVendedor() throws SQLException{
        List<Funcionario> listaFuncionario;
        listaFuncionario = new ArrayList<>();
        sql="select * from funcionario where funcao='vendedor' order by nome";
        pst = Conexão.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            listaFuncionario.add(new Funcionario(rs.getInt("codFuncionario"), rs.getString("Nome"), rs.getString("Telefone"),
            rs.getString("Email"), rs.getString("Cidade"), rs.getString("Estado")));
        }
        pst.close();
        return listaFuncionario;
    }
        
    public Funcionario BuscaFuncionarioporCodigo(int cod) throws SQLException {
        Funcionario funcionario = null;
        sql = "Select * from funcionario where codFuncionario=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, cod);
         ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            funcionario = new Funcionario(rs.getInt("codFuncionario"), rs.getString("Funcao"), rs.getDouble("Salario"), rs.getString("Nome"), rs.getString("Rg"), rs.getString("Cpf"),
                    rs.getString("Sexo"), rs.getString("Telefone"), rs.getString("Email"), rs.getString("Rua"),
                    rs.getString("Numero"), rs.getString("Complemento"), rs.getString("Bairro"), rs.getString("Cidade"),
                    rs.getString("Estado"), rs.getString("Cep"));
        }
        pst.close();
        return funcionario;
    }
    
    public Funcionario buscaLogin(String cpf, String senha) throws SQLException{
        sql = "select * from funcionario where Cpf COLLATE utf8_bin=? and senha COLLATE utf8_bin=?";
        Funcionario funcionario=null;
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setString(1, cpf);
        pst.setString(2, senha);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()){
            funcionario = new Funcionario(rs.getInt("codFuncionario"), rs.getString("Cpf"), rs.getString("Senha"), rs.getString("Funcao"));
        }
        return funcionario;
    }
}
