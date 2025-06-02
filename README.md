# Projeto Banco - Programação Orientada a Objetos 💰

Este é um projeto modelo de um sistema bancário simples desenvolvido durante a disciplina **Programação 2**, com foco em programação com o paradigma **programação orientada a objetos (POO)**.

---

## 📚 Objetivos Didáticos

- ✅ Aplicar os principais conceitos de POO: encapsulamento, herança, polimorfismo e abstração.
- ✅ Desenvolver a modelagem de classes representando contas bancárias, clientes e operações.
- ✅ Implementar um sistema interativo com funcionalidades básicas de um banco.

---

## 🧩 Funcionalidades

- ✅ Criação de contas (corrente, bonificada e poupança)
- ✅ Gerenciamento de múltiplas contas
- ✅ Conta bonificada (para cada saque efetuado, a conta desse tipo recebe **taxa adicional de 10%**) 
- ✅ Depósito e saque
- ✅ Consulta de saldo
- ✅ Incrementar cashback/bonus (apenas contas do tipo Bonificada)
- ✅ Taxas de rendimento de conta poupança (5% de rendimento ao chamar rendeConta())

---

## ➕ Extra

- 🔥 Criação automática das x contas totais definidas pelo usuário na proporção
  - **30% Conta Bonificada**
  - **30% Conta Poupança**
  - **40% Conta Corrente (genérica)**

- 🔐 Verificação de:
  - Valor do saque (**não permite saldo insuficiente**).
  - Valor do depósito (**não permite valores negativos ou zero**).
- 🛑 Caso o usuário insira uma **opção inválida**, o sistema é **interrompido imediatamente** para garantir a integridade.

---

## 📜 **Regras de Negócio**

- Ao criar o banco, o sistema solicita:
  - 📌 **Nome do banco.**
  - 📌 **Quantidade de contas a serem gerenciadas.**

- O sistema instancia as contas automaticamente da seguinte forma:
  - ➕ **30%** das contas → **Conta Bonificada** (`ContaBonificada`)
  - ➕ **30%** das contas → **Poupança** (`Poupanca`)
  - ➕ **40%** das contas → **Conta Corrente Genérica** (`Conta`)

- 🔄 O usuário pode **redefinir o tipo de qualquer conta manualmente** no menu de criação, sobrescrevendo a conta existente no índice escolhido.

- ⚠️ Ao tentar executar ações específicas como:
  - `incrementarBonus()` → válido apenas para **Conta Bonificada**.
  - `rendeConta()` → válido apenas para **Conta Poupança**.
  
  Se a conta selecionada não for do tipo correto, o sistema informará que **a operação não é válida para este tipo de conta**.

---

## 🏗️ Estrutura do Projeto

```bash
poo-banco/
│
├── models/
│   ├── Banco.java
│   ├── Conta.java
│   ├── ContaBonificada.java
│   └── Poupanca.java
├── view/
│   └── Main.java
│
├── README.md