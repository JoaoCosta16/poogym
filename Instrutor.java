/**
 * Classe Instrutor
 * @author Gustavo e João
 * @version 2.0
 */
public class Instrutor {
    private String nomeInstrutor;
    private String generoInstrutor;
    private String formacaoInstrutor;
 
    /**
     * cria um instrutor
     * @param nomeInstrutor nome do instrutor
     * @param generoInstrutor genero do instrutor
     * @param formacaoInstrutor cursos e formacoes do instrutor
     */
    public Instrutor(String nomeInstrutor, String generoInstrutor, String formacaoInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
        this.generoInstrutor = generoInstrutor;
        this.formacaoInstrutor = formacaoInstrutor;
    }
 
    /**
     * obtem o nome do instrutor
     * @return nome do instrutor
     */
    public String getNomeInstrutor() {
        return nomeInstrutor;
    }
 
    /**
     * obtem o genero do instrutor
     * @return genero do instrutor
     */
    public String getGeneroInstrutor() {
        return generoInstrutor;
    }
 
    /**
     * obtem a formacao do instrutor
     * @return formacao do instrutor
     */
    public String getFormacaoInstrutor() {
        return formacaoInstrutor;
    }
}
