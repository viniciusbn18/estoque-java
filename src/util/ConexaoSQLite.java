/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author CGFEGF
 */
public class ConexaoSQLite {

    private Connection conexao;

    /**
     * Conecta a um bando de dados (cria um banco caso ele não exista)
     *
     * @return
     */
    public boolean conectar() {

        try {
            String url = "jdbc:sqlite:db/dbestoque.db";

            this.conexao = DriverManager.getConnection(url);
            System.out.println("Conectado");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }
            System.out.println("Desconectado");
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Criar os statements para execução dos sqls
     *
     * @param pSQL
     * @param RETURN_GENERATED_KEYS
     * @return
     */
    public PreparedStatement criarPreparedStatement(String pSQL, int RETURN_GENERATED_KEYS) {
        try {
            System.out.println("Executando");
            return conexao.prepareStatement(pSQL, RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Connection getConnection() {
        return this.conexao;
    }

    /**
     * Criar os statements para nosso sqls serem executados
     *
     * @param sql
     * @return
     */
    public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }
}
