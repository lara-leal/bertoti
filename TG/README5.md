<h1 align="center"> Projeto 5: 1º Semestre de 2023 </h1>

<div align="center"> Projeto Integrador - 5° Semestre | Fatec Prof. Jessen Vidal - 2023 | Cliente parceiro: Midall </div>

## Visão do Projeto
O desafio proposto foi desenvolver uma aplicação que realizasse a tranferência de arquivos entre clouds para que fosse possível tranferir arquivos de qualquer tamanho de forma eficiente e não manual. 

Os objetivos destacados foram: Automatizar a jornada de download de arquivos, armazenados em uma plataforma de vídeo, efetuando essa transferência para à nuvem, através do desenvolvimento de um serviço tipo aplicação, tendo como funcionalidade junto ao usuário apenas um menu de configuração, que terá os parâmetros necessários para que o serviço de download seja executado. Processar automaticamente, gerando alertas caso ocorram quaisquer erros. Salvar metadados de arquivos para construção de dashboard de monitoramento da execução do serviço e posterior análise de resultados e indicadores (ex.: quantidade de arquivos transferidos, quantidade de bytes transferidos, tempo de transferência, etc.).

## Tecnologias adotadas na solução

### Java
Java é uma linguagem de programação orientada a objetos que foi criada na década de 1990 pela Sun Microsystems, e atualmente é propriedade da Oracle Corporation. É uma das linguagens de programação mais populares do mundo, usada em uma ampla variedade de aplicativos e sistemas, desde desenvolvimento de aplicativos desktop e web até jogos e dispositivos móveis.

### SpringBoot
O Spring Boot é um framework de desenvolvimento de aplicativos Java que visa facilitar a criação de aplicativos robustos e escaláveis. Ele fornece uma configuração simplificada e pré-definida, permitindo aos desenvolvedores se concentrarem na lógica de negócios em vez de tarefas de configuração. Com o Spring Boot, é possível criar rapidamente aplicativos Java de maneira eficiente, aproveitando a poderosa plataforma Spring.

### AWS
A AWS (Amazon Web Services) é uma plataforma líder em serviços de computação em nuvem fornecida pela Amazon, que oferece uma ampla gama de serviços de infraestrutura escaláveis e seguros para empresas e desenvolvedores.

### Google Drive 
O Google Drive é um serviço de armazenamento em nuvem oferecido pelo Google. Ele permite que os usuários armazenem, compartilhem e acessem arquivos e documentos de forma online. Com recursos de colaboração em tempo real, o Google Drive é amplamente utilizado para armazenar documentos, fotos, vídeos e outros tipos de arquivos de forma acessível a partir de qualquer dispositivo com acesso à internet. 

## Contribuições Pessoais
Durante a execução desse projeto, fui responsável na área de desenvolvimento na extração de metadados durante o envio de um arquivo do Google Drive para a AWS, para a elaboração da dashboard de monitoramento do cliente utilizando os recursos do fileMetadata do Google Drive API. 


<details> 
 <summary> Trecho do controller de extração de metadados </summary>

  
		@PostMapping("/upload")
	public ResponseEntity<?> uploadBasic(@RequestParam("file") MultipartFile file)
			throws IOException {
    Drive service = new Drive.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance(), requestInitializer)
				.setApplicationName("Drive samples").build();
   
	 Instant inicio = Instant.now();
		List<String> list = new ArrayList<>();
		list.add("1LFzz6RB4d-ePzRmyzVUC8zebcrYHzDTF");
		File fileMetadata = new File();
		fileMetadata.setParents(list);
		fileMetadata.setName(file.getOriginalFilename());
		String filePathd = new java.io.File(".").getCanonicalPath() + file.getOriginalFilename();
		file.transferTo(new java.io.File(filePathd));
  
		java.io.File filePath = new java.io.File(filePathd);
		FileContent mediaContent = new FileContent("multipart/form-data", filePath); 
		FileContent mediaContent = new FileContent("multipart/form-data", filePath);
		File files = service.files().create(fileMetadata, mediaContent).setFields("id").execute();
		System.out.println("File ID: " + files.getId());


		History history = new History();
		history.setNome_arquivo(file.getOriginalFilename());
		history.setFile_id(files.getId());
		history.setTamanho(file.getSize());
		history.setData_envio(LocalDate.now());

		FoldersSelect fol = folderService.findById(repo.findAll().get(0).getId());
		fileDownload.getFile(fol.getCodigo(), files.getId());


		Instant fim = Instant.now();
		Long duracao = Duration.between(inicio, fim).getSeconds();
		history.setTempo(duracao);
		historyService.save(history);
		return ResponseEntity.status(HttpStatus.OK).body(files);

	}

	@GetMapping("/files/{id}/metadata")
	public ResponseEntity<File> getFileMetadata(@PathVariable("id") String fileId) throws IOException {
		GoogleCredentials credentials = GoogleCredentials.getApplicationDefault()
				.createScoped(Arrays.asList(DriveScopes.DRIVE_METADATA));
		HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credentials);
		Drive service = new Drive.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance(), requestInitializer)
				.setApplicationName("Drive samples").build();

		File filemetadata = service.files().get(fileId).execute();

		return ResponseEntity.ok(filemetadata);
	}

	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleIOException(IOException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erro ao recuperar metadados do arquivo: " + e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erro interno do servidor: " + e.getMessage());
    }
	}
	
A parte mais desafiadora, foi compreender o funcionamento da API do Google pois tive que me aprofundar em leituras da documentação disponibilizada no Google e não existiam muitos artigos mais detalhados que pudessem nos auxiliar na implementação em nosso projeto. A parte de extração de metadados era crucial para que fosse possível seguir com o desenvolvimento do nosso Dashboard de monitoramento de desempenho da aplicação.

A lógica utilizada para o desenvolvimento dessa funcionalidade foi: Após a realização do upload do arquivo (imagem ou vídeo), o arquivo era tranferido para nosso servidor local e logo em seguida enviado para o Google Drive  através da API, durante esse processo eram registrados os metadados, como ID, tamanho, nome do arquivo e data de envio. E por fim, foi realizado um GET responsável por recuperar os metadados de um arquivo no Google Drive com base em seu ID. 

 </details>

 <details>
  <summary> Desenvolvimento da dashboard </summary>
	  <br></br>
	 <img src="https://github.com/lara-leal/bertoti/assets/80706297/40392e65-11b5-4b75-891f-4845bd49b066"/>
	 <br></br>
Durante a fase de desenvolvimento da dashboard, aproveitei vários recursos, incluindo o DAX (Data Analysis Expressions) do Power BI, incorporando campos calculados para otimizar a análise de dados.
<br></br>
	 
A utilização foi estratégica para realizar cálculos avançados, contribuindo significativamente para a funcionalidade da dashboard. Os campos calculados foram especialmente úteis ao capturar métricas importantes, como o tamanho médio do arquivo compartilhado e a identificação do tipo de arquivo mais frequentemente compartilhado, os mesmos, foram projetados para proporcionar insights imediatos, facilitando a interpretação dos resultados e oferecendo uma visão abrangente do desempenho do serviço.
<br></br>


``` 
tamanho_arquivo = 
    IF (
        history[tamanho] < 1024,
        FORMAT ( history[tamanho] , "#0.0# B" ),
        IF (
            history[tamanho]  < POWER ( 2, 20 ),
            FORMAT ( history[tamanho]  / POWER ( 2, 10 ), "#0.0# KB" ),
            IF (
                history[tamanho]  < POWER ( 2, 30 ),
                FORMAT ( history[tamanho]  / POWER ( 2, 20 ), "#0.0# MB" ),
                FORMAT ( history[tamanho]  / POWER ( 2, 30 ), "#0.0# GB" )
            )
        )
    )
 ```

```
mais_utilizado = 
MAXX (
    TOPN (
        1,
        SELECTCOLUMNS (
            SUMMARIZE (
                'history',
                'history'[tipo_arquivo],
                "Count", COUNTROWS ('history')
            ),
            "tipo_arquivo", 'history'[tipo_arquivo],
            "Count", [Count]
        ),
        [Count],
        DESC
    ),
    [tipo_arquivo]
)
```
</details>

 <details>
<summary> Desenvolvimento de protótipos da aplicação </summary>
<br></br>
Também, desempenhei o papel de Product Owner, onde fui responsáve pela prototipagem da aplicação com a utilização da ferramenta Figma. Minhas responsabilidades incluíram a obtenção da aprovação do cliente para o design da aplicação e a validação de eventuais ajustes ao longo do projeto. Durante as sprints, assumi a responsabilidade de negociar as entregas, buscando equilíbrio entre as necessidades do cliente e o cronograma de execução da equipe.
<br></br>
<img src="https://i.ibb.co/g7JB5w8/image.png"></a>

</details>

Além disso, desempenhei um papel crucial na implementação do Controle de Issues, uma iniciativa que possibilitou a utilização eficiente das "issues" para rastrear diversas dimensões do nosso projeto em nosso repositório. Essa ferramenta tornou-se fundamental para a gestão de tarefas, acompanhamento de melhorias, identificação e resolução de bugs, e facilitou discussões colaborativas entre os membros da equipe. Através do Issue Controll, conseguimos aprimorar a transparência, promover a colaboração e garantir um processo mais estruturado de gestão de projeto.


 ### Aprendizados Efetivos HS

Ao desenvolver esse projeto, tive diversas evoluções técnicas como explorar novas tecnologias, proporcionando um amplo espaço para aprendizado. Algumas das principais experiências incluíram: 


| Hard Skills                           | Nota (0-5) |
|--------------------------------------|-------------|
| Entender insights de metadados   | ★★★★★ |
| Elaborar dashboard de monitoramento   |★★★★★|
| Metodologia Ágil - Scrum             | ★★★★☆ |
| Trabalhar com ferramentas da AWS         |★★★★☆|
| Power BI |★★★★☆ |
| Utilizar Google drive API             |★★★☆☆|


### Soft skills


Desenvolvi e aprimorei minhas habilidades interpessoais, as chamadas Soft Skills, que irei detalhar a seguir:

- Resiliência
  
Trabalhar em ser resiliente foi fundamental diante dos desafios enfrentados. Enfrentar situações difíceis exigiu a capacidade de me adaptar, superar obstáculos e manter um equilíbrio positivo.

- Comunicação Assertiva
  
Durante o desenvolvimento do projeto, acredito que evolui muito em saber como realizar uma comunicação assertiva, tive a oportunidade de trabalhar como Product Owner, onde tive aprender ainda mais a ter uma comunicação clara  e  de fácil compreensão para transmitir para o cliente nosso entendimento do desafio e propor a solução elaborada, para que ao longo do projeto as mudanças necessárias fossem apenas por conta da necessidade do projeto e não por falta de entendimento.
  
- Evolução do trabalho em equipe
  
Por ter um papel fundamental no desenvolvimento do projeto, foi fundamental que eu e o restante do time estivessemos alinhados para que o produto final fosse entregue como o esperado, precisei transmitir a idéia de solução que tive, discutir o escopo do projeto e debater opiniões em relação a funcionalidades, design e etc.

- Visão de negócio

Minha habilidade de organização e planejamento desempenhou um papel crucial ao assumir as funções de Product Owner. Tais responsabilidades demandaram uma gestão eficiente do backlog do produto, a definição clara de requisitos e uma colaboração próxima com as partes interessadas.





  


