package Entidade;

import java.util.Date;

public class Funcionario extends Pessoa{
    private String senhaacesso;
    private Integer codigoContrato;
    private Date fimContrato;

    public String getSenhaacesso() {
        return senhaacesso;
    }

    public void setSenhaacesso(String senhaacesso) {
        this.senhaacesso = senhaacesso;
    }

    public Integer getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(Integer codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Date getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Date fimContrato) {
        this.fimContrato = fimContrato;
    }
    //Implementar
    public void validarLogUsuario(Usuario usuario){}
    
}
