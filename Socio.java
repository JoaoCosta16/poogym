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
    
    /**
     * Cria socio individual.
     * @param nomeSocio nome do socio
     * @param numeroSocio numero unico do socio
     * @param mailSocio e-mail do socio
     * @param tipoSocio tipo de socio
     * @param desconto desconto de socio 
     */

    public Socio(String nomeSocio,int numeroSocio,String mailSocio,String tipoSocio, int desconto){
        this.nomeSocio = nomeSocio;
        this.numeroSocio = numeroSocio;
        this.mailSocio = mailSocio;
        this.tipoSocio = tipoSocio;
        this.desconto = desconto;
    }

     /**
     * Obtem o nome do socio.
     * @return nome do socio
     */
    public String getNomeSocio() {
        return nomeSocio;
    }
 
    /**
     * Obtem o numero do socio.
     * @return numero do socio
     */
    public int getNumeroSocio() {
        return numeroSocio;
    }
 
    /**
     * Obtem o e-mail do socio.
     * @return e-mail do socio
     */
    public String getMailSocio() {
        return mailSocio;
    }
 
    /**
     * Obtem a percentagem de desconto do socio.
     * @return desconto em percentagem
     */
    public int getDesconto() {
        return desconto;
    }
 
    /**
     * Devolve a descricao textual do socio.
     * @return texto com os dados do socio
     */
    public String toString() {
        return "Nome: " + nomeSocio + ", Numero: " + numeroSocio + ", Mail: " + mailSocio + ",Tipo" + tipoSocio + ", Desconto: " + desconto + "%";
    }
}
