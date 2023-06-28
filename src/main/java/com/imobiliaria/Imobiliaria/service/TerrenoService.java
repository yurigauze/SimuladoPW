package com.imobiliaria.Imobiliaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliaria.Imobiliaria.entily.Terreno;
import com.imobiliaria.Imobiliaria.repository.TerrenoRepository;

@Service
public class TerrenoService {

    @Autowired
    private TerrenoRepository terrenoRepository;

    public List<Terreno> buscarTodos() {
        return terrenoRepository.findAll();
    }

    public Terreno buscarPorId(Long terrenoId) {
        Terreno terreno = terrenoRepository.findById(terrenoId).get();
        return terreno;
    }
    

    public Terreno inserir(Terreno objeto) {
        Terreno terrenoNovo = terrenoRepository.saveAndFlush(objeto);
        return terrenoNovo;

    }

    public Terreno alterar(Terreno objeto) {
        return terrenoRepository.saveAndFlush(objeto);

    }

    public void excluir(Long id) {
        Terreno objeto = terrenoRepository.findById(id).get();
        terrenoRepository.delete(objeto);

    }

    

}