import java.time.LocalDateTime;

/**
 * Representa uma sessao de personal training com um nivel de treino
 * @author Gustavo e João
 * @version 3.0
 */
public class SessaoPT extends Atividade {
    private String nivelTreino;

    /**
     * cria uma sessao de personal training
     * @param nomeAtividade nome da sessao
     * @param instrutor instrutor responsavel
     * @param inicio data e hora de inicio
     * @param duracao duracao em minutos
     * @param nivelTreino Iniciação, Intermédio ou Avançado
     */
    public SessaoPT(String nomeAtividade, Instrutor instrutor, LocalDateTime inicio, int duracao, String nivelTreino) {
        super(nomeAtividade, instrutor, inicio, duracao, calcularCustoBase(nivelTreino), "SESSAOPT");
        this.nivelTreino = nivelTreino;
    }

    /**
     * devolde o nivel treino
     * @return nivel de treino
     */
    public String getNivelTreino() {
        return nivelTreino;
    }

     /**
     * da o valor de cada aula
     * @return custo base
     */
    private static double calcularCustoBase(String nivelTreino) {
        if (nivelTreino.equalsIgnoreCase("Iniciacao")) {
            return 18.00;
        }
        if (nivelTreino.equalsIgnoreCase("Intermedio")) {
            return 22.00;
        }
        if (nivelTreino.equalsIgnoreCase("Avancado")) {
            return 28.00;
        }
        return 0.0;
    }

    /**
     * devolve a descricao da sessaopt
     * @return texto com os dados da sessao
     */
    public String toString() {
        return "[Sessao PT] " + super.toString() + ", Nivel: " + nivelTreino;
    }
}