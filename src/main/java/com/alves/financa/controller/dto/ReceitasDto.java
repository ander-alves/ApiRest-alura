package com.alves.financa.controller.dto;

import com.alves.financa.modelo.Receitas;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReceitasDto {
    private Long id;
    private String descricao;
    private Double valor;
    private LocalDateTime dataCriacao;

    //Construtor da Classe DTO Busca as Informacoes na classe
    // principal, por isso precisa apenas de getters//

    public ReceitasDto(Receitas receitas) {
        this.id = receitas.getId();
        this.descricao = receitas.getTitulo();
        this.valor = receitas.getValor();
        this.dataCriacao = receitas.getDataCriacao();
    }
//Criando metodo para converter a lista de topico para converter em topicos dto//

    public static List<ReceitasDto> converter(List<Receitas> receitasMetodo) {
        return receitasMetodo.stream().map(ReceitasDto::new).collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
