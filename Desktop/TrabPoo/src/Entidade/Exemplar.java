package Entidade;

public class Exemplar {

    private Livro livro;
    private Short edicao;
    private Integer tombo;
    private Boolean disponivel;
    private Integer numExemplar;

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

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getNumExemplar() {
        return numExemplar;
    }

    public void setNumExemplar(Integer numExemplar) {
        this.numExemplar = numExemplar;
    }

}
