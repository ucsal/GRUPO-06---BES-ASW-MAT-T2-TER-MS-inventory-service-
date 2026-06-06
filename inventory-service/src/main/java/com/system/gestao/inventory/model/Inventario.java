package com.system.gestao.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "inventarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numeroParcela;

    @Column
    private BigDecimal dapMediaCm;

    @Column
    private BigDecimal alturaMediaEstimada;

    @Column
    private String presencaPragasDoencas;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVegetacao estadoVegetacao;

    @Column(nullable = false)
    private LocalDateTime dataVistoria;

    @Column(nullable = false)
    private Long areaFlorestalId;

    @Column(nullable = false)
    private Long colaboradorId;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private Set<InventarioEspecie> especiesInventario = new HashSet<>();

}