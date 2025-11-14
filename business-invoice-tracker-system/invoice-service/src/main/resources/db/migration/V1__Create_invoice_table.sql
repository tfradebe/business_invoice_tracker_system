CREATE TABLE invoice(
    id BIGINT PRIMARY KEY,
    invoice_number VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE NOT NULL,
    client_id BIGINT NOT NULL,
    status VARCHAR NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NOT NULL
);

CREATE INDEX idx_client_id ON invoice (client_id);
