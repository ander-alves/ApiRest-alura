package com.alves.financa.repository;

import com.alves.financa.modelo.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesasRepository extends JpaRepository <Despesa, Long> {

}
