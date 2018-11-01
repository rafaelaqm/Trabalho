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
public class Peca {
    private int Codigo;
    private String TextoBreve;
    private String DescritivoCompleto;
    private double PrecoAquisicao;
    private double PrecoVenda;
    private float Saldo;

    public Peca() {
    }

    public Peca(int Codigo, String TextoBreve, String DescritivoCompleto, double PrecoAquisicao, double PrecoVenda, float Saldo) {
        this.Codigo = Codigo;
        this.TextoBreve = TextoBreve;
        this.DescritivoCompleto = DescritivoCompleto;
        this.PrecoAquisicao = PrecoAquisicao;
        this.PrecoVenda = PrecoVenda;
        this.Saldo = Saldo;
    }

    public Peca(int Codigo, String TextoBreve, float Saldo) {
        this.Codigo = Codigo;
        this.TextoBreve = TextoBreve;
        this.Saldo = Saldo;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getTextoBreve() {
        return TextoBreve;
    }

    public void setTextoBreve(String TextoBreve) {
        this.TextoBreve = TextoBreve;
    }

    public String getDescritivoCompleto() {
        return DescritivoCompleto;
    }

    public void setDescritivoCompleto(String DescritivoCompleto) {
        this.DescritivoCompleto = DescritivoCompleto;
    }

    public double getPrecoAquisicao() {
        return PrecoAquisicao;
    }

    public void setPrecoAquisicao(double PrecoAquisicao) {
        this.PrecoAquisicao = PrecoAquisicao;
    }

    public double getPrecoVenda() {
        return PrecoVenda;
    }

    public void setPrecoVenda(double PrecoVenda) {
        this.PrecoVenda = PrecoVenda;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }


}
