/**
 * Socio
 * @author João
 * @version 1.0
 */

public class Socio {
    private String nomeSocio;
    private int numeroSocio;
    private String mailSocio;

    public Socio(String nomeSocio,int numeroSocio,String mailSocio){
        this.nomeSocio = nomeSocio;
        this.numeroSocio = numeroSocio;
        this.mailSocio = mailSocio;
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

}
