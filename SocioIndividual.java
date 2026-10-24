import java.time.LocalDate;
/**
 * Classe SocioIndividual
 * @author Gustavo e João
 * @version 1.0
 */

public class SocioIndividual extends Socio{
    private int anoNascimento;

    /**
     * Cria socio individual.
     * @param nomeSocio nome do socio
     * @param numeroSocio numero unico do socio
     * @param mailSocio e-mail do socio
     * @param anoNascimento ano de nascimento do socio
     */

    public SocioIndividual(String nomeSocio, int numeroSocio, String mailSocio, String tipoSocio, int desconto, int anoNascimento){
        super(nomeSocio, numeroSocio, mailSocio,"INDIVIDUAL", calcularDesconto(anoNascimento));
        this.anoNascimento = anoNascimento;
    }

     /**
     * Obtem o ano de nascimento.
     * @return ano de nascimento
     */

     public int getAnoNascimento() {
        return anoNascimento;
    }
    
    /**
     * Através do ano calcula o desconto.
     * @return percentagem de desconto
     */
    public static int calcularDesconto(int anoNascimento){
        int idade = LocalDate.now().getYear() - anoNascimento;
        if (idade < 18) {
            return 10;
        }
        if (idade >= 65) {
            return 15;
        }
        return 0;
    }
   
    /**
     * Devolve a descricao textual do socio individual.
     * @return texto com os dados do socio
     */

    public String toString() {
        return super.toString() + ", Ano de Nascimento: " + anoNascimento;
    }
}
