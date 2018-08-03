package Entidade;

public class Usuario extends Pessoa{
    private Boolean ativo;
    private Integer codigoCadastro;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public Integer getCodigoCadastro() {
        return codigoCadastro;
    }

    public void setCodigoCadastro(Integer codigoCadastro) {
        this.codigoCadastro = codigoCadastro;
    }
}