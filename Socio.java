/**
 * Socio
 * @author João
 * @version 1.0
 */

public class Socio {
    private String nomeSocio;
    private int numeroSocio;
    private String mailSocio;

    private Socio(String nomeSocio,int numeroSocio,String mailSocio){
        this.nomeSocio = nomeSocio;
        this.numeroSocio = numeroSocio;
        this.mailSocio = mailSocio;
    }

    public String getnomeSocio(){
        return nomeSocio;
    }

    public int getnumeroSocio(){
        return numeroSocio;
    }

    public String getmailSocio(){
        return mailSocio;
    }

}
