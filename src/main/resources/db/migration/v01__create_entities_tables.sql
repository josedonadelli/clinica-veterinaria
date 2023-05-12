CREATE TABLE tb_cliente(
cliente_id VARCHAR(11) UNIQUE NOT NULL,
nome VARCHAR(255) NOT NULL,
telefone VARCHAR(13) NOT NULL,
email VARCHAR(255) NOT NULL,
rua VARCHAR(255),
numero VARCHAR(10),
cep VARCHAR(10),
complemento VARCHAR(50)
);

CREATE TABLE tb_cachorro(
dog_id BIGINT AUTO_INCREMENT PRIMARY KEY ,

imperial DOUBLE,
metric DOUBLE,
imperial_weight DOUBLE,
metric_weight Double,
nome VARCHAR(255) NOT NULL,
);

CREATE TABLE tb_veterinario(
veterinario_id VARCHAR(6) UNIQUE NOT NULL,
nome VARCHAR(255) NOT NULL,
telefone VARCHAR(13) NOT NULL,
email VARCHAR(255) NOT NULL,
rua VARCHAR(255),
numero VARCHAR(10),
cep VARCHAR(10),
complemento VARCHAR(50)
);