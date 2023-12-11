# Lara Oliveira Leal
## Introdução
<img align='right' src="https://media.discordapp.net/attachments/888964389368131629/1175834034404872253/fotor-2023111913227.png?ex=656cabc7&is=655a36c7&hm=5b0e72e0874ba809bb134b2ba1a0893a520970e815da7124df84da8dc042a61b&=&width=565&height=565" width="200" height="200"/>

<p style="text-align: justify;"> 
Olá! Meu nome é Lara Leal, sou de São José dos Campos - SP, e tenho 22 anos. Desde criança sempre fui muito curiosa, algo que me acompanha até hoje. No Ensino Médio, cursei Técnico em Química no CEPHAS (Centro Educacional Hélio Augusto de Souza) movida pela minha curiosidade. Terminei o técnico e, logo em seguida, veio o início da pandemia. Foi nesse momento que tomei conhecimento do Vestibular da FATEC e decidi prestá-lo para explorar mais sobre o mundo da tecnologia. Visto que seria online naquele momento, achei que seria uma ótima oportunidade para adquirir conhecimento durante essa fase desafiadora.

Minha primeira experiência com programação aconteceu na faculdade, onde aprendi Python nas aulas de LP 1. Atualmente, meu foco principal é o Back-End e Ciência de Dados. Tenho mais familiaridade com as linguagens Python e Java, o que me permite desenvolver web services, utilizar padrões de projetos e criar arquiteturas. Também tenho conhecimento em frameworks amplamente utilizados no mercado, como Quarkus, SpringBoot e Flask.

Atualmente, trabalho como Analista de Sistemas na Farma Conde. Minhas principais responsabilidades envolvem levantamento de requisitos, arquitetura e modelagem de banco de dados, além do desenvolvimento de automações de processos. </p>

<h1 align="center"> Projeto 1: 1º Semestre de 2021 </h1>

<div align="center"> Projeto Integrador - 1° Semestre | Fatec Prof. Jessen Vidal - 2021 | Cliente parceiro: Professor Fabiano Sabha </div>


## Visão do Projeto

Com o propósito de trazer para os estudantes, em geral, uma forma mais centralizada e organizada de cuidar da vida acadêmica e se manter atualizado em suas atividades, criamos a Athena- Assistente Pessoal de Estudos. O seu diferencial é reunir diversas ferramentas úteis em um único lugar.

## Tecnologias adotadas na solução

### Python

Python é uma linguagem de programação popular que foi criada na década de 1990 por Guido van Rossum. É conhecida por sua sintaxe simples e de fácil leitura, o que a torna uma ótima escolha para iniciantes em programação. Python é usada em muitas áreas diferentes, incluindo ciência de dados, desenvolvimento web, automação de tarefas, inteligência artificial e dentre outras. É uma linguagem interpretada, o que significa que o código é executado linha por linha sem a necessidade de compilação. Além disso, Python é uma linguagem de programação de alto nível, o que significa que é mais próxima da linguagem humana do que de uma linguagem de máquina, tornando a programação em Python mais intuitiva e acessível para muitas pessoas.

### **SQLite**

SQLite é um sistema de gerenciamento de banco de dados relacional que é fácil de usar e não requer uma configuração complexa. Um sistema conhecido por sua portabilidade, confiabilidade e eficiência e usado em muitas aplicações em dispositivos móveis e de desktop. O SQLite é incorporado diretamente em muitos aplicativos e sistemas operacionais, o que significa que não é necessário instalar nenhum software adicional para usar bancos de dados SQLite. Executado em um único arquivo, tornando-o ideal para pequenos projetos ou para aplicações que não requerem uma grande quantidade de dados. Além disso, o SQLite é compatível com SQL, possibilitando usar as mesmas consultas SQL que você usaria em outros sistemas de gerenciamento de banco de dados relacionais, como o MySQL ou o PostgreSQL.

### SpeechRecognition

A biblioteca SpeechRecognition é uma ferramenta de reconhecimento de fala para a linguagem de programação Python. Com essa ferramenta, é possível capturar e converter áudio em texto, tornando a interação com aplicativos mais intuitiva e acessível.

Também, é possível desenvolver aplicativos que utilizam a fala como entrada de dados, como assistentes virtuais, sistemas de controle de voz, transcrições de áudio, entre outros. A biblioteca SpeechRecognition simplifica muito a tarefa de processar áudio em texto, permitindo que desenvolvedores implementem recursos de reconhecimento de fala em suas aplicações de forma rápida e fácil.

### Interface com o usuário

Esse projeto não possui interface gráfica pois foi baseado 100% em comandos de voz. 

### BackEnd

Python é uma linguagem de programação de alto nível e de código aberto amplamente utilizada em desenvolvimento de software, análise de dados, IA e automação de tarefas. Possui sintaxe simples e legível, ampla biblioteca padrão e é uma escolha popular para iniciantes e profissionais.

## Contribuições pessoais

Minhas contribuições pessoais neste projeto foram principalmente na parte de definição do escopo do produto e divisão das tarefas atuando como Scrum Master, também com desenvolvimento do backend e criação do banco de dados.

A ferramenta utilizada para desenvolver o banco de dados nesse primeiro projeto foi o SQLite por se tratar de uma ferramenta simples e menos complexa. 

Fui a responsável pelo desenvolvimento das seguintes funções da nossa assistente de voz:

</details>

<details>
<summary> Cálculo de média </summary>

Através de comandos de voz, a aplicação pergunta ao usuário a matéria desejada e realiza uma consulta SQL. Em seguida, calcula a média com base em valores específicos das colunas do resultado da consulta e informa o resultado ao usuário por voz.

```` if there_exists(["calcule a média", "mostrar média", "visualizar média"]):
        speak("Para qual matéria gostaria de calcular sua média ")
        vsqlin = " SELECT * FROM GERAL"
        res = consulta(vcon, vsqlin)
        materias_media = []
        for result in res:
            materias_media.append(result[1])
        voice = record_audio().strip().lower()
        index_media = materias_media.index(voice)
        if voice in materias_media:
            if res[index_media][4] != -1 or res[index_media][5] != -1 or res[index_media][6] != \
                    -1 or res[index_media][7] != -1:
                media = (res[index_media][4] + res[index_media][5] + res[index_media][6] + res[index_media][7]) / 4
                speak(f'a média para a matéria "{voice}" é: {media}')
            else:
                speak('Não foi possível calcular sua média, tente cadastrar todas suas notas e tente novamente!')
        else:
            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria basta dizer '
                  '"Cadastrar Matéria" ')
            return record_audio()
````
</details>

<details>
<summary> Controle de faltas </summary>

A lógica implementada foi fazer a aplicação verificar se o usuário quer registrar, adicionar ou remover faltas. Solicita a matéria e a quantidade de faltas desejada, realizando as operações necessárias no banco de dados. 

````
if there_exists(["registrar faltas", "anotar faltas", "adicionar faltas", "cadastrar faltas",
                     "cadastrar falta", "registrar falta", "anotar falta"]):
        try:
            vsqlin = " SELECT * FROM GERAL"
            res = consulta(vcon, vsqlin)
            materias_faltas = []
            for result in res:
                materias_faltas.append(result[1])
            speak('Para qual matéria gostaria de registrar suas faltas?')
            fal = record_audio().strip().lower().split()
            if fal[0] in materias_faltas:
                index = materias_faltas.index(fal[0])
                if res[index][8] == -1:
                    speak(f'quantas faltas gostaria de registrar para a matéria: "{fal[0]}"')
                    int_faltas = record_audio().strip()
                    update("FALTAS", int(int_faltas), res[index][8])
                else:
                    speak(' Voce deseja "somar" ou "remover" suas faltas ?')
                    resp = record_audio().strip().lower()
                    if resp == "somar":
                        speak('Para qual matéria gostaria de adicionar suas faltas?')
                        fal = record_audio().strip().lower().split()
                        if fal[0] in materias_faltas:
                            speak(f'Quantas faltas gostaria de adicionar para a matéria: "{fal[0]}"')
                            int_faltas = record_audio().strip()
                            index = materias_faltas.index(fal[0])
                            update("FALTAS", int(int_faltas) + res[index][8], res[index][8])
                        else:
                            speak('Não encontrei essa matéria no meu banco de dados, para criar uma nova matéria '
                                  'basta dizer "Cadastrar Matéria" ')
                    if resp == "remover":
                        speak('Para qual matéria gostaria de remover suas faltas ?')
                        fal = record_audio().strip().lower().split()
                        if fal[0] in materias_faltas:
                            speak(f'Quantas faltas gostaria de remover para a matéria: "{fal[0]}"')
                            int_faltas = record_audio().strip()
                            index = materias_faltas.index(fal[0])
                            update("FALTAS", res[index][8] - int(int_faltas), res[index][8])
````


</details>

### Aprendizados Efetivos HS

Neste projeto pude começar a desenvolver minhas habilidades em linguagens de programação do zero. Abaixo listei alguns dos aprendizados obtidos nesse semestre:



| Hard Skills                           | Nota (0-5) |
|--------------------------------------|-------------|
| Aprender como usar uma IDE |★★★★☆ |
| Aprender como fazer um MER         |★★★★☆|
|Aprender como programar   |★★★☆☆|
| Lógica de programação   | ★★★☆☆ |
| Metodologia Ágil - Scrum             | ★★★★☆ |
| Biblioteca SpeechRecognition             |★★★☆☆|

### Soft skills

Em relação a Soft Skills acredito que pude evoluir nos seguintes aspectos:

- Trabalho em equipe

Melhorei minha habilidade de trabalhar em equipe. Saber me comunicar de forma clara com os colegas e realizar atividades em conjunto foi fundamental para o sucesso do projeto.

- Metodologias ágeis

Tive meu primeiro contato com metodologias ágeis onde pude aprender como funciona o Scrum, também tive oportunidade de aplicá-lo mesmo que de forma simples sendo Scrum Master da equipe. 

- Proatividade
  
Por ser o ínicio de tudo, a proatividade foi fundamental para garantir a execução das entregas acordadas com o cliente. Demonstrei iniciativa ao buscar conhecimento de forma autônoma e assumir responsabilidades adicionais quando necessário.
    
