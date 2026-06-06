package com.system.gestao.inventory.service;

import com.system.gestao.inventory.dto.InventarioEspecieRequest;
import com.system.gestao.inventory.dto.InventarioEspecieResponse;
import com.system.gestao.inventory.model.Inventario;
import com.system.gestao.inventory.model.InventarioEspecie;
import com.system.gestao.inventory.repository.InventarioEspecieRepository;
import com.system.gestao.inventory.repository.InventarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventarioEspecieService {

    private final InventarioEspecieRepository repository;
    private final InventarioRepository inventarioRepository;

    @Transactional
    public InventarioEspecieResponse salvar(InventarioEspecieRequest req) {
        Inventario inventario = inventarioRepository.findById(req.inventarioId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Inventário não encontrado: " + req.inventarioId()));

        InventarioEspecie entidade = new InventarioEspecie();
        entidade.setInventario(inventario);
        entidade.setEspecieId(req.especieId());
        entidade.setQuantidadeIndividuos(req.quantidadeIndividuos());

        InventarioEspecie salvo = repository.save(entidade);

        return new InventarioEspecieResponse(
                salvo.getId(),
                salvo.getInventario().getId(),
                salvo.getEspecieId(),
                salvo.getQuantidadeIndividuos()
        );
    }

    @Transactional(readOnly = true)
    public List<InventarioEspecieResponse> listarPorInventario(Long inventarioId) {
        return repository.findByInventarioId(inventarioId)
                .stream()
                .map(e -> new InventarioEspecieResponse(
                        e.getId(),
                        e.getInventario().getId(),
                        e.getEspecieId(),
                        e.getQuantidadeIndividuos()
                ))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InventarioEspecieResponse> listarPorEspecie(Long especieId) {
        return repository.findByEspecieId(especieId)
                .stream()
                .map(e -> new InventarioEspecieResponse(
                        e.getId(),
                        e.getInventario().getId(),
                        e.getEspecieId(),
                        e.getQuantidadeIndividuos()
                ))
                .toList();
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Registro não encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
