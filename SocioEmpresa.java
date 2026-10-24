/**
 * Classe SocioEmpresa
 * @author Gustavo e João
 * @version 1.0
 */

public class SocioEmpresa extends Socio{
    private int nifEmpresa;
    private String nomeEmpresa;
  

    public SocioEmpresa(String nomeSocio, int numeroSocio, String mailSocio,String tipoSocio, int desconto, int nifEmpresa, String nomeEmpresa){
        super(nomeSocio, numeroSocio, mailSocio, "EMPRESA", 20);
        this.nifEmpresa = nifEmpresa;
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getNifEmpresa() {
        return nifEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String toString() {
        return super.toString() + ", NIF: " + nifEmpresa + ", Nome da Empresa: " + nomeEmpresa;
    }
}