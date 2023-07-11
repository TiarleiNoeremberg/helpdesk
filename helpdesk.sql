--
-- Name: chamado; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.chamado (
    id integer NOT NULL,
    data_abertura date,
    data_fechamento date,
    observacoes character varying(255),
    prioridade integer,
    status integer,
    titulo character varying(255),
    cliente_id integer,
    tecnico_id integer
);


--
-- Name: chamado_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.chamado ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.chamado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: perfis; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.perfis (
    pessoa_id integer NOT NULL,
    perfis integer
);


--
-- Name: pessoa; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.pessoa (
    dtype character varying(31) NOT NULL,
    id integer NOT NULL,
    cpf character varying(255),
    data_criacao date,
    email character varying(255),
    nome character varying(255),
    senha character varying(255)
);


--
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.pessoa ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: chamado chamado_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.chamado
    ADD CONSTRAINT chamado_pkey PRIMARY KEY (id);


--
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- Name: pessoa uk_mc87q8fpvldpdyfo9o5633o5l; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT uk_mc87q8fpvldpdyfo9o5633o5l UNIQUE (email);


--
-- Name: pessoa uk_nlwiu48rutiltbnjle59krljo; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT uk_nlwiu48rutiltbnjle59krljo UNIQUE (cpf);


--
-- Name: chamado fkivlss0iq4e3dcjqwgfar8i77a; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.chamado
    ADD CONSTRAINT fkivlss0iq4e3dcjqwgfar8i77a FOREIGN KEY (cliente_id) REFERENCES public.pessoa(id);


--
-- Name: chamado fkkc34p1kfv0acpiymukv930dd9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.chamado
    ADD CONSTRAINT fkkc34p1kfv0acpiymukv930dd9 FOREIGN KEY (tecnico_id) REFERENCES public.pessoa(id);


--
-- Name: perfis fklnesgnyiynjyqx8ks8cyhv6il; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.perfis
    ADD CONSTRAINT fklnesgnyiynjyqx8ks8cyhv6il FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);


--
-- PostgreSQL database dump complete
--

