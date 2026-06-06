package com.system.gestao.inventory.service;

import com.system.gestao.inventory.dto.InventarioRequest;
import com.system.gestao.inventory.dto.InventarioResponse;
import com.system.gestao.inventory.model.Inventario;
import com.system.gestao.inventory.repository.InventarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class
InventarioService {

    private final InventarioRepository repository;

    @Transactional
    public InventarioResponse salvar(InventarioRequest req) {
        Inventario inv = new Inventario();
        inv.setNumeroParcela(req.numeroParcela());
        inv.setAreaFlorestalId(req.areaFlorestalId());
        inv.setColaboradorId(req.colaboradorId());
        inv.setDapMediaCm(req.dapMediaCm());
        inv.setAlturaMediaEstimada(req.alturaMediaEstimada());
        inv.setPresencaPragasDoencas(req.presencaPragasDoencas());
        inv.setEstadoVegetacao(req.estadoVegetacao());
        inv.setDataVistoria(req.dataVistoria() != null ? req.dataVistoria() : LocalDateTime.now());

        Inventario salvo = repository.save(inv);

        return new InventarioResponse(
                salvo.getId(),
                salvo.getNumeroParcela(),
                salvo.getAreaFlorestalId(),
                salvo.getColaboradorId(),
                salvo.getDapMediaCm(),
                salvo.getAlturaMediaEstimada(),
                salvo.getPresencaPragasDoencas(),
                salvo.getEstadoVegetacao(),
                salvo.getDataVistoria()
        );
    }

    @Transactional
    public InventarioResponse atualizar(Long id, InventarioRequest req) {
        Inventario inv = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inventário não encontrado: " + id));

        inv.setNumeroParcela(req.numeroParcela());
        inv.setAreaFlorestalId(req.areaFlorestalId());
        inv.setColaboradorId(req.colaboradorId());
        inv.setDapMediaCm(req.dapMediaCm());
        inv.setAlturaMediaEstimada(req.alturaMediaEstimada());
        inv.setPresencaPragasDoencas(req.presencaPragasDoencas());
        inv.setEstadoVegetacao(req.estadoVegetacao());
        if (req.dataVistoria() != null) {
            inv.setDataVistoria(req.dataVistoria());
        }

        Inventario atualizado = repository.save(inv);

        return new InventarioResponse(
                atualizado.getId(),
                atualizado.getNumeroParcela(),
                atualizado.getAreaFlorestalId(),
                atualizado.getColaboradorId(),
                atualizado.getDapMediaCm(),
                atualizado.getAlturaMediaEstimada(),
                atualizado.getPresencaPragasDoencas(),
                atualizado.getEstadoVegetacao(),
                atualizado.getDataVistoria()
        );
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Inventário não encontrado: " + id);
        }
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public InventarioResponse buscarPorId(Long id) {
        Inventario inv = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inventário não encontrado: " + id));

        return new InventarioResponse(
                inv.getId(),
                inv.getNumeroParcela(),
                inv.getAreaFlorestalId(),
                inv.getColaboradorId(),
                inv.getDapMediaCm(),
                inv.getAlturaMediaEstimada(),
                inv.getPresencaPragasDoencas(),
                inv.getEstadoVegetacao(),
                inv.getDataVistoria()
        );
    }

    @Transactional(readOnly = true)
    public List<InventarioResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(inv -> new InventarioResponse(
                        inv.getId(),
                        inv.getNumeroParcela(),
                        inv.getAreaFlorestalId(),
                        inv.getColaboradorId(),
                        inv.getDapMediaCm(),
                        inv.getAlturaMediaEstimada(),
                        inv.getPresencaPragasDoencas(),
                        inv.getEstadoVegetacao(),
                        inv.getDataVistoria()
                ))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InventarioResponse> buscarHistoricoComparativo(Integer parcela) {
        return repository.findByNumeroParcelaOrderByDataVistoriaDesc(parcela)
                .stream()
                .map(inv -> new InventarioResponse(
                        inv.getId(),
                        inv.getNumeroParcela(),
                        inv.getAreaFlorestalId(),
                        inv.getColaboradorId(),
                        inv.getDapMediaCm(),
                        inv.getAlturaMediaEstimada(),
                        inv.getPresencaPragasDoencas(),
                        inv.getEstadoVegetacao(),
                        inv.getDataVistoria()
                ))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InventarioResponse> listarPorColaborador(Long colaboradorId) {
        return repository.findByColaboradorId(colaboradorId)
                .stream()
                .map(inv -> new InventarioResponse(
                        inv.getId(),
                        inv.getNumeroParcela(),
                        inv.getAreaFlorestalId(),
                        inv.getColaboradorId(),
                        inv.getDapMediaCm(),
                        inv.getAlturaMediaEstimada(),
                        inv.getPresencaPragasDoencas(),
                        inv.getEstadoVegetacao(),
                        inv.getDataVistoria()
                ))
                .toList();
    }
}
