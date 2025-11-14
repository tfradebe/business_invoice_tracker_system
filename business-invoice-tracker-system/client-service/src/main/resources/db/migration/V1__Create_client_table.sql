CREATE TABLE CLIENT
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    street_number VARCHAR(255) NOT NULL,
    complex       VARCHAR(255) NOT NULL,
    street_name   VARCHAR(255) NOT NULL,
    town          VARCHAR(255) NOT NULL,
    city          VARCHAR(255) NOT NULL,
    postal_code   VARCHAR(255) NOT NULL,
    province      VARCHAR(255) NOT NULL,
    created_date  TIMESTAMP    NOT NULL,
    updated_date  TIMESTAMP    NOT NULL
);

CREATE INDEX idx_client_email ON CLIENT (email);