# 📚 Trabalho em Grupo — POO Java

---

## 🏫 Informações do Grupo

| Campo   | Informação |
|---------|------------|
| 👥 **Grupo** | 2 |
| 🎓 **Turma** | 037 |
| 📖 **Disciplina** | Programação Orientada a Objetos |
| 💻 **Linguagem** | Java |

---

## 👨‍💻 Integrantes

| Nome | Responsabilidade |
|------|-----------------|
| 🧑 Bernardo da Silva | Implementação dos pacotes e restrições do programa |
| 🧑 Bruno Vitor | Cálculo do INSS, IR e Salário Líquido |
| 🧑 Mário Praun | Formatação de Saída do arquivo |
| 🧑 Matheus Lahr | Formatação de Entrada do arquivo |
| 👩 Melissa Lima | Criação das Classes Obrigatórias e Atributos Mínimos |
| 👩 Vitória Zanchet | Banco de Dados |

---


## 🧠 Conceitos de POO Aplicados

| Conceito | Onde é usado |
|----------|-------------|
| 🔵 **Herança** | `Funcionario extends Pessoa` |
| 🟣 **Interfaces** | `CalculaDescontoINSS`, `CalculaDescontoIR` |
| 🏛️ **Classes abstratas** | `Pessoa` definida como classe abstrata base |
| 🧱 **Classe concreta** | `Funcionario` e `Dependente` implementam os comportamentos concretos |
| 🟡 **Encapsulamento** | Atributos `private` com getters/setters em todas as classes |
| 🔒 **Modificadores de acesso** | Uso de `private`, `protected` e `public` para controlar visibilidade |
| ⚠️ **Exceções** | Lançamento de `IllegalArgumentException` para CPF duplicado e dados inválidos |
| 🏷️ **Enum** | Utilizado para representar categorias fixas (ex: tipo de contrato, faixa de IR) |
| 📁 **Arquivos** | Leitura e/ou gravação de dados de funcionários em arquivo |
| 📅 **LocalDate** | Todas as datas (nascimento, admissão) são do tipo `java.time.LocalDate` |
| 📦 **Coleções** | `HashSet` para CPFs únicos, `ArrayList` para lista de dependentes |
| 📂 **Separação por pacotes** | Classes organizadas em pacotes como `model`, `interfaces`, `enums`, `util` |
