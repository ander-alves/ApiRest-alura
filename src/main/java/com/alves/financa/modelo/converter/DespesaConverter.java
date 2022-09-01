package com.alves.financa.modelo.converter;

import com.alves.financa.modelo.dto.DespesaDto;
import com.alves.financa.controller.form.DespesaDtoInput;
import com.alves.financa.modelo.Despesa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DespesaConverter {
    public List<DespesaDto> toDespesaDtoList (List<Despesa> despesaList){
        List<DespesaDto> despesaDtoList = new ArrayList<>();
        despesaList.forEach((despesa)->{
            DespesaDto despesaDto = DespesaDto.builder()
                    .dataCriacao(despesa.getDataCriacao())
                    .valor(despesa.getValor())
                    .descricao(despesa.getDescricao())
                    .build();
            despesaDtoList.add(despesaDto);
    });
        return despesaDtoList;
   }
    public DespesaDto toDespesaDtoList (Despesa despesa) {
        return DespesaDto.builder()
                .descricao(despesa.getDescricao())
                .valor(despesa.getValor())
                .dataCriacao(despesa.getDataCriacao())
                .build();
    }
    public Despesa toDespesaBanco(DespesaDtoInput despesaDtoInput){
        return Despesa.builder()
                .dataCriacao(despesaDtoInput.getDataCriacao())
                .descricao(despesaDtoInput.getDescricao())
                .valor(despesaDtoInput.getValor())
                .build();
    }
    public DespesaDto toDespesaDtoOutput(Despesa despesa){
        return DespesaDto.builder()
                .descricao(despesa.getDescricao())
                .valor(despesa.getValor())
                .dataCriacao(despesa.getDataCriacao())
                .build();
            }

}





