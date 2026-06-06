package com.system.gestao.inventory.dto;

import com.system.gestao.inventory.model.EstadoVegetacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InventarioResponse(
        Long id,
        Integer numeroParcela,
        Long areaFlorestalId,
        Long colaboradorId,
        BigDecimal dapMediaCm,
        BigDecimal alturaMediaEstimada,
        String presencaPragasDoencas,
        EstadoVegetacao estadoVegetacao,
        LocalDateTime dataVistoria
) {}