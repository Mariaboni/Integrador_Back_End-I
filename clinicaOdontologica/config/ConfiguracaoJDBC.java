package com.dh.clinicaOdontologica.config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConfiguracaoJDBC {

    private final String jdbcDrive;
    private final String dbUrl;
    private final String nomeUsuario;
    private final String senha;

    public ConfiguracaoJDBC() {
        this.jdbcDrive = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:tcp://localhost/~/dbclinica1;AUTO_SERVER=TRUE";
        this.nomeUsuario = "sa";
        this.senha = "";
    }

    public Connection conectarComBancoDeDados() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
