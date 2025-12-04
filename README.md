# 📘 EstudoLivre 📘 - Projeto de PDS e PI

## 1. Objetivos do projeto 📝:
Este projeto está sendo desenvolvido para avaliação e obtenção da nota nas diciplinas de Projeto de Desenvolvimento de Software (PDS) e Programação para a Internet (PI)

A ideia central no desenvolvimento deste projeto é a criação de uma plataforma online e gratuita que permita acesso a diversas formas de conteúdo para apredizagem e estudos, sendo isso livros, artigos, apostilas, videoaulas e cursos online. Se trata de um ambiente onde estudantes e professores podem buscar e compartilhar conteúdos de conhecimento de forma gratuita.

- Para permitir o gerenciamento de materiais didáticos publicados na plataforma.
- Gerenciar login de usuários por denominações como "Estudante" ou "Professor" e outros cargos ou funções administrativas do sistema.
- Permitir Download dos materiais disponibilizados.

## 2. Arquitetura e Stack 🪪:
Esta plataforma utiliza de uma arquitetura de classes [orientada a objetos](https://www.alura.com.br/artigos/poo-programacao-orientada-a-objetos).

Estando organizado em uma [arquitetura de camadas](docs/Layers-Project.md), e a estrutura de dados pode ser visualizada com mais detalhes na [documentação](docs/data-structure.md).

### Detalhes da stack e integrações:
- A implementação é feita em [Java](https://www.java.com/pt-BR/download/help/whatis_java.html) [21](https://docs.oracle.com/en/java/javase/21/).
- Uso do framework [Spring Boot](https://spring.io/projects/spring-boot).
- Persistência de dados feita em um banco [MySQL](https://dev.mysql.com/doc/), acesse o modelo de dados para uma visualização do modelo
- As bibliotecas utilizadas pelo projeto podem ser vistas no arquivo [pom.xml](pom.xml) na raiz do projeto dentro da tag dependencies.


## 3. Execução
Para executar o serviço é necessário configurar as variáveis de ambiente no arquivo [appliccation.properties](src/main/resources/application.properties):

- spring.datasource.url: com o endereço completo do driver de conexão a um banco de dados MySQL.
- spring.datasource.username: com o seu usuário do banco de dados MySQL que deseja se 
conectar.
- spring.datasource.password: com a senha do usuário do banco de dados que deseja se 
conectar.

O projeto é feito para executar pela JVM do Java 21, portanto é necessário que utilize um compilador que faça a execussão do projeto.

## 4. Alterações
Toda e qualquer alteração no código deve ser realizada respeitando o processo de [Git Flow](https://www.alura.com.br/artigos/git-flow-o-que-e-como-quando-utilizar) [definido](docs/git-flow.md).