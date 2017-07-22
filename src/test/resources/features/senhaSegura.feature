# language: pt

@senhaSegura
Funcionalidade: Garantir senha segura para cliente

Como cliente
Eu quero garantir a seguranca das contas
Para evitar o uso por terceiros

Cenario: Usuario entra com uma senha pequena
Dado que um cliente vai criar uma conta
Quando a senha e pequena
Entao a conta nao e criada

Cenario: Usuario entra com uma senha grande mas fraca
Dado que um cliente vai criar uma conta
Quando a senha e grande mas fraca
Entao a criacao nao e concluida

Cenario: Usuario entra com uma senha segura
Dado que um cliente vai criar uma conta
Quando a senha e segura
Entao a criacao e concluida
