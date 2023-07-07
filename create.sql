CREATE TABLE IF NOT EXISTS chamado
(
    id serial NOT NULL primary key,
    data_abertura date,
    data_fechamento date,
    observacoes varchar(255),
    prioridade int4,
    status int4,
    titulo varchar(255),
    cliente_id int4,
    tecnico_id int4
);

CREATE TABLE IF NOT EXISTS perfis
(
    pessoa_id int4 NOT NULL,
    perfis int4
);

CREATE TABLE IF NOT EXISTS pessoa
(
    dtype varchar(31) NOT NULL,
    id serial NOT NULL primary key,
    cpf varchar(255),
    data_criacao date,
    email varchar(255),
    nome varchar(255),
    senha varchar(255)
);

ALTER TABLE pessoa
	ADD CONSTRAINT uk_nlwiu48rutiltbnjle59krljo
	UNIQUE (cpf);

ALTER TABLE pessoa
	ADD CONSTRAINT uk_mc87q8fpvldpdyfo9o5633o5l
	UNIQUE (email);

ALTER TABLE chamado
	ADD CONSTRAINT fkivlss0iq4e3dcjqwgfar8i77a
	FOREIGN KEY (cliente_id) 
	REFERENCES pessoa (id);

ALTER TABLE chamado
	ADD CONSTRAINT FKkc34p1kfv0acpiymukv930dd9
	FOREIGN KEY (tecnico_id)
    	REFERENCES pessoa (id);

ALTER TABLE perfis 
       ADD CONSTRAINT FKlnesgnyiynjyqx8ks8cyhv6il 
       FOREIGN KEY (pessoa_id) 
       REFERENCES pessoa (id);

INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Tecnico', 1, '809.932.000-01', '2023-07-05', 'tiarlei@gmail.com', 'Tiarlei Noeremberg', '$2a$10$wFdxZ87VbWiYxtqNrrFKzO98xZsAz62J5RtlJdxULe6/ow4HPEtj2');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Tecnico', 2, '866.038.320-62', '2023-07-05', 'stallman@mail.com', 'Richard Stallman', '$2a$10$QXnmrTKJdAFZH/2HMVI3LeDTe2523uKK/ygo/Rs6iDeQ5pH.YGcgm');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Tecnico', 3, '737.286.470-47', '2023-07-05', 'shannon@mail.com', 'Claude Elwood Shannon', '$2a$10$hT/4ZiAqE6F3xdRtzUc.WudqfBONoizPMST0rlYBRl8gg.AqBKkJ2');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Tecnico', 4, '516.232.000-59', '2023-07-05', 'lee@mail.com', 'Tim Berners-Lee', '$2a$10$lRsv5mMVHzkykXd8LTr6.uUJrIcUDzMF1ziSfObZLgsu.tu9x2AwK');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Tecnico', 5, '812.839.840-75', '2023-07-05', 'linus@mail.com', 'Linus Torvalds', '$2a$10$x5MfAGZiQiQehLpy4n1gR.tctVVaM4nfPKF7cxtNRi486tgO2sUuy');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Cliente', 6, '114.866.520-00', '2023-07-05', 'santosdu@hotmail.com', 'Santos Dumond', '$2a$10$G02wx2.mJ8IvRFXqGHJhTeI6bc/Ze6Gx5WYo2Q6ozWtlSQx36gyz6');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Cliente', 7, '878.125.920-49', '2023-07-05', 'einstein@mail.com', 'Albert Einstein', '$2a$10$eWQIR9Y2VzSQWxsGe8ku/..fK/G9j9eqgn1PCciPn7fFRHlTJqpz2');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Cliente', 8, '009.507.300-09', '2023-07-05', 'curie@mail.com', 'Marie Curie', '$2a$10$klOa9kLI78vmDXmqE9bywO22Mk4hEVJF0n5JcjcfvJDSMr6lQDgcu');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Cliente', 9, '737.834.090-12', '2023-07-05', 'darwin@mail.com', 'Charles Darwin', '$2a$10$UZVA1LmQ00GJmobCUkK2UeYKu00TSUa/qi7Dix37ZX2D0s9.nGzZC');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Cliente', 10, '370.506.910-11', '2023-07-05', 'hawking@mail.com', 'Stephen Hawking', '$2a$10$yFhThlYLdPe5se5eFlQD8uoNzd15wgX0.Bz/f.1TcA9iGx6O.zo52');
INSERT INTO pessoa (dtype, id, cpf, data_criacao, email, nome, senha) VALUES ('Cliente', 11, '585.833.510-15', '2023-07-05', 'planck@mail.com', 'Max Planck', '$2a$10$44y7Qzra.T.QGR2p2pluGO2YNaUiy4rp7RilMieZHA10AesD5NxLK');

INSERT INTO chamado (id, data_abertura, data_fechamento, observacoes, prioridade, status, titulo, cliente_id, tecnico_id) VALUES (1, '2023-07-05', null, 'Primeiro chamado', 1, 1, 'Chamado 1', 6, 1);
INSERT INTO chamado (id, data_abertura, data_fechamento, observacoes, prioridade, status, titulo, cliente_id, tecnico_id) VALUES (2, '2023-07-05', null, 'Teste chamado 2', 2, 0, 'Chamado 2', 7, 1);
INSERT INTO chamado (id, data_abertura, data_fechamento, observacoes, prioridade, status, titulo, cliente_id, tecnico_id) VALUES (3, '2023-07-05', null, 'Teste chamado 3', 0, 2, 'Chamado 3',8,2);
INSERT INTO chamado (id, data_abertura, data_fechamento, observacoes, prioridade, status, titulo, cliente_id, tecnico_id) VALUES (4, '2023-07-05', null, 'Teste chamado 4', 2, 0, 'Chamado 4', 8, 3);
INSERT INTO chamado (id, data_abertura, data_fechamento, observacoes, prioridade, status, titulo, cliente_id, tecnico_id) VALUES (5, '2023-07-05', null, 'Teste chamado 5', 1, 1, 'Chamado 5', 6, 2);
INSERT INTO chamado (id, data_abertura, data_fechamento, observacoes, prioridade, status, titulo, cliente_id, tecnico_id) VALUES (6, '2023-07-05', null, 'Teste chamado 6', 0, 2, 'Chamado 7', 10, 1);

INSERT INTO perfis (pessoa_id, perfis) VALUES (1, 0);
INSERT INTO perfis (pessoa_id, perfis) VALUES (1, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (1, 2);
INSERT INTO perfis (pessoa_id, perfis) VALUES (2, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (2, 2);
INSERT INTO perfis (pessoa_id, perfis) VALUES (3, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (3, 2);
INSERT INTO perfis (pessoa_id, perfis) VALUES (4, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (4, 2);
INSERT INTO perfis (pessoa_id, perfis) VALUES (5, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (5, 2);
INSERT INTO perfis (pessoa_id, perfis) VALUES (6, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (7, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (8, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (9, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (10, 1);
INSERT INTO perfis (pessoa_id, perfis) VALUES (11, 1);