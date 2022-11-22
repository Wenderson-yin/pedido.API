package com.example.pedido.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String precoIndividual;
    private String quantidade;

    public Pedido(String nome, String precoIndividual, String quantidade){

        this.nome =nome;
        this.precoIndividual =precoIndividual;
        this.quantidade =quantidade;

    }

    public Pedido() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrecoIndividual() {
        return precoIndividual;
    }

    public void setPrecoIndividual(String precoIndividual) {
        this.precoIndividual = precoIndividual;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
