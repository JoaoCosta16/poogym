/**
 * Classe AulaGrupo
 * @author Gustavo e João
 * @version 2.0
 */
import java.time.LocalDateTime;

public class AulaGrupo extends Atividades{
    private String modalidade;
    private int capacidadeMaxima;
    private double custoBase;

    public AulaGrupo(String nomeAtividade, String instrutorResponsavel, LocalDateTime horarioAtividade, double duracaoAtividade, String modalidade, int capacidadeMaxima, double custoBase) {
        super(nomeAtividade, instrutorResponsavel, horarioAtividade, duracaoAtividade);
        this.modalidade = modalidade;
        this.capacidadeMaxima = capacidadeMaxima;
        this.custoBase = calcularCustoBase(modalidade);
    }

    public String getModalidade() {
        return modalidade;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public double getCustoBase(){
        return custoBase;
    }

    private double calcularCustoBase(String modalidade) {
        if (modalidade.equals("Yoga")) {
            return 8.00;
        }
        if (modalidade.equals("Spinning")) {
            return 9.00;
        }
        if (modalidade.equals("Zumba")) {
            return 8.50;
        }
        return 12.00;
    }
}   
