package com.alves.financa.controller.dto;

import com.alves.financa.modelo.Despesas;
import com.alves.financa.modelo.Receitas;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DespesasDto {

    private Long id;
    private String descricao;
    private Double valor;
    private LocalDateTime dataCriacao;

    //Construtor da Classe DTO Busca as Informacoes na classe
    // principal, por isso precisa apenas de getters//

    public DespesasDto(Despesas despesas) {
        this.id = despesas.getId();
        this.descricao = despesas.getTitulo();
        this.valor = despesas.getValor();
        this.dataCriacao = despesas.getDataCriacao();
    }
//Criando metodo para converter a lista de topico para converter em topicos dto//

    public static List<DespesasDto> converter(List<Despesas> despesasMetodo) {
        return despesasMetodo.stream().map(DespesasDto::new).collect(Collectors.toList());
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
