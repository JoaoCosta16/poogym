import java.time.LocalDateTime;

/**
 * Classe AulaGrupo
 * @author Gustavo
 * @version 1.0
 */

public class AulaGrupo extends Atividades{
    private String modalidade;
    private int capacidadeMaxima;

    public AulaGrupo(String nomeAtividade, String instrutorResponsavel, LocalDateTime horarioAtividade, double duracaoAtividade, String modalidade, int capacidadeMaxima) {
        super(nomeAtividade, instrutorResponsavel, horarioAtividade, duracaoAtividade);
        this.modalidade = modalidade;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getModalidade() {
        return modalidade;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

}   
