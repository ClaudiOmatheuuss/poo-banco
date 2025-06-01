# Projeto Banco - Programação Orientada a Objetos 💰

Este é um projeto modelo de um sistema bancário simples desenvolvido durante a disciplina **Programação 2**, com foco em programação com o paradigma **programação orientada a objetos (POO)**.

## 📚 Objetivos Didáticos

- Aplicar os principais conceitos de POO: encapsulamento, herança, polimorfismo e abstração.
- Desenvolver a modelagem de classes representando contas bancárias, clientes e operações.
- Implementar um sistema interativo com funcionalidades básicas de um banco.

## 🧩 Funcionalidades

- Criação de contas (corrente e poupança)
- Gerenciamento de múltiplas contas
- Conta bonificada (para cada saque efetuado, a conta desse tipo recebe **taxa adicional de 5%**) 
- Incrementar cashback/bonus (apenas contas do tipo Bonificada)
- Depósito e saque
- Consulta de saldo
- Taxas de rendimento de conta poupança

## ➕ Extra

- Verificação de valor do saque
- Verificação do valor de depósito
- Caso o usuário insira um número que represente uma opção inválida, o sistema é interrompido imediatamente

## 🏗️ Estrutura do Projeto

```bash
banco-orientado-a-objetos/
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