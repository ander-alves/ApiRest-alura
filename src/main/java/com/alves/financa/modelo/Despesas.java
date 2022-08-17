package com.alves.financa.modelo;



import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Despesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private double valor;
    @OneToMany(mappedBy = "despesas")
    private List<Despesas> despesasSaida = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "despesas_id")
    private Despesas despesas;

    public Despesas getDespesas() {
        return despesas;
    }

    public void setDespesas(Despesas despesas) {
        this.despesas = despesas;
    }

    public Despesas() {
    }

    public Despesas(String titulo, double valor) {
        this.titulo = titulo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Despesas> getDespesasSaida() {
        return despesasSaida;
    }

    public void setDespesasSaida(List<Despesas> despesasSaida) {
        this.despesasSaida = despesasSaida;
    }
}