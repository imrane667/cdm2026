# 🏆 CDM 2026 - Application de Pronos

Application web pour placer ses pronostics pour la Coupe du Monde 2026, développée avec Spring Boot.

## ✨ Fonctionnalités

- Choix du profil utilisateur
- Visualisation des 12 groupes et leurs équipes
- Placement de pronostics par groupe (classement des 4 équipes)
- Indicateur visuel si le prono est déjà placé
- Classement des joueurs par points
- Anti-doublons dans le formulaire de prono

## 🛠️ Technologies

- **Backend** : Java 21, Spring Boot 4, Spring Data JPA, Hibernate
- **Frontend** : Thymeleaf, Bootstrap 5
- **Base de données** : H2 (dev) / MariaDB (prod)
- **Déploiement** : Docker, Raspberry Pi

## 🚀 Lancer le projet en local

### Prérequis
- Java 21
- Maven

### Installation

```bash
git clone https://github.com/imrane667/cdm2026.git
cd cdm2026
./mvnw spring-boot:run
```

Accès : `http://localhost:8080`

## 🐳 Docker

```bash
docker build -t cdm2026 .
docker run -p 8080:8080 cdm2026
```

## 📝 Système de points

- 2 points par position correcte dans un groupe
- Maximum 8 points par groupe
- Maximum 96 points au total (12 groupes × 8 points)

## 🤝 Contribution

N'hésitez pas à forker le projet et proposer des améliorations via Pull Request !

---
*Site codé par Imrane 💻# cdm2026
Application de pronos pour la Coupe du Monde 2026 - Spring Boot
