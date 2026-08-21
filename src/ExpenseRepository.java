import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {
    private final File file = new File("expenses.json");
    private final ObjectMapper mapper;

    public ExpenseRepository() {
        this.mapper = new ObjectMapper();
        // Registra il modulo per gestire LocalDate automaticamente
        this.mapper.registerModule(new JavaTimeModule());
    }

    public List<Expense> loadAll() {
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try {
            return mapper.readValue(file, new TypeReference<List<Expense>>() {});
        } catch (IOException e) {
            System.err.println("Errore nel caricamento del file JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveAll(List<Expense> expenses) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, expenses);
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio su file: " + e.getMessage());
        }
    }
}