package com.system.gestao.inventory.controller;

import com.system.gestao.inventory.dto.InventarioEspecieRequest;
import com.system.gestao.inventory.dto.InventarioEspecieResponse;
import com.system.gestao.inventory.service.InventarioEspecieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventarios/especies")
@RequiredArgsConstructor
public class InventarioEspecieController {

    private final InventarioEspecieService service;

    @PostMapping
    public ResponseEntity<InventarioEspecieResponse> salvar(
            @RequestBody @Valid InventarioEspecieRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(request));
    }

    @GetMapping("/inventario/{inventarioId}")
    public ResponseEntity<List<InventarioEspecieResponse>> listarPorInventario(
            @PathVariable Long inventarioId) {
        return ResponseEntity.ok(service.listarPorInventario(inventarioId));
    }

    @GetMapping("/especie/{especieId}")
    public ResponseEntity<List<InventarioEspecieResponse>> listarPorEspecie(
            @PathVariable Long especieId) {
        return ResponseEntity.ok(service.listarPorEspecie(especieId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}