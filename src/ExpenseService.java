import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseService {
    private final ExpenseRepository repository;
    private final List<Expense> expenses;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
        this.expenses = repository.loadAll();
    }

    public void addExpense(String description, BigDecimal amount, String category) {
        long newId = expenses.stream().mapToLong(Expense::getId).max().orElse(0) + 1;
        Expense expense = new Expense(newId, description, amount, category, LocalDate.now());
        expenses.add(expense);
        repository.saveAll(expenses);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public BigDecimal getTotalAmount() {
        return expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenses.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public boolean deleteExpense(Long id) {
        boolean removed = expenses.removeIf(e -> e.getId().equals(id));
        if (removed) {
            repository.saveAll(expenses);
        }
        return removed;
    }
}