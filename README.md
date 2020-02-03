

# Descrição do projeto:

Crie um projeto REST para atender a seguinte demanda respeitando as especificações abaixo.

Para atender uma solicitação de um setor da empresa será necessário desenvolver uma API REST para cadastro de colaboradores e essa API será consumida por diversos sistemas.

Essa API terá 4 funcionalidades: 
- inserir colaborador
- remover colaborador
- buscar um colaborador
- listar colaboradores agrupados por setor
- Nesta última funcionalidade, deverão ser exibidos os campos nome e e-mail dos colaboradores para cada setor.

Os atributos necessários para cadastrar um **colaborador** são: 
- cpf
- nome
- telefone
- e-mail.
  
Um colaborador deve pertencer somente a um dos setores que já devem existir na tabela "setores", que possui um id e uma descrição.

As tabelas devem ser criadas através de **scripts**, porém deve ser efetuada uma validação estrutural das tabelas existentes no banco no momento que a aplicação for iniciada.

- Somente é permitido até 20% de colaboradores menores que 18 anos por setor.
- Somente é permitido até 20% de colaboradores maiores que 65 anos na empresa.

**A funcionalidade de listar colaboradores agrupados por setor terá um volume de acesso consideravelmente alto.**

Critérios técnicos para desenvolvimento do projeto

- O projeto deve ser escrito em Java utilizando preferencialmente o Spring.
- É obrigatório a utilização do Maven para gerenciamento de dependências.
- Boas práticas de programação serão avaliadas.
- Seria interessamente, mas não obrigatório, que a aplicação e suas dependencias rodassem num container
- A lista de códigos de Status HTTP deve seguir a seguinte regra:
  - 201 - Recurso criado
  - 200 - Sucesso
  - 400 - Requisição inválida
  - 404 - Recurso não encontrado



# Run with docker

- build project with maven
```
./mvnw package
```
- build image
```
docker build -t springio/gs-spring-boot-docker .
```
- run the container
```
docker run -p 8080:8080 -t springio/gs-spring-boot-docker
```