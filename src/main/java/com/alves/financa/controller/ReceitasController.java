package com.alves.financa.controller;

import com.alves.financa.controller.dto.ReceitasDto;
import com.alves.financa.modelo.Receitas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ReceitasController {


    @RequestMapping("/receitas")
    public List<ReceitasDto> listarReceitas() {
        Receitas pgto = new Receitas("salario",123.21);
        return ReceitasDto.converter(Arrays.asList(pgto,pgto));
    }

}
