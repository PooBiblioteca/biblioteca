package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entidade.Autor;
import java.sql.PreparedStatement;

public class AutorDAO {

    public void Salvar(Autor autor) {
        String sql = "INSERT INTO autor(codigo,nome) VALUES(?,?)";
        try {
            Connection con = ConectaBanco.getConexao();
            /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setInt(1, autor.getCodigo());
            stat.setString(2, autor.getNome());

            stat.execute();
            stat.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    public ArrayList<Autor> BuscarAutor() throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //Criando variável sql vazia
            String sql;

            //Montando o sql
            sql = "select * from autor";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo autor */
            ArrayList<Autor> autores = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. 
                Autor autor = new Autor();

                /* Mapeando a tabela do banco para objeto */
                autor.setCodigo(rs.getInt("codigo"));
                autor.setNome(rs.getString("nome"));


                /* Inserindo o objeto  no ArrayList */
                autores.add(autor);

            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return autores;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

        }//fecha finally
    }

}
