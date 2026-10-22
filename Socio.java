/**
 * Socio
 * @author João
 * @version 1.0
 */

public class Socio {
    private String nomeSocio;
    private int numeroSocio;
    private String mailSocio;
    private String tipoSocio;

    public Socio(String nomeSocio,int numeroSocio,String mailSocio,String tipoSocio){
        this.nomeSocio = nomeSocio;
        this.numeroSocio = numeroSocio;
        this.mailSocio = mailSocio;
        this.tipoSocio = tipoSocio;
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

}
