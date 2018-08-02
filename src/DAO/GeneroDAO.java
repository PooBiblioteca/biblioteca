package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entidade.Genero;
import java.sql.PreparedStatement;

public class GeneroDAO {

    public void Salvar(Genero genero) {
        String sql = "INSERT INTO genero(codigo,tipo) VALUES(?,?)";
        try {
            Connection con = ConectaBanco.getConexao();
            /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setInt(1, genero.getCodigo());
            stat.setString(2, genero.getTipo());

            stat.execute();
            stat.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public ArrayList<Genero> BuscarGenero() throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //Criando variável sql vazia
            String sql;

            //Montando o sql
            sql = "select * from genero";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo genero */
            ArrayList<Genero> generos = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj.
                Genero genero = new Genero();

                /* Mapeando a tabela do banco para objeto */
                genero.setCodigo(rs.getInt("codigo"));
                genero.setTipo(rs.getString("tipo"));


                /* Inserindo o objeto no ArrayList */
                generos.add(genero);

            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return generos;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

        }//fecha finally
    }

}
