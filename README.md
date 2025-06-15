# Projeto Banco - Programação Orientada a Objetos 💰

Este é um projeto modelo de um sistema bancário simples desenvolvido durante a disciplina **Programação 2**, com foco em programação com o paradigma **Programação Orientada a Objetos (POO)**.

---

## 📚 Objetivos Didáticos

- ✅ Aplicar os principais conceitos de POO: encapsulamento, herança, polimorfismo e abstração.
- ✅ Desenvolver a modelagem de classes representando contas bancárias e operações.
- ✅ Implementar um sistema interativo com funcionalidades básicas de um banco.

---

## 🧩 Funcionalidades

- ✅ Criação de contas pelo usuário (corrente, bonificada e poupança)
- ✅ Gerenciamento de múltiplas contas
- ✅ Conta bonificada (a cada saque, a conta acumula **bônus de 10%** do valor sacado) 
- ✅ Depósito e saque com validações
- ✅ Consulta de saldo
- ✅ Incrementar cashback/bônus (apenas contas do tipo bonificada)
- ✅ Rendimento de conta poupança (5% ao acionar a função `rendeConta()`)

---

## ➕ Extras e Validações

- 🔐 Verificações de:
  - Valor do saque (**não permite saldo insuficiente**).
  - Valor do depósito (**não permite valores negativos ou zero**).

- 🛑 Caso o usuário insira uma **opção inválida**, o sistema é **interrompido imediatamente** para garantir a integridade.

---

## 📜 Regras de Negócio

- Ao iniciar o sistema, o usuário informa:
  - 📌 **Nome do banco**
  - 📌 **Quantidade total de contas** que o banco pode gerenciar

- 🆕 As contas **não são mais criadas automaticamente**. O usuário deve:
  - Escolher **o índice** onde deseja criar a conta
  - Selecionar o **tipo de conta** (corrente, bonificada ou poupança)
  - O sistema sobrescreve a conta anterior (se houver) no índice informado

- ⚠️ Ações específicas dependem do tipo da conta:
  - `incrementarBonus()` → apenas para **Conta Bonificada**
  - `rendeConta()` → apenas para **Conta Poupança**
  
  Se a conta não for compatível com a operação, o sistema exibirá uma mensagem apropriada.

---

## 🏗️ Estrutura do Projeto

```bash
poo-banco/
│
├── model/
│   ├── Banco.java
│   ├── Conta.java
│   ├── ContaBonificada.java
│   ├── Poupanca.java
│   └── TipoConta.java
│
├── view/
│   └── Main.java
│
└── README.md