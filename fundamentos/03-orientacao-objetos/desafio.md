# Desafio: Sistema de Conta Bancária

## Regras:
- Classe `ContaBancaria`: titular, saldo
- Métodos: `depositar()`, `sacar()`, `exibirSaldo()`
- Criar herança para `ContaPoupanca` com limite de saques mensais

## Extras:
- Usar `data class` para registrar transações
- 
# 🎥 Desafio: Catálogo de Filmes & Playlists

## 🎯 Regras:
- Criar a classe `Filme` com os atributos:
    - `titulo`
    - `genero`
    - `duracao` (em minutos)
    - `classificacaoIndicativa`
    - `anoLancamento`

- Criar a classe `Catalogo`, com:
    - Lista de filmes disponíveis
    - Métodos:
        - `adicionarFilme(filme: Filme)`
        - `buscarPorGenero(genero: String)`
        - `listarFilmes()`
        - `filmesPorAno(ano: Int)`
