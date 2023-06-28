package com.imobiliaria.Imobiliaria.entily;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "terreno")
@Data
public class Terreno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Endereço é obrigatorio.")
    private String endereco;
    private Double metrosQuadradro;
    private Double comprimento;
    private Double largura;
    @NotNull(message = "Valor Pedida é obrigatorio.")
    private Double valorPedida;
    private Double valorVenda;
    private String Situacao;
    
    @ManyToOne
    @JoinColumn(name = "idLoteadora")
    private Loteadora loteadora;

    public String vendido() {
        return Situacao;
    }
    
    public void setVendido(String vendido) {
        this.Situacao = vendido;
    }

}
