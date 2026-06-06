package com.system.gestao.inventory.dto;

import com.system.gestao.inventory.model.EstadoVegetacao;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InventarioRequest(

        @NotNull(message = "Número da parcela é obrigatório")
        Integer numeroParcela,

        @NotNull(message = "Área florestal é obrigatória")
        Long areaFlorestalId,

        @NotNull(message = "Colaborador é obrigatório")
        Long colaboradorId,

        BigDecimal dapMediaCm,
        BigDecimal alturaMediaEstimada,
        String presencaPragasDoencas,

        @NotNull(message = "Estado da vegetação é obrigatório")
        EstadoVegetacao estadoVegetacao,

        LocalDateTime dataVistoria
) {}
