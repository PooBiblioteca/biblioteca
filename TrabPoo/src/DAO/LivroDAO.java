/*package DAO;

import Entidade.Genero;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entidade.Livro;
import java.sql.PreparedStatement;

public class LivroDAO {

    public void Salvar(Livro livro) {
        String sql = "INSERT INTO livro(codigo,titulo,ano,genero,autor,volume,editora,exemplar) VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection con = ConectaBanco.getConexao();
            /*Criando obj. capaz de executar instruções
         SQL no banco de dados
            PreparedStatement stat = con.prepareStatement(sql);

            stat.setInt(1, livro.getCodigo());
            stat.setString(2, livro.getTitulo());
            stat.setInt(3, livro.getAno());
           
            stat.setInt(4, livro.getGeneros().addAll(generos));
            stat.setInt(5, livro.getAutores().addAll());
            stat.setInt(6, livro.getVolume());
            stat.setInt(7, livro.getEditora());
            stat.setInt(8, livro.getExemplares().addAll());
      
            stat.execute();
            stat.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
*/