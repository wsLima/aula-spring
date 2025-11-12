-- Criação da tabela ITENS_PEDIDO
CREATE TABLE itens_pedido (
                              id BIGSERIAL PRIMARY KEY,
                              pedido_id BIGINT NOT NULL,
                              produto_id BIGINT NOT NULL,
                              quantidade INTEGER NOT NULL CHECK (quantidade > 0),
                              subtotal NUMERIC(15,2),

                              CONSTRAINT fk_itens_pedido_pedido FOREIGN KEY (pedido_id)
                                  REFERENCES pedidos (id) ON DELETE CASCADE,

                              CONSTRAINT fk_itens_pedido_produto FOREIGN KEY (produto_id)
                                  REFERENCES produtos (id) ON DELETE CASCADE
);
