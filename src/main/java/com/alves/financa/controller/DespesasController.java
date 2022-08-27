package com.alves.financa.controller;

import com.alves.financa.controller.converter.DespesaConverter;
import com.alves.financa.controller.converter.ReceitaConverter;
import com.alves.financa.controller.dto.DespesaDto;
import com.alves.financa.controller.dto.ReceitaDto;
import com.alves.financa.controller.form.DespesaDtoInput;
import com.alves.financa.controller.form.ReceitaDtoInput;
import com.alves.financa.modelo.Despesa;
import com.alves.financa.modelo.Receita;
import com.alves.financa.repository.DespesasRepository;
import com.alves.financa.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesa")
public class DespesasController {

    @Autowired
    private DespesasRepository despesasRepository;
    @Autowired
    private DespesaConverter despesaConverter;


    @GetMapping
    public List<DespesaDto> listarDespesas(String nomeBusca) {
        List<Despesa> listaDeDespesas;
        if (nomeBusca == null){
            listaDeDespesas = despesasRepository.findAll();
        }else {
            listaDeDespesas = despesasRepository.findReceitaByDescricao(nomeBusca);
        }
        return despesaConverter.toDespesaDtoList(listaDeDespesas);
    }

    @PostMapping
    public ResponseEntity<DespesaDto> cadastrarDespesa(@RequestBody DespesaDtoInput despesaDtoInput){
        Despesa despesa = despesaConverter.toDespesaBanco(despesaDtoInput);
        despesasRepository.save(despesa);

        return ResponseEntity.ok(despesaConverter.toDespesaDtoList(despesa));
    }
    @GetMapping("/{id}")
    public DespesaDto buscarPorId (@PathVariable Long id ) {
        Optional<Despesa> despesa = despesasRepository.findById(id);
        if (despesa.isPresent()){
            return despesaConverter.toDespesaDtoList(despesa.get());
        }
        return null;
    }


}
