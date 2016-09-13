
-- Table: public.color_list

-- DROP TABLE public.color_list;
CREATE SEQUENCE public."color_list_ID_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public."color_list_ID_seq"
    OWNER TO postgres;
    
CREATE TABLE public.color_list
(
    "ID" bigint NOT NULL DEFAULT nextval('"color_list_ID_seq"'::regclass),
    "COLOR_NAME" character varying(50) NOT NULL,
    CONSTRAINT color_list_pkey PRIMARY KEY ("ID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.color_list
    OWNER to postgres;

-- Table: public.keeper_list

-- DROP TABLE public.keeper_list;
CREATE SEQUENCE public."keeper_list_ID_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public."keeper_list_ID_seq"
    OWNER TO postgres;
    
CREATE TABLE public.keeper_list
(
    "ID" bigint NOT NULL DEFAULT nextval('"keeper_list_ID_seq"'::regclass),
    "NAME" character varying(200) NOT NULL,
    "PERSON_CODE" character varying(12) NOT NULL,
    CONSTRAINT keeper_list_pkey PRIMARY KEY ("ID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.keeper_list
    OWNER to postgres;
	
-- Table: public.auto_reg

-- DROP TABLE public.auto_reg;
CREATE SEQUENCE public."auto_reg_ID_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public."auto_reg_ID_seq"
    OWNER TO postgres;
    
CREATE TABLE public.auto_reg
(
    "ID" bigint NOT NULL DEFAULT nextval('"auto_reg_ID_seq"'::regclass),
    "BRAND" character varying(100) NOT NULL,
    "NUMBER" character varying(20) ,
    "COLOR_ID" integer NOT NULL,
    "KEEPER_ID" integer NOT NULL,
    CONSTRAINT auto_reg_pkey PRIMARY KEY ("ID"),
    CONSTRAINT fk_color_id FOREIGN KEY ("COLOR_ID")
        REFERENCES public.color_list ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_keeper_id FOREIGN KEY ("KEEPER_ID")
        REFERENCES public.keeper_list ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.auto_reg
    OWNER to postgres;

INSERT INTO public.color_list(
"ID", "COLOR_NAME")
VALUES (1, 'White');

INSERT INTO public.color_list(
"ID", "COLOR_NAME")
VALUES (2, 'Black');

INSERT INTO public.color_list(
"ID", "COLOR_NAME")
VALUES (3, 'Red');

INSERT INTO public.color_list(
"ID", "COLOR_NAME")
VALUES (4, 'Blue');

INSERT INTO public.keeper_list(
"ID", "NAME", "PERSON_CODE")
VALUES (1, 'Maksims', '111111-11111');

INSERT INTO public.keeper_list(
"ID", "NAME", "PERSON_CODE")
VALUES (2, 'Evita', '222222-22222');

INSERT INTO public.keeper_list(
"ID", "NAME", "PERSON_CODE")
VALUES (3, 'Anna', '123456-12345');

INSERT INTO public.keeper_list(
"ID", "NAME", "PERSON_CODE")
VALUES (4, 'Uldis', '888888-88888');

INSERT INTO public.keeper_list(
"ID", "NAME", "PERSON_CODE")
VALUES (5, 'Viktors', '777777-77777');


INSERT INTO public.auto_reg(
"ID", "BRAND", "NUMBER", "COLOR_ID", "KEEPER_ID")
VALUES (1, 'Audi', 'TR2345', 1, 1);

INSERT INTO public.auto_reg(
"ID", "BRAND", "NUMBER", "COLOR_ID", "KEEPER_ID")
VALUES (2, 'Opel', 'SR3456', 1, 2);

INSERT INTO public.auto_reg(
"ID", "BRAND", "NUMBER", "COLOR_ID", "KEEPER_ID")
VALUES (3, 'Ford', 'TT1234', 2, 3);

INSERT INTO public.auto_reg(
"ID", "BRAND", "NUMBER", "COLOR_ID", "KEEPER_ID")
VALUES (4, 'Porsche', 'ZERO', 3, 1);

INSERT INTO public.auto_reg(
"ID", "BRAND", "NUMBER", "COLOR_ID", "KEEPER_ID")
VALUES (5, 'BMW', 'CC4567', 4, 5);