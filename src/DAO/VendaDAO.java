/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Venda;
import Model.VendaItens;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author wyss2
 */
public class VendaDAO {
    PreparedStatement pst;
    String sql;
    
    public void salvar(Venda venda) throws SQLException{
        int codVenda=0;
        sql = "insert into venda(codCliente, codVendedor, totalVenda) values(?,?,?)";
        pst = Conexão.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, venda.getCliente().getCodigo());
        pst.setInt(2, venda.getFuncionario().getCodigo());
        pst.setFloat(3, venda.getTotalVenda());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        while(rs.next()){
            codVenda =rs.getInt(1);
        }
        pst.close();
        salvarVendaItens(venda.getVendaItens(),codVenda);
    }
    
    public void salvarVendaItens(List<VendaItens> VendaItens, int codVenda) throws SQLException{
        for(VendaItens itens: VendaItens){
            sql="insert into itemvenda values(?,?,?,?,?,?)";
            pst = Conexão.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setInt(2, codVenda);
            pst.setInt(3, itens.getProduto().getCodigo());
            pst.setFloat(4, itens.getQtd());
            pst.setFloat(5, itens.getPreco());
            pst.setFloat(6, itens.getPrecoTotalItem());
            pst.execute();
            pst.close();        
        }
    }
    /**
     *
     * @throws SQLException
     */
}
