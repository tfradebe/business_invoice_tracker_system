CREATE TABLE invoice_items(
                              invoice_id BIGINT NOT NULL,
                              name VARCHAR(255) NOT NULL,
                              description VARCHAR(255),
                              price DECIMAL(10,2),
                              quantity INT NOT NULL,
                              PRIMARY KEY (invoice_id, name),
                              FOREIGN KEY (invoice_id) REFERENCES invoice(id) ON DELETE CASCADE
);

CREATE INDEX idx_invoice_items_invoice_id ON invoice_items(invoice_id);