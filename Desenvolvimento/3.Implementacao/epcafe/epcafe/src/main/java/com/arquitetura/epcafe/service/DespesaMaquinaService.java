package com.arquitetura.epcafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitetura.epcafe.model.DespesaMaquina;
import com.arquitetura.epcafe.repository.DespesaMaquinaRepository;

@Service
public class DespesaMaquinaService {
    
    @Autowired
    private DespesaMaquinaRepository despesaMaquinaRepository;

    public void save(DespesaMaquina despesaMaquina) {
        this.despesaMaquinaRepository.save(despesaMaquina);
    }

    public List<DespesaMaquina> findAll() {
        return this.despesaMaquinaRepository.findAll();
    }
}
