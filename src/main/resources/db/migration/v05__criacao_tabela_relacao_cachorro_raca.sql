
CREATE TABLE tb_cachorro_raca(
cachorro_id BIGINT NOT NULL,
raca_id BIGINT NOT NULL,
FOREIGN KEY (cachorro_id) REFERENCES tb_cachorro(dog_id),
FOREIGN KEY (raca_id) REFERENCES tb_raca(id)
);