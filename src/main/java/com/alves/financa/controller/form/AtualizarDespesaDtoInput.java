package com.alves.financa.controller.form;

import com.alves.financa.modelo.Despesa;
import com.alves.financa.repository.DespesasRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AtualizarDespesaDtoInput {
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

    public Despesa atualizar(Long id, DespesasRepository despesasRepository) {
        Despesa despesa = despesasRepository.getReferenceById(id);
        despesa.setDescricao(this.descricao);
        despesa.setValor(this.valor);
        despesa.setDataCriacao(this.dataCriacao);
        return despesa;


    }
}
