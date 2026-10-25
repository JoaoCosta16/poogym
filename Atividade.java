import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
/**
 * representa uma atividade do ginasio com os dados comuns a aulas de grupo e sessoes de personal training
 * @author Gustavo e João
 * @version 3.0
 */
public class Atividade {
    private String nomeAtividade;
    private Instrutor instrutor;
    private LocalDateTime inicio;
    private int duracao;
    private double custoBase;
 
    /**
     * cria uma atividade
     * @param nomeAtividade nome da atividade
     * @param instrutor instrutor responsavel
     * @param inicio data e hora de inicio
     * @param duracao duracao em minutos
     * @param custoBase custo base em euros
     */
    public Atividade(String nomeAtividade, Instrutor instrutor, LocalDateTime inicio, int duracao, double custoBase) {
        this.nomeAtividade = nomeAtividade;
        this.instrutor = instrutor;
        this.inicio = inicio;
        this.duracao = duracao;
        this.custoBase = custoBase;
    }
 
    /**
     * obtem o nome da atividade
     * @return nome da atividade
     */
    public String getNomeAtividade() {
        return nomeAtividade;
    }
 
    /**
     * obtem o instrutor.
     * @return instrutor 
     */
    public Instrutor getInstrutor() {
        return instrutor;
    }
 
    /**
     * Obtem a data e hora de inicio
     * @return data e hora de inicio
     */
    public LocalDateTime getInicio() {
        return inicio;
    }
 
    /**
     * Obtem a duracao em minutos
     * @return duracao em minutos
     */
    public int getDuracao() {
        return duracao;
    }
 
    /**
     * Obtem o custo base 
     * @return custo base 
     */
    public double getCustoBase() {
        return custoBase;
    }
 
    /**
     * Devolve a descricao da aula
     * @return texto com os dados da atividade
     */
    public String toString() {
        return "Nome: " + nomeAtividade + ", Instrutor: " + instrutor.getNomeInstrutor()
                + ", Inicio: " + inicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                + ", Duracao: " + duracao + " min, Custo base: " + String.format("%.2f", custoBase) + " EUR";
    }
}