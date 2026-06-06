package com.system.gestao.inventory.repository;

import com.system.gestao.inventory.model.InventarioEspecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioEspecieRepository extends JpaRepository<InventarioEspecie, Long> {

    List<InventarioEspecie> findByInventarioId(Long inventarioId);

    List<InventarioEspecie> findByEspecieId(Long especieId);
}