package com.imobiliaria.Imobiliaria.entily;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "imobiliaria")
@Data
public class Loteadora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeFantasia;
    
    @NotNull(message = "Razão Social é obrigatorio.")
    private String razaoSocial;
    private String endereco;
    private String telefone;
    @NotNull(message = "Comissão é obrigatorio.")
    private Double porcentagemComissao;
  


    
}
