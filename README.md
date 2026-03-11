# 🛡️ BEDWARS2026

<p align="center">
<img src="https://raw.githubusercontent.com/SULEIMANDEEV/BedWars2026/main/bedwars2026.png" width="900"/>
</p>

<p align="center">
<img src="https://img.shields.io/github/actions/workflow/status/SULEIMANDEEV/BedWars2026/build.yml?style=for-the-badge">
<img src="https://img.shields.io/github/v/release/SULEIMANDEEV/BedWars2026?style=for-the-badge">
<img src="https://img.shields.io/badge/Java-11+-orange?style=for-the-badge">
<img src="https://img.shields.io/badge/Spigot-1.8.x-yellow?style=for-the-badge">
<img src="https://img.shields.io/github/license/SULEIMANDEEV/BedWars2026?style=for-the-badge">
<img src="https://img.shields.io/github/stars/SULEIMANDEEV/BedWars2026?style=for-the-badge">
</p>

---

# ⚔️ Sobre o Projeto

**BEDWARS2026** é uma implementação **moderna, otimizada e sem dependências externas** do modo de jogo **BedWars** para servidores Minecraft.

Este projeto é uma **versão aprimorada do BedWars1058**, reestruturado com uma arquitetura mais limpa, melhor desempenho e maior facilidade de manutenção.

O objetivo do projeto é fornecer um **sistema de BedWars nível Hypixel**, pronto para redes de servidores Minecraft.

---

# 🚀 Melhorias em relação ao BedWars1058

✔ Remoção de dependências externas  
✔ Arquitetura mais limpa e organizada  
✔ Melhor performance nas arenas  
✔ Código mais fácil de manter  
✔ Estrutura modular  
✔ Preparado para redes de servidores  

---

# ⚙️ Funcionalidades Principais

## 🎮 Mecânicas do Jogo

- Sistema de proteção da cama
- Combate entre equipes
- Sistema de final kills
- Sistema de respawn
- Modo espectador
- Fase de morte súbita

---

## 🏝 Sistema de Arenas

- Suporte a múltiplas arenas
- Carregamento dinâmico de arenas
- Grupos de arena (Solo, Dupla, etc)
- Sistema de reset de mapa
- Configuração de geradores
- Proteção de spawn de equipe

---

## 🛒 Sistema de Loja

Sistema de loja totalmente configurável:

- Quick Buy
- Upgrades permanentes
- Categorias de itens
- Itens personalizados
- Compras com execução de comandos
- Sistema de tiers de itens

---

## ⚔ Upgrades de Equipe

Sistema completo de upgrades:

- Upgrade de forge
- Sistema de traps
- Upgrades de proteção
- Efeitos de poção
- Melhorias da base
- Níveis de upgrade configuráveis

---

## 📊 Estatísticas do Jogador

Sistema interno de estatísticas:

- Vitórias
- Final Kills
- Camas destruídas
- Partidas jogadas
- Tempo de jogo

Tudo acessível através de **menus GUI dentro do jogo**.

---

## 👥 Sistema de Party

O **BEDWARS2026** possui sistema de party nativo:

- Criação de party
- Convite de jogadores
- Entrada em partidas com party
- Sistema de fila em grupo

Nenhum plugin externo é necessário.

---

## 📊 Sistema de Scoreboard

Sistema interno de scoreboard:

- Atualização dinâmica
- Scoreboard por arena
- Scoreboard por jogador
- Layouts totalmente configuráveis

---

# 🧠 Arquitetura do Projeto

O projeto utiliza uma **arquitetura modular**, facilitando manutenção e expansão.

BedWars2026
│
├── api
│ ├── events
│ ├── interfaces
│ └── hooks
│
├── core
│ ├── bootstrap
│ ├── configuration
│ ├── scheduler
│ └── registry
│
├── game
│ ├── arena
│ ├── teams
│ ├── generators
│ └── phases
│
├── player
│ ├── profiles
│ ├── stats
│ ├── reconnect
│ └── spectator
│
├── systems
│ ├── scoreboard
│ ├── menus
│ ├── npc
│ ├── party
│ └── cosmetics
│
├── commands
│
└── utils


Essa arquitetura permite:

- código mais organizado
- fácil manutenção
- expansão de funcionalidades
- melhor escalabilidade

---

# ⚡ Performance

O **BEDWARS2026** foi projetado pensando em **alto desempenho para servidores Minecraft**.

Otimizações incluem:

- loops de arena otimizados
- menor alocação de memória
- sistemas internos mais rápidos
- menos bloqueios assíncronos
- reset de arenas mais rápido

---

# 📦 Requisitos

Java 11+
Spigot / Paper 1.8.x


Nenhum plugin externo é necessário.

---

# 🗺 Roadmap

### ✔ Fase 1 — Sistemas Base

- Sistema de arenas
- Sistema de equipes
- Sistema de geradores
- Loja básica
- Upgrades básicos

### ✔ Fase 2 — Sistemas de Gameplay

- Sistema de party
- Estatísticas
- Scoreboard
- Modo espectador
- GUI de seleção de arenas

### 🔄 Fase 3 — Sistemas Avançados

- Cosméticos avançados
- Sistema de NPC
- Integração com lobby
- Melhorias de matchmaking
- Otimizações adicionais

### 🚀 Fase 4 — Recursos para Network

- Compatibilidade com proxy
- Estatísticas cross-server
- Matchmaking global
- API avançada

---

# 👨‍💻 Desenvolvedor

**SuleimanDEV**

Desenvolvedor Backend  
Java & Kotlin Developer  
Minecraft Systems Architect

---

# 📜 Licença

Este projeto é uma atualização do **BedWars1058 de Andrei1058**, distribuído sob licença **GNU GPL v3**.

O **BEDWARS2026** introduz melhorias estruturais mantendo o respeito à licença open-source original.

---

# ⭐ Contribuições

Contribuições são bem-vindas.

1. Faça um fork do projeto  
2. Crie uma branch  
3. Envie um Pull Request  

---

# 💡 Visão do Projeto

O **BEDWARS2026** pretende se tornar uma **base moderna de BedWars para redes Minecraft**, oferecendo um sistema poderoso, modular e sem dependências externas.
