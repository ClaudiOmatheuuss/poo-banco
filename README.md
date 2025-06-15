# 💰 Projeto Banco - Programação Orientada a Objetos

Este é um sistema bancário simples desenvolvido como exercício da disciplina **Programação 2**, com foco em **Programação Orientada a Objetos (POO)**. O projeto simula a criação e manipulação de contas bancárias com diferentes comportamentos.

---

## 🎯 Objetivos Didáticos

- Aplicar os principais conceitos de POO:
  - Encapsulamento
  - Herança
  - Polimorfismo
  - Abstração
- Desenvolver a modelagem de classes para contas e operações bancárias.
- Trabalhar com exceções personalizadas e validação de entradas.
- Criar uma interface interativa via terminal com menus e controle de fluxo.

---

## 🧩 Funcionalidades

- Criação de contas:
  - Conta Corrente
  - Conta Corrente Bonificada (com cashback de 10% a cada saque)
  - Conta Poupança (com rendimento de 5% ao acionar `rendeConta()`)
- Depósito e saque com validação
- Consulta de saldo
- Adição de bônus (somente para contas bonificadas)
- Aplicação de rendimento (somente para contas poupança)
- Exclusão de contas
- Gerenciamento de múltiplas contas com verificação de existência

---

## ✅ Validações Implementadas

- Valor do saque não pode ser maior que o saldo.
- Valor do depósito deve ser positivo.
- Índices inválidos de conta são tratados com exceções.
- Não é possível ultrapassar o número máximo de contas definido no início.
- Verificação do tipo de conta antes de aplicar bônus ou rendimento.

---

## 📜 Regras de Negócio

- Ao iniciar, o usuário informa:
  - 🏦 Nome do banco
  - 🔢 Quantidade máxima de contas
- As contas só são criadas sob demanda.
- O sistema mostra um menu com 8 opções, e o usuário escolhe pelo número correspondente.
- Ao realizar operações, o usuário escolhe o índice da conta (de 0 até o número máximo - 1).
- Exceções como `TamanhoInvalidoException`, `ContaInexistenteException` e `LimiteContasException` são lançadas e tratadas com mensagens amigáveis.

---

## 🏗️ Estrutura do Projeto

```bash
poo-banco/
│
├── model/
│   ├── Banco.java                # Lógica do banco e gerenciamento de contas
│   ├── Conta.java                # Classe base de conta(conta corrente generica)
│   ├── ContaBonificada.java      # Conta com cashback em saques
│   ├── Poupanca.java             # Conta com rendimento
│   └── TipoConta.java            # Enum com os tipos de conta
│
├── exception/
│   ├── TamanhoInvalidoException.java
│   ├── TamanhoNegativoException.java
│   ├── LimiteContasException.java
│   ├── ContaInexistenteException.java
│   └── IdInvalidoException.java
│
├── view/
│   └── Main.java                 # Interface de texto com menu e interações
│
└── README.md