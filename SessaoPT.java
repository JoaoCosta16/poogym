/**
 * Classe SessaoPT
 * @author Gustavo e João
 * @version 2.0
 */
import java.time.LocalDateTime;

public class SessaoPT extends Atividades {
    private String nivelTreino;
    private double custoBase;

    public SessaoPT(String nomeAtividade, String instrutorResponsavel, LocalDateTime horarioAtividade, double duracaoAtividade, String nivelTreino, double custoBase) {
        super(nomeAtividade, instrutorResponsavel, horarioAtividade, duracaoAtividade);
        this.nivelTreino = nivelTreino;
        this.custoBase = CalcularCustoBase(nivelTreino);
    }

    public String getNivelTreino() {
        return nivelTreino;
    }

    public double getCustoBase(){
        return custoBase;
    }

    private double CalcularCustoBase(String nivelString){
        if (nivelString.equals("Iniciação")) {
            return 18.00;
        }
        if (nivelString.equals(" Intermédio")) {
            return 22.00;
        }

        return 28.00;
    }
}
