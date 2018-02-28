
CREATE TABLE tb_evento(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(200),
	data DATE,
	local VARCHAR(100),
	preco DOUBLE(10,2),
	ativo BOOLEAN NOT NULL
);

CREATE TABLE rfid(
	id BIGINT(20) PRIMARY KEY,
	id_evento BIGINT(20),
	ativo BOOLEAN,
	FOREIGN KEY (id_evento) REFERENCES tb_evento(id)
);

CREATE TABLE tb_usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL,
	ativo BOOLEAN NOT NULL
);

CREATE TABLE tb_ingresso_usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_evento BIGINT(20),
	id_usuario BIGINT(20),
	rfid_id BIGINT(20),
	FOREIGN KEY (id_evento) REFERENCES tb_evento(id),
	FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id),
	FOREIGN KEY (rfid_id) REFERENCES rfid(id)
);

--criar um evento
INSERT INTO tb_evento (nome, data, local, preco, ativo) values ('Charli brau cover', '2012-01-01', '21 Music Bar', 10.0, true);

--criar uma tag relacionada a um evento
INSERT INTO rfid (id, id_evento, ativo) values (1182, 1, true);

--admin senha admin 
INSERT INTO tb_usuario (nome, email, senha, ativo) values ('Administrador', 'admin@admin.com','$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', true);

--ingresso do user
INSERT INTO tb_ingresso_usuario(id_evento, id_usuario, rfid_id) values (1, 1, 1182);
