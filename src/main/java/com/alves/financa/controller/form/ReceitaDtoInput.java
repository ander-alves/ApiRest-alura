package com.alves.financa.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ReceitaDtoInput {

    private String descricao;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate dataCriacao;

    private Double valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ReceitaDtoInput(String descricao, LocalDate dataCriacao, Double valor) {
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.valor = valor;

    }
}
