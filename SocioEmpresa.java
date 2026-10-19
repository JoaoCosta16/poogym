public class SocioEmpresa extends Socio{
    private int nifEmpresa;
    private String nomeEmpresa;

    public SocioEmpresa(String nomeSocio, int numeroSocio, String mailSocio, int nifEmpresa, String nomeEmpresa){
        super(nomeSocio, numeroSocio, mailSocio);
        this.nifEmpresa = nifEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        
    }

    public int getnifEmpresa() {
        return nifEmpresa;
    }

    public String getnomeEmpresa() {
        return nomeEmpresa;
    }
}