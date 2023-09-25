 # Lara Oliveira Leal

## Introdução

Olá, seja bem-vindo ao meu repositório, meu nome é Lara Oliveira Leal, sou estudante de Banco de Dados na FATEC São José dos Campos - Prof. Jessen Vidal.

  <img src="https://user-images.githubusercontent.com/80706297/204921403-b4a50c19-1385-4d16-8ed1-9e3bb7cf491c.jpeg" width="300" height="400"/>

## Principais Conhecimentos

Meu primeiro contato com programação foi na faculdade, a primeira linguagem que aprendi foi Python nas aulas de LP 1 na faculdade. Atualmente meu foco principal de atuação é o Back-End onde a linguagem que possuo mais “fluência” é Java, tendo conhecimento para desenvolver web services, utilizar padrões de projetos e desenvolver sua arquitetura. Também possuo conhecimento em frameworks muito utilizadas em Java como: Quarkus, SpringBoot, Hibernate ORM.

# Projeto 5: 1º Semestre de 2023

### Parceiro Acadêmico

O parceiro do projeto nesse semestre foi a empresa Midall.

<img src="https://user-images.githubusercontent.com/80851038/163725778-498ec2e9-e8eb-45cf-a586-848e5bb1dd97.png" width="300" height="200"/>

### Visão do Projeto
Automatizar a jornada de download de arquivos, armazenados em uma plataforma de vídeo, efetuando essa transferência para a nuvem, através do desenvolvimento de um serviço tipo aplicação, tendo como funcionalidade junto ao usuário apenas um menu de configuração, que terá os parâmetros necessários para que o serviço de download seja executado. processar automaticamente, gerando alertas caso ocorram erros de processamento. Salvar metadados de arquivos para construção de dashboard de monitoramento da execução do serviço e posterior análise de resultados e indicadores (ex.: quantidade de arquivos transferidos, quantidade de bytes transferidos, tempo de transferência, etc.).

### Tecnologias adotadas na solução

### Java
Java é uma linguagem de programação orientada a objetos que foi criada na década de 1990 pela Sun Microsystems, e atualmente é propriedade da Oracle Corporation. É uma das linguagens de programação mais populares do mundo, usada em uma ampla variedade de aplicativos e sistemas, desde desenvolvimento de aplicativos desktop e web até jogos e dispositivos móveis.

### SpringBoot
O Spring Boot é um framework de desenvolvimento de aplicativos Java que visa facilitar a criação de aplicativos robustos e escaláveis. Ele fornece uma configuração simplificada e pré-definida, permitindo aos desenvolvedores se concentrarem na lógica de negócios em vez de tarefas de configuração. Com o Spring Boot, é possível criar rapidamente aplicativos Java de maneira eficiente, aproveitando a poderosa plataforma Spring.

### AWS
A AWS (Amazon Web Services) é uma plataforma líder em serviços de computação em nuvem fornecida pela Amazon, que oferece uma ampla gama de serviços de infraestrutura escaláveis e seguros para empresas e desenvolvedores.

### Google Drive 
O Google Drive é um serviço de armazenamento em nuvem oferecido pelo Google. Ele permite que os usuários armazenem, compartilhem e acessem arquivos e documentos de forma online. Com recursos de colaboração em tempo real, o Google Drive é amplamente utilizado para armazenar documentos, fotos, vídeos e outros tipos de arquivos de forma acessível a partir de qualquer dispositivo com acesso à internet. 

### Contribuições Pessoais
Durante o desenvolvimento desse projeto, fui responsável na área de desenvolvimento na extração de metadados durante o envio de um arquivo do Google Drive para a AWS, para a elaboração da dashboard de monitoramento do cliente utilizando os recursos do fileMetadata do Google drive API. 


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
	


 </details>

 <details>
  <summary> Desenvolvimento da dashboard </summary>
	 <img src="https://github.com/lara-leal/bertoti/assets/80706297/40392e65-11b5-4b75-891f-4845bd49b066"/>
	 Durante o desenvolvimento da dashboard, pude utilizar diferentes  recursos como o DAX do power BI com campos calculados, para armazenar e extrair informações como, tamanho do arquivo compartilhado e o tipo de arquivo mais compartilhado através da ferramenta.
  

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
 
 ### Aprendizados Efetivos HS
 - Trabalhar com ferramentas da AWS; 
 - Utilizar Google drive API;
 - Entender insights de metadados para elaboração de dashboard de monitoramento;

