<h1 align="center"> Projeto 6: 2º Semestre de 2023 </h1>

<div align="center"> Projeto Integrador - 6° Semestre | Fatec Prof. Jessen Vidal - 2023 | Cliente parceiro: Visiona </div>

## Visão do Projeto

O Proagro é um programa governamental que financia atividades agrícolas de pequenos e médios produtores no Brasil. Ao participar, o produtor precisa fornecer detalhes sobre sua atividade agrícola e a localização das áreas cultivadas. Esses dados são armazenados em tabelas e em um banco de dados. Além disso, informações sobre técnicas de cultivo, tipos de plantas, potencial de produção, dados de plantio e colheita são essenciais. O uso de sensoriamento remoto tem sido eficaz para monitorar atividades agrícolas, e os dados do Proagro são valiosos para criar modelos de inteligência artificial com base em informações obtidas por satélite. O desafio é apresentar esses dados de forma clara e intuitiva em um sistema de informação geográfica, combinando informações sobre operações agrícolas e dados de sensoriamento remoto.

## Tecnologias adotadas na solução

### Python

Python é uma linguagem de programação popular que foi criada na década de 1990 por Guido van Rossum. É conhecida por sua sintaxe simples e fácil de ler, o que a torna uma ótima escolha para iniciantes em programação. Python é usado em muitas áreas diferentes, incluindo ciência de dados, desenvolvimento web, automação de tarefas, inteligência artificial e muito mais. É uma linguagem interpretada, o que significa que o código é executado linha por linha sem a necessidade de compilação. Além disso, Python é uma linguagem de programação de alto nível, o que significa que é mais próxima da linguagem humana do que de uma linguagem de máquina, tornando a programação em Python mais intuitiva e acessível para muitas pessoas.

### PostgreSQL

PostgreSQL é um sistema de gerenciamento de banco de dados relacional (SGBDR) de código aberto e altamente confiável. Ele é amplamente conhecido por sua robustez, escalabilidade e recursos avançados que o tornam uma escolha popular para uma variedade de aplicações. Uma das principais características do PostgreSQL é sua capacidade de suportar grandes volumes de dados e cargas de trabalho intensivas.


### PostGIS
O PostGIS é uma extensão do PostgreSQL para lidar com dados geoespaciais em bancos de dados relacionais. Ele permite armazenar, consultar e analisar informações de localização, sendo essencial para sistemas de informação geográfica (SIG) e análises territoriais, oferecendo operações complexas e indexação espacial para eficiência na manipulação de dados geográficos.

## Contribuições Pessoais
Durante o projeto, minha principal contribuição consistiu na execução do extração, tratamento e carregamento de dados. O cliente nos forneceu os dados do banco por meio de arquivos .csv, juntamente com a modelagem atual do banco de dados. Inicialmente, realizei uma análise da modelagem, procedendo com a normalização e remodelagem do banco, focando em trazer apenas informações que fossem relevantes para o negócio. 


<img src="https://i.ibb.co/2hyqpXV/mer-3.png" alt="mer-3" border="0">


Após essa fase, me dediquei ao tratamento dos dados, utilizando a biblioteca Pandas para filtrar exclusivamente as informações relacionadas à cultura de SOJA, uma vez que esses dados eram cruciais para atender às exigências da regra de negócio de nossa aplicação.
````
import pandas as pd
produtos = pd.read_csv(r'../../data/Produto.csv', encoding='ISO-8859-1')
soja = produtos[produtos['DESCRICAO'] == 'SOJA']`

empreendimento = pd.read_csv(r'../../data/Empreendimento.csv', sep=';', encoding='ISO-8859-1')
cod_empreendimento =  empreendimento[empreendimento['PRODUTO'] == 'SOJA']

sicor_cop_basico = pd.read_csv("C:/Users/leall/OneDrive/Área de Trabalho/02_TABS_BASICAS_OPERACAO_CREDITO_RURAL_PROAGRO_RECURSOS_PUBLICOS_PRIVADOS/SICOR_COP_BASICO.csv", sep=';', encoding='ISO-8859-1')
sicor_cop_basico = sicor_cop_basico.drop(columns=['DT_FIM_COLHEITA', 'DT_FIM_PLANTIO', 'DT_INICIO_PLANTIO', 'DT_INICIO_COLHEITA'])

merged = ref_bacen.merge(sicor_cop_basico, on=['REF_BACEN', 'NU_ORDEM'], how='inner')

glebas = pd.read_csv(r'C:/Users/leall/OneDrive/Área de Trabalho/03_TABS_COMP_BASICAS_OPERACOES_CREDITO_RURAL_PROAGRO_RECURSOS_PUB/Glebas.csv', sep=';', encoding='ISO-8859-1')
glebas_soja = glebas[(glebas['REF_BACEN'].isin(set(merged['REF_BACEN']))) & (glebas['NU_ORDEM'].isin(set(merged['NU_ORDEM'])))]
````





Posteriormente, após concluir o tratamento dos dados, realizei a criação dos comandos de INSERT dos dados no novo banco que fora criado.
````
with open('C:/Users/leall/OneDrive/Área de Trabalho/api-lara/GeoForesight-back/database/insert_postgres/insert_op.sql', 'w') as file:

    for index, row in df.iterrows():
        ref_bacen = str(row['ref_bacen'])
        nu_ordem = str(row['nu_ordem'])
        inicio_plantio = row['inicio_plantio']
        final_plantio = row['final_plantio']
        inicio_colheita = row['inicio_colheita']
        final_colheita = row['final_colheita']
        data_vencimento = row['data_vencimento']
        idempreendimento = row['idempreendimento']
        idevento = row['idevento']
        idsolo = row['idsolo']
        idirrigacao = row['idirrigacao']
        idciclo = row['idciclo']
        idgrao = row['idgrao']
        idcultivar = row['idcultivar']
        idprograma = row['idprograma']
        estado = row['estado']

        
        dataframe = query = f"INSERT INTO PUBLIC.operacao_credito_estadual(ref_bacen, nu_ordem, inicio_plantio, final_plantio, inicio_colheita, final_colheita, data_vencimento, idempreendimento, idevento, idsolo, idirrigacao, idciclo, idgrao, idcultivar, idprograma, estado) VALUES ('{ref_bacen}', '{nu_ordem}', '{inicio_plantio}', '{final_plantio}', '{inicio_colheita}', '{final_colheita}', '{data_vencimento}', {idempreendimento}, {idevento}, {idsolo}, {idirrigacao}, {idciclo}, {idgrao}, {idcultivar}, {idprograma}, '{estado}');\n"
        file.write(query)
````

Desempenhei um papel fundamental na implementação de alguns conceitos da Lei Geral de Proteção de Dados (LGPD) no backend da aplicação. Isso envolveu a elaboração de termos de uso e consentimento, a validação do aceite desses termos e a modificação da permissão concedida.

````
@app.route('/verificar_aceitacao', methods=['GET'])
@jwt_required()
def verificar_aceitacao():
    current_user = get_jwt_identity()

    query = text(f"""
         SELECT id_user, au.id_termo, tt.id_tipo, tt.tipo_desc ,data_aceitacao, au.aceite
FROM aceitacao_usuario AS au
join public.user as u on u.id = au.id_user 
JOIN termos AS t ON t.id = au.id_termo
JOIN tipo_termos AS tt ON tt.id_tipo = tt.id_tipo
            WHERE au.aceite = True
            AND au.data_aceitacao = ( SELECT MAX(data_aceitacao)
            FROM aceitacao_usuario
            WHERE id_user =:current_user);
    """)

    result = db.session.execute(query, {'current_user': current_user})

    
    termos_aceitos = []
    for row in result:
        termos_aceitos.append({
            'id_user': row[0],
            'id_termo': row[1],
            'id_tipo': row[2],
            'tipo_desc': row[3],
            'data_aceitacao': row[4].isoformat(),
            'aceite': row[5]
        })
    print(termos_aceitos)

    if termos_aceitos:
        return jsonify({'termos_aceitos': termos_aceitos})
    else:
        return jsonify({'message': 'Nenhum termo aceito encontrado'}), 404

````

Também tive a oportunidade de aprender como utilizar a extensão postGIS do PostgreSQL, que cria primeiramente tabelas com colunas espaciais, e entender como é feito um insert de dados geográficos. Por exemplo, na criação da coluna "coordenadas" é utilizado o tipo geography(Point,4326), que é utilizado para armazenar informações geográficas no formato Point usando o sistema de referência espacial WGS 84 (SRID 4326). 

````
CREATE TABLE IF NOT EXISTS public.glebas
(
    idgleba integer SERIAL,
    ref_bacen numeric,
    nu_ordem numeric,
    longitude character varying(255) COLLATE pg_catalog."default",
    latitude character varying(255) COLLATE pg_catalog."default",
    coordenadas geography(Point,4326),
    altitude numeric,
    nu_ponto numeric,
    nu_identificador numeric,
    nu_indice numeric,
    CONSTRAINT glebas_pkey PRIMARY KEY (idgleba),
    CONSTRAINT glebas_ref_bacen_nu_ordem_fkey FOREIGN KEY (nu_ordem, ref_bacen)
        REFERENCES public.operacao_credito_estadual (nu_ordem, ref_bacen) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
````
Já para criar um insert é necessário utilizar a função ST_GeogFromText que cria um ponto em um espaço bidimensional usando as coordenadas, gerando um dado geográfico.
````
INSERT INTO PUBLIC.GLEBAS(REF_BACEN,  NU_ORDEM, LONGITUDE, LATITUDE,  COORDENADAS, ALTITUDE, NU_PONTO,NU_IDENTIFICADOR) VALUES('513678782','1',-52.2909909,-27.7581412,ST_GeogFromText('POINT(-52.2909909 -27.7581412)'),0,29,1);
````
###  Aprendizados Efetivos HS
- Trabalhar com a biblioteca Pandas do Python para extrair, transformar e carregar dados;
- Utilizar a extensão postGIS do PostgreSQL;
- Remodelagem e normalização de um banco de dados legado;
- Trabalhar com Flask para desenvolvimento do backend da aplicação;
