package Entidade;

import java.util.ArrayList;

public class Livro {

    private Integer codigo;
    private String titulo;
    private Integer ano;
    private String genero;
    private String autor;
    private Integer volume;
    private String editora;
    private Exemplar exemplar;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

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

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    /* public Integer obterDisponivel() {
        for (Exemplar e : getExemplar()) {
            if (e.getDisponivel()) {
                return e.getNumExemplar();
            }
        }
        return 0;
    }

  

    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares = exemplares;
        if (exemplares.isEmpty()) {
            System.out.println("Lista vazia");
        }
    }
     */
    @Override

    public String toString() {

        return getTitulo();
    }

}
