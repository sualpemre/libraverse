CREATE SEQUENCE seq_roles start 1 increment 1;

CREATE TABLE IF NOT EXISTS account
(
    account_id VARCHAR(255) NOT NULL,
    user_name  VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    role_id    bigint NOT NULL,
    is_active  BOOLEAN      NOT NULL,
    last_login TIMESTAMP WITHOUT TIME ZONE,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_account PRIMARY KEY (account_id)
);

CREATE TABLE IF NOT EXISTS role
(
    role_id bigint NOT NULL default nextval('seq_roles'),
    name    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);


ALTER TABLE account
    ADD CONSTRAINT uc_account_user_name UNIQUE (user_name);


ALTER TABLE account
    ADD CONSTRAINT fk_user_role_on_account FOREIGN KEY (role_id) REFERENCES role (role_id);

ALTER TABLE role
    ADD CONSTRAINT uc_role_name UNIQUE (name);


