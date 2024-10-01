CREATE SEQUENCE IF NOT EXISTS revinfo_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE revinfo
(
    rev      INTEGER NOT NULL,
    revtstmp BIGINT,
    CONSTRAINT pk_revinfo PRIMARY KEY (rev)
);

CREATE TABLE motoclube.member
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    deleted_at          TIMESTAMP WITHOUT TIME ZONE,
    modified_by_user_id BIGINT,
    deleted_by_user_id  BIGINT,
    created_by_user_id  BIGINT,
    name                VARCHAR(255),
    nickname            VARCHAR(255),
    phone               VARCHAR(255),
    cpf                 VARCHAR(255),
    street              VARCHAR(255),
    neighborhood        VARCHAR(255),
    cep                 VARCHAR(255),
    city                VARCHAR(255),
    uf                  VARCHAR(255),
    number              VARCHAR(255),
    complement          VARCHAR(255),
    CONSTRAINT pk_member PRIMARY KEY (id)
);

ALTER TABLE motoclube.member
    ADD CONSTRAINT FK_MEMBER_ON_CREATEDBYUSER FOREIGN KEY (created_by_user_id) REFERENCES motoclube.users (id);

ALTER TABLE motoclube.member
    ADD CONSTRAINT FK_MEMBER_ON_DELETEDBYUSER FOREIGN KEY (deleted_by_user_id) REFERENCES motoclube.users (id);

ALTER TABLE motoclube.member
    ADD CONSTRAINT FK_MEMBER_ON_MODIFIEDBYUSER FOREIGN KEY (modified_by_user_id) REFERENCES motoclube.users (id);

CREATE TABLE motoclube_audit.member_audit
(
    rev                 INTEGER NOT NULL,
    created_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    deleted_at          TIMESTAMP WITHOUT TIME ZONE,
    modified_by_user_id BIGINT,
    deleted_by_user_id  BIGINT,
    created_by_user_id  BIGINT,
    revtype             SMALLINT,
    id                  BIGINT  NOT NULL,
    name                VARCHAR(255),
    nickname            VARCHAR(255),
    phone               VARCHAR(255),
    cpf                 VARCHAR(255),
    street              VARCHAR(255),
    neighborhood        VARCHAR(255),
    cep                 VARCHAR(255),
    city                VARCHAR(255),
    uf                  VARCHAR(255),
    number              VARCHAR(255),
    complement          VARCHAR(255),
    CONSTRAINT pk_member_audit PRIMARY KEY (rev, id)
);

ALTER TABLE motoclube_audit.member_audit
    ADD CONSTRAINT FK_MEMBER_AUDIT_ON_REV FOREIGN KEY (rev) REFERENCES revinfo (rev);