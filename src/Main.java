import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseRepository repo = new ExpenseRepository();
        ExpenseService service = new ExpenseService(repo);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- GESTORE SPESE PERSONALI ---");
            System.out.println("1. Aggiungi Spesa");
            System.out.println("2. Mostra Tutte le Spese");
            System.out.println("3. Calcola Totale Speso");
            System.out.println("4. Filtra per Categoria");
            System.out.println("5. Elimina Spesa");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Pulizia del buffer

            switch (choice) {
                case 1:
                    System.out.print("Descrizione: ");
                    String desc = scanner.nextLine();
                    System.out.print("Importo (€): ");
                    BigDecimal amount = new BigDecimal(scanner.nextLine());
                    System.out.print("Categoria (es. Cibo, Svago, Casa): ");
                    String cat = scanner.nextLine();
                    service.addExpense(desc, amount, cat);
                    System.out.println("Spesa aggiunta con successo!");
                    break;
                case 2:
                    service.getAllExpenses().forEach(e -> System.out.println(e));
                    break;
                case 3:
                    System.out.println("Totale complessivo speso: " + service.getTotalAmount() + " €");
                    break;
                case 4:
                    System.out.print("Inserisci la categoria: ");
                    String filterCat = scanner.nextLine();
                    service.getExpensesByCategory(filterCat).forEach(e -> System.out.println(e));
                    break;
                case 5:
                    System.out.print("ID della spesa da rimuovere: ");
                    Long id = scanner.nextLong();
                    if (service.deleteExpense(id)) {
                        System.out.println("Spesa eliminata.");
                    } else {
                        System.out.println("ID non trovato.");
                    }
                    break;
                case 0:
                    System.out.println("Chiusura applicazione. Arrivederci!");
                    return;
                default:
                    System.out.println("Opzione non valida.");
                    break;
            }
        }
    }
}