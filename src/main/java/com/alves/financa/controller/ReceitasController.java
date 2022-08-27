package com.alves.financa.controller;

import com.alves.financa.controller.converter.ReceitaConverter;
import com.alves.financa.controller.dto.ReceitaDto;
import com.alves.financa.controller.form.ReceitaDtoInput;
import com.alves.financa.modelo.Receita;
import com.alves.financa.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receita")
public class ReceitasController {

    @Autowired
    private ReceitasRepository receitasRepository;
    @Autowired
    private ReceitaConverter receitaConverter;


    @GetMapping
    public List<ReceitaDto> listarReceitas(String nomeBusca) {
        List<Receita> listaDeReceitas;
        if (nomeBusca == null){
            listaDeReceitas = receitasRepository.findAll();
        }else {
            listaDeReceitas = receitasRepository.findReceitaByDescricao(nomeBusca);
        }
        return receitaConverter.toReceitaDtoList(listaDeReceitas) ;
    }

    @PostMapping
    public ResponseEntity<ReceitaDto> cadastrarReceitas(@RequestBody ReceitaDtoInput receitaDtoInput){
        Receita receita = receitaConverter.toReceitaBanco(receitaDtoInput);
        receitasRepository.save(receita);

        return ResponseEntity.ok(receitaConverter.toReceitaDto(receita));
    }
    @GetMapping("/{id}")
    public ReceitaDto buscarPorId (@PathVariable Long id ) {
        Optional<Receita> receita = receitasRepository.findById(id);
        if (receita.isPresent()){
            return receitaConverter.toReceitaDto(receita.get());
        }
        return null;
    }


}
