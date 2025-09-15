
---

# Desafio POO Java – DIO / Riachuelo

## App de transações financeiras

## 📋 Sumário

* [Sobre](#sobre)
* [Funcionalidades](#funcionalidades)
* [Tecnologias](#tecnologias)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Como executar](#como-executar)
* [Como contribuir](#como-contribuir)
* [Autor](#autor)

---

## Sobre

Este projeto foi desenvolvido como parte do desafio de **Programação Orientada a Objetos (POO)** proposto pela DIO para a Riachuelo. O objetivo é aplicar os conceitos de POO em Java, tais como classes, encapsulamento, herança, polimorfismo, abstração, entre outros.

---

## Funcionalidades

Descrever aqui as funcionalidades implementadas — algumas ideias:

* Criação de classes representativas de domínio (ex: cliente, produto, pedido, etc.)
* Operações de CRUD (criar, ler, atualizar, deletar) sobre objetos
* Relacionamentos entre classes (ex: agregação, composição)
* Tratamento de exceções
* Testes unitários (se houver)
* Possível persistência em memória (lista, coleção) ou arquivo

---

## Tecnologias

* Java (versão X — especifique, ex: Java 17)
* Gradle (wrapper incluso) para build e gerenciamento de dependências
* IDE: qualquer que suporte Java (IntelliJ, Eclipse, VSCode, etc.)

---

## Estrutura do Projeto

```
Desafio_POO_Java_DIO_Riachuelo/
├── src/
│   └── main/
│       └── java/
│           └── br/com/dio/
│               └── … (pacotes de domínio, serviços, etc.)
├── .gitignore
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew / gradlew.bat
└── … outros arquivos de configuração
```

* `src/main/java/br/com/dio/`: código-fonte principal
* Arquivos `gradle` para automação de build
* `.gitignore` para ignorar arquivos binários/temp

---

## Como executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/abdieldeathayde/Desafio_POO_Java_DIO_Riachuelo.git
   ```

2. Acesse o diretório do projeto:

   ```bash
   cd Desafio_POO_Java_DIO_Riachuelo
   ```

3. Compile/build com o Gradle wrapper:

   ```bash
   ./gradlew build
   ```

   Ou no Windows:

   ```cmd
   gradlew.bat build
   ```

4. Execute a aplicação:

   * Se for uma aplicação de console:

     ```bash
     ./gradlew run
     ```
   * Se for outro tipo de aplicação, rode conforme instruções do projeto

5. (Opcional) Execute testes, se existirem:

   ```bash
   ./gradlew test
   ```

---

## Como contribuir

Contribuições são bem-vindas! Se quiser colaborar:

1. Fork este repositório
2. Crie uma branch para sua feature ou correção:

   ```bash
   git checkout -b minha-feature
   ```
3. Faça mudanças / adicione funcionalidades
4. Teste as mudanças
5. Abra um Pull Request descrevendo as alterações feitas

---

## Autor

**Abdiel De Athayde**
Projeto criado como parte do desafio POO Java da DIO em parceria com a Riachuelo.

---


