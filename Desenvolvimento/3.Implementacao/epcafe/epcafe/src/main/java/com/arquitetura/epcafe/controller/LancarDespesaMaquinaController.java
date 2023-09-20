package com.arquitetura.epcafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arquitetura.epcafe.model.DespesaMaquina;
import com.arquitetura.epcafe.service.DespesaMaquinaService;

import jakarta.validation.Valid;

@Controller
public class LancarDespesaMaquinaController {
    
    @Autowired
    private DespesaMaquinaService despesaMaquinaService;

    @GetMapping("/lancarDespesaMaquina")
    public String lancarDespesaMaquina(DespesaMaquina despesaMaquina) {
        return "lancarDespesaMaquina";
    }

    @PostMapping("/lancarDespesaMaquina")
    public String novo(@Valid DespesaMaquina despesaMaquina, BindingResult result){
        if(result.hasErrors()){
            return "lancarDespesaMaquina";
        }

        despesaMaquinaService.save(despesaMaquina);

        return "redirect:/lancarDespesaMaquina";
    }
}
