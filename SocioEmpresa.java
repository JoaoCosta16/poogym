/**
 * SocioEmpresa
 * @author Gustavo e João
 * @version 3.0
 */

public class SocioEmpresa extends Socio{
    private int nifEmpresa;
    private String nomeEmpresa;
  

    /**
     * cria socio empresa
     * @param nomeSocio nome do socio
     * @param numeroSocio numero unico do socio
     * @param mailSocio e-mail do socio
     * @param nifEmpresa nif da empresa
     * @param nomeEmpresa nome da empresa
     */

    public SocioEmpresa(String nomeSocio, int numeroSocio, String mailSocio,String tipoSocio, int desconto, int nifEmpresa, String nomeEmpresa){
        super(nomeSocio, numeroSocio, mailSocio, "EMPRESA", 20);
        this.nifEmpresa = nifEmpresa;
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * obtem o NIF da empresa
     * @return NIF da empresa
     */
    public int getNifEmpresa() {
        return nifEmpresa;
    }
 
    /**
     * obtem o nome da empresa
     * @return nome da empresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
 
    /**
     * devolve a descricao socio empresa.
     * @return texto com os dados do socio e empresa
     */
    
    public String toString() {
        return "[Empresa] " + super.toString() + ", NIF: " + nifEmpresa + ", Empresa: " + nomeEmpresa;
    }
}