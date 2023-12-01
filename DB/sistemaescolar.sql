CREATE SCHEMA IF NOT EXISTS sistemaescolar DEFAULT CHARACTER SET utf8 ;
USE sistemaescolar;


CREATE TABLE pessoa (
    idpessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE aluno (
    idaluno INT PRIMARY KEY  ,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    turma VARCHAR(255) NOT NULL
);

CREATE TABLE professor (
    idprofessor INT PRIMARY KEY ,
    nome VARCHAR(255) NOT NULL,
    disciplina VARCHAR(255) NOT NULL,
    cargahoraria INT NOT NULL
);

CREATE TABLE disciplina (
    iddisciplina INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idprofessor INT,
    FOREIGN KEY (idprofessor) REFERENCES professor(idprofessor)
);


CREATE TABLE aula (
    idaula INT PRIMARY KEY ,
    iddisciplina INT,
    horario VARCHAR(255) NOT NULL,
    local VARCHAR(255) NOT NULL,
    FOREIGN KEY (iddisciplina) REFERENCES disciplina(iddisciplina)
);

CREATE TABLE funcionario (
    idfuncionario INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL
);

CREATE TABLE periodoletivo (
    idperiodoletivo INT PRIMARY KEY,
    datainicio DATE NOT NULL,
    datatermino DATE NOT NULL
);

CREATE TABLE gradecurricular (
    idgradecurricular INT PRIMARY KEY ,
    idperiodoletivo INT,
    FOREIGN KEY (idperiodoletivo) REFERENCES periodoletivo(idperiodoletivo)
);

CREATE TABLE gradecurricular_disciplina (
    idgradecurricular INT ,
    iddisciplina INT,
    PRIMARY KEY (idgradecurricular, iddisciplina),
    FOREIGN KEY (idgradecurricular) REFERENCES gradecurricular(idgradecurricular),
    FOREIGN KEY (iddisciplina) REFERENCES disciplina(iddisciplina)
);




CREATE TABLE presenca (
    idpresenca INT PRIMARY KEY,
    idaluno INT NOT NULL ,
    data DATE NOT NULL,
    presente BOOLEAN NOT NULL,
    FOREIGN KEY (idaluno) REFERENCES aluno(idaluno)
);


CREATE TABLE turma (
    idturma INT PRIMARY KEY ,
    horario VARCHAR(255) NOT NULL
);



CREATE TABLE turma_aluno (
    idturma INT NOT NULL,
    idaluno INT NOT NULL,
    PRIMARY KEY (idturma, idaluno),
    FOREIGN KEY (idturma) REFERENCES turma(idturma),
    FOREIGN KEY (idaluno) REFERENCES aluno(idaluno)
);


CREATE TABLE turma_professor (
    idturma INT NOT NULL,
    idprofessor INT NOT NULL,
    PRIMARY KEY (idturma, idprofessor),
    FOREIGN KEY (idturma) REFERENCES turma(idturma),
    FOREIGN KEY (idprofessor) REFERENCES professor(idprofessor)
);

CREATE TABLE nota (
    idnota INT PRIMARY KEY ,
    idaluno INT NOT NULL,
    iddisciplina INT NOT NULL,
    valor DOUBLE,
    FOREIGN KEY (idaluno) REFERENCES aluno(idaluno),
    FOREIGN KEY (iddisciplina) REFERENCES disciplina(iddisciplina)
);

SELECT * FROM nota;
