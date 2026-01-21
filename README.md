# E-Commerce Admin – JavaFX Anwendung

## Projektbeschreibung
Diese Anwendung ist eine Administrationsplattform für Produkte eines E-Commerce-Systems.  
Sie ermöglicht das Anzeigen, Hinzufügen und Löschen von Produkten, welche in einer PostgreSQL-Datenbank gespeichert sind.

Die Anwendung wurde in **Java** mit **JavaFX** für die grafische Benutzeroberfläche entwickelt und verwendet **JDBC** für den Datenbankzugriff.  
Die Architektur folgt dem **MVC-Prinzip (Model-View-Controller)**.

---

## Verwendete Technologien
- Java 21
- JavaFX
- Maven
- PostgreSQL
- Docker
- JDBC
- DBeaver (Datenbankverwaltung)

---

## Funktionalitäten
- Anzeige aller Produkte in einer Tabelle
- Hinzufügen neuer Produkte
- Löschen bestehender Produkte (mit Bestätigungsdialog)
- Direkte Verbindung zu einer PostgreSQL-Datenbank
- Grafische Benutzeroberfläche mit JavaFX

---

## Datenbank

Die PostgreSQL-Datenbank wird in einem **Docker-Container** betrieben.

### Start der Datenbank
```bash
docker-compose up -d