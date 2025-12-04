# Novas implementações 🧩

Para manter uma organização nos processos de desenvolvimento do software e ainda manter o código aberto para que outras pessoas possam ajudar no desenvolvimento, foi-se utilizado o fluxo de trabalho conhecido como [Git Flow](https://www.alura.com.br/artigos/git-flow-o-que-e-como-quando-utilizar), aliado ao [modelo em espiral](https://medium.com/contexto-delimitado/o-modelo-em-espiral-de-boehm-ed1d85b7df) para tornar o processo de desenvolvimento dinâmico e com menos risco de conflitos entre os cóodigos dos membros da equipe.

A seguir será detalhado o procedimento para cada tipo de atualização no projeto:

## 1. Entendendo a estrutura

Como pode-se notar, o projeto detém de duas branchs principais, a [develop](https://github.com/Thales-Rangel/Plataforma-de-estudos-online/tree/develop) e a [main](https://github.com/Thales-Rangel/Plataforma-de-estudos-online).

Para efeitos de entendimento, a branch de `develop` é a branch onde será o desenvolvimento, onde novas funcionalidades serão implementadas e testadas, enquanto a branch `main` permanecerá intocada até o momento de lançamento de uma nova `release`.

E para integrar essas novas funcionalidades, correções e etc. será descrito a seguir:

## 2. Nova funcionalidade

Para quando for implementar uma nova funcionalidade ao projeto, será necessário abrir uma `feature`.

`features` são branchs criadas a partir do `develop` para se integrar novas funcionalidades e/ou novos recursos, para isso, faça o seguinte procedimento:

_Para universalidade na explicação, os passos a seguir foram feitos usando comandos padrão do git, porém nada impede de usar a CLI do git-flow_

```
git checkout develop
git pull
git checkout -b feature/name-feature
```

Com isso, pode desenvolver a nova funcionalidade ou recurso desejado, ao finalizar a implementação, integre ela ao `develop` com os seguintes passos:

```
git checkout develop
git pull
git merge feature/name-feature
git push
```

## 3. Corrigindo um erro

Caso tenha encontrado um erro no projeto e deseja corrigir, deve-se abrir uma `hotfix`.
`hotfix` são branchs específicas para correção de erros no ramo principal, para isso, deve-se executar o seguinte procedimento:

```
git checkout main
git pull
git checkout -b hotfix/name-hotfix
```

Após ter finalizado as correções, execute os seguintes comando para integrar suas alterações:

```
git checkout main
git merge hotfix/name-hotfix
git push
git checkout develop
git merge hotfix/name-hotfix
git tag name-hotfix
git push
```

## 4. Lançando uma nova versão

Quando já houver feito uma quantidade de novas features o suficiente para integrar na `main` como uma nova atualização do projeto, significa que chegou a hora de lançar uma `release`.

Uma branch `release` irá fazer uma ponte para a mescla entre a branch `main` e a `develop`, por ela você irá resolver possíveis conflitos que possam ocorrer antes de enviar direto para a `main`.

Para iniciar uma nova release, faça os seguintes comando:

```
git checkout develop
git pull
git checkout -b release/1.0.0
```

Após resolver possíveis conflitos e atualizar a documentação do projeto, para lançar essa release, execute:

```
git checkout main
git merge release/1.0.0
git checkout develop
git merge release/1.0.0
git tag 1.0.0
```

## 5. Notas finais

Com esses procedimentos básicos, o processo de desenvolvimento do Estudo Livre se torna mais dinâmico e aberto para qualquer pessoa poder ajudar a desenvolver.

Lembre-se de adaptar os valores e nomes passados nos comandos para a suas adições, e procure entender a [estrutura de dados](data-structure.md) e a [arquitetura do projeto](Layers-Project.md) para ter uma melhor base sobre novos recursos a serem implementados.