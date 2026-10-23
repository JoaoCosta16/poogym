/**
 * Classe SocioIndividual
 * @author Gustavo e João
 * @version 1.0
 */

public class SocioIndividual extends Socio{
    private int anoNascimento;

    public SocioIndividual(String nomeSocio, int numeroSocio, String mailSocio, int anoNascimento){
        super(nomeSocio, numeroSocio, mailSocio, "INDIVIDUAL");
        this.anoNascimento = anoNascimento;
    }

     public int getAnoNascimento() {
        return anoNascimento;
    }

    public String toString() {
        return super.toString() + ", Ano de Nascimento: " + anoNascimento;
    }
}
