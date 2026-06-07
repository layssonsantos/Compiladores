# 📚 Compiladores - T5 (Gerador de Código)

![Java](https://img.shields.io/badge/Java-17+-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-orange)
![ANTLR](https://img.shields.io/badge/ANTLR-4-red)
![GCC](https://img.shields.io/badge/GCC-C%20Compiler-green)

---

## 📌 Descrição

O **Trabalho 5 (T5)** da disciplina consiste em implementar um **gerador de código** para a linguagem **LA (Linguagem Algorítmica)**, desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar.

Nesta etapa, o compilador recebe um programa escrito em LA e gera um programa equivalente em linguagem **C**, preservando o comportamento de entrada e saída do programa original.

O gerador de código utiliza toda a infraestrutura construída nos trabalhos anteriores:

* Análise Léxica (T1)
* Análise Sintática (T2)
* Análise Semântica (T3 e T4)

Somente após a validação completa do programa de entrada é realizada a geração do código C correspondente.

O objetivo é desenvolver um **compilador completo para a linguagem LA**, incluindo:

* 🔹 Análise léxica integrada
* 🔹 Análise sintática integrada
* 🔹 Análise semântica integrada
* 🔹 Controle de escopos aninhados
* 🔹 Verificação de tipos
* 🔹 Verificação de funções e procedimentos
* 🔹 Verificação de ponteiros e registros
* 🔹 Geração automática de código C
* 🔹 Emissão de mensagens de erro padronizadas

---

## 📋 Requisitos

Para compilar e executar o projeto, você precisa ter instalado:

* Java JDK 11 ou superior
* Apache Maven 3.x
* ANTLR 4 (gerenciado via Maven)
* GCC (GNU Compiler Collection)
* Git (clonagem do repositório)

Não é necessária configuração adicional além de ter o Java, Maven e GCC corretamente instalados e disponíveis no `PATH`.

---

## 📁 Estrutura do Projeto

```bash
T5/
├── src/
│   └── main/
│       ├── antlr4/
│       │   └── br/
│       │       └── ufscar/
│       │           └── dc/
│       │               └── compiladores/
│       │                   └── t5/
│       │                       └── AnalisadorSemanticoLA.g4
│       └── java/
│           └── br/
│               └── ufscar/
│                   └── dc/
│                       └── compiladores/
│                           └── t5/
│                               ├── Escopos.java
│                               ├── GeradorC.java
│                               ├── Semantico.java
│                               ├── SemanticoUtils.java
│                               ├── T5.java
│                               └── TabelaDeSimbolos.java
├── target/
├── pom.xml
└── README.md
```

---

## 📥 Clonando o Repositório

Abra o terminal e execute:

```bash
git clone git@github.com:layssonsantos/Compiladores.git
```

Navegue até o diretório do projeto:

```bash
cd Compiladores/T5
```

---

## ▶️ Como Compilar

Na raiz do projeto, execute:

```bash
mvn clean package
```

Isso irá gerar um arquivo `.jar` na pasta `target/`, com todas as dependências incluídas e baixadas automaticamente via Maven.

---

## ▶️ Execução

Para executar o compilador, utilize o seguinte comando:

```bash
java -jar <caminho_do_jar> <arquivo_entrada> <arquivo_saida>
```

* `<arquivo_entrada>`: programa escrito na linguagem LA
* `<arquivo_saida>`: arquivo onde será gravado o resultado da compilação

### ✅ Exemplo

```bash
java -jar target/t5-1.0-SNAPSHOT-jar-with-dependencies.jar exemplos/entrada.la exemplos/saida.c
```

---

## ⚙️ Comportamento da Execução

O compilador implementado possui o seguinte comportamento:

* Realiza a leitura de um programa escrito em LA.
* Executa análise léxica.
* Executa análise sintática.
* Executa análise semântica.
* Verifica identificadores declarados.
* Verifica compatibilidade de tipos.
* Verifica funções e procedimentos.
* Verifica parâmetros formais e argumentos.
* Verifica ponteiros e registros.
* Verifica uso correto do comando `retorne`.
* Gera código equivalente em linguagem C quando não há erros.
* Escreve o resultado exclusivamente no arquivo de saída informado.
* Não imprime resultados no terminal.

### Caso existam erros

Se forem encontrados erros léxicos, sintáticos ou semânticos, o arquivo de saída conterá as mensagens de erro seguidas de:

```text
Fim da compilacao
```

### Caso não existam erros

O arquivo de saída conterá um programa equivalente em linguagem C, pronto para ser compilado utilizando GCC.

---

## 🔄 Fluxo de Compilação

```text
Programa LA
     │
     ▼
Análise Léxica
     │
     ▼
Análise Sintática
     │
     ▼
Análise Semântica
     │
     ▼
Geração de Código C
     │
     ▼
Arquivo .c
     │
     ▼
Compilação com GCC
     │
     ▼
Programa Executável
```

---

## ❌ Erros Detectados

O compilador mantém todas as verificações implementadas nos trabalhos anteriores:

* Símbolo não identificado
* Cadeia literal não fechada
* Comentário não fechado
* Erros sintáticos
* Identificador já declarado anteriormente
* Identificador não declarado
* Tipo não declarado
* Atribuição incompatível
* Incompatibilidade de parâmetros
* Uso inválido de `retorne`
* Incompatibilidades envolvendo ponteiros
* Incompatibilidades envolvendo registros

---

## 🧪 Casos de Teste

A validação do trabalho é realizada através de casos de teste fornecidos pela disciplina.

Para cada caso:

1. O programa LA é compilado.
2. O código C é gerado.
3. O código C é compilado utilizando GCC.
4. O executável é executado.
5. A saída produzida é comparada com a saída esperada.

O código C gerado não precisa ser idêntico ao exemplo fornecido nos testes, mas sua execução deve produzir exatamente o mesmo comportamento.

---

## 🚀 Atualizações

A documentação será mantida atualizada conforme o andamento dos trabalhos da disciplina.
