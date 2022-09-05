package com.alves.financa.service;

import com.alves.financa.controller.form.AtualizarDespesaDtoInput;
import com.alves.financa.modelo.converter.DespesaConverter;
import com.alves.financa.controller.form.DespesaDtoInput;
import com.alves.financa.modelo.Despesa;
import com.alves.financa.modelo.dto.DespesaDto;
import com.alves.financa.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CadastroDespesaService {
    @Autowired
    private DespesasRepository despesasRepository;

    @Autowired
    private DespesaConverter despesaConverter;

    public DespesaDto cadastrarDespesa(DespesaDtoInput despesaDtoInput) {
        List<Despesa> despesaList = despesasRepository.findDespesaByDescricao(despesaDtoInput.getDescricao());

        if (!despesaList.isEmpty()){
            Set<Despesa> despesaSet = despesaList.stream().filter(despesa -> despesa.getDataCriacao().getMonth()
                    .equals(despesaDtoInput.getDataCriacao().getMonth())).collect(Collectors.toSet());
            if (!despesaSet.isEmpty()){
                return null;
            }
        }
        Despesa despesa = despesaConverter.toDespesaBanco(despesaDtoInput);

        return despesaConverter.toDespesaDtoOutput(despesasRepository.save(despesa));

    }
    //gettimaping
    public List<DespesaDto> listarDespesas(String nomeBusca){
        List<Despesa> listaDeDespesas;
        if (nomeBusca == null){
            listaDeDespesas = despesasRepository.findAll();
        } else {
            listaDeDespesas = despesasRepository.findDespesaByDescricao(nomeBusca);
        }
        return despesaConverter.toDespesaDtoList(listaDeDespesas);
    }

    public DespesaDto buscarPorId (Long id){
        Optional<Despesa> despesa = despesasRepository.findById(id);
        if (despesa.isPresent()){
            return despesaConverter.toDespesaDtoOutput(despesa.get());
        }
        return null;
    }
    public DespesaDto atualizar(Long id , AtualizarDespesaDtoInput atualizarDespesaDtoInput){
        Despesa despesa = atualizarDespesaDtoInput.atualizar(id, despesasRepository);
        return despesaConverter.toDespesaDtoOutput(despesa);
    }

}
