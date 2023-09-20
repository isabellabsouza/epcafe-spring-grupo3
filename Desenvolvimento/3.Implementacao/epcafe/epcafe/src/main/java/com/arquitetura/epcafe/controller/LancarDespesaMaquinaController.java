package com.arquitetura.epcafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arquitetura.epcafe.model.DespesaMaquina;
import com.arquitetura.epcafe.model.Maquina;
import com.arquitetura.epcafe.repository.MaquinaRepository;
import com.arquitetura.epcafe.service.DespesaMaquinaService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Controller
public class LancarDespesaMaquinaController {
    
    @Autowired
    private DespesaMaquinaService despesaMaquinaService;

    @Autowired
    private MaquinaRepository maquinaRepository;

    @GetMapping("/lancarDespesaMaquina")
    public String lancarDespesaMaquina(DespesaMaquina despesaMaquina, Model model) {
        List<Maquina> maquinas = maquinaRepository.findAll();
        model.addAttribute("maquinas", maquinas);
        log.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        return "lancarDespesaMaquina";
    }

    @PostMapping("/lancarDespesaMaquina")
    public String novo(@Valid DespesaMaquina despesaMaquina, BindingResult result){
        log.info(result.toString());
        if(result.hasErrors()){
            return "lancarDespesaMaquina";
        }
        
        log.info("LANÇANDO O NEGOCIO!!!!!!: " + despesaMaquina.toString());
        despesaMaquinaService.save(despesaMaquina);

        return "redirect:/lancarDespesaMaquina";
    }
}
