package com.alves.financa.modelo;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receitas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private double valor;
    @OneToMany(mappedBy = "receitas")
    private List<Receitas> receitasEntrada = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "receitas_id")
    private Receitas receitas;

    public Receitas getReceitas() {
        return receitas;
    }

    public void setReceitas(Receitas receitas) {
        this.receitas = receitas;
    }


    public Receitas() {
    }

    public Receitas(String titulo, Double valor) {
//        this.id = id;//
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    public List<Receitas> getReceitasEntrada() {
        return receitasEntrada;
    }

    public void setReceitasEntrada(List<Receitas> receitasEntrada) {
        this.receitasEntrada = receitasEntrada;
    }
}
