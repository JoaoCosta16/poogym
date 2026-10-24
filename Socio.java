/**
 * Socio
 * @author Gustavo e João
 * @version 1.0
 */

public class Socio {
    private String nomeSocio;
    private int numeroSocio;
    private String mailSocio;
    private String tipoSocio;
    private int desconto;

    public Socio(String nomeSocio,int numeroSocio,String mailSocio,String tipoSocio, int desconto){
        this.nomeSocio = nomeSocio;
        this.numeroSocio = numeroSocio;
        this.mailSocio = mailSocio;
        this.tipoSocio = tipoSocio;
        this.desconto = desconto;
    }

    protected void setDesconto(int desconto) {
    this.desconto = desconto;
    }

    public String getNomeSocio(){
        return nomeSocio;
    }

    public int getNumeroSocio(){
        return numeroSocio;
    }

    public String getMailSocio(){
        return mailSocio;
    }
    public String getTipoSocio() {
        return tipoSocio;
    }

    public int getDesconto() {
        return desconto;
    }

    public String toString() {
        return "Nome: " + nomeSocio + ", Numero: " + numeroSocio + ", Mail: " + mailSocio;
    }

}
