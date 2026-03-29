### 📌 1. Trabalho 1 - Compiladores (Analisador Léxico)

```md
## Descrição

O trabalho 1 (T1) da disciplina consiste em implementar um analisador léxico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar. O analisador léxico deve ler um programa-fonte e produzir uma lista de tokens identificados.

---

## Requisitos

- Java JDK 11 ou superior
- Apache Maven 3.x
- ANTLR 4 (gerenciado via Maven)
- Git (clonagem do repositório)

---

## 📁 Estrutura do Projeto
``` bash
T1/
├── src/
│ └── main/
│ ├── java/
│ │ └── br/ufscar/compiladores/t1/
│ │ └── AnalisadorLexico.java
│ └── antlr4/
│ └── AnalisadorLexicoLA.g4
├── target/
├── pom.xml
└── README.md
```

---

## 📥 Clonando o Repositório

Abra o terminal e execute:

```bash
git clone https://git@github.com:layssonsantos/Compiladores.git
```

Navegue até o diretório do projeto:

```bash
cd T1/
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

Para executar o analisador léxico, utilize o seguinte comando:

```bash
java -jar target/t1-1.0-SNAPSHOT-jar-with-dependencies.jar <arquivo_entrada> <arquivo_saida>
```

- `<entrada.txt>`: Caminho para o arquivo de entrada (código em Linguagem Algorítmica)
- `<saida.txt>`: Caminho para o arquivo de saída (lista de tokens)

### ✅ Exemplo

```bash
java -jar target/t1-1.0-SNAPSHOT-jar-with-dependencies.jar exemplos/entrada.txt exemplos/saida.txt 
```

---

## 🧪 Casos de Teste

Casos de teste adicionais estão disponíveis neste link fornecido pelo professor:

📁 [Casos de Teste - Linguagem Algorítmica](https://drive.google.com/file/d/1m6BHsFyi7m6WkP7MGPBWuky5NacPRxJl/view)

---