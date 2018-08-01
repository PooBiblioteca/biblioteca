package Entidade;

import java.util.ArrayList;

public class Livro {
    private String titulo;
    private Integer ano;
    private ArrayList<Genero> genero = new ArrayList();
    private Integer codigo;
    private ArrayList<Autor> autor = new ArrayList();
    private Integer volume;
    private Integer editora;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getVolume() {
        return volume;
    }
    
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getEditora() {
        return editora;
    }

    public void setEditora(Integer editora) {
        this.editora = editora;
    }
}
