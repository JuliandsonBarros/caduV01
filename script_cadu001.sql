DROP TABLE IF EXISTS cadu_004_permissao;

DROP TABLE IF EXISTS cadu_001_secretaria;

DROP TABLE IF EXISTS cadu_006_historico;

DROP TABLE IF EXISTS cadu_005_autenticacao;

DROP TABLE IF EXISTS cadu_002_usuario;

DROP TABLE IF EXISTS cadu_003_perfil;

CREATE TABLE cadu_003_perfil (
  id_perfil INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  nom_perfil VARCHAR(50)  NOT NULL  ,
  sta_perfil CHAR(1)  NOT NULL    ,
PRIMARY KEY(id_perfil));



CREATE TABLE cadu_002_usuario (
  id_usuario BIGINT  NOT NULL   AUTO_INCREMENT,
  nom_usuario VARCHAR(200)  NOT NULL  ,
  nom_email VARCHAR(200)  NOT NULL  ,
  dta_nascimento DATE  NOT NULL  ,
  cod_cpf VARCHAR(15)  NOT NULL  ,
  cod_rg VARCHAR(15)  NOT NULL  ,
  cod_telefone VARCHAR(20)  NOT NULL  ,
  sta_usuario CHAR(1)  NOT NULL    ,
PRIMARY KEY(id_usuario));



CREATE TABLE cadu_005_autenticacao (
  id_autenticacao BIGINT  NOT NULL   AUTO_INCREMENT,
  id_usuario BIGINT  NOT NULL  ,
  cod_acess_token VARCHAR(500)  NOT NULL  ,
  sta_token CHAR(1)  NOT NULL  ,
  dth_autenticacao DATETIME  NOT NULL    ,
PRIMARY KEY(id_autenticacao, id_usuario)  ,
INDEX cadu_005_autenticacao_FKIndex1(id_usuario),
  FOREIGN KEY(id_usuario)
    REFERENCES cadu_002_usuario(id_usuario)
      ON DELETE RESTRICT
      ON UPDATE RESTRICT);



CREATE TABLE cadu_006_historico (
  id_historico BIGINT  NOT NULL   AUTO_INCREMENT,
  id_usuario BIGINT  NOT NULL  ,
  dth_historico INTEGER UNSIGNED  NOT NULL  ,
  tp_acao CHAR(1)  NOT NULL  ,
  nom_acao VARCHAR(100)  NOT NULL  ,
  des_acao VARCHAR(1000)  NOT NULL  ,
  cod_ip_maquina VARCHAR(20)  NOT NULL    ,
PRIMARY KEY(id_historico, id_usuario)  ,
INDEX cadu_006_log_FKIndex1(id_usuario),
  FOREIGN KEY(id_usuario)
    REFERENCES cadu_002_usuario(id_usuario)
      ON DELETE RESTRICT
      ON UPDATE RESTRICT);



CREATE TABLE cadu_001_secretaria (
  id_secretaria INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  id_responsavel BIGINT  NULL  ,
  nom_secretaria VARCHAR(200)  NOT NULL  ,
  nom_endereco VARCHAR(500)  NOT NULL  ,
  cod_telefone VARCHAR(20)  NOT NULL  ,
  sta_secretaria CHAR(1)  NOT NULL  ,
  des_observacao VARCHAR(500)  NULL    ,
PRIMARY KEY(id_secretaria)  ,
INDEX cadu_001_secretaria_FKIndex1(id_responsavel),
  FOREIGN KEY(id_responsavel)
    REFERENCES cadu_002_usuario(id_usuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);



CREATE TABLE cadu_004_permissao (
  id_perfil INTEGER UNSIGNED  NOT NULL  ,
  id_usuario BIGINT  NOT NULL  ,
  sta_permissao CHAR(1)  NOT NULL  ,
  nom_senha VARCHAR(300)  NOT NULL  ,
  cod_verificador VARCHAR(6)  NULL    ,
PRIMARY KEY(id_perfil, id_usuario)  ,
INDEX cadu_004_permissao_FKIndex1(id_usuario)  ,
INDEX cadu_004_permissao_FKIndex2(id_perfil),
  FOREIGN KEY(id_usuario)
    REFERENCES cadu_002_usuario(id_usuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(id_perfil)
    REFERENCES cadu_003_perfil(id_perfil)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);




