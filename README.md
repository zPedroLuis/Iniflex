# Sistema de Gerenciamento de Funcionários

![Java](https://img.shields.io/badge/Java-17-blue) ![License](https://img.shields.io/badge/license-MIT-green)

Este é um sistema simples em Java para gerenciar funcionários. Ele permite realizar operações como adicionar funcionários, ajustar salários, agrupar por função, calcular totais de salários e exibir informações detalhadas sobre os funcionários.

## 📋 Índice

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Licença](#licença)

---

## 🌟 Visão Geral

O sistema foi desenvolvido para demonstrar operações comuns em um ambiente corporativo, como:

- Manipulação de listas de funcionários.
- Cálculos financeiros (ajuste de salário, total de salários, etc.).
- Agrupamento e ordenação de dados.
- Formatação de datas e números.

Ele utiliza recursos modernos do Java, como `Stream API`, `BigDecimal` para cálculos precisos e `DateTimeFormatter` para manipulação de datas.

---

## ✨ Funcionalidades

O sistema oferece as seguintes funcionalidades:

1. **Adicionar Funcionários**: Inclui funcionários com nome, data de nascimento, salário e função.
2. **Remover Funcionários**: Remove um funcionário específico da lista.
3. **Ajuste de Salário**: Aplica um aumento percentual aos salários dos funcionários.
4. **Exibição de Funcionários**: Exibe os funcionários em uma tabela formatada.
5. **Agrupamento por Função**: Agrupa os funcionários por suas funções.
6. **Aniversariantes**: Lista os funcionários que fazem aniversário em meses específicos.
7. **Funcionário Mais Velho**: Identifica o funcionário mais velho.
8. **Ordenação Alfabética**: Ordena os funcionários pelo nome.
9. **Cálculo de Total de Salários**: Calcula o total de salários pagos pela empresa.
10. **Salários Mínimos**: Calcula quantos salários mínimos cada funcionário recebe.

---

## ⚙️ Pré-requisitos

Para executar este projeto, você precisa ter instalado:

- **Java 17 ou superior**: [Baixe aqui](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **IDE ou Editor de Código**: Recomenda-se o uso do IntelliJ IDEA, Eclipse ou VS Code.
- **Git**: Para clonar o repositório. [Baixe aqui](https://git-scm.com/)

---

## ▶️ Como Executar

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/zPedroLuis/Iniflex.git
   cd Iniflex

1. **Compile o Projeto**:
   - Se estiver usando uma IDE, basta importar o projeto e executar a classe `Principal`.
   - Se estiver usando o terminal, compile com o comando:
     ```bash
     javac *.java
     ```

2. **Execute o Programa**:
   - Execute a classe `Principal` para iniciar o sistema:
     ```bash
     java Principal
     ```

3. **Resultado**:
   - O programa exibirá todas as funcionalidades implementadas no console.

---

## 📂 Estrutura do Projeto
```
sistema-funcionarios/
├── Principal.java          # Classe principal que executa o sistema.
├── Funcionario.java        # Classe que representa um funcionário.
├── Pessoa.java             # Classe base que contém informações gerais de uma pessoa.
├── README.md               # Documentação do projeto.
└── LICENSE                 # Licença do projeto.
```

---

## 📜 Licença

Este projeto está licenciado sob a **MIT License**. Consulte o arquivo [LICENSE](LICENSE) para obter mais detalhes.

---
