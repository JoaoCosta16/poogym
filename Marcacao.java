import java.time.LocalDateTime;
 
/**
 * Representa a marcacao de um socio numa atividade, com os respetivos valores financeiros.
 * @author Gustavo e João
 * @version 3.0
 */
public class Marcacao {
    private Socio socio;
    private Atividades atividade;
    private LocalDateTime dataHora;
    private double precoBase;
    private double poupanca;
    private double precoFinal;
 
    /**
     * Cria uma marcacao e calcula a poupanca e o preco final.
     * @param socio socio que efetua a marcacao
     * @param atividade atividade marcada
     * @param dataHora data e hora da marcacao
     */
    public Marcacao(Socio socio, Atividades atividade, LocalDateTime dataHora) {
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = dataHora;
        this.precoBase = atividade.getCustoBase();
        this.poupanca = precoBase * socio.getDesconto() / 100;
        this.precoFinal = precoBase - poupanca;
    }
 
    /**
     * Obtem o socio da marcacao.
     * @return socio da marcacao
     */
    public Socio getSocio() {
        return socio;
    }
 
    /**
     * Obtem a atividade da marcacao.
     * @return atividade da marcacao
     */
    public Atividades getAtividade() {
        return atividade;
    }
 
    /**
     * Obtem a data e hora da marcacao.
     * @return data e hora da marcacao
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }
 
    /**
     * Obtem o preco base.
     * @return preco base em euros
     */
    public double getPrecoBase() {
        return precoBase;
    }
 
    /**
     * Obtem o valor poupado graças ao desconto.
     * @return poupanca em euros
     */
    public double getPoupanca() {
        return poupanca;
    }
 
    /**
     * Obtem o preco final apos desconto.
     * @return preco final em euros
     */
    public double getPrecoFinal() {
        return precoFinal;
    }
 
    /**
     * Devolve a descricao textual da marcacao.
     * @return texto com os dados da marcacao
     */
    public String toString() {
        return "socio: " + socio.getNomeSocio() + " (" + socio.getNumeroSocio() + "), atividade: " + atividade.getNomeAtividade()
                + ", data: " + dataHora
                + ", base: " + precoBase 
                + " EUR, poupanca: " + poupanca
                + " EUR, final: " + precoFinal + " EUR";
    }
}