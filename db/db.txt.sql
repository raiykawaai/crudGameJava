
CREATE TABLE tb_jogador (
    cd_jogador           NUMBER(7)             NOT NULL,
    nm_jogador           VARCHAR2(50)          NOT NULL,
    ds_type_jogador      VARCHAR2(100)         NOT NULL,
    ds_mode_game         VARCHAR2(100)         NOT NULL,
    ds_armament          VARCHAR2(300)         NOT NULL
);

CREATE SEQUENCE sq_tb_jogador START WITH 1 INCREMENT BY 1 NOCACHE;

-- CHAVE PRIMÁRIA 
  ALTER TABLE tb_jogador 
ADD CONSTRAINT pk_jogador
    PRIMARY KEY ( cd_jogador );


-- UNIQUE -> CAMPO nm_jogador
  ALTER TABLE tb_jogador
ADD CONSTRAINT un_jogador_nome 
    UNIQUE ( nm_jogador );