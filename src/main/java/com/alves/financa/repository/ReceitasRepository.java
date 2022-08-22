package com.alves.financa.repository;

import com.alves.financa.modelo.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitasRepository extends JpaRepository <Receita, Long> {

    List<Receita> findReceitaByDescricao(String descricao);

    //metodo para criar query//

}
