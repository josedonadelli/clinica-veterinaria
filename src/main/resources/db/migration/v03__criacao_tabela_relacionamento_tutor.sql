CREATE TABLE tb_tutor(
cliente_id BIGINT NOT NULL,
cachorro_id BIGINT NOT NULL,

FOREIGN KEY (cliente_id) REFERENCES tb_cliente(cliente_id),
FOREIGN KEY (cachorro_id) REFERENCES tb_cachorro(dog_id) ON DELETE CASCADE ON UPDATE CASCADE
);