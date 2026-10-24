import java.time.LocalDateTime;
 
/**
 * Representa uma aula de grupo com modalidade e capacidade maxima.
 * @author Gustavo e João
 * @version 3.0
 */
public class AulaGrupo extends Atividades {
    private String modalidade;
    private int capacidadeMaxima;
 
    /**
     * Cria uma aula de grupo; o custo base e determinado pela modalidade.
     * @param nomeAtividade nome da aula
     * @param instrutor instrutor responsavel
     * @param inicio data e hora de inicio
     * @param duracao duracao em minutos
     * @param modalidade Yoga, Spinning, Zumba ou CrossFit
     * @param capacidadeMaxima numero maximo de participantes
     */
    public AulaGrupo(String nomeAtividade, Instrutor instrutor, LocalDateTime inicio, int duracao, String modalidade, int capacidadeMaxima) {
        super(nomeAtividade, instrutor, inicio, duracao, calcularCustoBase(modalidade));
        this.modalidade = modalidade;
        this.capacidadeMaxima = capacidadeMaxima;
    }
 
    /**
     * Obtem a modalidade.
     * @return modalidade da aula
     */
    public String getModalidade() {
        return modalidade;
    }
 
    /**
     * Obtem a capacidade maxima.
     * @return capacidade maxima de participantes
     */
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
 
    private static double calcularCustoBase(String modalidade) {
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
 
    /**
     * Devolve a descricao textual da aula de grupo.
     * @return texto com os dados da aula
     */
    public String toString() {
        return "[Aula de Grupo] " + super.toString() + ", Modalidade: " + modalidade + ", Capacidade: " + capacidadeMaxima;
    }
}
