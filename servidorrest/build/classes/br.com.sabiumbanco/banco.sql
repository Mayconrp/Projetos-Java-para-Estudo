CREATE DATABASE testesabium
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
       
       CREATE TABLE employee
(
  id bigint NOT NULL,
  name character varying(300) NOT NULL,
  salary numeric(19,2),
  CONSTRAINT employee_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE employee
  OWNER TO postgres;
  
  
  
CREATE TABLE project
(
  id bigint NOT NULL,
  name character varying(300) NOT NULL,
  CONSTRAINT project_pkey PRIMARY KEY (id),
  CONSTRAINT project_name_key UNIQUE (name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE project
  OWNER TO postgres;

  
  
  CREATE TABLE emp_proj
(
  emp_id bigint NOT NULL,
  proj_id bigint NOT NULL,
  id bigint NOT NULL,
  CONSTRAINT constraintemp_id FOREIGN KEY (emp_id)
      REFERENCES employee (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT constraintproj_id FOREIGN KEY (proj_id)
      REFERENCES project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT emp_proj_emp_id_proj_id_key UNIQUE (emp_id, proj_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE emp_proj
  OWNER TO postgres;
  
  
CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 44
  CACHE 1;
ALTER TABLE hibernate_sequence
  OWNER TO postgres;
  
  
  CREATE SEQUENCE seq_employee
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 10
  CACHE 1;
ALTER TABLE seq_employee
  OWNER TO postgres;
  
  
  
  CREATE SEQUENCE seq_project
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 17
  CACHE 1;
ALTER TABLE seq_project
  OWNER TO postgres;





