package br.com.dio;

import br.com.dio.persistence.migration.MigrationStrategy;
import br.com.dio.ui.MainMenu;

import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;


public class Main {
    public static void main(String[] args) {
        try (var connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou migrar o banco de dados: " + e.getMessage());
            return;
        }

        new MainMenu().execute();
    }
}
