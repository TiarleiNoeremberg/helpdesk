
    create table chamado (
        cliente_id integer,
        data_abertura date,
        data_fechamento date,
        id integer not null auto_increment,
        prioridade tinyint,
        status tinyint,
        tecnico_id integer,
        observacoes varchar(255),
        titulo varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table perfis (
        perfis integer,
        pessoa_id integer not null
    ) engine=InnoDB;

    create table pessoa (
        data_criacao date,
        id integer not null auto_increment,
        dtype varchar(31) not null,
        cpf varchar(255),
        email varchar(255),
        nome varchar(255),
        senha varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table pessoa 
       add constraint UK_nlwiu48rutiltbnjle59krljo unique (cpf);

    alter table pessoa 
       add constraint UK_mc87q8fpvldpdyfo9o5633o5l unique (email);

    alter table chamado 
       add constraint FKivlss0iq4e3dcjqwgfar8i77a 
       foreign key (cliente_id) 
       references pessoa (id);

    alter table chamado 
       add constraint FKkc34p1kfv0acpiymukv930dd9 
       foreign key (tecnico_id) 
       references pessoa (id);

    alter table perfis 
       add constraint FKlnesgnyiynjyqx8ks8cyhv6il 
       foreign key (pessoa_id) 
       references pessoa (id);
