# Gerenciador de Tarefas 📝✨

Este é um projeto Java que utiliza o Maven como sistema de build, Spring Boot como framework e Spring Data JPA como ferramente de gerenciamento e manutenção de banco de dados. 

A aplicação é um Gerenciador de Tarefas, permitindo criar, listar, atualizar e deletar tarefas.

O projeto ainda está em construção, novas funcionalidades serão adicionadas! 😊

## Como Funciona:

Para a organização estrutural, o projeto foi baseado no padrão de arquitetura MVC (Model-View-Controller)

- **TaskApplication.java**: Classe principal que inicia a aplicação Spring Boot.
  
- **TaskController.java**: Controlador que manipula as solicitações HTTP para operações CRUD de tarefas.
  
- **TaskService.java e TaskServiceImpl.java**: Interface e implementação do serviço com a lógica de negócios para gerenciamento de tarefas.
  
- **TaskRepository.java**: Repositório que interage com o banco de dados para persistir as tarefas.
  
- **TaskDTO.java**: Objeto de Transferência de Dados (DTO) usado para transferir dados de tarefas pela aplicação.
  
- **application.properties**: Arquivo de configuração para definir propriedades da aplicação Spring Boot, como configurações de banco de dados.
  
- **TaskApplicationTests.java**: Classe de testes unitários para a aplicação.

## Como Testar os Endpoints no Postman

Você pode testar os endpoints da API usando o Postman da seguinte maneira:

1. **Criar Tarefa (POST)**:
   - Endpoint: `http://localhost:8080/tasks/create`
   - Corpo da Requisição (JSON):
     ```json
     {
       "titulo": "Minha Nova Tarefa",
       "descricao": "Descrição da Tarefa...",
       "concluida": false,
       "dataConclusao": "2024-03-21"
     }
     ```
   
2. **Listar Todas as Tarefas (GET)**:
   - Endpoint: `http://localhost:8080/tasks/list`
   
3. **Atualizar Tarefa Existente (PUT)**:
   - Endpoint: `http://localhost:8080/tasks/update`
   - Corpo da Requisição (JSON):
     ```json
     {
       "id": 1,
       "titulo": "Tarefa Atualizada",
       "descricao": "Nova Descrição da Tarefa...",
       "concluida": true,
       "dataConclusao": "2024-03-22"
     }
     ```

4. **Deletar Tarefa por ID (DELETE)**:
   - Endpoint: `http://localhost:8080/tasks/delete/{id}`
     - Substitua `{id}` pelo ID da tarefa que deseja deletar.
  
Certifique-se de substituir `http://localhost:8080` pela URL correta da sua aplicação, se necessário.
