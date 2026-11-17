# Liga da Refatoração (Turma: Engenharia de Software 2 | UFPA)

Prof. Dr. Victor Santiago

Este projeto contém **10 questões**, cada uma em um pacote separado (`q1` ... `q10`), com código "antes" para você aplicar um tipo específico de refatoração. Se preferir dê uma olhada no material da aula passada e no livro do Fowler ou nesse link: https://refactoring.guru/pt-br

## Como rodar
```bash
mvn test
```

## Regras
- **Não mude o comportamento**: use os testes para garantir isso.
- Faça a refatoração em **micro-passos** (há dicas no slide da aula).
- Você pode criar novos arquivos/classes, desde que mantenha os pacotes.

## Estrutura
- Produção: `src/main/java/br/ufpa/refactoring/qX/`
- Testes: `src/test/java/br/ufpa/refactoring/qX/`

> Os testes não estão completos. Você deve completar com asserts de comportamento
> antes/depois da refatoração.

## Atividades para hoje
- Q1: Extract Method
- Q2: Inline Method
- Q3: Replace Temp with Query
- Q4: Replace Inheritance with Delegation
- Q5: Collapse Hierarchy
- Q6: Replace Conditional with Polymorphism
- Q7: Introduce Null Object
- Q8: Extract Class
- Q9: Move Method / Move Field
- Q10: Introduce Parameter Object
