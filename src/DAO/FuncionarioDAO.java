package DAO;

import Model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    PreparedStatement pst;
    String sql;
    
    public void salvar(Funcionario funcionario) throws SQLException{
        sql = "insert into funcionario values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = dao.Conexão.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, funcionario.getFuncaoFuncionario());
        pst.setString(3, funcionario.getSalarioFuncionario());
        pst.setString(4, funcionario.getNomeFuncionario());
        pst.setString(5, funcionario.getRgFuncionario());
        pst.setString(6, funcionario.getCpfFuncionario());
        pst.setString(7, funcionario.getSexoFuncionario());
        pst.setString(9, funcionario.getEmailFuncionario());
        pst.setString(10,funcionario.getRuaFuncionario());
        pst.setString(11,funcionario.getNumeroFuncionario());
        pst.setString(12,funcionario.getComplementoFuncionario());
        pst.setString(13,funcionario.getBairroFuncionario());
        pst.setString(14,funcionario.getCidadeFuncionario());
        pst.setString(15,funcionario.getEstadoFuncionario());
        pst.setString(16,funcionario.getCepFuncionario());
        
        pst.execute();
        pst.close();
    }
    
    public List<Funcionario> ListaFuncionarios() throws SQLException{
       List<Funcionario> listaFuncionarios;
       listaFuncionarios= new ArrayList<>();
       sql = "select * from cliente order by nome";
       pst = dao.Conexão.getInstance().prepareStatement(sql);
       ResultSet rs = pst.executeQuery();
       while (rs.next()){
           listaFuncionarios.add(new Funcionario(rs.getInt("codigo"), rs.getString("funcao"), rs.getString("salario"), rs.getString("nome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("sexo"),
           rs.getString("telefone"), rs.getString("email"), rs.getString("rua"), rs.getString("numero"), rs.getString("complemento"), rs.getString("bairro"),
           rs.getString("cidade"), rs.getString("estado"), rs.getString("cep")));
       }
       pst.close();
       return listaFuncionarios;
    }
}

    
    
    
    

