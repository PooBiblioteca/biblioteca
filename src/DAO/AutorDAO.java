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

}
