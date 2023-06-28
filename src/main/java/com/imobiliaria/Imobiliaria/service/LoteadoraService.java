package com.imobiliaria.Imobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliaria.Imobiliaria.entily.Loteadora;
import com.imobiliaria.Imobiliaria.repository.LoteadoraRepository;

@Service
public class LoteadoraService {

    @Autowired
    private LoteadoraRepository loteadoraRepository;

    public List<Loteadora> buscarTodos() {
        return loteadoraRepository.findAll();
    }

    public Loteadora buscarPorId(Long loteadoraId) {
        Loteadora loteadora = loteadoraRepository.findById(loteadoraId).get();
        return loteadora;
    }


    public Loteadora inserir(Loteadora objeto) {
        Loteadora loteadoraNovo = loteadoraRepository.saveAndFlush(objeto);
        return loteadoraNovo;

    }

    public Loteadora alterar(Loteadora objeto) {
        return loteadoraRepository.saveAndFlush(objeto);

    }

    public void excluir(Long id) {
        Loteadora objeto = loteadoraRepository.findById(id).get();
        loteadoraRepository.delete(objeto);

    }

}