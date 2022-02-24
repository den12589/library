CREATE TABLE IF NOT EXISTS public.authors
(
    id uuid NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    surname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT authors_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.books
(
    id uuid NOT NULL,
    title character varying(50) COLLATE pg_catalog."default" NOT NULL,
    authorid uuid,
    CONSTRAINT books_pkey PRIMARY KEY (id),
    CONSTRAINT books_authorid_fkey FOREIGN KEY (authorid)
        REFERENCES public.authors (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
