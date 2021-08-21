# Sistema de Gestão de Tarefas

O Sistema de Gestão de Tarefas foi o exemplo proposto para o teste prático de seleção para a vaga de Desenvolvedor Java da ESIG GROUP. Foi realizada a parte de configuração de ambiente, de banco de dados, configuração das dependências do Maven, configuração do servidor Tomcat 9, criação dos packages, dentre eles: daos, models, controllers, enums, services e util. Foi feito o cadastro e listagem de responsavel, as telas de cadastro de tarefa, a navegação entre telas. O projeto foi montado seguindo o modelo arquitetural MVC (Model, View, Controller), foram seguidos padrões de implementação para cada camada desenvolvida.

### No sistema foram utilizadas as tecnologias:

- a) Foi utilizado o JavaServer Faces (JSF) para tornar as páginas dinâmicas;
- b) Foi utilizado um bando de dados PostgreSQL para realizar a persistência dos dados;
- c) Foi utilizado o Framework JPA para fazer consultas, remoções, inserções;

### Itens Extras:

- Hibernate 
- Spring Boot Framework
- Bootstrap 4 
- Java 8


### Para instalar o sistema deve-se seguir os passos abaixo:

- Configurar um banco de dados postgreSQL local.
- Realizar o clone do projeto e importa-lo no eclipse pelo caminho File -> Import... -> Maven -> Existing Maven Projects
- Setar a url, username e password do banco de dados no arquivo que está na pasta raiz do projeto META-INF -> persistence.xml
- Configurar o servidor Tomcat 9, após configurado dar "Start" e acessar localhost:8080/tarefas/index.xhtml
- As tabelas serão criadas ao executar o projeto pela primeira vez, e o sistema estará pronto para uso.