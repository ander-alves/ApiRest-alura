package com.alves.financa.modelo.converter;

import com.alves.financa.modelo.dto.ReceitaDto;
import com.alves.financa.controller.form.ReceitaDtoInput;
import com.alves.financa.modelo.Receita;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaConverter {

    public List<ReceitaDto> toReceitaDtoList (List<Receita> receitaList){
        List<ReceitaDto> receitaDtoList = new ArrayList<>();
        receitaList.forEach((receita)->{
            ReceitaDto receitaDto = ReceitaDto.builder()
                    .dataCriacao(receita.getDataCriacao())
                    .valor(receita.getValor())
                    .descricao(receita.getDescricao())
                    .build();
            receitaDtoList.add(receitaDto);
        });
        return receitaDtoList;

    }

    public ReceitaDto toReceitaDto(Receita receita){

        return ReceitaDto.builder()
                .descricao(receita.getDescricao())
                .valor(receita.getValor())
                .dataCriacao(receita.getDataCriacao())
                .build();

    }
    public Receita toReceitaBanco(ReceitaDtoInput receitaDtoInput){

        return Receita.builder()
                .dataCriacao(receitaDtoInput.getDataCriacao())
                .descricao(receitaDtoInput.getDescricao())
                .valor(receitaDtoInput.getValor())
                .build();
    }


}
