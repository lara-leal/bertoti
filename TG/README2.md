<h1 align="center"> Projeto 2: 2º Semestre de 2021 </h1>

<div align="center"> Projeto Integrador - 2° Semestre | Fatec Prof. Jessen Vidal - 2023 | Cliente parceiro: Necto Systems </div>

## Visão do Projeto

Um software integrado que monitore e apresente métricas referentes ao uso e a saúde do SGBD em tempo real. Além de oferecer um pós gerenciamento de múltiplos BD’s no servidor, como diferencial.

## Tecnologias adotadas na solução

### Java

Java é uma linguagem de programação orientada a objetos que foi criada na década de 1990 pela Sun Microsystems, e é propriedade da Oracle Corporation. É uma das linguagens de programação mais populares do mundo usada em uma ampla variedade de aplicativos e sistemas, desde desenvolvimento de aplicativos desktop e web até jogos e dispositivos móveis.

### PostgreSQL

PostgreSQL é um sistema de gerenciamento de banco de dados relacional (SGBDR) de código aberto e altamente confiável. É amplamente conhecido por sua robustez, escalabilidade e recursos avançados que o tornam uma escolha popular para uma variedade de aplicações.

Uma das principais características do PostgreSQL é sua capacidade de suportar grandes volumes de dados e cargas de trabalho intensivas.

### SQLite

O SQLite é um banco de dados embutido, rápido e leve que não requer um servidor separado para funcionar. Diferente dos bancos de dados tradicionais, o SQLite armazena todo o banco de dados em um único arquivo, tornando-o fácil de implantar e usar em aplicativos.

O SQLite é amplamente utilizado em aplicativos móveis, desktop e em outras aplicações que precisam de um banco de dados local e escrito em linguagem C e disponibiliza uma interface simples através de comandos SQL para executar operações de banco de dados, como criação de tabelas, inserção, atualização, exclusão e consulta de dados.

### Interface com o usuário

Esse projeto não possui interface gráfica pois tinha como objetivo ser executado apenas no terminal.

## Contribuições pessoais

Minhas contribuições  neste projeto foram principalmente na parte extração e implementação de métricas sobre a saúde do banco de dados. 

Para extrair as métricas utilizei como referencia um artigo **“Extraindo Metadados de SGBDs”** da **PONTIFÍCIA UNIVERSIDADE CATÓLICA DO RIO DE JANEIRO.** Esse artigo me ajudou a identificar as tabelas e schemas que extraiam as métricas que definimos como escopo para nosso projeto. Como por exemplo:

- pg_stat_statements
- pg_stat_database
- information_schema.tables

A maior parte do esforço desse semestre foi encontrar documentação que me instruísse como extrair as métricas sobre a saúde do SGBD e como elaborar as querys. 

Como eu estava no 2º semestre, ainda não tinha experiência efetiva em elaborar querys que fossem bem estruturadas. Então a maior parte do desenvolvimento foi constituído por isso. 

Também utilizei Java como linguagem de programação da aplicação, que também foi um desafio visto que durante esse projeto foi a primeira vez que tive contato com a linguagem. 

Desenvolvi a conexão do banco de dados utilizando o SQLite, com nosso “historico.db”. como o trecho de código a seguir: 

```
public static void main(String[] args) throws SQLException, IOException  {
mainClass  con = new mainClass ("postgres");
	String SqLite = "jdbc:sqlite:historico.db";
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	Connection connSqlite = DriverManager.getConnection(SqLite);
	 Statement statement = connSqlite.createStatement();
	 statement.setQueryTimeout(30);
}
```

O banco que usei para realizar o monitoramento foi um banco PostgreSQL.

### Aprendizados Efetivos HS



| Hard Skills                           | Nota (0-5) |
|--------------------------------------|-------------|
| Aprender a programar em Java |★★★☆☆ |
| Aprender a elaborar queries em SQL         |★★★★☆|
|Aprender a usar o postgreSQL  |★★★☆☆|
|Aprender a lidar com cliente real  | ★★★☆☆ |

Em relação a Soft Skills acredito que pude evoluir nos seguintes aspectos:




