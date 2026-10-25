import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu do ginasio que permite ao utilizador interagir com o programa e realizar diversas operacoes relacionadas com socios, instrutores, atividades e marcacoes.
 * @author Gustavo e João
 * @version 3.0
 */

public class Menu {
    private Gestor gestor;
    private Scanner sc;

    /**
     * Constroi o menu e inicializa o motor de gestao, do scanner e carrega dados predefinidos
     */
    public Menu() {
        this.gestor = new Gestor();
        this.sc = new Scanner(System.in);
        
        this.gestor.carregarDados();
    }

    /**
     * Solicita e valida a introducao de um numero inteiro
     * @param mensagem Texto descritivo que serve como output para o utilizador
     * @return valor introduzido pelo utilizador
     */
    private int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while(!sc.hasNextInt()) {
            System.out.println("Erro: Deve introduzir um numero inteiro valido!");
            sc.nextLine();
            System.out.print(mensagem);
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    /**
     * Solicita e valida a introducao de uma string nao vazio
     * @param mensagem Texto descritivo que serve como output para o utilizador
     * @return string introduzida pelo utilizador
     */
    private String lerString(String mensagem) {
        System.out.print(mensagem);
        String texto = sc.nextLine().trim();
        while(texto.isEmpty()) {
            System.out.println("Erro: O campo nao pode ficar vazio!");
            System.out.print(mensagem);
            texto = sc.nextLine().trim();
        }
        return texto;
    }

    /**
     * Solicita uma data e hora
     * @return o objeto LocalDateTime correspondente aos valores introduzidos
     */
    private LocalDateTime lerDataHora() {
        System.out.println("--- Inserir Data e Hora ---");
        int dia = lerInteiro("Dia: ");
        int mes = lerInteiro("Mes: ");
        int ano = lerInteiro("Ano: ");
        int hora = lerInteiro("Hora (0-23): ");
        int minuto = lerInteiro("Minutos (0-59): ");

        return LocalDateTime.of(ano, mes, dia, hora, minuto);
    }

    /**
     * Faz uma pausa na execucao da consola, aguardando que o utilizador prima a tecla Enter para continuar e regressar ao menu principal.
     */
    private void esperarEnter() {
        System.out.print("Prima ENTER para voltar ao menu...");
        sc.nextLine();
    }

    /**
     * Inicia o ciclo principal da aplicacao e apresenta as opcoes disponiveis
     */
    public void iniciarMenu() {
        int opcao = -1;
        do {
            System.out.println("\n========== POOGYM ==========");
            System.out.println("1 - Registar Socio");
            System.out.println("2 - Registar Instrutor");
            System.out.println("3 - Registar Atividade");
            System.out.println("4 - Listar Socios");
            System.out.println("5 - Listar Atividades");
            System.out.println("6 - Criar Marcação");
            System.out.println("7 - Listar Marcacoes");
            System.out.println("8 - Resumo de Atividades");
            System.out.println("9 - Mais Popular");
            System.out.println("10 - Valores Socio");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInteiro("");
            System.out.println();
            switch (opcao) {
                case 1:
                    registarSocio();
                    esperarEnter();
                    break;
                case 2:
                    registarInstrutor();
                    esperarEnter();
                    break;
                case 3:
                    registarAtividade();
                    esperarEnter();
                    break;
                case 4:
                    listarSocios();
                    esperarEnter();
                    break;
                case 5:
                    listarAtividades();
                    esperarEnter();
                    break;
                case 6:
                    registarMarcacao();
                    esperarEnter();
                    break;
                case 7:
                    listarMarcacoes();
                    esperarEnter();
                    break;
                case 8:
                    resumoAtividades();
                    esperarEnter();
                    break;
                case 9:
                    maisPopular();
                    esperarEnter();
                    break;
                case 10:
                    valoresSocio();
                    esperarEnter();
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    /**
     * Recolhe os dados fornecidos pelo utilizador para a criacao de um novo socio
     */
    private void registarSocio() {
        Socio novoSocio = null;
        System.out.println("---Registar Socio---");
        
        String nomeSocio = lerString("Nome: ");
        int numeroSocio = lerInteiro("Numero: ");
        String email = lerString("Email: ");
        int tipo = lerInteiro("Introduza o numero correspondente ao seu tipo de Socio (0 - Individual | 1 - Empresa): ");

        switch (tipo) {
            case 0:
                System.out.println("--Socio Individual Escolhido--");
                int ano = lerInteiro("Ano de nascimento: ");
                novoSocio = new SocioIndividual(nomeSocio, numeroSocio, email, ano);

                break;
            case 1: 
                System.out.println("--Socio Empresa Escolhido--");

                String nomeEmpresa = lerString("Nome da empresa: ");

                int NIF = lerInteiro("NIF da empresa: ");

                novoSocio = new SocioEmpresa(nomeSocio, numeroSocio, email, NIF ,nomeEmpresa);

                break;
            default:
                System.out.println("Opcao invalida!");
        }
        if (novoSocio != null) {
            if(gestor.adicionarSocio(novoSocio)) {
                System.out.println("Socio adicionado com sucesso");
            } else {
                System.out.println("Erro a adicionar socio");
            }
        }
    }

    /**
     * Recolhe os dados fornecidos pelo utilizador para a criacao de um novo instrutor
     */
    private void registarInstrutor() {
        System.out.println("---Registar Instrutor---");

        String nome = lerString("Nome: ");

        String genero = lerString("Genero: ");

        String formacao = lerString("Formacao (Cursos e Formacoes):");

        Instrutor instrutor = new Instrutor(nome, genero, formacao);

        if (gestor.adicionarInstrutor(instrutor)) {
            System.out.println("Instrutor registado com sucesso");
        } else {
            System.out.println("Erro ao registar o instrutor");
        }
    }

    /**
     * Recolhe os dados fornecidos pelo utilizador para a criacao de uma nova atividade
     */
    private void registarAtividade() {
        System.out.println("---Registar Atividade---");

        String nomeAtividade = lerString("Nome da atividade a registar: ");

        String nomeInstrutorResponsavel = lerString("Instrutor responsavel: ");

        Instrutor instrutor = gestor.procurarInstrutor(nomeInstrutorResponsavel);

        if (instrutor == null) {
            System.out.println("Erro: Instrutor nao encontrado no sistema!");
            return;
        }

        System.out.println("Data e hora da atividade:");
        LocalDateTime dataHora = lerDataHora();

        int duracao = lerInteiro("Duracao da atividade (em minutos): ");

        int tipo = lerInteiro("Introduza o numero correspondente ao tipo de Atividade (0 - Aula de Grupo | 1 - Personal Training): ");

        Atividade atividade = null;

        switch (tipo) {
            case 0:
                System.out.println("--Aula de Grupo Escolhida--");

                String modalidade = lerString("Modalidades disponiveis: Yoga, Spinning, Zumba, CrossFit. Escolha uma modalidade: ");

                int capacidadeMaxima = lerInteiro("Capacidade maxima de participantes: ");

                atividade = new AulaGrupo(nomeAtividade, instrutor, dataHora, duracao, modalidade, capacidadeMaxima);

                break;
            case 1: 
                System.out.println("--Sessao de Personal Training Escolhida--");

                String nivel = lerString("Niveis disponiveis: iniciacao, intermedio, avancado. Escolha o nivel do treino: ");

                atividade = new SessaoPT(nomeAtividade, instrutor, dataHora, duracao, nivel);
                break;
            default:
                System.out.println("Opcao invalida!");
        }
        if (atividade != null) {
            if (gestor.adicionarAtividade(atividade)) {
                System.out.println("Atividade registada com sucesso");
            } else {
                System.out.println("Erro ao registar a atividade");
            }
        }
    }
    /**
     * Recolhe os dados fornecidos pelo utilizador para a criacao de uma nova marcacao
     */
    private void registarMarcacao() {
        System.out.println("---Registar Marcacao---");

        if (gestor.getSocios().isEmpty()) {
            System.out.println("Erro: Nao existem socios registados no sistema");
            return;
        }

        if (gestor.getAtividades().isEmpty()) {
            System.out.println("Erro: Nao existem atividades registadas no sistema");
            return;
        }

        int numeroSocioMarcacao = lerInteiro("Numero do Socio:");
        Socio socio = gestor.procurarSocio(numeroSocioMarcacao);
        if (socio == null) {
            System.out.println("Erro: Socio com o numero " + numeroSocioMarcacao + " nao encontrado");
            return;
        }

        String nomeAtividadeMarcacao = lerString("Nome da Atividade:");
        Atividade atividade = gestor.procurarAtividade(nomeAtividadeMarcacao);
        if (atividade == null) {
            System.out.println("Erro: Atividade com o nome '" + nomeAtividadeMarcacao + "' nao encontrada");
            return;
        }
        LocalDateTime dataHoraInicio = atividade.getInicio();

        Marcacao marcacao = new Marcacao(socio, atividade, dataHoraInicio);
        if (gestor.adicionarMarcacao(marcacao)) {
            System.out.println("Marcacao efetuada com sucesso!");
            System.out.println("----------------------------------------");
            System.out.println("Socio: " + socio.getNomeSocio());
            System.out.println("Atividade: " + atividade.getNomeAtividade());
            System.out.printf("Custo Base: %.2f EUR\n", marcacao.getPrecoBase());
            System.out.printf("Desconto Aplicado (Poupanca): %.2f EUR\n", marcacao.getPoupanca());
            System.out.printf("Preco Final a Pagar: %.2f EUR\n", marcacao.getPrecoFinal());
            System.out.println("----------------------------------------");
        }
    }

    /**
     * Apresenta no terminal todos os socios registados no sistema
     */
    private void listarSocios() {
        System.out.println("---Lista de Socios---");
        if (gestor.getSocios().isEmpty()) {
            System.out.println("Nao existem socios registados.");
            return;
        }
        for (Socio s : gestor.getSocios()) {
            System.out.println(s);
        }
    }

    /**
     * Apresenta no terminal todas as atividades registadas no sistema
     */
    private void listarAtividades() {
        System.out.println("---Lista de Atividades---");
        if (gestor.getAtividades().isEmpty()) {
            System.out.println("Nao existem atividades registados.");
            return;
        }
        for (Atividade a : gestor.getAtividades()) {
            System.out.println(a);
        }
    }

    /**
     * Apresenta no terminal todas as marcacoes registadas no sistema, os seus custos e o total faturado pelo ginasio
     */    
    private void listarMarcacoes() {
        System.out.println("---Lista de Marcacoes---");
        if (gestor.getMarcacoes().isEmpty()) {
            System.out.println("Nao existem marcacoes registados.");
            return;
        }
        for (Marcacao m : gestor.getMarcacoes()) {
            System.out.println(m);
        }
        double totalFaturado = gestor.calcularTotalFaturado();
        System.out.printf("Total Faturado: %.2f EUR\n", totalFaturado);
    }

    /**
     * Apresenta no terminal o numero e tipo de socios e atividades registados no sistema
     */
    private void resumoAtividades() {
        int contagemSocios[] = gestor.contarSociosPorTipo();
        int contagemAtividades[] = gestor.contarAtividadesPorTipo();

        System.out.println("---Socios e Atividades Registados---");
        System.out.println("Socios Individuais: " + contagemSocios[0] + ", Socios Empresa: " + contagemSocios[1] + ", Aulas de Grupo: " + contagemAtividades[0] + ", SessoesPT: " + contagemAtividades[1]);
    }

    /**
     * Apresenta no terminal a ou as atividades com o maior numero de marcacoes
     */
    private void maisPopular() {
        System.out.println("---Atividade mais Popular---");
        
        ArrayList<Atividade> populares = gestor.calcularAtividadeMaisPopular();

        if (populares.isEmpty()) {
            System.out.println("Nao existem marcacoes registadas");
            return;
        }
        int totalMarcacoes = gestor.contarMarcacoesPorAtividade(populares.get(0));

        if (populares.size() == 1) {
            System.out.println("Atividade mais Popular (com " + totalMarcacoes + " marcacoes):");
            System.out.println(populares.get(0));
        } 
        else {
            System.out.println("As atividades mais Populares (com " + totalMarcacoes + " marcacoes cada):");
            for (Atividade a : populares) {
                System.out.println(a);
            }
        }      
    }
    /**
     * Pede ao utilizador o numero de um socio e apresenta no terminal as despesas e valores poupados pelo socio
     */
    private void valoresSocio() {
        System.out.println("---Valores Socio---");

        if (gestor.getSocios().isEmpty()) {
            System.out.println("Nao existem socios registados no sistema.");
            return;
        }

        int numSocio = lerInteiro("Indique o numero de um socio: ");
        Socio socio = gestor.procurarSocio(numSocio);

        if (socio == null) {
            System.out.println("Erro: socio com o numero " + numSocio + " nao encontrado!");
            return;
        }
        double[] valores = gestor.calcularValoresSocio(socio);
        double totalGasto = valores[0];
        double totalPoupado = valores[1];
        System.out.println(socio);
        System.out.printf("Total gasto: %.2f EUR\n", totalGasto);
        System.out.printf("Total poupado: %.2f EUR\n", totalPoupado);
    }
}
