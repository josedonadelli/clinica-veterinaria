CREATE TABLE tb_consulta(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
cachorro_id BIGINT DEFAULT '' NOT NULL,
veterinario_id VARCHAR(6) NOT NULL,
data DATETIME,
peso DOUBLE(5,2) NOT NULL,
altura DOUBLE(5, 2) NOT NULL,
idade INTEGER NOT NULL,
diagnostico TEXT(5000),
comentarios  TEXT(1000)
FOREIGN KEY (cachorro_id) REFERENCES tb_cachorro(dog_id),
FOREIGN KEY (veterinario_id) REFERENCES tb_veterinario(veterinario_id)

);