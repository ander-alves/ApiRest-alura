package com.alves.financa.repository;

import com.alves.financa.modelo.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesasRepository extends JpaRepository <Despesa, Long> {

    List<Despesa> findReceitaByDescricao(String nomeBusca);
}
