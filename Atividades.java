
import java.time.LocalDateTime;

/**
 * Classe Atividades
 * @author Gustavo
 * @version 1.0
 */

public class Atividades {
    private String nomeAtividade;
    private String instrutorResponsavel;
    private LocalDateTime horarioAtividade;
    private double duracaoAtividade;

    public Atividades(String nomeAtividade, String instrutorResponsavel, LocalDateTime horarioAtividade, double duracaoAtividade) {
        this.nomeAtividade = nomeAtividade;
        this.instrutorResponsavel = instrutorResponsavel;
        this.horarioAtividade = horarioAtividade;
        this.duracaoAtividade = duracaoAtividade;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public String getInstrutorResponsavel() {
        return instrutorResponsavel;
    }

    public LocalDateTime getHorarioAtividade() {
        return horarioAtividade;
    }

    public double getDuracaoAtividade() {
        return duracaoAtividade;
    }
}
