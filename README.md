# 📚 Projeto Final da Disciplina de POO

---

## 🏫 Descrição do Grupo

- 👥 **Grupo** — 02
- 🎓 **Turma** — 037
- 📖 **Disciplina** — Programação Orientada a Objetos
- 💻 **Linguagem** — Java

---

## 🎯 Objetivo do Trabalho

Desenvolver classes, interfaces e enumeradores para o cálculo do salário de um ou vários funcionários de uma empresa, abordando conceitos desenvolvidos ao longo do curso.

---

## 👨‍💻 Integrantes e Responsabilidades

- **Bernardo da Silva** — Implementação dos pacotes e restrições do programa
- **Bruno Vitor** — Cálculo do INSS, IR e Salário Líquido
- **Mário Praun** — Formatação de Saída do arquivo
- **Matheus Lahr** — Formatação de Entrada do arquivo
- **Melissa Lima** — Criação das Classes Obrigatórias e Atributos Mínimos
- **Vitória Zanchet** — Banco de Dados

---


## 🧠 Conceitos de POO Aplicados

- 🔵 **Herança**
- 🟣 **Interfaces**
- 🏛️ **Classes abstratas**
- 🧱 **Classe concreta**
- 🟡 **Encapsulamento**
- 🔒 **Modificadores de acesso**
- ⚠️ **Exceções**
- 🏷️ **Enum**
- 📁 **Arquivos**
- 📅 **LocalDate**
- 📦 **Coleções**
- 📂 **Separação por pacotes**

## ▶️ Como Executar a Aplicação

#### 🚀 Execução

Execute a classe `Main.java`<br/>
O sistema irá ler automaticamente o arquivo de entrada informado e gerar o arquivo de saída.


<details> <summary>📥 Arquivo de Entrada</summary>

O sistema utiliza um arquivo chamado: `Entrada.csv`
  
O caminho já deve estar configurado no código, por exemplo:

`C:\Users\user\Trabalho_Serratec_POO_JAVA\src\entrada-saida\Entrada.csv`

Apenas substituir os nomes e restante do caminho caso salve em local distinto
⚠️ O usuário não precisa alterar o código, apenas editar o arquivo.

</details>

<details> <summary>📝 Formato dos Dados</summary>

O arquivo deve seguir exatamente este formato:

- `<Nome_do_funcionario>;<CPF_do_Funcionario>;<DataNascimento_do_funcionario>;<salarioBruto_do_funcionario>`
- `<Nome_do_dependente>;<CPF_do_dependente>;<DataNascimento_do_dependente>;<Parentesco_do_dependente>`

📌 Exemplo:<br/>
João Silva;12345678900;01/01/1980;5000.00<br/>
Maria Silva;98765432100;01/01/2010;FILHO<br/>
Pedro Silva;11122233344;05/05/2012;SOBRINHO<br/>
</details>

<details> <summary>👨‍👩‍👧 Regras para dependentes</summary>
Você pode adicionar quantos dependentes quiser, sempre abaixo do funcionário.<br/>
Parentescos permitidos:<br/>

- FILHO
- SOBRINHO
- OUTROS

⚠️ Qualquer outro valor pode causar erro.

</details>

<details> <summary>📤 Arquivo de Saída</summary>
  
O sistema gera automaticamente o arquivo de `Saida.csv`. 

O caminho será o mesmo do arquivo de entrada, mudando apenas o nome: 
`C:\Users\user\Trabalho_Serratec_POO_JAVA\src\entrada-saida\Saida.csv `

Apenas substituir os nomes e restante do caminho caso salve em local distinto
</details>
