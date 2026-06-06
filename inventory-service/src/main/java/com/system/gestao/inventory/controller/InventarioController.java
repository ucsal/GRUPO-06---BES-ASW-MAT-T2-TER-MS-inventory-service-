package com.system.gestao.inventory.controller;

import com.system.gestao.inventory.dto.InventarioRequest;
import com.system.gestao.inventory.dto.InventarioResponse;
import com.system.gestao.inventory.service.InventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService service;

    @PostMapping
    public ResponseEntity<InventarioResponse> salvar(@RequestBody @Valid InventarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(request));
    }

    @GetMapping
    public ResponseEntity<List<InventarioResponse>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/parcela/{numeroParcela}")
    public ResponseEntity<List<InventarioResponse>> historicoComparativo(
            @PathVariable Integer numeroParcela) {
        return ResponseEntity.ok(service.buscarHistoricoComparativo(numeroParcela));
    }

    @GetMapping("/colaborador/{colaboradorId}")
    public ResponseEntity<List<InventarioResponse>> listarPorColaborador(
            @PathVariable Long colaboradorId) {
        return ResponseEntity.ok(service.listarPorColaborador(colaboradorId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioResponse> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid InventarioRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
