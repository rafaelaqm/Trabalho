/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author wyss2
 */
public class VendaItens {
    private int CodItem;
    private Produto produto;
    private float Qtd;
    private float Preco;
    private float PrecoTotalItem;

    public VendaItens() {
    }

    public VendaItens(int CodItem, Produto produto, float Qtd, float Preco, float PrecoTotalItem) {
        this.CodItem = CodItem;
        this.produto = produto;
        this.Qtd = Qtd;
        this.Preco = Preco;
        this.PrecoTotalItem = PrecoTotalItem;
    }

    public int getCodItem() {
        return CodItem;
    }

    public void setCodItem(int CodItem) {
        this.CodItem = CodItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQtd() {
        return Qtd;
    }

    public void setQtd(float Qtd) {
        this.Qtd = Qtd;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public float getPrecoTotalItem() {
        return PrecoTotalItem;
    }

    public void setPrecoTotalItem(float PrecoTotalItem) {
        this.PrecoTotalItem = PrecoTotalItem;
    }
}
