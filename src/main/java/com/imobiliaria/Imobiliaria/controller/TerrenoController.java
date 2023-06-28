package com.imobiliaria.Imobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.imobiliaria.Imobiliaria.repository.TerrenoRepository;
import com.imobiliaria.Imobiliaria.service.LoteadoraService;
import com.imobiliaria.Imobiliaria.service.TerrenoService;

@RestController
@RequestMapping("/api/terreno")
public class TerrenoController {
    
    @Autowired
    private TerrenoService terrenoService;

    private LoteadoraService loteadoraService;

    @GetMapping("/")
    public List<Terreno> buscarTodos() {
        return terrenoService.buscarTodos();
    }

    @PostMapping("/")
    public Terreno inserir(@RequestBody Terreno objeto) {
        return terrenoService.inserir(objeto);

    }

    @PutMapping("/alterar")
    public Terreno alterar(@RequestBody Terreno objeto) {
        return terrenoService.alterar(objeto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        terrenoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terreno> buscarPorId(@PathVariable("id") Long terrenoId) {
        Terreno terreno = terrenoService.buscarPorId(terrenoId); // Obter o terreno pelo ID
        
        if (terreno != null) {
            return ResponseEntity.ok(terreno); // Retorna o terreno encontrado com o status 200 (OK)
        } else {
            return ResponseEntity.notFound().build(); // Retorna o status 404 (Not Found) se o terreno não for encontrado
        }
    }


    @PostMapping("/{id}/vendido")
    public ResponseEntity<String> marcarTerrenoComoVendido(@PathVariable("id") Long terrenoId, @RequestBody Terreno objeto) {
        

        Terreno terreno = terrenoService.buscarPorId(terrenoId); 
        terreno.setVendido("vendido");
        alterar(terreno);
        
    return ResponseEntity.ok("Terreno marcado como vendido com sucesso.");
    }    



    @GetMapping("/comissao/{id}")
    public ResponseEntity<String> comissao(@PathVariable("id") Long terrenoId) {
        Terreno terreno = terrenoService.buscarPorId(terrenoId);

        // Obtendo o valor de porcentagemComissao
        double porcentagemComissao = terreno.getLoteadora().getPorcentagemComissao();
        double calculo = terreno.getValorVenda() * (porcentagemComissao/100);

  

        // Retornando a resposta
        return ResponseEntity.ok("Valor da Comissão: " + calculo);
    }

    @PostMapping("/{id}/aumentarvenda/{double}")
    public ResponseEntity<String> aumentarVenda(@PathVariable("id") Long loteadoraId, @PathVariable("double") Double valor){
        double testes = 0;  
        try {
            List<Terreno> terrenos = buscarTodos();
            for (Terreno terreno : terrenos)  {
                if (terreno.getLoteadora().getId().equals(loteadoraId) && terreno.getSituacao().equals("Vendendo")) {
                    double x = terreno.getValorPedida();
                    testes = (x * (valor / 100));
                    terreno.setValorVenda(testes);
                }
            }
            return ResponseEntity.ok("Valores alterados " + testes);
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }

    }

    
}
