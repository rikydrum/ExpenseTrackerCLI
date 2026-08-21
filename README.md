# 💰 Personal Expense Tracker CLI

Un'applicazione Java da riga di comando (CLI) progettata per la gestione e il tracciamento delle spese personali con persistenza dei dati in formato JSON.

Il progetto applica l'architettura a livelli (Layered Architecture), utilizza la Java Stream API per la manipolazione avanzata dei dati e gestisce la serializzazione/deserializzazione tramite la libreria Jackson.

---

## 🛠️ Stack Tecnologico & Strumenti

* **Linguaggio:** Java 17+
* **Build Tool & Dipendenze:** Apache Maven
* **Librerie di Terze Parti:**
    * `jackson-databind` (Gestione e parsing JSON)
    * `jackson-datatype-jsr310` (Supporto nativo per `java.time.LocalDate`)
* **IDE:** IntelliJ IDEA

---

## 🏗️ Architettura del Progetto

Il codice segue i principi di separazione delle responsabilità (SOC):

* `Expense.java` — **Domain Model**: Rappresenta l'entità della spesa con id, descrizione, importo (`BigDecimal`), categoria e data.
* `ExpenseRepository.java` — **Data Access Layer**: Gestisce la lettura e scrittura del file `expenses.json`.
* `ExpenseService.java` — **Business Logic Layer**: Elabora le operazioni di filtraggio, calcolo del totale e logica d'inserimento/rimozione tramite **Java Streams**.
* `Main.java` — **Presentation Layer**: Gestisce l'interfaccia utente a riga di comando (CLI) e l'I/O da tastiera tramite `Scanner`.

---

## 🚀 Funzionalità Principali

- [x] **Aggiunta Spese:** Registrazione di una nuova spesa con generazione automatica dell'ID e data corrente.
- [x] **Persistenza Automatica:** Salvataggio e caricamento automatico delle spese su file `expenses.json`.
- [x] **Analisi Finanziaria:** Calcolo del totale complessivo speso con precisione decimale avanzata (`BigDecimal`).
- [x] **Filtraggio Dati:** Ricerca ed estrazione delle spese filtrate per categoria.
- [x] **Rimozione Spesa:** Cancellazione di un elemento dal registro tramite ID.

---

## 📋 Come Eseguire il Progetto

### Requisiti
* Java Development Kit (JDK) 17 o superiore
* Apache Maven

### Passaggi

1. **Clona la repository:**
   ```bash
   git clone [https://github.com/tuo-username/ExpenseTrackerCLI.git](https://github.com/tuo-username/ExpenseTrackerCLI.git)
   cd ExpenseTrackerCLI