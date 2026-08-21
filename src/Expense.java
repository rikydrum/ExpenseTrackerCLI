
import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {
    private Long id;
    private String description;
    private BigDecimal amount;
    private String category;
    private LocalDate date;

    public Expense() {} // Costruttore vuoto necessario per la deserializzazione JSON

    public Expense(Long id, String description, BigDecimal amount, String category, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getter e Setter...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public BigDecimal getAmount() { return amount; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return String.format("[%d] %s | %s € | Cat: %s | Data: %s",
                id, description, amount, category, date);
    }
}

