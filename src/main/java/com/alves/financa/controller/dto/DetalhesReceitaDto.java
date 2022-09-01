package com.alves.financa.controller.dto;

import com.alves.financa.modelo.Receita;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class DetalhesReceitaDto {

    private Long id;
    private String descricao;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataCriacao;
    private Double valor;

    public DetalhesReceitaDto(Receita receita) {
        this.id = receita.getId();
        this.descricao = receita.getDescricao();
        this.dataCriacao = receita.getDataCriacao();
        this.valor = receita.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
