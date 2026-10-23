/**
 * Classe Gestor
 * @author Gustavo e João
 * @version 2.0
 */

import java.util.ArrayList;
public class Gestor {

    /**
     * Listas dinamica que contem todos os socios e instrutores registados no ginasio
     */
    private ArrayList<Socio> socios;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<Atividades> atividades;

    /**
     * Construtor da classe Gestor
     * Inicia a lista dos socios e instrutores vazia
     */
    public Gestor(){
        socios = new ArrayList<>();
        instrutores = new ArrayList<>();
        atividades = new ArrayList<>();
    }

    /**
     * Verifica se ja existe um socio registado com o numero indicado 
     * @param numeroSocio o valor a verificar se ja existe
     * @return true se o socio ja exister e false caso contrario
     */

    public boolean existeSocio(int numeroSocio) {
        for (Socio s : socios) {
            if (s.getNumeroSocio() == numeroSocio) {
                return true;
            }   
        }
        return false;
    }

    /**
     * Adiciona um novo socio a lista caso este seja valido
     * @param novoSocio o objeto da Classe Socio a adicionar
     * @return true se a insercao tiver sucesso e false caso contrario
     */

    public boolean adicionarSocio(Socio novoSocio) {
        if (novoSocio == null || existeSocio(novoSocio.getNumeroSocio())) {
            return false;
        }
        socios.add(novoSocio);
        return true;
    }

    /**
     * Obtem a lista com todos os socios registados no ginasio
     * @return
     */
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    /**
     * Verifica se ja existe um instrutor registado com o nome indicado 
     * @param nomeInstrutor o nome a verificar se ja existe
     * @return true se o instrutor ja exister e false caso contrario
     */

    public boolean existeInstrutor(String nomeInstrutor) {
        for (Instrutor i : instrutores) {
            if (i.getNomeInstrutor().equals(nomeInstrutor)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um novo intrutor a lista caso este seja valido
     * @param instrutor o objeto da Classe instrutor a adicionar
     * @returninstrutor true se a insercao tiver sucesso e false caso contrario
     */

    public boolean adicionarInstrutor(Instrutor novoInstrutor) {
        if (novoInstrutor == null || existeInstrutor(novoInstrutor.getNomeInstrutor())) {
            return false;
        }
        instrutores.add(novoInstrutor);
        return true;
    }

    /**
     * Obtem a lista com todos os instrutores registados no ginasio
     * @return
     */
    public ArrayList<Instrutor> getInstrutores() {
        return instrutores;
    }

    /**
     * Adiciona uma nova atividade a lista caso esta seja valida
     * @param novaAtividade o objeto da Classe Atividades a adicionar
     * @return true se a insercao tiver sucesso e false caso contrario
     */

    public boolean adicionarAtividade(Atividades novaAtividade) {
        if (novaAtividade == null) {
            return false;
        }
        atividades.add(novaAtividade);
        return true;
    }

    /**
     * Obtem a lista com todas as atividades registadas no ginasio
     * @return
     */
    public ArrayList<Atividades> getAtividades() {
        return atividades;
    }

    public void carregarDados() {
        Instrutor i1 = new Instrutor("Carlos Silva", "M", "Educacao Fisica");
        Instrutor i2 = new Instrutor("Ana Maria", "F", "Curso PT");
        Instrutor i3 = new Instrutor("Pedro Miguel", "M", "Curso de Cross Fit");

        this.adicionarInstrutor(i1);
        this.adicionarInstrutor(i2);
        this.adicionarInstrutor(i3);

        SocioIndividual s1 = new SocioIndividual("Joao Santos", 101, "joao@gmail.com", 2010); // Menor (<18)
        SocioIndividual s2 = new SocioIndividual("Maria Luisa", 102, "maria@gmail.com", 1995); // Adulto
        SocioIndividual s3 = new SocioIndividual("Antonio Dias", 103, "antonio@gmail.com", 1955); // Sénior (>=65)

        SocioEmpresa s4 = new SocioEmpresa("Rita Ramos", 201, "rita@gmail.com", 501234567, "TechSolutions");
        SocioEmpresa s5 = new SocioEmpresa("Bernardo Cruz", 202, "bcruz@gmail.com", 509876543, "InovSoft");
        SocioEmpresa s6 = new SocioEmpresa("Sofia Ferreira", 203, "sofia@gmail.com", 505555555, "GlobalConsult");

        this.adicionarSocio(s1);
        this.adicionarSocio(s2);
        this.adicionarSocio(s3);
        this.adicionarSocio(s4);
        this.adicionarSocio(s5);
        this.adicionarSocio(s6);
    }

}
