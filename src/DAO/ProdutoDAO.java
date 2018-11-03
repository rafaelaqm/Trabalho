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

/**
 *
 * @author wyss2
 */
public class ProdutoDAO {
    PreparedStatement pst;
    String sql;
    
    public void salvar(Produto peca) throws SQLException{
        sql="insert into produto values(?,?,?,?,?,?)";
        pst=Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, peca.getTextoBreve());
        pst.setString(3, peca.getDescritivoCompleto());
        pst.setDouble(4, peca.getPrecoAquisicao());
        pst.setDouble(5, peca.getPrecoVenda());
        pst.setFloat(6, peca.getSaldo());
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
    
    public void alterar(Produto peca) throws SQLException{
        sql= "update produto set TextoBreve=?, DescritivoCompleto=?, PrecoAquisicao=?, PrecoVenda=? where codProduto=?";
        pst = Conexão.getInstance().prepareStatement(sql);
        pst.setString(1, peca.getTextoBreve());
        pst.setString(2, peca.getDescritivoCompleto());
        pst.setDouble(3, peca.getPrecoAquisicao());
        pst.setDouble(4, peca.getPrecoVenda());
        pst.setInt(5, peca.getCodigo());
        System.out.println(pst);
        pst.execute();
        pst.close();
    }
    
    //corrigir geral ListaPeca
    public List<Produto> ListaPeca() throws SQLException{
        List<Produto> listaPecas;
        listaPecas = new ArrayList<>();
        sql="select * from produto order by TextoBreve";
        pst = Conexão.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            listaPecas.add(new Produto(rs.getInt("codProduto"), rs.getString("TextoBreve"), rs.getString("DescritivoCompleto"), rs.getFloat("Saldo")));
        }
        pst.close();
        return listaPecas;
    }
}
