package Entidade;

public class Exemplar {
    private Livro livro;
    private Short edicao;
    private Integer tombo;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Short getEdicao() {
        return edicao;
    }

    public void setEdicao(Short edicao) {
        this.edicao = edicao;
    }

    public Integer getTombo() {
        return tombo;
    }

    public void setTombo(Integer tombo) {
        this.tombo = tombo;
    }
    //Implementar
    public Boolean IsDisponivel(Livro livro){return null;}
    
}
