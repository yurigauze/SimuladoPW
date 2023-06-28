package com.imobiliaria.Imobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imobiliaria.Imobiliaria.entily.Loteadora;
import com.imobiliaria.Imobiliaria.entily.Terreno;
import com.imobiliaria.Imobiliaria.service.LoteadoraService;

@RestController
@RequestMapping("/api/loteadora")
public class LoteadoraController {
    
    @Autowired
    private LoteadoraService loteadoraService;

    @GetMapping("/")
    public List<Loteadora> buscarTodos() {
        return loteadoraService.buscarTodos();
    }


    @PostMapping("/")
    public Loteadora inserir(@RequestBody Loteadora objeto) {
        return loteadoraService.inserir(objeto);

    }

    @PutMapping("/alterar")
    public Loteadora alterar(@RequestBody Loteadora objeto) {
        return loteadoraService.alterar(objeto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        loteadoraService.excluir(id);
        return ResponseEntity.ok().build();
    }
    
}
