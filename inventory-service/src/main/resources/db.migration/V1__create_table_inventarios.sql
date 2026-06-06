CREATE TABLE inventarios (
    id                      BIGSERIAL       PRIMARY KEY,
    numero_parcela          INTEGER         NOT NULL,
    dap_media_cm            NUMERIC(10, 2),
    altura_media_estimada   NUMERIC(10, 2),
    presenca_pragas_doencas VARCHAR(255),
    estado_vegetacao        VARCHAR(50)     NOT NULL,
    data_vistoria           TIMESTAMP       NOT NULL,
    area_florestal_id       BIGINT          NOT NULL,
    colaborador_id          BIGINT          NOT NULL
);