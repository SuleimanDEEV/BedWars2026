# 🛡️ BEDWARS2026

<p align="center">
<img src="https://raw.githubusercontent.com/SuleimanDEEV/BedWars2026/refs/heads/main/bedwars2026.png?token=GHSAT0AAAAAADXINBL65NOJ5WDZTBTVSF3C2NQWVMQ" width="900"/>
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

# ⚔️ BEDWARS2026

A **modern, optimized and dependency-free BedWars implementation** for Minecraft servers.

Inspired by **BedWars1058**, but completely redesigned with a **clean modular architecture and zero external dependencies**.

---

## 🚀 Highlights

✔ Fully self-contained  
✔ Hypixel-style mechanics  
✔ High performance  
✔ Clean architecture  
✔ Network ready  

---

# ⚙️ Core Features

### 🎮 Game Mechanics

- Bed protection system
- Team based combat
- Final kills system
- Respawn mechanics
- Spectator mode
- Sudden death phase

---

### 🏝 Arena System

- Multi arena support
- Dynamic arena loading
- Arena groups (Solo, Doubles, etc)
- Map restore system
- Generator configuration
- Team spawn protection

---

### 🛒 Shop System

Fully configurable shop system:

- Quick buy
- Permanent upgrades
- Item categories
- Custom items
- Command execution purchases
- Item tier system

---

### ⚔ Team Upgrades

Upgradeable team abilities:

- Forge upgrades
- Traps
- Protection upgrades
- Potion effects
- Base upgrades
- Custom upgrade tiers

---

### 📊 Player Statistics

Internal stats system including:

- Wins
- Final kills
- Beds destroyed
- Games played
- Playtime

Accessible through **in-game GUI menus**.

---

### 👥 Party System

BEDWARS2026 includes a **native party system**:

- Party creation
- Player invites
- Team join system
- Party queue system

No external plugins required.

---

### 📊 Scoreboard System

Custom internal scoreboard implementation:

- Dynamic scoreboard updates
- Per-arena scoreboard
- Per-player scoreboard
- Fully configurable layouts

---

# 🧠 Architecture

BEDWARS2026 follows a **modular backend architecture** designed for scalability.


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
│ │ ├── Arena
│ │ ├── ArenaManager
│ │ └── ArenaState
│ │
│ ├── teams
│ │ ├── Team
│ │ └── TeamManager
│ │
│ ├── generators
│ │ ├── Generator
│ │ └── GeneratorManager
│ │
│ └── phases
│ ├── LobbyPhase
│ ├── GamePhase
│ └── EndPhase
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

This architecture ensures:

• maintainable code  
• scalable modules  
• easier debugging  
• easier feature expansion  

---

# ⚡ Performance

BEDWARS2026 was designed with **server performance in mind**.

Performance improvements include:

- optimized arena loops
- internal utility systems
- reduced memory allocations
- minimal async blocking
- faster arena resets

---

# 📦 Requirements


Java 11+
Spigot / Paper 1.8.x

No external plugins required.

---

# 🗺 Roadmap

### ✔ Phase 1 — Core Development

- Arena system
- Team system
- Generator system
- Basic shop system
- Basic upgrades

---

### ✔ Phase 2 — Gameplay Systems

- Party system
- Player statistics
- Scoreboard system
- Spectator mode
- Arena GUI selector

---

### 🔄 Phase 3 — Advanced Systems

- Advanced cosmetics
- NPC join system
- Lobby integration
- Matchmaking improvements
- Performance optimizations

---

### 🚀 Phase 4 — Network Features

- Proxy compatibility
- Cross-server stats
- Global matchmaking
- Advanced API

---

# 👨‍💻 Developer

**SuleimanDEV**

Backend Developer  
Java & Kotlin Developer  
Minecraft Systems Architect

---

# 📜 License

This project is inspired by **BedWars1058 by Andrei1058**, originally released under **GNU GPL v3**.

BEDWARS2026 introduces major architectural changes while respecting the open-source license.

---

# ⭐ Contributing

Contributions are welcome.

Steps:

1. Fork the repository
2. Create a new branch
3. Submit a pull request

---

# 💡 Project Vision

BEDWARS2026 aims to become a **modern BedWars foundation for Minecraft networks**, providing a powerful and dependency-free system ready for large scale servers.
