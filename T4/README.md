# 📚 Compiladores - T4 (Analisador Semântico) - Parte 2

![Java](https://img.shields.io/badge/Java-17+-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-orange)
![ANTLR](https://img.shields.io/badge/ANTLR-4-red)

---

## 📌 Descrição

O **Trabalho 4 (T4)** da disciplina consiste em implementar uma segunda parte **analisador semântico** para a linguagem **LA (Linguagem Algorítmica)**, desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar.

O analisador semântico deve ler um programa-fonte, percorrer sua árvore sintática e verificar regras de significado da linguagem, detectando inconsistências relacionadas a declarações, uso de identificadores e compatibilidade de tipos.

O objetivo é desenvolver um **analisador semântico**, incluindo:

- 🔹 Análise léxica integrada  
- 🔹 Análise sintática integrada  
- 🔹 Verificação semântica de identificadores e tipos  
- 🔹 Controle de escopos  
- 🔹 Geração de mensagens de erro padronizadas  

---

## 📋 Requisitos

Para compilar e executar o projeto, você precisa ter instalado:

- Java JDK 11 ou superior  
- Apache Maven 3.x  
- ANTLR 4 (gerenciado via Maven)  
- Git (clonagem do repositório)  

Não é necessária configuração adicional além de ter o Java e o Maven corretamente instalados e disponíveis no `PATH`.

---

## 📁 Estrutura do Projeto

```bash
T3/
├── src/
│   └── main/
│       ├── antlr4/
│       │   └── br/
│       │       └── ufscar/
│       │           └── dc/
│       │               └── compiladores/
│       │                   └── t3/
│       │                       └── AnalisadorSemanticoLA.g4
│       └── java/
│           └── br/
│               └── ufscar/
│                   └── dc/
│                       └── compiladores/
│                           └── t3/
│                               ├── AnalisadorSemantico.java
│                               ├── Semantico.java
│                               ├── SemanticoUtils.java
│                               ├── Escopos.java
│                               └── TabelaDeSimbolos.java
├── target/
├── pom.xml
└── README.md
```

## 📥 Clonando o Repositório

Abra o terminal e execute:

```bash
git clone git@github.com:layssonsantos/Compiladores.git
```

Navegue até o diretório do projeto:

```bash
cd Compiladores/T3
```

---

## ▶️ Como Compilar

Na raiz do projeto, execute:

```bash
mvn clean package
```
Isso irá gerar um arquivo ```.jar``` na pasta ```target/```, com todas as dependências incluídas e baixadas automaticamente via ```Maven```.

---

## ▶️ Execução

Para executar o analisador sintático, utilize o seguinte comando:

```bash
java -jar <caminho_do_jar> <arquivo_entrada> <arquivo_saida>
```

- `<entrada.txt>`: Caminho para o arquivo de entrada (código em Linguagem Algorítmica)
- `<saida.txt>`: Caminho para o arquivo de saída (resultado da análise sintática ou mensagem de erro)

### ✅ Exemplo

```bash
java -jar target/t3-1.0-SNAPSHOT-jar-with-dependencies.jar exemplos/entrada.txt exemplos/saida.txt 
```

---
## ⚙️ Comportamento da Execução

O analisador semântico implementado possui o seguinte comportamento durante a execução:

- Realiza a leitura de um arquivo de entrada contendo um programa escrito na linguagem LA.
- Executa a análise léxica e sintática antes da etapa semântica.
- Percorre a árvore sintática gerada pelo parser.
- Controla escopos de variáveis, funções e procedimentos.
- Verifica se identificadores foram declarados corretamente.
- Verifica se tipos utilizados existem.
- Verifica compatibilidade de tipos em atribuições e expressões.
- Continua a análise mesmo após encontrar erros semânticos.
- Escreve o resultado exclusivamente em arquivo de saída especificado pelo usuário.
- Não imprime nenhuma saída no terminal.
- Ao final da execução, imprime:

```text
Fim da compilacao
```
---

## 🧪 Casos de Teste

Casos de teste adicionais estão disponíveis neste link fornecido pelo professor:

📁 [Casos de Teste - Linguagem Algorítmica](https://drive.google.com/file/d/1m6BHsFyi7m6WkP7MGPBWuky5NacPRxJl/view)

---
