package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class BancoLocal {
    public static Connection conexao = null;
    public PreparedStatement prep = null;
    public ResultSet tabela = null;
    

    public BancoLocal() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection(
    "jdbc:postgresql://127.0.0.1:5432/Usuario", "postgres", "vitor08032001");
               
            }
        } catch (Exception ex) {
      throw new Exception("Erro de conexao:" + ex.getMessage());
        }
    }
}
