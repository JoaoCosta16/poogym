/**
 * Classe SessaoPT
 * @author Gustavo
 * @version 1.0
 */
import java.time.LocalDateTime;

public class SessaoPT extends Atividades {
    private String nivelTreino;

    public SessaoPT(String nomeAtividade, String instrutorResponsavel, LocalDateTime horarioAtividade, double duracaoAtividade, String nivelTreino) {
        super(nomeAtividade, instrutorResponsavel, horarioAtividade, duracaoAtividade);
        this.nivelTreino = nivelTreino;
    }

    public String getNivelTreino() {
        return nivelTreino;
    }
    
}
