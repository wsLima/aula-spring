-- Criação da tabela PRODUTOS
CREATE TABLE produtos (
                          id BIGSERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          descricao TEXT,
                          preco NUMERIC(15,2) NOT NULL CHECK (preco > 0),
                          categoria_id BIGINT,

                          CONSTRAINT fk_produtos_categoria FOREIGN KEY (categoria_id)
                              REFERENCES categorias (id) ON DELETE SET NULL
);
