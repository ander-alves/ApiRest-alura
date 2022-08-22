package com.alves.financa.controller;

import com.alves.financa.controller.dto.DespesasDto;
import com.alves.financa.modelo.Despesa;
import com.alves.financa.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DespesasController {
//
//    @Autowired
//    private DespesasRepository  despesasRepository;
//
//    @RequestMapping("/despesas")
//    public List<DespesasDto> listarDespesas(String nomeDespesas) {
//        List<Despesa> listaDeDespesas;
//        if (nomeDespesas == null){
//            listaDeDespesas = despesasRepository.findAll();
//        } else {
//            listaDeDespesas = despesasRepository.findAll();
//        }
//        return DespesasDto.converter(listaDeDespesas);
//    }
}
