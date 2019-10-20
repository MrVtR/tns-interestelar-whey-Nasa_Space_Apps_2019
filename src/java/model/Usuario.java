package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.ResultSet;


/**
 *
 * @author aluno
 */
public class Usuario {

    private String usuario;
    private String senha;
    private String nome;
    private String email;
    private int qtdeadulto;


    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the qtdeadulto
     */
    public int getQtdeadulto() {
        return qtdeadulto;
    }

    /**
     * @param qtdeadulto the qtdeadulto to set
     */
    public void setQtdeadulto(int qtdeadulto) {
        this.qtdeadulto = qtdeadulto;
    }

    public boolean login(String user, String pass) throws Exception {
        Banco bb;
        try {
            bb = new Banco();
            bb.prep = Banco.conexao.prepareStatement(
                    "Select usuario,senha from Usuario"
                    + " where usuario=? and senha=?");
            bb.prep.setString(1, user);
            bb.prep.setString(2, pass);
            bb.tabela = bb.prep.executeQuery();
            if ((bb.tabela != null) && (bb.tabela.next())) {               
                this.setUsuario(bb.tabela.getString(1));
                this.setSenha(bb.tabela.getString(2));
                return (true);
            } else {
                return (false);
            }
        } catch (Exception ex) {
            throw new Exception("Erro no login: " + ex.getMessage());
        }
    }  
     public void gravar() throws Exception {
        Banco bb;
        try {
            bb = new Banco();
            bb.prep = Banco.conexao.prepareStatement("Insert into usuario(nome,usuario,senha,email,qtdeadulto) values(?,?,?,?,?)");
            bb.prep.setString(1, this.getNome());
            bb.prep.setString(2, this.getUsuario());
            bb.prep.setString(3, this.getSenha());
            bb.prep.setString(4, this.getEmail());
            bb.prep.setInt(5, this.getQtdeadulto());
            bb.prep.executeUpdate(); // executa o Sql
        } catch (Exception ex) {
            throw new Exception("Erro na conexão do banco: " + ex.getMessage());

        }

    }

    
}
