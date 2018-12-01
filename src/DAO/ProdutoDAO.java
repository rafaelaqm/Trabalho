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
import Model.Produto;
import java.sql.Statement;

/**
 *
 * @author wyss2
 */
public class ProdutoDAO {
    PreparedStatement pst;
    String sql;
    
    public void salvar(Produto produto) throws SQLException{
        sql="insert into produto values(?,?,?,?,?,?)";
        pst=Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, produto.getTextoBreve());
        pst.setString(3, produto.getDescritivoCompleto());
        pst.setDouble(4, produto.getPrecoAquisicao());
        pst.setDouble(5, produto.getPrecoVenda());
        pst.setFloat(6, produto.getSaldo());
        pst.execute();
        pst.close();
    }
    
    public void excluir(Produto peca) throws SQLException{
        sql = "delete from produto where codProduto=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, peca.getCodigo());
        pst.execute();
        pst.close();
    }
    
    public void alterar(Produto produto) throws SQLException{
        sql= "update produto set TextoBreve=?, DescritivoCompleto=?, PrecoAquisicao=?, PrecoVenda=? where codProduto=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setString(1, produto.getTextoBreve());
        pst.setString(2, produto.getDescritivoCompleto());
        pst.setDouble(3, produto.getPrecoAquisicao());
        pst.setDouble(4, produto.getPrecoVenda());
        pst.setInt(5, produto.getCodigo());
        System.out.println(pst);
        pst.execute();
        pst.close();
    }
    
    public List<Produto> ListaProduto() throws SQLException{
        List<Produto> listaProduto;
        listaProduto = new ArrayList<>();
        sql="select * from produto order by TextoBreve";
        pst = Conexão.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            listaProduto.add(new Produto(rs.getInt("codProduto"), rs.getString("TextoBreve"), rs.getString("DescritivoCompleto"), rs.getFloat("Saldo")));
        }
        pst.close();
        return listaProduto;
    }

    public List<Produto> ListaProdutoNome(String nome) throws SQLException{
        List<Produto> listaProduto;
        listaProduto = new ArrayList<>();
        sql="select * from produto where nome like '%" + nome + "%'";
        pst = Conexão.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            listaProduto.add(new Produto(rs.getInt("codProduto"), rs.getString("TextoBreve"), rs.getString("DescritivoCompleto"), rs.getFloat("Saldo")));
        }
        pst.close();
        return listaProduto;
    }
    
    public Produto BuscaProdutoporCodigo(int id) throws SQLException {
        Produto produto = null;
        sql = "Select * from produto where codProduto=?";
        Statement st;
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {
            produto = new Produto(rs.getInt("codProduto"), rs.getString("TextoBreve"), rs.getString("DescritivoCompleto"),
                    rs.getDouble("PrecoAquisicao"), rs.getDouble("PrecoVenda"), rs.getFloat("Saldo"));
        }
        pst.close();
        return produto;
    }    
}
