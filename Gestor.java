import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Classe Gestor
 * @author Gustavo e João
 * @version 2.0
 */

public class Gestor {

    /**
     * Listas dinamicas que contem todos os socios, instrutores e atividades registados no ginasio
     */
    private ArrayList<Socio> socios;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<Atividade> atividades;
    private ArrayList<Marcacao> marcacoes;

    /**
     * Construtor da classe Gestor
     * Inicia a lista dos socios, instrutores e atividades vazia
     */
    public Gestor(){
        socios = new ArrayList<>();
        instrutores = new ArrayList<>();
        atividades = new ArrayList<>();
        marcacoes = new ArrayList<>();
    }

    /**
     * Verifica se ja existe um socio registado com o numero indicado 
     * @param numeroSocio o valor a verificar se ja existe
     * @return true se o socio ja existir e false caso contrario
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
     * Verifica se ja existe um instrutor registado com o nome indicado 
     * @param nomeInstrutor o nome a verificar se ja existe
     * @return true se o instrutor ja existir e false caso contrario
     */
    public boolean existeInstrutor(String nomeInstrutor) {
        for (Instrutor i : instrutores) {
            if (i.getNomeInstrutor().trim().equalsIgnoreCase(nomeInstrutor.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Procura um socio na lista de socios pelo seu numero
     * @param numeroSocio numero do socio a procurar
     * @return o objeto socio correspondente se este for encontrado e null caso contrario
     */
    public Socio procurarSocio(int numeroSocio) {
        for (Socio s : this.socios) {
            if (s.getNumeroSocio() == numeroSocio) {
                return s;
            }
        }
        return null;
    }

    /**
     * Procura um instrutor na lista de instrutores pelo seu nome
     * @param nomeInstrutor nome do instrutor a procurar
     * @return o objeto instrutor correspondente se este for encontrado e null caso contrarioS
     */
    public Instrutor procurarInstrutor(String nomeInstrutor) {
        for (Instrutor i : this.instrutores) {
            if (i.getNomeInstrutor().trim().equalsIgnoreCase(nomeInstrutor.trim())) {
                return i;
            }
        }
        return null;
    }

    /**
     * Procura uma atividade na lista de atividades pelo seu nome
     * @param nomeAtividade nome da atividade a procurar
     * @return o objeto atividade correspondente se esta for encontrada e null caso contrario
     */
    public Atividade procurarAtividade(String nomeAtividade) {
        for (Atividade a : this.atividades) {
            if (a.getNomeAtividade().trim().equalsIgnoreCase(nomeAtividade.trim())) {
                return a;
            }
        }
        return null;
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
     * Adiciona um novo instrutor a lista caso este seja valido
     * @param novoInstrutor o objeto da Classe Instrutor a adicionar
     * @return true se a insercao tiver sucesso e false caso contrario
     */
    public boolean adicionarInstrutor(Instrutor novoInstrutor) {
        if (novoInstrutor == null || existeInstrutor(novoInstrutor.getNomeInstrutor())) {
            return false;
        }
        instrutores.add(novoInstrutor);
        return true;
    }

    /**
     * Adiciona uma nova atividade a lista caso esta seja valida
     * @param novaAtividade o objeto da Classe Atividades a adicionar
     * @return true se a insercao tiver sucesso e false caso contrario
     */
    public boolean adicionarAtividade(Atividade novaAtividade) {
        if (novaAtividade == null) {
            return false;
        }
        atividades.add(novaAtividade);
        return true;
    }

    /**
     * Adiciona uma nova marcacao a lista caso esta seja valida e haja vaga
     * @param m o objeto da Classe Marcacao a adicionar
     * @return true se a insercao tiver sucesso e false caso contrario
     */
    public boolean adicionarMarcacao(Marcacao m) {
        if (m == null) {
            return false;
        }

        Atividade a = m.getAtividade();
        int ocupacaoAtual = contarMarcacoesPorAtividade(a);

        if (a.getTipoAtividade().equalsIgnoreCase("AULAGRUPO")) {
            AulaGrupo aula = (AulaGrupo) a;
            if (ocupacaoAtual >= aula.getCapacidadeMaxima()) {
                return false;
            }
        } else {
            if(ocupacaoAtual >+ 1) {
                return false;
            }
        }

        marcacoes.add(m);
        return true;
    }    
    
    /**
     * Conta o numero total de socios individuais e de empresa registados
     * @return um array de inteiros onde o indice 0 representa o numero de socios individuas e 1 representa os de empresa
     */
    public int[] contarSociosPorTipo() {
        int individuais = 0;
        int empresa = 0;

        for (Socio s : socios) {
            if (s.getTipoSocio().equalsIgnoreCase("INDIVIDUAL")) {
                individuais++;
            }
            else {
                empresa++;
            }
        }
        return new int[] {individuais, empresa};
    }

    /**
     * Conta o numero total de Aulas de Grupo e SessoesPT registadas
     * @return um array de inteiros onde o indice 0 representa o numero de Aulas de Grupo e 1 representa o numero de SessoesPT
     */
    public int[] contarAtividadesPorTipo() {
        int aulasGrupo = 0;
        int sessoesPt = 0;

        for (Atividade a : atividades) {
            if (a.getTipoAtividade().equalsIgnoreCase("AULAGRUPO")) {
                aulasGrupo++;
            }
            else {
                sessoesPt++;
            }
        }
        return new int[] {aulasGrupo, sessoesPt};
    }

    /**
     * Conta quantas marcacoes ja estao associadas a uma determinada atividade
     * @param a atividade a verificar
     * @return numero de marcacoes existentes
     */
    public int contarMarcacoesPorAtividade(Atividade a) {
        int total = 0;
        for (Marcacao m : marcacoes) {
            if(m.getAtividade().equals(a)) {
                total++;
            }
        }
        return total;
    }

    /**
     * Calcula o total faturado pelo ginasio
     * @return soma de todos os precos finais das marcacoes registadas
     */
    public double calcularTotalFaturado() {
        double total = 0.0;
        for (Marcacao m : marcacoes) {
            total += m.getPrecoFinal();
        }
        return total;
    }

    /**
     * Obtem uma copia da lista com todos os socios registados no ginasio
     * @return lista de socios
     */
    public ArrayList<Socio> getSocios() {
        return new ArrayList<>(socios);
    }

    /**
     * Obtem uma copia da lista com todos os instrutores registados no ginasio
     * @return lista de instrutores
     */
    public ArrayList<Instrutor> getInstrutores() {
        return new ArrayList<>(instrutores);
    }

    /**
     * Obtem a lista com todas as atividades registadas no ginasio
     * @return lista de atividades
     */
    public ArrayList<Atividade> getAtividades() {
        return new ArrayList<>(atividades);
    }

    /**
     * Obtem a lista com todas as marcacoes registadas no ginasio
     * @return lista de marcacoes
     */
    public ArrayList<Marcacao> getMarcacoes() {
        return new ArrayList<>(marcacoes);
    }

    /**
     * Metodo que carrega dados de exemplo
     */
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

        AulaGrupo ag1 = new AulaGrupo("Yoga Matinal", i2, LocalDateTime.of(2026, 11, 2, 8, 30), 60, "Yoga", 15);
        AulaGrupo ag2 = new AulaGrupo("Spinning Cardio", i1, LocalDateTime.of(2026, 11, 2, 18, 0), 45, "Spinning", 20);
        AulaGrupo ag3 = new AulaGrupo("Zumba Fitness", i2, LocalDateTime.of(2026, 11, 3, 19, 0), 50, "Zumba", 25);
        AulaGrupo ag4 = new AulaGrupo("CrossFit WOD", i3, LocalDateTime.of(2026, 11, 4, 17, 30), 60, "CrossFit", 12);

        SessaoPT pt1 = new SessaoPT("PT Adaptacao Funcional", i1, LocalDateTime.of(2026, 11, 2, 10, 0), 60, "Iniciacao");
        SessaoPT pt2 = new SessaoPT("PT Hipertrofia", i3, LocalDateTime.of(2026, 11, 2, 14, 0), 60, "Intermedio");
        SessaoPT pt3 = new SessaoPT("PT Performance Atletica", i3, LocalDateTime.of(2026, 11, 3, 11, 0), 90, "Avancado");
        SessaoPT pt4 = new SessaoPT("PT Mobilidade e Postura", i2, LocalDateTime.of(2026, 11, 4, 15, 0), 45, "Iniciacao");

        this.adicionarAtividade(ag1);
        this.adicionarAtividade(ag2);
        this.adicionarAtividade(ag3);
        this.adicionarAtividade(ag4);
        this.adicionarAtividade(pt1);
        this.adicionarAtividade(pt2);
        this.adicionarAtividade(pt3);
        this.adicionarAtividade(pt4);

        Marcacao m1 = new Marcacao(s1, ag1, ag1.getInicio());
        Marcacao m2 = new Marcacao(s2, ag1, ag1.getInicio());
        Marcacao m3 = new Marcacao(s4, ag2, ag2.getInicio());
        Marcacao m4 = new Marcacao(s3, pt1, pt1.getInicio());
        Marcacao m5 = new Marcacao(s5, pt2, pt2.getInicio());
        Marcacao m6 = new Marcacao(s6, ag3, ag3.getInicio());

        this.adicionarMarcacao(m1);
        this.adicionarMarcacao(m2);
        this.adicionarMarcacao(m3);
        this.adicionarMarcacao(m4);
        this.adicionarMarcacao(m5);
        this.adicionarMarcacao(m6);
    }
}