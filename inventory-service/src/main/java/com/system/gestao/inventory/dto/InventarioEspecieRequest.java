package com.system.gestao.inventory.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record InventarioEspecieRequest(

        @NotNull(message = "Inventário é obrigatório")
        Long inventarioId,

        @NotNull(message = "Espécie é obrigatória")
        Long especieId,

        @NotNull(message = "Quantidade de indivíduos é obrigatória")
        @Positive(message = "Quantidade deve ser maior que zero")
        Integer quantidadeIndividuos
) {}
