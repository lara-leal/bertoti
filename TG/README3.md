<h1 align="center"> Projeto 3: 1º Semestre de 2022 </h1>

<div align="center"> Projeto Integrador - 3° Semestre | Fatec Prof. Jessen Vidal - 2023 | Cliente parceiro: Midall </div>

## Visão do Projeto

Este projeto teve como proposta a criação de **promoções em um Ecommerce**. Onde se era necessário uma solução inteligente com a qual, as mecânicas das promoções pudessem ser feitas de forma flexível e de rápida atualização no sistema.

A ideia foi criar um motor de regras com uma interface onde as regras das promoções possam ser cadastradas e aplicadas no momento que os itens forem para o carrinho de compras.

## Tecnologias adotadas na solução

### Interface com o usuário

**JavaScript** é uma linguagem de programação de alto nível criada, a princípio, para ser executada em navegadores e manipular comportamentos de páginas web.

Segundo a **Mozilla Foundation**, atual nome da antiga **Netscape Communications Corporations**, empresa responsável pela criação do JS, "*JavaScript é uma linguagem de programação, leve, interpretada, orientada a objetos, baseada em protótipos e em first-class functions (funções de primeira classe), mais conhecida como a linguagem de script da Internet.*"

O **jQuery** trata-se de uma biblioteca JavaScript que pode ser adicionada aos projetos de codificação. Basicamente, o jQuery permite que os desenvolvedores web conectem recursos de rotina de JavaScript em uma página da web para que possam passar mais tempo focando em recursos complicados que são exclusivos do site.

### BackEnd

Java é uma linguagem de programação e um ambiente computacional criado pela Sun Microsystems na década de 90, sendo posteriormente adquirido pela Oracle.

Devido a possibilidade de escrever o código apenas uma vez e rodá-lo em diferentes dispositivos, a tecnologia logo se tornou popular, passando a ser implementada em praticamente qualquer lugar, desde sites e computadores até datacenters, celulares, calculadoras, videogames, etc.

Como linguagem de programação, o código Java é baseado em classes e orientado a objetos, com foco em segurança, portabilidade e alta performance.

## Contribuições pessoais

Minhas contribuições pessoais neste projeto foram principalmente na parte do desenvolvimento do backend e na modelagem e criação do banco de dados. 

Para a modelagem do banco utilizei a ferramenta brModelo para criar as entidades, atributos e definir seus relacionamentos onde foi definido que: Um produto pode fazer parte de vários carrinhos e um carrinho precisa receber pelo menos um ou vários produtos. Uma promoção pertence a apenas um produto, já um produto pode fazer parte de diversas promoções, ou seja, uma promoção não pode existir sem um produto.
<details>
<summary>Modelagem</summary>
<img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F718ca954-37be-47dd-8e1d-46bb63ffad25%2FUntitled.png?table=block&id=36cc1090-d8f6-4f7e-872e-83d9dad12b32&spaceId=70f68203-9aa8-48f2-9c19-ba66c1511816&width=2000&userId=607976c1-73b5-4be3-8f82-323ac698a9fd&cache=v2" width="500" height="400"/>
</details>  

Fui responsável pelo desenvolvimento do projeto utilizando programação OO e definição da utilização do Arquitetura do projeto: Models, Services, Repositories e Resources. Contribui, também, no desenvolvimento da lógica para verificar as promoções dos produtos no carrinho de compras. 
<details>
<summary> Packages </summary>
<img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F7de10511-ef9a-4955-9d4e-e3b7d744e72a%2Fpatterns.png?table=block&id=566df640-3624-4898-889d-f0e018fb6683&spaceId=70f68203-9aa8-48f2-9c19-ba66c1511816&width=2000&userId=607976c1-73b5-4be3-8f82-323ac698a9fd&cache=v2" width="500" height="400"/>
</details>

Durante o desenvolvimento se tornou necessário a refatoração do código para adicionar Dto's e injeções de dependência onde contribui efetivamente, o que ajudou a deixar o código mais desacoplado e facilitar na hora de ampliar a aplicação.
<details>
<summary> DTO </summary>
<img src="https://user-images.githubusercontent.com/80706297/204786984-af27a088-7eeb-446e-b6cd-25374a1425c0.png" width="500" height="300"/>
</details>  

<details>
<summary> Injeção de dependências </summary>
<img src="https://user-images.githubusercontent.com/80706297/204789559-e565bf85-1519-496f-b81c-1f239a0f0f45.png" width="600" height="400"/>
</details>  


A linguagem de programação JavaScript foi utilizada sem nenhuma framework para o desenvolvimento do front-End, ou seja, a  interface com o usuário via  aplicação web. 

Durante o projeto utilizei o JQuery  para simplificar os scripts e interações com o HTML.

### Aprendizados Efetivos HS

Neste projeto desenvolvi mais minhas habilidades no back-End, aprendendo como  utilizar uma Rest API considerada nova no mercado chamada Quarkus. Essa experiência me ajudou muito a, como, pesquisar  informações nas fontes primárias, que são as publicações técnicas geralmente realizadas pelos próprios criadores e responsáveis pelas mais diversas tecnologias. Considero esse aprendizado fundamental para minha trajetória pessoal e profissional, me tornando mais proativa em minhas skills de programação.

Já no front-End o aprendizado foi limitado pois não foi o foco de desenvolvimento no projeto, porém, aprendi um pouco sobre estruturas das páginas em HTML e funcionalidades em JavaScript.

- Criação de CRUD’S completos;
- Requisição GET, POST, PUT, DELETE;
- Organizar a arquitetura do projeto de forma correta;
- Usar lógica de programação para desenvolver regras para criação de promoções;
- Desenvolver aplicações utilizando frameworks de REST API;
