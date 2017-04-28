ALTER SCHEMA public RENAME TO dbo;
CREATE SEQUENCE dbo."Users_Id_seq"
    INCREMENT 1
    START 3
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE dbo."Users_Id_seq"
    OWNER TO postgres;
CREATE TABLE dbo."Users"
(
    "Id" bigint NOT NULL DEFAULT nextval('dbo."Users_Id_seq"'::regclass),
    "Name" character varying(32) COLLATE pg_catalog."default" NOT NULL,
    "Surname" character varying(32) COLLATE pg_catalog."default" NOT NULL,
    "UserName" character varying(32) COLLATE pg_catalog."default" NOT NULL,
    "Password" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "EmailAddress" character varying(256) COLLATE pg_catalog."default" UNIQUE NOT NULL,
    "PhoneNumber" text COLLATE pg_catalog."default"
)