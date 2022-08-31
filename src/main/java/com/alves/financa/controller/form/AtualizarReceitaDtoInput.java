package com.alves.financa.controller.form;

import com.alves.financa.modelo.Receita;
import com.alves.financa.repository.ReceitasRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AtualizarReceitaDtoInput {
        @NotNull
    @NotEmpty
    @Size(min = 5, max = 200, message = "About Me must be between 10 and 200 characters")
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

    public Receita atualizar(Long id, ReceitasRepository receitasRepository) {
        Receita receita = receitasRepository.getReferenceById(id);
        receita.setDescricao(this.descricao);
        receita.setValor(this.valor);
        receita.setDataCriacao(this.dataCriacao);
        return receita;
    }
}
