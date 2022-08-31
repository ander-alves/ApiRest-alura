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
}
