-- Criação da tabela CLIENTES
CREATE TABLE clientes (
                          id BIGSERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          emaile VARCHAR(255) UNIQUE NOT NULL,
                          telefone VARCHAR(50),
                          CONSTRAINT email_unico UNIQUE (email)
);

-- Inserções iniciais
INSERT INTO clientes (nome, email, telefone) VALUES
                                                 ('Kennedy Lima', 'kennedy.lima@gmail.com', '(92) 9999-9999'),
                                                 ('Artur Lira', 'art@gmail.com', '(92) 9999-9999'),
                                                 ('Jaqueline Alves', 'jaqueline.alves@gmail.com', '(92) 9999-9999'),
                                                 ('Bernardo Aguiar', 'bernardo.aguiar@gmail.com', '(92) 9999-9999'),
                                                 ('Ana Paula', 'ana.paula@gmail.com', '(92) 9999-9999');
