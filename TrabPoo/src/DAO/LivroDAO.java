package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entidade.Livro;
import java.sql.PreparedStatement;
import java.util.List;

public class LivroDAO {

    public void Salvar(Livro livro) {
        String sql = "INSERT INTO livro(titulo,ano,genero,autor,volume,editora) VALUES(?,?,?,?,?,?)";
        try {
            Connection con = ConectaBanco.getConexao();

            PreparedStatement stat = con.prepareStatement(sql);

            stat.setString(1, livro.getTitulo());
            stat.setInt(2, livro.getAno());
            stat.setString(3, livro.getGenero());
            stat.setString(4, livro.getAutor());
            stat.setInt(5, livro.getVolume());
            stat.setString(6, livro.getEditora());

            stat.execute();
            stat.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<Livro> BuscarPorTitulo(String titulo) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM livro WHERE upper(titulo) like ?";

        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, titulo);

        // Recebe o resultado da consulta SQL
        ResultSet rs = stat.executeQuery();

        List<Livro> lista = new ArrayList<>();

        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while (rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Livro livro = new Livro();

            // "c" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
            //funcionario.setSenhaacesso(rs.getString("senha"));

            /* Inserindo o objeto  no ArrayList */
            livro.setCodigo(rs.getInt("codigo"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAno(rs.getInt("ano"));
            livro.setGenero(rs.getString("genero"));
            livro.setAutor(rs.getString("autor"));
            livro.setVolume(rs.getInt("volume"));
            livro.setEditora(rs.getString("editora"));

            // Adiciona o registro na lista
            lista.add(livro);
        }

        // Fecha a conexão com o BD
        rs.close();
        stat.close();

        // Retorna a lista de registros, gerados pela consulta
        return lista;
    }

    public ArrayList<Livro> BuscarLivro() throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConectaBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //Criando variável sql vazia
            String sql;

            //Montando o sql
            sql = "select * from livro";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo autor */
            ArrayList<Livro> livros = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. 
                Livro livro = new Livro();

                /* Mapeando a tabela do banco para objeto */
                livro.setCodigo(rs.getInt("codigo"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAno(rs.getInt("ano"));
                livro.setGenero(rs.getString("genero"));
                livro.setAutor(rs.getString("autor"));
                livro.setVolume(rs.getInt("volume"));
                livro.setEditora(rs.getString("editora"));

                /* Inserindo o objeto  no ArrayList */
                livros.add(livro);

            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return livros;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {

        }//fecha finally
    }
}
