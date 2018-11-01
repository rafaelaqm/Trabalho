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
public class Funcionario {
    private int Codigo;
    private String Funcao;
    private double Salario;
    private String Nome;
    private String Rg;
    private String Cpf;
    private String Sexo;
    private String Telefone;
    private String Email;
    private String Rua;
    private String Numero;
    private String Complemento;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String Cep;

    public Funcionario() {
    }

    public Funcionario(int Codigo, String Funcao, double Salario, String Nome, String Rg, String Cpf, String Sexo, String Telefone, String Email, String Rua, String Numero, String Complemento, String Bairro, String Cidade, String Estado, String Cep) {
        this.Codigo = Codigo;
        this.Funcao = Funcao;
        this.Salario = Salario;
        this.Nome = Nome;
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.Sexo = Sexo;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Rua = Rua;
        this.Numero = Numero;
        this.Complemento = Complemento;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.Cep = Cep;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }



    public Funcionario(int Codigo, String Nome, String Telefone, String Email, String Cidade, String Estado) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Cidade = Cidade;
        this.Estado = Estado;
    }
}
