
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Cliente;

public class ClienteDAO {
    PreparedStatement pst;
    String sql;
    
    public void salvar(Cliente cliente) throws SQLException{
        sql = "insert into cliente values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = dao.Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, cliente.getNomeCliente());
        pst.setString(3, cliente.getRgCliente());
        pst.setString(4, cliente.getCpfCliente());
        pst.setString(5, cliente.getSexoCliente());
        pst.setString(6, cliente.getTelefoneCliente());
        pst.setString(7, cliente.getEmailCliente());
        pst.setString(8, cliente.getRuaCliente());
        pst.setString(9, cliente.getNumeroCliente());
        pst.setString(10, cliente.getComplementoCliente());
        pst.setString(11, cliente.getBairroCliente());
        pst.setString(12, cliente.getCidadeCliente());
        pst.setString(13, cliente.getEstadoCliente());
        pst.setString(14, cliente.getCepCliente());
        
        pst.execute();
        pst.close();
    }
    
    public List<Cliente> ListaCliente() throws SQLException{
       List<Cliente> listaClientes;
       listaClientes = new ArrayList<>();
       sql = "select * from cliente order by nome";
       pst = dao.Conexão.getInstance().prepareStatement(sql);
       ResultSet rs = pst.executeQuery();
       while (rs.next()){
           listaClientes.add(new Cliente(rs.getInt("codigo"),
                                            rs.getString("nome"),
                                            rs.getString("rg"),
                                            rs.getString("cpf"),
                                            rs.getString("sexo"),
                                            rs.getString("telefone"),
                                            rs.getString("email"),
                                            rs.getString("rua"),
                                            rs.getString("numero"),
                                            rs.getString("complemento"),
                                            rs.getString("bairro"),
                                            rs.getString("cidade"),
                                            rs.getString("estado"),
                                            rs.getString("cep")));
       }
       pst.close();
       return listaClientes;
    }
}
