package com.alves.financa.controller;

import com.alves.financa.controller.form.AtualizarDespesaDtoInput;
import com.alves.financa.controller.form.AtualizarReceitaDtoInput;
import com.alves.financa.modelo.Despesa;
import com.alves.financa.modelo.converter.DespesaConverter;
import com.alves.financa.modelo.dto.DespesaDto;
import com.alves.financa.service.CadastroDespesaService;
import com.alves.financa.controller.form.DespesaDtoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
@RestController
@RequestMapping("/despesa")
public class DespesasController {
    @Autowired
    private CadastroDespesaService cadastroDespesaService;


    @GetMapping
    public List<DespesaDto> listarDespesas(String nomeBusca) {
        return cadastroDespesaService.listarDespesas(nomeBusca);
    }

    @PostMapping
    public ResponseEntity<?> salvarDespesa (@RequestBody DespesaDtoInput despesaDtoInput){
        DespesaDto despesaDto = cadastroDespesaService.cadastrarDespesa(despesaDtoInput);
        if (Objects.isNull(despesaDto)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ja Existe uma despesa com a Mesma descricao neste mes");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DespesaDto> buscarPorId (@PathVariable Long id ) {
        DespesaDto despesaDto = cadastroDespesaService.buscarPorId(id);
        if (Objects.isNull(despesaDto)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(despesaDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DespesaDto> atualizar(@PathVariable Long id, @RequestBody
    @Valid AtualizarDespesaDtoInput atualizarDespesaDtoInput) {
        DespesaDto despesaDto = cadastroDespesaService.atualizar(id,atualizarDespesaDtoInput);
        return ResponseEntity.ok(despesaDto);
    }
}
