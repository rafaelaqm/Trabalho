/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author wyss2
 */
public class Venda {
    private int codVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private List<VendaItens> VendaItens;
    private float TotalVenda;

    public Venda() {
        this.VendaItens = new ArrayList<>();
    }

    public Venda(int codVenda, Cliente cliente, Funcionario funcionario, List<VendaItens> VendaItens, float TotalVenda) {
        this.codVenda = codVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.VendaItens = VendaItens;
        this.TotalVenda = TotalVenda;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<VendaItens> getVendaItens() {
        return VendaItens;
    }

    public void setVendaItens(List<VendaItens> VendaItens) {
        this.VendaItens = VendaItens;
    }

    public float getTotalVenda() {
        return TotalVenda;
    }

    public void setTotalVenda(float TotalVenda) {
        this.TotalVenda = TotalVenda;
    }
}
