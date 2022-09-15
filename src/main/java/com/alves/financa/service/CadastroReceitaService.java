package com.alves.financa.service;

import com.alves.financa.controller.form.AtualizarDespesaDtoInput;
import com.alves.financa.controller.form.DespesaDtoInput;
import com.alves.financa.controller.form.ReceitaDtoInput;
import com.alves.financa.modelo.Despesa;
import com.alves.financa.modelo.Receita;
import com.alves.financa.modelo.converter.ReceitaConverter;
import com.alves.financa.modelo.dto.DespesaDto;
import com.alves.financa.modelo.dto.ReceitaDto;
import com.alves.financa.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CadastroReceitaService {
    @Autowired
    private ReceitasRepository receitasRepository;

    @Autowired
    private ReceitaConverter receitaConverter;

    public ReceitaDto cadastrarDespesa(ReceitaDtoInput receitaDtoInput) {
        List<Receita> receitaList = receitasRepository.findReceitaByDescricao(receitaDtoInput.getDescricao());

        if (!receitaList.isEmpty()){
            Set<Receita> receitaSet = receitaList.stream().filter(receita -> receita.getDataCriacao().getMonth()
                    .equals(receitaDtoInput.getDataCriacao().getMonth())).collect(Collectors.toSet());
            if (!receitaSet.isEmpty()){
                return null;
            }
        }
        Receita receita = receitaConverter.toReceitaBanco(receitaDtoInput);

        return receitaConverter.toReceitaDtoOutput(receitasRepository.save(receita));

    }
    //gettimaping
    public List<ReceitaDto> listarReceitas(String nomeBusca){
        List<Receita> listarReceitas;
        if (nomeBusca == null){
            listarReceitas = receitasRepository.findAll();
        } else {
            listarReceitas = receitasRepository.findReceitaByDescricao(nomeBusca);
        }
        return receitaConverter.toReceitaDtoList(listarReceitas);
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
    public void deletar(Long id) {
        Optional<Despesa> optional = despesasRepository.findById(id);
        if (optional.isPresent()) {
            despesasRepository.deleteById(id);
            return;
        }
    }
}
