# 📚 Compiladores - T2 (Analisador Sintático)

![Java](https://img.shields.io/badge/Java-17+-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-orange)
![ANTLR](https://img.shields.io/badge/ANTLR-4-red)

---

## 📌 Descrição

O **Trabalho 2 (T2)** da disciplina consiste em implementar um analisador sintático para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar. O analisador sintático deve ler um programa-fonte e apontar onde existe erro sintático, indicando a linha e o lexema que causou a detecção do erro

O objetivo é desenvolver um **analisador sintático** para a linguagem **LA (Linguagem Algorítmica)**, incluindo:

- 🔹 Análise léxica integrada
- 🔹 Análise sintática baseada em gramática formal
- 🔹 Tratamento de erros customizado

---

## 📋 Requisitos

Para compilar e executar o projeto, você precisa ter instalado:

- Java JDK 11 ou superior
- Apache Maven 3.x
- ANTLR 4 (gerenciado via Maven)
- Git (clonagem do repositório)
- Não é necessária configuração adicional além de ter o Java e o Maven corretamente instalados e disponíveis no ```PATH```.
---

## 📁 Estrutura do Projeto
``` bash
T2/
├── src/
│   └── main/
│       ├── antlr4/
│       │   └── br/
│       │       └── ufscar/
│       │           └── compiladores/
│       │               └── t2/
│       │                   └── AnalisadorSintaticoLA.g4
│       └── java/
│           └── br/
│               └── ufscar/
│                   └── compiladores/
│                       └── t2/
│                           └── AnalisadorDeErros.java
│                           └── AnalisadorSintatico.java
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
cd Compiladores/T2
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
- `<saida.txt>`: Caminho para o arquivo de saída (lista de tokens)

### ✅ Exemplo

```bash
java -jar target/t2-1.0-SNAPSHOT-jar-with-dependencies.jar exemplos/entrada.txt exemplos/saida.txt 
```

---
## ⚙️ Comportamento da Execução

O analisador sintático implementado possui o seguinte comportamento durante a execução:

- Realiza a leitura de um arquivo de entrada contendo um programa escrito na linguagem LA.
- Executa a análise léxica e sintática de forma integrada.
- Verifica se a estrutura do programa está de acordo com a gramática definida.
- Identifica tokens inválidos e erros estruturais na entrada.
- Interrompe imediatamente a execução ao encontrar o primeiro erro (léxico ou sintático).
- Escreve o resultado da análise exclusivamente em um arquivo de saída especificado pelo usuário. (temp)
- Não imprime nenhuma saída no terminal.
- Ao final da execução (com ou sem erro), imprime:

```text
Fim da compilacao
```
---

## 🧪 Casos de Teste

Casos de teste adicionais estão disponíveis neste link fornecido pelo professor:

📁 [Casos de Teste - Linguagem Algorítmica](https://drive.google.com/file/d/1m6BHsFyi7m6WkP7MGPBWuky5NacPRxJl/view)

---