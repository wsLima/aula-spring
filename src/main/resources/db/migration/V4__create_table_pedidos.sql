-- Criação da tabela PEDIDOS
CREATE TABLE pedidos (
                         id BIGSERIAL PRIMARY KEY,
                         cliente_id BIGINT NOT NULL,
                         data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         total NUMERIC(15,2) DEFAULT 0,

                         CONSTRAINT fk_pedidos_cliente FOREIGN KEY (cliente_id)
                             REFERENCES clientes (id) ON DELETE CASCADE
);
