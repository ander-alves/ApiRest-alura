package com.alves.financa.controller;

import com.alves.financa.controller.dto.DespesasDto;
import com.alves.financa.modelo.Despesas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DespesasController {

    @RequestMapping("/despesas")
    public List<DespesasDto> listarDespesas() {
        Despesas cartao = new Despesas("Cartao",123.23);
        return DespesasDto.converter(Arrays.asList(cartao));
    }
}
