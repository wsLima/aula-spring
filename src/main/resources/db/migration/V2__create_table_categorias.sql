-- Criação da tabela CATEGORIAS
CREATE TABLE categorias (
                            id BIGSERIAL PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL
);

-- Inserções iniciais
INSERT INTO categorias (nome) VALUES
                                  ('Masculino'),
                                  ('Feminino'),
                                  ('Infantil'),
                                  ('Calçados'),
                                  ('Acessórios');
