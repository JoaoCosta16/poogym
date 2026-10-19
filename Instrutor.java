/**
 * Classe Instrutor
 * @author Gustavo
 * @version 1.0
 */

public class Instrutor {
    private String nomeInstrutor;
    private String generoInstrutor;
    private String formacaoInstrutor;

    private Instrutor (String nomeInstrutor, String generoInstrutor, String formacaoInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
        this.generoInstrutor = generoInstrutor;
        this.formacaoInstrutor = formacaoInstrutor;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public String getGeneroInstrutor() {
        return generoInstrutor;
    }

    public String getFormacaoInstrutor() {
        return formacaoInstrutor;
    }
}
