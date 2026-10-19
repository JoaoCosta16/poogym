/**
 * Classe SessaoPT
 * @author Gustavo
 * @version 1.0
 */

public class SessaoPT extends Atividades {
    private String nivelTreino;

    public SessaoPT(String nomeAtividade, String instrutorResponsavel, LocalDateTime horarioAtividade, double duracaoAtividade) {
        super(nomeAtividade, instrutorResponsavel, horarioAtividade, duracaoAtividade);
        this.nivelTreino = nivelTreino;
    }

    public String getNivelTreino() {
        return nivelTreino;
    }
    
}
