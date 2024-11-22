package dev.mutua.pos.service;

import dev.mutua.pos.model.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class CategoryService {
    private Category category;
    String url = "jdbc:postgres://localhost:5432/pos";
    Connection conn = null;
    String username = "postgres";
    String password = "test1234";

    public CategoryService(Category category) {
        this.category = category;
        try {
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCategory(String categoryName) {
        category = new Category.Builder()
                .withId(UUID.randomUUID().clockSequence())
                .withName(categoryName)
                .build();

    }
}
