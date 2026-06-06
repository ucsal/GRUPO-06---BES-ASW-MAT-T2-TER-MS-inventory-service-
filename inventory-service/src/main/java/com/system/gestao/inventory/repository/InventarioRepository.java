package com.system.gestao.inventory.repository;

import com.system.gestao.inventory.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    List<Inventario> findByNumeroParcelaOrderByDataVistoriaDesc(Integer numeroParcela);

    List<Inventario> findByColaboradorId(Long colaboradorId);
}