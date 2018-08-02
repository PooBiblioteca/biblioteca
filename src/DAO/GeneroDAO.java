package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entidade.Genero;
import DAO.ConectaBanco;
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

}
