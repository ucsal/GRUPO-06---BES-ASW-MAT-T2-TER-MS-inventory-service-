CREATE TABLE inventario_especies (
    id                    BIGSERIAL   PRIMARY KEY,
    quantidade_individuos INTEGER     NOT NULL,
    inventario_id         BIGINT      NOT NULL,
    especie_id            BIGINT      NOT NULL,

    CONSTRAINT fk_inventario_especies_inventario
        FOREIGN KEY (inventario_id)
        REFERENCES inventarios (id)
        ON DELETE CASCADE
);