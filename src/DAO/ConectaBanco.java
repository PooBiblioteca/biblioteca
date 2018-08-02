package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {

    private static Connection conexao;
    private static String url;
    private static String usuario = "root";
    private static String senha = "1234";
    private static String banco = "biblioteca";

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                setUrl("jdbc:mysql://localhost:3306/" + getBanco() + "?useSSL=true");
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(getUrl(), getUsuario(), getSenha());

            }

        } catch (ClassNotFoundException cnfex) {
            System.out.println("Driver não carregado");
            System.exit(0);
//        } catch (SQLexception sqlex) {
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        return conexao;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConectaBanco.url = url;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ConectaBanco.usuario = usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        ConectaBanco.senha = senha;
    }

    public static String getBanco() {
        return banco;
    }

    public static void setBanco(String banco) {
        ConectaBanco.banco = banco;

    }    
   		
}
