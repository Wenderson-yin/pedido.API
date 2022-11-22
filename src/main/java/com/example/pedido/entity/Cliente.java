package com.example.pedido.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String endereco;
    private String cep;
    private String numero;
    private String formaDePagamento;
    private String parcelas;
    private String valorTotal;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Cliente(String endereco, String cep, String numero, String formaDePagamento, String parcelas, String valorTotal){
        this.endereco = endereco;
        this.cep = cep;
        this.numero = numero;
        this.formaDePagamento = formaDePagamento;
        this.parcelas = parcelas;
        this.valorTotal = valorTotal;
    }

    public Cliente(){

    }

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
