# Estrutura de dados 🗂️

A [arquitetura de camadas](Layers-Project.md) do projeto esta projetada de forma orientada a objetos, cujo as informações serão armazenadas no banco de dados MySQL e gerenciadas através das camadas de repositories e services.

A seguir, tem-se uma descrição detalhada de como as informações estão dispostas no banco e como se interligam.

## 1. Usuários ([Users](../src/main/java/com/estudolivre/ProjetoPDS/models/Users.java))
Esta parte se trata de uma classe mais abrangente que determina características em comum a todos os usuáros que podem ser cadastrados no sistema.

De forma geral, todos os usuários tem alguns dados em comum, que são:

- ID, que é gerado automaticamente
- Nome
- Email
- Senha

Essas características são gerais e universais entre todos os usuários, porém existem certos atributos que podem se distinguir a depender dos tipos de usuários, a seguir haverão uma descrição dos tipos de usuários e suas características particulares.

### 1.1 Estudantes ([Student](../src/main/java/com/estudolivre/ProjetoPDS/models/Student.java))
Se trata principalmente do usuários consumidores da plataforma, eles terão acesso aos materiais disponibilizados pelos usuários do tipo professor, podendo fazer download dos conteúdos.

Ele utiliza dos atibutos comuns de usuários, porém ele detém das seguintes características exclusivas dele:

- Matrícula
- Curso

### 1.2 Professores ([Teachers](../src/main/java/com/estudolivre/ProjetoPDS/models/Teachers.java))
São os usuários principalmente publicadores dos conteúdos da plataforma, eles podem fazer upload dos materiais didáticos além de criar cursos com materiais direcionados ao conteúdo abordado, além de poderem consumir o conteúdo já publicado.

Ele também tem os atributos comuns de usuário, além dos seus atributos exclusivos, que são:

- disciplina
- formação

## 2. Materiais ([Materials](../src/main/java/com/estudolivre/ProjetoPDS/models/Materials.java))
Serão os conteúdos postados pelos professores, também se trata de uma classe mais abrangente para os tipos de objetos que teram as características de materiais em comum.

De forma geral, os materiais terão os seguintes atributos em comum:

- ID, gerado automaticamente
- Autor
- Título
- Data de publicação

Assim como os usuários, os materiais também se dividem em tipos com características específicas.

### 2.1 Livros ([Book](../src/main/java/com/estudolivre/ProjetoPDS/models/Book.java))

Livros didáticos ou literários que podem servir como materiais de estudos e consulta de conteúdo.

Os livros tem os mesmos atributos comuns a todos os materiais, com um acrescimo de um atributo "file", que é onde o arquivo com o conteúdo do livro é disposto.

### 2.2 Vídeos ([VideoAula](../src/main/java/com/estudolivre/ProjetoPDS/models/VideoAula.java))
Vídeos explicativos ou didáticos que auxiliam no entendimento ou na visualização do conteúdo.

Detém dos mesmos atributos comum a outros materiais, com o acrescimo de dois atributos:

- Tipo
- Dados
