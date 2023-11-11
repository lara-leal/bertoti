<h1 align="center"> Projeto 6: 2º Semestre de 2023 </h1>

<div align="center"> Projeto Integrador - 6° Semestre | Fatec Prof. Jessen Vidal - 2023 | Cliente parceiro: Visiona </div>

### Visão do Projeto

O Proagro é um programa governamental que financia atividades agrícolas de pequenos e médios produtores no Brasil. Ao participar, o produtor precisa fornecer detalhes sobre sua atividade agrícola e a localização das áreas cultivadas. Esses dados são armazenados em tabelas e em um banco de dados. Além disso, informações sobre técnicas de cultivo, tipos de plantas, potencial de produção, dados de plantio e colheita são essenciais. O uso de sensoriamento remoto tem sido eficaz para monitorar atividades agrícolas, e os dados do Proagro são valiosos para criar modelos de inteligência artificial com base em informações obtidas por satélite. O desafio é apresentar esses dados de forma clara e intuitiva em um sistema de informação geográfica, combinando informações sobre operações agrícolas e dados de sensoriamento remoto.

### Tecnologias adotadas na solução

### Python

Python é uma linguagem de programação popular que foi criada na década de 1990 por Guido van Rossum. É conhecida por sua sintaxe simples e fácil de ler, o que a torna uma ótima escolha para iniciantes em programação. Python é usado em muitas áreas diferentes, incluindo ciência de dados, desenvolvimento web, automação de tarefas, inteligência artificial e muito mais. É uma linguagem interpretada, o que significa que o código é executado linha por linha sem a necessidade de compilação. Além disso, Python é uma linguagem de programação de alto nível, o que significa que é mais próxima da linguagem humana do que de uma linguagem de máquina, tornando a programação em Python mais intuitiva e acessível para muitas pessoas.

### PostgreSQL

PostgreSQL é um sistema de gerenciamento de banco de dados relacional (SGBDR) de código aberto e altamente confiável. Ele é amplamente conhecido por sua robustez, escalabilidade e recursos avançados que o tornam uma escolha popular para uma variedade de aplicações. Uma das principais características do PostgreSQL é sua capacidade de suportar grandes volumes de dados e cargas de trabalho intensivas.


### PostGIS
O PostGIS é uma extensão do PostgreSQL para lidar com dados geoespaciais em bancos de dados relacionais. Ele permite armazenar, consultar e analisar informações de localização, sendo essencial para sistemas de informação geográfica (SIG) e análises territoriais, oferecendo operações complexas e indexação espacial para eficiência na manipulação de dados geográficos.

### Contribuições Pessoais
Durante o projeto, minha principal contribuição consistiu na execução do extração, tratamento e carregamento de dados. O cliente nos forneceu os dados do banco por meio de arquivos .csv, juntamente com a modelagem atual do banco de dados. Inicialmente, realizei uma análise da modelagem, procedendo com a normalização e remodelagem do banco. Após essa fase, me dediquei ao tratamento dos dados, utilizando a biblioteca Pandas para filtrar exclusivamente as informações relacionadas à cultura de SOJA, uma vez que esses dados eram cruciais para atender às exigências da regra de negócio de nossa aplicação.

Posteriormente, após concluir o tratamento dos dados, realizei a criação dos comandos de INSERT dos dados no novo banco que fora criado. Também, desempenhei um papel fundamental na implementação de alguns conceitos da Lei Geral de Proteção de Dados (LGPD) no backend da aplicação. Isso envolveu a elaboração de termos de uso e consentimento, a validação do aceite desses termos e a modificação da permissão concedida.

## Aprendizados Efetivos HS
- Trabalhar com a biblioteca Pandas do Python para extrair, transformar e carregar dados;
- Utilizar a extensão postGIS do PostgreSQL;
- Remodelagem e normalização de um banco de dados legado;
