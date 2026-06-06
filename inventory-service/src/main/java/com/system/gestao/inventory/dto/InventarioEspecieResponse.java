package com.system.gestao.inventory.dto;

public record InventarioEspecieResponse(
        Long id,
        Long inventarioId,
        Long especieId,
        Integer quantidadeIndividuos
) {}