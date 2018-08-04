package Entidade;

import java.util.Date;

public class Emprestimo {
    
    private Integer codigo;
    private Date dataretirada;
    private Date dataDevolucao;
    private Boolean dano; //passivel de remocao
    private String observacao;
    private Funcionario funcionario;
    private Exemplar exemplar;
    private Usuario usuario;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    public Date getDataretirada() {
        return dataretirada;
    }

    public void setDataretirada(Date dataretirada) {
        this.dataretirada = dataretirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Boolean getDano() {
        return dano;
    }

    public void setDano(Boolean dano) {
        this.dano = dano;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public void finalizarEmprestimo(Livro livro, Usuario usuario){}
    
    public void cadastraEmprestimo (Livro livro, Usuario usuario){}
    
    //Metodos de listagem - penso que 3 esta ok
    //.
    //.
    //.
}

