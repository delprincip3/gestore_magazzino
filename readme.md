# Sistema di Gestione Magazzino

![Logo Sistema Magazzino](https://via.placeholder.com/150x50?text=SGM)

Un'applicazione moderna per la gestione completa del magazzino, prodotti, clienti e fatturazione. Sviluppata con Spring Boot e un'interfaccia utente responsive e intuitiva.

## 📋 Funzionalità Principali

- **Gestione Prodotti**: catalogo completo, aggiunta, modifica e visualizzazione
- **Gestione Clienti**: anagrafica clienti con dati personali e fiscali
- **Vendite**: sistema di vendita prodotti con selezione cliente
- **Fatturazione**: generazione automatica e visualizzazione fatture
- **Dashboard**: panoramica immediata delle attività principali
- **Interfaccia Responsive**: utilizzabile da desktop, tablet e smartphone

## 🔧 Requisiti di Sistema

- Java 17 o superiore
- Maven 3.6 o superiore
- PostgreSQL 12 o superiore
- Browser web moderno (Chrome, Firefox, Safari, Edge)

## 🚀 Installazione e Configurazione

### Prerequisiti
1. Installare JDK 17+
2. Installare Maven
3. Installare PostgreSQL

### Database
1. Creare un database PostgreSQL:
CREATE DATABASE inventorymanager;
CREATE USER inventoryadmin WITH ENCRYPTED PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE inventorymanager TO inventoryadmin;



### Configurazione Applicazione
1. Clonare il repository:
bash
git clone https://github.com/delprincip3/inventorymanager.git
cd inventorymanager


2. Configurare il database in `application.properties`:
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/inventorymanager
spring.datasource.username=inventoryadmin
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


3. Compilare e avviare l'applicazione:
bash
mvn clean install
mvn spring-boot:run


4. Accedere all'applicazione all'indirizzo: `http://localhost:8080`

## 🗃️ Struttura del Database

Il sistema utilizza PostgreSQL con le seguenti tabelle principali:

- **product**: catalogo prodotti con codice, descrizione, prezzo e quantità
- **customer**: anagrafica clienti con nome, cognome e codice fiscale
- **purchase**: registrazione delle vendite con riferimenti a prodotti e clienti

## 📱 Utilizzo dell'Applicazione

### Gestione Prodotti
- Visualizzare tutti i prodotti in magazzino
- Aggiungere nuovi prodotti con codice, descrizione, prezzo e quantità
- Modificare prodotti esistenti
- Vendere prodotti con generazione automatica di fatture

### Gestione Clienti
- Registrare nuovi clienti con dati anagrafici e fiscali
- Visualizzare e modificare clienti esistenti
- Associare clienti alle vendite

### Fatturazione
- Visualizzare tutte le fatture emesse
- Visualizzare i dettagli di ogni fattura
- Stampare fatture in formato adatto alla presentazione

## 🖥️ Screenshot

![Dashboard](https://via.placeholder.com/800x400?text=Dashboard)
![Lista Prodotti](https://via.placeholder.com/800x400?text=Lista+Prodotti)
![Dettaglio Fattura](https://via.placeholder.com/800x400?text=Dettaglio+Fattura)

## 🔍 Tecnologie Utilizzate

- **Backend**: Java, Spring Boot, Spring Data JPA, Hibernate
- **Frontend**: HTML5, CSS3, JavaScript, Bootstrap 5, Font Awesome
- **Template Engine**: Thymeleaf
- **Database**: PostgreSQL
- **Build Tool**: Maven

## 🔄 Aggiornamenti e Sviluppi Futuri

- Gestione fornitori
- Sistema di notifiche per scorte in esaurimento
- Dashboard con grafici statistici
- Reportistica avanzata
- Integrazione con sistemi POS

## 📜 Licenza

Questo progetto è distribuito con licenza MIT. Vedere il file `LICENSE` per ulteriori informazioni.

## 👥 Autori

- **delprincip3** - *Sviluppo iniziale* - [GitHub](https://github.com/delprincip3)

---

© 2025 Sistema di Gestione Magazzino | Tutti i diritti riservati