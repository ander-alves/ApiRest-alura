package com.alves.financa.controller.converter;

import com.alves.financa.controller.dto.ReceitaDto;
import com.alves.financa.controller.form.ReceitasDtoInput;
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
    public Receita toReceitaBanco(ReceitasDtoInput receitasDtoInput){

        return Receita.builder()
                .dataCriacao(receitasDtoInput.getDataCriacao())
                .descricao(receitasDtoInput.getDescricao())
                .valor(receitasDtoInput.getValor())
                .build();
    }


}
