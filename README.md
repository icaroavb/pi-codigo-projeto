# 🎭 Sistema de Teatro - Compra de Tickets com Validação de CPF

Este é um projeto em Java que simula um sistema de compra de ingressos para um teatro, utilizando boas práticas de organização de código e padrões de projeto.

---

## ✨ Funcionalidades

- Cadastro de usuários com CPF válido
- Listagem de usuários cadastrados
- Compra de ticket para poltronas numeradas (1 a 30)
- Exibição de poltronas livres e ocupadas
- Validação real de CPF com algoritmo da Receita Federal

---

## 🧱 Estrutura do Projeto

```
principal/
├── App.java                         ← Interface de console
├── action/compra/
│   ├── CompraTicketTemplate.java    ← Template Method base
│   ├── CompraTicket.java            ← Implementação da compra
│   └── Poltrona.java                ← Array de poltronas
├── cadastro/
│   ├── RepositorioUsuarios.java     ← Singleton para salvar/verificar CPF
│   ├── Validador.java               ← Interface de estratégia (Strategy)
│   ├── ValidadorCPF.java            ← Validador de CPF
│   └── VerificarCPF.java            ← Lógica de validação real
```

---

## 🛠️ Padrões de Projeto Aplicados

| Padrão | Aplicação |
|--------|-----------|
| **Strategy** | Validação de CPF com a interface `Validador` e classe `ValidadorCPF` |
| **Singleton** | Repositório central de usuários (`RepositorioUsuarios`) |
| **Template Method** | Processo de compra (`CompraTicketTemplate`) com execução padronizada |
| **Responsabilidade Única (SRP)** | Cada classe faz apenas uma coisa bem definida |

---

## 🔁 Fluxo de Compra de Ticket

1. Digitar CPF
2. Validar CPF
3. Verificar se está cadastrado
4. Exibir poltronas livres
5. Escolher uma poltrona
6. Registrar a compra
7. Exibir comprovante

---

## ✅ Validação de CPF

- Aceita entrada com ou sem pontos/traços (`12345678900` ou `123.456.789-00`)
- Verifica se são 11 dígitos
- Rejeita CPFs com todos os dígitos iguais
- Calcula os dígitos verificadores conforme a Receita Federal

---

## 🚀 Próximos passos sugeridos

- Persistir poltronas compradas em arquivo
- Associar tickets aos dados completos do usuário
- Adicionar descontos (meia, VIP) com Strategy
- Criar testes automatizados com JUnit

---

## 👨‍💻 Desenvolvido com foco em boas práticas e clareza de código.